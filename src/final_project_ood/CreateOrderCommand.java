package final_project_ood;


import final_project_ood.ShippingManager.eShippingType;

public class CreateOrderCommand extends Informer implements ICommand{
	private StorageManager storageManager;
	private OrderManager orderManager;
	private String orderID;
	private Customer customer;
	private Product product;
	private int quantity;
	private eShippingType shippingType;
	
	
	
	public CreateOrderCommand(String orderID, Customer customer, Product product, int quantity,
			eShippingType shippingType) {
		super();
		this.storageManager = Store.getStoreInstance().getStorageManager();
		this.orderManager = Store.getStoreInstance().getOrderManager();
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
		if(Store.getStoreInstance().getOrderManager().doesOrderExist(this.orderID)) {
			System.out.println("There is already an order with that ID.");
			return;
		}
		if(this.product == null || !this.product.getIsActive()){
			System.out.println("No product with this ID.");
			return;
		}
		if(this.quantity <= 0) {
			System.out.println("Order quantity has to be a positive number.");
			return;
		}
		if(this.product.getStock() < this.quantity) {
			System.out.println("These isn't enough of " + product.getProductName() + " in stock to make that order, try again.");
			return;
		}
		this.storageManager.updateQuantity(this.product, this.quantity);
		this.storageManager.addOrderToProduct(this.product, this.orderID);
		if(!(product instanceof ProductWebsite)) {
			this.orderManager.createOrder(this.orderID, this.customer, this.product, this.quantity);
		}
		else {
			if(this.shippingType == null) {
				System.out.println("Incorrect shipping type.");
				return;
			}
			CheapestShippingService cheapestShipping = inform((ProductWebsite)product, this.shippingType);
			this.orderManager.createOrder(this.orderID, this.customer, this.product, this.quantity,
					this.shippingType, cheapestShipping.getPrice(), cheapestShipping.getShippingService());
		}
	}
	
	
}
