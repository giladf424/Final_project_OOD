package final_project_ood;

public class CheapestShippingService {
	private double price;
	private String ID;
	
	
	public CheapestShippingService(double price, String iD) {
		this.price = price;
		this.ID = iD;
	}


	public double getPrice() {
		return price;
	}

	public String getID() {
		return ID;
	}
	

}
