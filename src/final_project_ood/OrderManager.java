package final_project_ood;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class OrderManager {
	private LinkedHashSet<Order> allOrders;

	public OrderManager() {
		allOrders = new LinkedHashSet<>();
	}
	
// create new order ( gets user input , need to add the order to the list of all orders and the id to product list)
	public Order createOrder(String orderID, Customer customer, String productID, int quantity) {
		Order newOrder = new Order(orderID, customer, productID, quantity);
		this.allOrders.add(newOrder);
		return newOrder;
	}
	
	
// updateShippingForOrder ( adding the shipping service and shipping fees to the last order who created)
	
	public boolean doesOrderExist(String orderID) {
		for (Iterator iterator = allOrders.iterator(); iterator.hasNext();) {
			Order order = (Order) iterator.next();
			if(order.getOrderID().equals(orderID))
				return true;
		}
		return false;
	}

}
