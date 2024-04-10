package final_project_ood;

public class ProductInStore extends Product{

	public ProductInStore(String name, int costPrice, int sellingPrice, String productID, int weight) {
		super(name, costPrice, sellingPrice, productID, weight);
		this.currency = eCurrency.NIS;
	}
	
	
	@Override
	public String toString() {
		return super.toString();
	}

}
