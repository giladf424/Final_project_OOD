package final_project_ood;

public class ProductWholesalers extends Product{

	public ProductWholesalers(String name, int costPrice, int sellingPrice, String productID, int weight) {
		super(name, costPrice, sellingPrice, productID, weight);
		this.currency = eCurrency.NIS;
	}
	
	@Override
	public ProductWholesalers clone() {
		try {
			return (ProductWholesalers)super.clone();
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	public String toString() {
		return "Type: " + eProductType.WholesalerProduct + super.toString();
	}
	
}
