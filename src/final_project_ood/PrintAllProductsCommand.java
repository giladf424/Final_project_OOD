package final_project_ood;

import java.util.Iterator;

public class PrintAllProductsCommand implements ICommand {
	private StorageManager storageManager;
	private OrderManager orderManager;
	
	public PrintAllProductsCommand() {
		this.storageManager = Store.getStoreInstance().getStorageManager();
		this.orderManager = Store.getStoreInstance().getOrderManager();
	}

	@Override
	public void execute() {
		int profit = 0;
		int spendings = 0;
		System.out.println("All the products in the store:");
		if(storageManager.getAllProducts().isEmpty()) {
			System.out.println("There are no products in the store.");
		}
		else {
			for (Iterator<Product> iterator = storageManager.getAllProducts().iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
				if(product.getIsActive()) {
					spendings += product.getStock() * product.getCostPrice();
					System.out.println(product.toString());
					System.out.println();
				}
				
			}
			for (Iterator<Order> iterator = orderManager.getAllOrders().iterator(); iterator.hasNext();) {
				Order order = (Order) iterator.next();
				Product product = storageManager.getProductByID(order.getProductID());
				profit += orderManager.calculateOrderProfit(order, product.getSellingPrice(), product.getCostPrice(), product.getCurrency());
				System.out.println(order.toString());
				System.out.println();
			}
		}
		int totalProfit = profit - spendings;
		System.out.println("The store total profit is: (takes into account existing stock value) " + totalProfit + " NIS\n");
	}
	

}
