package final_project_ood;

public class Store {
	private static Store storeInstance;
	private OrderManager orderManager;
	private ShippingManager shippingManager;
	private StorageManager storageManager;
	
	
	private Store() {
		this.orderManager = new OrderManager();
		this.shippingManager = new ShippingManager();
		this.storageManager = new StorageManager();
	}
	
	public static Store getStoreInstance() {
		if(storeInstance == null) {
			storeInstance = new Store();
		}
		return storeInstance;
	}
	
	public OrderManager getOrderManager() {
		return this.orderManager;
	}
	
	public ShippingManager getShippingManager() {
		return this.shippingManager;
	}
	
	public StorageManager getStorageManager() {
		return this.storageManager;
	}
}
