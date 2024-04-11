package final_project_ood;

public class DHL extends ShippingService{

	protected DHL(String contact, int phoneNumber) {
		super(contact, phoneNumber);
	}

	@Override
	public double calculateStandardShippingFees(ProductWebsite product) {
		double shippingFees = product.sellingPrice;
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

}
