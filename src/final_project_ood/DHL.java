package final_project_ood;

public class DHL extends ShippingService implements Cloneable {

	protected DHL(String contact, int phoneNumber) {
		super(contact, phoneNumber);
	}

	@Override
	public double calculateStandardShippingFees(ProductWebsite product) {
		double shippingFees = product.getSellingPrice();
		if (shippingFees >= 1000) {
			shippingFees = 100;
		} else
			shippingFees *= 0.1;
		return shippingFees;
	}

	@Override
	public double calculateExpressShippingFees(ProductWebsite product) {

		return 100 + calculateImportTax(product.getDestCountry());
	}

	@Override
	public DHL clone() {
		try {
			return (DHL) super.clone();
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

}
