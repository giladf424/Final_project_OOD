package final_project_ood;

public class CheapestShippingService {
	private double price;
	private ShippingService company;
	
	
	public CheapestShippingService(double price, ShippingService company) {
		this.price = price;
		this.company = company;
	}


	public double getPrice() {
		return price;
	}

	public ShippingService getShippingService () {
		return company;
	}
	

}
