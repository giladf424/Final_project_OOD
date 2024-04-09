package final_project_ood;

public abstract class ShippingService {
	protected String contact;
	protected int phoneNumber;
	protected String ID;
	
	protected ShippingService(String contact, int phoneNumber, String Id) {
		this.contact = contact;
		this.phoneNumber = phoneNumber;
		this.ID = ID;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public abstract double calculateStandardtShippingFees(ProductWebsite product);
	
	public abstract double calculateExpresstShippingFees(ProductWebsite product);
	
	public double calculateImportTax(String destCountry) {
		return 20;
	}
	

}
