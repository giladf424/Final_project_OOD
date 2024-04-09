package final_project_ood;

public class DHL extends ShippingService{

	protected DHL(String contact, int phoneNumber, String ID) {
		super(contact, phoneNumber, ID);
	}

	@Override
	public double calculateStandardtShippingFees(ProductWebsite product) {
		double shippingFees = product.sellingPrice * product.exchangeRate;
		if (shippingFees >= 1000) {
			shippingFees = 100;
		} else
			shippingFees *= 0.1;
		return shippingFees;
	}

	@Override
	public double calculateExpresstShippingFees(ProductWebsite product) {
		
		return 100 + calculateImportTax(product.getDestCountry());
	}

}