package final_project_ood;

import final_project_ood.ShippingManager.eShippingType;

public interface Informed {
	public CheapestShippingService getInformed(eShippingType type, ProductWebsite product);
}
