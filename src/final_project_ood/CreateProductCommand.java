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
	
	
	public CreateProductCommand(String name, int costPrice, int sellingPrice, String productID, int weight) {
		this.storageManager = Store.getStoreInstance().getStorageManager();
		this.name = name;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.productID = productID;
		this.weight = weight;
		this.regularShipping = false;
		this.expressShipping = false;
		this.destCountry = null;
	}
	
	public CreateProductCommand(String name, int costPrice, int sellingPrice, String productID, int weight, boolean regular, boolean express, String dest) {
		this.storageManager = Store.getStoreInstance().getStorageManager();
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
		
	}

}
