package final_project_ood;

import java.util.Objects;

public abstract class Order implements Cloneable{
	protected Customer customer;
	protected String productID;
	protected String orderID;
	protected int quantity;
	
	public Order(String orderID, Customer customer, Product product, int quantity) {
		this.orderID = orderID;
		this.customer = customer;
		this.productID = product.getProductID();
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getOrderID() {
		return this.orderID;
	}
	
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderID, other.orderID);
	}

	@Override
	public String toString() {
		StringBuffer orderDesc = new StringBuffer();
		orderDesc.append("Order ID: " + orderID + "\n").append("Product ID: " + productID + "\t Quantity: " + quantity + "\n");
		return orderDesc.toString() + customer.toString();
	}
	
	
	@Override
    public Order clone() {
        try {
            Order clonedOrder = (Order) super.clone();
            clonedOrder.customer = this.customer.clone();
            return clonedOrder;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); 
        }
    }
	

}
