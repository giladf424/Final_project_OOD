package final_project_ood;

import final_project_ood.ShippingManager.eShippingType;

public abstract class Informer {
	protected Informed shippingManager;
	
	public Informer() {
		this.shippingManager = Store.getStoreInstance().getShippingManager();
	}
	
	public CheapestShippingService inform(ProductWebsite product, eShippingType type) {
		return this.shippingManager.getInformed(type, product);
	}
}
