package final_project_ood;

public class Store {
	private static Store storeInstance;
	private OrderManager orderManager;
	private ShippingManager shippingManager;
	private StorageManager storageManager;
	private StoreMemento storeBackup;
	
	private Store() {
		this.orderManager = new OrderManager();
		this.shippingManager = new ShippingManager();
		this.storageManager = new StorageManager();
		this.storeBackup = null;
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
	
	public StoreMemento getStoreBackup() {
		return this.storeBackup;
	}
	
	public void setStoreBackup(StoreMemento storeBackup) {
		this.storeBackup = storeBackup;
	}
	
	public static class StoreMemento{
		private final OrderManager orderManager;
		private final ShippingManager shippingManager;
		private final StorageManager storageManager;
		
		private StoreMemento(OrderManager orderManager, ShippingManager shippingManager, StorageManager storageManager) {
			this.orderManager = orderManager.clone();
			this.shippingManager = shippingManager.clone();
			this.storageManager = storageManager.clone();
		}
		
	}
	
	public StoreMemento createMemento() {
		return new StoreMemento(this.orderManager, this.shippingManager, this.storageManager);
	}
	
	public void restoreFromMemento(StoreMemento memento) {
		this.orderManager = memento.orderManager;
		this.shippingManager = memento.shippingManager;
		this.storageManager = memento.storageManager;
	}
}
