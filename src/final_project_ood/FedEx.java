package final_project_ood;

public class FedEx extends ShippingService {

	protected FedEx(String contact, int phoneNumber) {
		super(contact, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateStandardtShippingFees(ProductWebsite product) {
		
		return 0;
	}

	@Override
	public double calculateExpresstShippingFees(ProductWebsite product) {
		// TODO Auto-generated method stub
		return 0;
	}

}
