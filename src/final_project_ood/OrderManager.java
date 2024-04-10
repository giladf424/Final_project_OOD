package final_project_ood;

import java.util.Iterator;
import java.util.LinkedHashSet;

import final_project_ood.ShippingManager.eShippingType;

public class OrderManager {
	private LinkedHashSet<Order> allOrders;

	public OrderManager() {
		allOrders = new LinkedHashSet<>();
	}
	
// create new order ( gets user input , need to add the order to the list of all orders and the id to product list)
	public OrderStore createOrder(String orderID, Customer customer, String productID, int quantity) {
		OrderStore newOrder = new OrderStore(orderID, customer, productID, quantity);
		this.allOrders.add(newOrder);
		return newOrder;
	}
	
	public OrderShipped createOrder(String orderID, Customer customer, String productID, int quantity, eShippingType type, double shippingFee, ShippingService shippingService) {
		OrderShipped newOrder = new OrderShipped(orderID, customer, productID, quantity, type, shippingFee, shippingService);
		this.allOrders.add(newOrder);
		return newOrder;
	}
	
	public boolean doesOrderExist(String orderID) {
		for (Iterator iterator = allOrders.iterator(); iterator.hasNext();) {
			Order order = (Order) iterator.next();
			if(order.getOrderID().equals(orderID))
				return true;
		}
		return false;
	}

}
