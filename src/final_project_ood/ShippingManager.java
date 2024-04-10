package final_project_ood;

import java.util.HashSet;
import java.util.Iterator;

public class ShippingManager implements Informed {
	private HashSet<ShippingService> companies;
	public enum eShippingType { Standard, Express, NofTypes };
	

	public ShippingManager() {
		this.companies = new HashSet<>();
	}

	@Override
	public CheapestShippingService getInformed(eShippingType type, ProductWebsite product) {
		CheapestShippingService cheapest = null;
		eShippingType[] shippingType = eShippingType.values();
		if(type == shippingType[0]) {
			cheapest = getCheapestStandardShipping(product);
		}else if(type == shippingType[1]) {
			cheapest = getCheapestExpressShipping(product);
		}
		return cheapest;
		
	}
	
	//add method , to add a new shipping company.
	public boolean addShippingCompany(ShippingService company) {
		return companies.add(company);
	}
	
	// get the cheapest standard shipping cost
	public CheapestShippingService getCheapestStandardShipping(ProductWebsite product) {
		Iterator<ShippingService> shippingIt = companies.iterator();
		ShippingService cheapest = shippingIt.next();
		double min = cheapest.calculateStandardtShippingFees(product);
		for (ShippingService company : companies) {
			double tmp =company.calculateStandardtShippingFees(product);
			if(tmp < min) {
				min = tmp;
				cheapest = company;
			}
		}
		return new CheapestShippingService(min, cheapest);
	}
	
	// get the cheapest express shipping cost
	public CheapestShippingService getCheapestExpressShipping(ProductWebsite product) {
		Iterator<ShippingService> shippingIt = companies.iterator();
		ShippingService cheapest = shippingIt.next();
		double min = cheapest.calculateExpresstShippingFees(product);
		for (ShippingService company : companies) {
			double tmp =company.calculateExpresstShippingFees(product);
			if(tmp < min) {
				min = tmp;
				cheapest = company;
			}
		}
		return new CheapestShippingService(min, cheapest);
	}
	

}


