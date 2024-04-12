package final_project_ood;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class PrintProductCommand implements ICommand {
	private StorageManager storageManager;
	private OrderManager orderManager;
	private String productId;
	
	public PrintProductCommand (String productID) {
		this.storageManager = Store.getStoreInstance().getStorageManager();
		this.orderManager = Store.getStoreInstance().getOrderManager();
		this.productId = productID;
	}

	@Override
	public void execute() {
		int profit = 0;
		Product product = storageManager.getProductByID(productId);
		if(product == null || !product.getIsActive()) {
			System.out.println("No product with this ID.");
			return;
		}
		System.out.println(product.toString());
		LinkedHashSet<String> productOrdersID = product.getProductOrdersID();
		if(productOrdersID.isEmpty()) {
			System.out.println("This product has no orders.");
		}
		else {
			for (Iterator<String> iterator = productOrdersID.iterator(); iterator.hasNext();) {
				String orderID = (String) iterator.next();
				Order order = orderManager.getOrderByID(orderID);
				if (order != null) {
					System.out.println(order.toString());
					System.out.println();
					profit += orderManager.calculateOrderProfit(order, product.getSellingPrice(), product.getCostPrice(), product.getCurrency());
				}
			}
		}
		System.out.println("Total profit from product's orders: " + profit + " NIS\n");
	}
	
	

}
