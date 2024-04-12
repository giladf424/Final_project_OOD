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
		if(commandToUndo == null) {
			System.out.println("There is no order to undo.");
			return;
		}
		System.out.println("Dear " + commandToUndo.getCustomer().getCustomerName() + ",");
		System.out.println("We are sorry to inform you that your order " + commandToUndo.getOrderID() + " has been canceled due to storage issues.");
		this.orderManager.removeLastOrder();
		this.storageManager.addQuantity(this.commandToUndo.getProduct(), this.commandToUndo.getQuantity());
		
	}

}
