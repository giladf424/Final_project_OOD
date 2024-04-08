package final_project_ood;

import java.util.HashSet;

public class ShippingManager implements Listener {
	private HashSet<ShippingService> companies;
	public enum eShippingType { eStandard, eExpress, eNofTypes }
	

	public ShippingManager() {
		this.companies = new HashSet<>();
	}

	@Override
	public void update() {
		
	}
	
	//add method , to add a new shipping company.
	
	// get the cheapest standard shipping cost
	
	// get the cheapest express shipping cost
	
	

}


