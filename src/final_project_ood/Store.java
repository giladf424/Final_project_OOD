package final_project_ood;

import java.util.Iterator;
import java.util.LinkedHashSet;

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
	
	public static class storeMemento{
		private final OrderManager orderManager;
		private final ShippingManager shippingManager;
		private final StorageManager storageManager;
		
		private storeMemento(OrderManager orderManager, ShippingManager shippingManager, StorageManager storageManager) {
			this.orderManager = new OrderManager();
			this.shippingManager = new ShippingManager();
			this.storageManager = storageManager.clone();
		}
		
	}
	
	public storeMemento createMemento() {
		return new storeMemento(this.orderManager, this.shippingManager, this.storageManager);
	}
	
	public void restoreFromMemento(storeMemento memento) {
		this.orderManager = memento.orderManager;
		this.shippingManager = memento.shippingManager;
		this.storageManager = memento.storageManager;
	}
}
