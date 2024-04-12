package final_project_ood;

public class FedEx extends ShippingService implements Cloneable {

	protected FedEx(String contact, int phoneNumber) {
		super(contact, phoneNumber);
	}

	@Override
	public double calculateStandardShippingFees(ProductWebsite product) {
		int temp = product.getWeight() / 10;
		return temp * 10;
	}

	@Override
	public double calculateExpressShippingFees(ProductWebsite product) {
		int temp = product.getWeight() / 10;
		return temp * 50 + calculateImportTax(product.getDestCountry());
	}

	@Override
	public FedEx clone() {
		try {
			return (FedEx) super.clone();
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

}
