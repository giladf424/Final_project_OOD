package final_project_ood;

import java.util.HashSet;

public class ShippingManager implements Listener {
	private HashSet<ShippingService> companies;
	public enum eShippingType { eStandard, eExpress, eNofTypes }
	

	public ShippingManager() {
		this.companies = new HashSet<>();
	}

	@Override
	public void update(eShippingType type, ProductWebsite product) {
		
	}
	
	//add method , to add a new shipping company.
	public boolean addShippingCompany(ShippingService company) {
		return companies.add(company);
	}
	
	// get the cheapest standard shipping cost
	public CheapestShippingService getCheapestStandardShipping(ProductWebsite product) {
		
		double min = 0;
		for (ShippingService company : companies) {
			double tmp =company.calculateStandardtShippingFees(product);
			double firstTmp = tmp;
			if(firstTmp > min) {
				min = tmp;
				ID = company.ID;
			}
			if(tmp < min) {
				min = tmp;
				ID = company.ID;
			}
		}
		return new CheapestShippingService(min, ID);
	}
	
	// get the cheapest express shipping cost
	public CheapestShippingService getCheapestExpressShipping(ProductWebsite product) {
		double min = 0;
		String ID =null;
		for (ShippingService company : companies) {
			double tmp =company.calculateExpresstShippingFees(product);
			double firstTmp = tmp;
			if(firstTmp > min) {
				min = tmp;
				ID = company.ID;
			}
			if(tmp < min) {
				min = tmp;
				ID = company.ID;
			}
		}
		return new CheapestShippingService(min, ID);
	}
	

}


