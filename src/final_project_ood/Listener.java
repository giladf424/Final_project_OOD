package final_project_ood;

import final_project_ood.ShippingManager.eShippingType;

public interface Listener {
	public CheapestShippingService update(eShippingType type, ProductWebsite product);
}
