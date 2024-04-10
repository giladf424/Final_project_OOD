package final_project_ood;

public class UpdateQuantityCommand implements ICommand {
	private StorageManager storageManager;
	private Product product;
	private int quantity;
	
	public UpdateQuantityCommand(Product product, int quantity) {
		this.storageManager = Store.getStoreInstance().getStorageManager();
		this.product = product;
		this.quantity = quantity;
	}
	
	@Override
	public void execute() {
		this.storageManager.addQuantity(this.product, this.quantity);
	}

}
