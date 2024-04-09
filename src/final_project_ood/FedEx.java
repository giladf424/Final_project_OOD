package final_project_ood;

public class FedEx extends ShippingService {

	protected FedEx(String contact, int phoneNumber, String ID) {
		super(contact, phoneNumber, ID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateStandardtShippingFees(ProductWebsite product) {
		int temp = product.productWeight/10;
		return temp * 10;
	}

	@Override
	public double calculateExpresstShippingFees(ProductWebsite product) {
		int temp = product.productWeight/10;
		return temp * 50 + calculateImportTax(product.getDestCountry());
	}

}
