package final_project_ood;

public class RemoveProductCommand implements ICommand{
	private StorageManager storageManager;
	private String productID;
	
	public RemoveProductCommand(Product product) {
		this.storageManager = Store.getStoreInstance().getStorageManager();
		this.productID = product.getProductID();
	}

	@Override
	public void execute() {
		this.storageManager.setProductActivity(productID, false);
	}
}
