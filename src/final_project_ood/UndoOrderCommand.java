package final_project_ood;

public class UndoOrderCommand implements ICommand{
	private OrderManager orderManager;
	private StorageManager storageManager;
	private CreateOrderCommand commandToUndo;
	
	public UndoOrderCommand(CreateOrderCommand commandToUndo) {
		this.orderManager = Store.getStoreInstance().getOrderManager();
		this.storageManager = Store.getStoreInstance().getStorageManager();
		this.commandToUndo = commandToUndo;
	}
	
	@Override
	public void execute() {
		this.orderManager.removeLastOrder();
		this.storageManager.addQuantity(this.commandToUndo.getProduct(), this.commandToUndo.getQuantity());
	}

}
