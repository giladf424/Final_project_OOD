package final_project_ood;

public abstract class ShippingService implements Cloneable {
	protected String contact;
	protected int phoneNumber;

	public ShippingService(String contact, int phoneNumber) {
		this.contact = contact;
		this.phoneNumber = phoneNumber;
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

	public abstract double calculateStandardShippingFees(ProductWebsite product);

	public abstract double calculateExpressShippingFees(ProductWebsite product);

	public double calculateImportTax(String destCountry) {
		return 20;
	}

	@Override
	public ShippingService clone() {
		try {
			return (ShippingService) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

}
