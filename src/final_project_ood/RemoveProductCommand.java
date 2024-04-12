package final_project_ood;

public class RemoveProductCommand implements ICommand{
	private StorageManager storageManager;
	private Product product;
	
	public RemoveProductCommand(Product product) {
		this.storageManager = Store.getStoreInstance().getStorageManager();
		this.product = product;
	}

	@Override
	public void execute() {
		if(this.product == null) {
			return;
		}
		this.storageManager.setProductActivity(product.getProductID(), false);
		this.storageManager.setProductStock(product.getProductID(), 0);
	}
}
