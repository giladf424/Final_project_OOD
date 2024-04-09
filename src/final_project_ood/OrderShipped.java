package final_project_ood;

import final_project_ood.ShippingManager.eShippingType;

public class OrderShipped extends Order{
	private ShippingService shippingService;
	private double shippingFees;
	private eShippingType shippingType;
	
	public OrderShipped(String orderID, Customer customer, String productID, int quantity) {
		super(orderID, customer, productID, quantity);
	}
	
	
}
