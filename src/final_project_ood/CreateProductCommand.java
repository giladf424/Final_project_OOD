package final_project_ood;

import final_project_ood.Product.eProductType;

public class CreateProductCommand implements ICommand{
	private StorageManager storageManager;
	private String name;
	private int costPrice;
	private int sellingPrice;
	private String productID;
	private int weight;
	private boolean regularShipping;
	private boolean expressShipping;
	private String destCountry;
	private eProductType productType;
	
	
	public CreateProductCommand(eProductType productType, String name, int costPrice, int sellingPrice, String productID, int weight) {
		this.storageManager = Store.getStoreInstance().getStorageManager();
		this.productType = productType;
		this.name = name;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.productID = productID;
		this.weight = weight;
		this.regularShipping = false;
		this.expressShipping = false;
		this.destCountry = null;
	}
	
	public CreateProductCommand(eProductType productType, String name, int costPrice, int sellingPrice, String productID, int weight, boolean regular, boolean express, String dest) {
		this.storageManager = Store.getStoreInstance().getStorageManager();
		this.productType = productType;
		this.name = name;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.productID = productID;
		this.weight = weight;
		this.regularShipping = regular;
		this.expressShipping = express;
		this.destCountry = dest;
	}
	
	@Override
	public void execute() {
		if(this.name == null || this.productID == null) {
			System.out.println("Improper product name or ID.");
			return;
		}
		if(this.storageManager.getProductByID(this.productID) != null && this.storageManager.getProductByID(this.productID).getIsActive()) {
			System.out.println("This product ID is already taken.");
			return;
		}
		if(this.costPrice <= 0 || this.sellingPrice <= 0 || this.sellingPrice < this.costPrice) {
			System.out.println("Improper prices for product.");
			return;
		}
		if(this.weight <= 0) {
			System.out.println("Product weight must be have a positive value.");
			return;
		}
		switch(this.productType) {
		case WebsiteProduct:
			if(this.destCountry == null) {
				System.out.println("Destination country invalid.");
				return;
			}
			this.storageManager.createProductWebsite(name, costPrice, sellingPrice, productID, weight, regularShipping, expressShipping, destCountry);
			break;
		case StoreProduct:
			this.storageManager.createProductStore(name, costPrice, sellingPrice, productID, weight);
			break;
		case WholesalerProduct:
			this.storageManager.createProductStore(name, costPrice, sellingPrice, productID, weight);
			break;
		}
	}

}
