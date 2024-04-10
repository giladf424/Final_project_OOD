package final_project_ood;


import final_project_ood.ShippingManager.eShippingType;

public class CreateOrderCommand extends Informer implements ICommand{
	private String orderID;
	private Customer customer;
	private Product product;
	private int quantity;
	private eShippingType shippingType;
	
	
	
	protected CreateOrderCommand(String orderID, Customer customer, Product product, int quantity,
			eShippingType shippingType) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
		this.shippingType = shippingType;
	}
	
		public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public eShippingType getShippingType() {
		return shippingType;
	}

	public void setShippingType(eShippingType shippingType) {
		this.shippingType = shippingType;
	}

	@Override
	public void execute() {
		Store.getStoreInstance().getStorageManager().updateQuantity(this.product, this.quantity);
		Store.getStoreInstance().getStorageManager().addOrderToProduct(this.product, this.orderID);
		if(!(product instanceof ProductWebsite)) {
			Store.getStoreInstance().getOrderManager().createOrder(this.orderID, this.customer, this.product, this.quantity);
		}
		else {
			CheapestShippingService cheapestShipping = inform((ProductWebsite)product, this.shippingType);
			Store.getStoreInstance().getOrderManager().createOrder(this.orderID, this.customer, this.product, this.quantity,
					this.shippingType, cheapestShipping.getPrice(), cheapestShipping.getShippingService());
		}
	}
	
	
}
