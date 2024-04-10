package final_project_ood;

import final_project_ood.ShippingManager.eShippingType;

public class OrderShipped extends Order{
	private ShippingService shippingService;
	private double shippingFees;
	private eShippingType shippingType;
	
	public OrderShipped(String orderID, Customer customer, Product product, int quantity, eShippingType type, double shippingFees, ShippingService shippingService) {
		super(orderID, customer, product, quantity);
		this.shippingType = type;
		this.shippingFees = shippingFees;
		this.shippingService = shippingService;
	}

	public ShippingService getShippingServiceId() {
		return shippingService;
	}

	public void setShippingServiceId(ShippingService shippingService) {
		this.shippingService = shippingService;
	}

	public double getShippingFees() {
		return shippingFees;
	}

	public void setShippingFees(double shippingFees) {
		this.shippingFees = shippingFees;
	}

	public eShippingType getShippingType() {
		return shippingType;
	}

	public void setShippingType(eShippingType shippingType) {
		this.shippingType = shippingType;
	}
	
	
	
}
