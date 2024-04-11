package final_project_ood;

import java.util.Iterator;
import java.util.LinkedHashSet;

import final_project_ood.ShippingManager.eShippingType;

public class OrderManager {
	private LinkedHashSet<Order> allOrders;

	public OrderManager() {
		allOrders = new LinkedHashSet<>();
	}
	
	public LinkedHashSet<Order> getAllOrders(){
		return this.allOrders;
	}
	
	public void setAllOrders(LinkedHashSet<Order> allOrders) {
		this.allOrders = allOrders;
	}
	
// create new order ( gets user input , need to add the order to the list of all orders and the id to product list)
	public OrderStore createOrder(String orderID, Customer customer, Product product, int quantity) {
		OrderStore newOrder = new OrderStore(orderID, customer, product, quantity);
		this.allOrders.add(newOrder);
		return newOrder;
	}
	
	public OrderShipped createOrder(String orderID, Customer customer, Product product, int quantity, eShippingType type, double shippingFee, ShippingService shippingService) {
		OrderShipped newOrder = new OrderShipped(orderID, customer, product, quantity, type, shippingFee, shippingService);
		this.allOrders.add(newOrder);
		return newOrder;
	}
	
	public OrderWholeSaler createOrder(String orderID, Customer customer, ProductWholesalers product, int quantity) {
		OrderWholeSaler newOrder = new OrderWholeSaler(orderID, customer, product, quantity);
		this.allOrders.add(newOrder);
		return newOrder;
	}
	
	public void removeLastOrder() {
		Order order = null;
		for (Iterator<Order> iterator = allOrders.iterator(); iterator.hasNext();) {
			order = (Order) iterator.next();
		}
		this.allOrders.remove(order);
	}
	
	public boolean doesOrderExist(String orderID) {
		for (Iterator<Order> iterator = allOrders.iterator(); iterator.hasNext();) {
			Order order = (Order) iterator.next();
			if(order.getOrderID().equals(orderID))
				return true;
		}
		return false;
	}

}
