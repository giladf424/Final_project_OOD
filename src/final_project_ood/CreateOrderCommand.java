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
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public String getOrderID() {
		return this.orderID;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
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
		if((this.product instanceof ProductWebsite) && !((ProductWebsite) this.product).getSupportedShippings()[this.shippingType.ordinal()]) {
			System.out.println("This product doesn't support this shipping type.");
			return;
		}
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
			if(this.shippingType == eShippingType.Standard)
				System.out.println("Please be aware that the store doesn't handle shipping taxes at this moment.");
		}
		this.storageManager.updateQuantity(this.product, this.quantity);
		this.storageManager.addOrderToProduct(this.product, this.orderID);
	}
	
	
}
