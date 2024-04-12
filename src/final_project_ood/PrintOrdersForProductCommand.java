package final_project_ood;

import java.util.Iterator;

public class PrintOrdersForProductCommand implements ICommand{
	private StorageManager storageManager;
	private OrderManager orderManager;
	private String productId;
	
	public PrintOrdersForProductCommand(String productID) {
		this.storageManager = Store.getStoreInstance().getStorageManager();
		this.orderManager = Store.getStoreInstance().getOrderManager();
		this.productId = productID;
	}

	@Override
	public void execute() {
		int profit = 0;
		int totalProfit = 0;
		Product product = storageManager.getProductByID(productId);
		if (product == null) {
			System.out.println("No product with this ID.");
			return;
		}else if (!product.getIsActive()) {
			System.out.println("The product you chose isn't available in the store anymore.");
		}
		System.out.println("This is the list of all orders of the product you chose:");
		for (Iterator<String> iterator = product.productOrdersID.iterator(); iterator.hasNext();) {
			String orderID = (String) iterator.next();
			Order order = orderManager.getOrderByID(orderID);
			if (order != null) {
				System.out.println(order.toString());
				profit = orderManager.calculateOrderProfit(order, product.sellingPrice, product.costPrice, product.currency);
				totalProfit += profit;
				System.out.println("The profit from this order is: " + profit + " NIS");
			}
		}
		System.out.println("Total profit from product's orders: " + totalProfit + " NIS");
		
	}

}