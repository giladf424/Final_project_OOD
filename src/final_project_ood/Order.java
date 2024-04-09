package final_project_ood;

public class Order {
	private Customer customer;
	private String productID;
	private String orderID;
	private int quantity;
	
	public Order(String orderID, Customer customer, String productID, int quantity) {
		this.orderID = orderID;
		this.customer = customer;
		this.productID = productID;
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
	
	

}
