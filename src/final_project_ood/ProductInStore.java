package final_project_ood;

public class ProductInStore extends Product{

	public ProductInStore(String name, int costPrice, int sellingPrice, String productID, int weight) {
		super(name, costPrice, sellingPrice, productID, weight);
		this.currency = eCurrency.NIS;
	}
	
	@Override
	public ProductInStore clone() {
		try {
			return (ProductInStore)super.clone();
		} catch (Exception e) {
			throw new AssertionError();
		}
	}
	
	@Override
	public String toString() {
		return "Type: " + eProductType.StoreProduct + super.toString();
	}

}
