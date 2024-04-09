package final_project_ood;

import final_project_ood.ShippingManager.eShippingType;

public interface Listener {
	public void update(eShippingType type, ProductWebsite product);
}
