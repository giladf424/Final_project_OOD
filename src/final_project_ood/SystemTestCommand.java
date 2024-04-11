package final_project_ood;

public class SystemTestCommand implements ICommand{
	private StorageManager storageManager;
	private OrderManager orderManager;
	private ShippingManager shippingManager;
	
	public SystemTestCommand() {
		this.storageManager = new StorageManager();
		this.orderManager = new OrderManager();
		this.shippingManager = new ShippingManager();
	}
	
	@Override
	public void execute() {
		this.storageManager.createProductStore("Fishing Pole Model 2", 150, 300, "AT3-FC", 1);						//store product 1
		this.storageManager.createProductStore("Blue Plastic Chair", 100, 200, "ZBG-4F", 1);						//store product 2
		this.storageManager.createProductStore("Triangle Toast", 75, 100, "FAH-h7", 2);								//store product 3
		this.storageManager.createProductWholesalers("White Plastic Chair", 30, 60, "ZWG-4G", 1);					//wholesaler product 1
		this.storageManager.createProductWholesalers("Wheat", 20, 70, "DK4-VK", 5);									//wholesaler product 2
		this.storageManager.createProductWholesalers("Wooden Planks 3m Long", 50, 150, "SLO-DR", 3);				//wholesaler product 3
		this.storageManager.createProductWebsite("School Bag Mk.3", 30, 100, "BNH-R3", 1, true, false, "Israel");	//website product 1
		this.storageManager.createProductWebsite("Keyboard", 40, 150, "S4L-BT", 2, true, true, "Italy");			//website product 2
		this.storageManager.createProductWebsite("Aquarium 50L", 80, 250, "HS3-M9", 7, false, true, "Greece");		//website product 3
		
		
	}

}
