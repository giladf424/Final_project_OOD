package final_project_ood;

import final_project_ood.ShippingManager.eShippingType;

public abstract class Publisher {
	private Listener shippingManager;
	
	public Publisher() {
		this.shippingManager = Store.getStoreInstance().getShippingManager();
	}
	
	public CheapestShippingService notifyShipping(ProductWebsite product, eShippingType type) {
		return this.shippingManager.update(type, product);
	}
}
