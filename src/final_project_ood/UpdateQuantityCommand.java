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
		if(this.product == null) {
			System.out.println("This product doesn't exist.");
			return;
		}
		if(this.quantity < 0) {
			System.out.println("Quantity can't be a negative value.");
		}
		this.storageManager.addQuantity(this.product, this.quantity);
	}

}
