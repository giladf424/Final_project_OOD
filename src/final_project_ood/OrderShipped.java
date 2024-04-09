package final_project_ood;

import final_project_ood.ShippingManager.eShippingType;

public class OrderShipped extends Order{
	private String shippingServiceId;
	private double shippingFees;
	private eShippingType shippingType;
	
	public OrderShipped(String orderID, Customer customer, String productID, int quantity, eShippingType type, double shippingFees, String shippingServiceID) {
		super(orderID, customer, productID, quantity);
		this.shippingType = type;
		this.shippingFees = shippingFees;
		this.shippingServiceId = shippingServiceID;
	}

	public String getShippingServiceId() {
		return shippingServiceId;
	}

	public void setShippingServiceId(String shippingServiceId) {
		this.shippingServiceId = shippingServiceId;
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
