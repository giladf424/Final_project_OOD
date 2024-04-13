package final_project_ood;

import java.util.HashSet;
import java.util.Iterator;

public class ShippingManager implements Informed, Cloneable {
	private HashSet<ShippingService> companies;

	public enum eShippingType {
		Standard, Express, NofTypes
	};

	public ShippingManager() {
		this.companies = new HashSet<>();
	}

	public HashSet<ShippingService> getCompanies() {
		return companies;
	}

	public void setCompanies(HashSet<ShippingService> companies) {
		this.companies = companies;
	}

	@Override
	public CheapestShippingService getInformed(eShippingType type, ProductWebsite product) {
		CheapestShippingService cheapest = null;
		eShippingType[] shippingType = eShippingType.values();
		if (type == shippingType[0]) {
			cheapest = getCheapestStandardShipping(product);
		} else if (type == shippingType[1]) {
			cheapest = getCheapestExpressShipping(product);
		}
		return cheapest;

	}

	public boolean addShippingCompany(ShippingService company) {
		return companies.add(company);
	}

	public CheapestShippingService getCheapestStandardShipping(ProductWebsite product) {
		Iterator<ShippingService> shippingIt = companies.iterator();
		ShippingService cheapest = shippingIt.next();
		double min = cheapest.calculateStandardShippingFees(product);
		for (ShippingService company : companies) {
			double tmp = company.calculateStandardShippingFees(product);
			if (tmp < min) {
				min = tmp;
				cheapest = company;
			}
		}
		return new CheapestShippingService(min, cheapest);
	}

	public CheapestShippingService getCheapestExpressShipping(ProductWebsite product) {
		Iterator<ShippingService> shippingIt = companies.iterator();
		ShippingService cheapest = shippingIt.next();
		double min = cheapest.calculateExpressShippingFees(product);
		for (ShippingService company : companies) {
			double tmp = company.calculateExpressShippingFees(product);
			if (tmp < min) {
				min = tmp;
				cheapest = company;
			}
		}
		return new CheapestShippingService(min, cheapest);
	}

	@Override
	public ShippingManager clone() {
		try {
			ShippingManager clonedManager = (ShippingManager) super.clone();
			clonedManager.companies = new HashSet<>();
			for (ShippingService company : this.companies) {
				if (company instanceof DHL) {
					clonedManager.companies.add(((DHL) company).clone());
				} else if (company instanceof FedEx) {
					clonedManager.companies.add(((FedEx) company).clone());
				}
			}
			return clonedManager;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

}
