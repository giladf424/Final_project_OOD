package final_project_ood;

import final_project_ood.ShippingManager.eShippingType;

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
		ProductInStore product1 = this.storageManager.createProductStore("Fishing Pole Model 2", 150, 300, "AT3-FC", 1);						//store product 1
		ProductInStore product2 = this.storageManager.createProductStore("Blue Plastic Chair", 100, 200, "ZBG-4F", 1);							//store product 2
		ProductInStore product3 = this.storageManager.createProductStore("Triangle Toast", 75, 100, "FAH-h7", 2);								//store product 3
		ProductWholesalers product4 = this.storageManager.createProductWholesalers("White Plastic Chair", 30, 60, "ZWG-4G", 1);					//wholesaler product 1
		ProductWholesalers product5 = this.storageManager.createProductWholesalers("Wheat", 20, 70, "DK4-VK", 5);								//wholesaler product 2
		ProductWholesalers product6 = this.storageManager.createProductWholesalers("Wooden Planks 3m Long", 50, 150, "SLO-DR", 3);				//wholesaler product 3
		ProductWebsite product7 = this.storageManager.createProductWebsite("School Bag Mk.3", 30, 100, "BNH-R3", 1, true, false, "Israel");		//website product 1
		ProductWebsite product8 = this.storageManager.createProductWebsite("Keyboard", 40, 150, "S4L-BT", 2, true, true, "Italy");				//website product 2
		ProductWebsite product9 = this.storageManager.createProductWebsite("Aquarium 50L", 80, 250, "HS3-M9", 7, false, true, "Greece");		//website product 3
		
		Customer customer1 = new Customer("Benny", 9385735);
		Customer customer2 = new Customer("Dor", 7257884);
		Customer customer3 = new Customer("Tal", 3579894);
		Customer customer4 = new Customer("Joe Biden", 2458973);
		Customer customer5 = new Customer("Yakov", 7214457);
		Customer customer6 = new Customer("Tami", 3745839);
		
		this.orderManager.createOrder("KDNG-CK7Y", customer1, product1, 1);
		this.orderManager.createOrder("KDNG-BMH7", customer2, product1, 2);
		this.orderManager.createOrder("KDNG-E4HV", customer3, product1, 4);
		this.orderManager.createOrder("DICJ-EN6D", customer4, product2, 10);
		this.orderManager.createOrder("DICJ-39DF", customer5, product2, 4);
		this.orderManager.createOrder("DICJ-934V", customer6, product2, 5);
		this.orderManager.createOrder("LCOE-WERT", customer1, product3, 1);
		this.orderManager.createOrder("LCOE-3647", customer2, product3, 2);
		this.orderManager.createOrder("LCOE-485G", customer3, product3, 1);
		
		this.orderManager.createOrder("NVHDN-JFIR", customer4, product4, 30);
		this.orderManager.createOrder("NVHDN-J47D", customer5, product4, 50);
		this.orderManager.createOrder("NVHDN-KDI3", customer6, product4, 100);
		this.orderManager.createOrder("XNSJD-FJI4", customer1, product5, 100);
		this.orderManager.createOrder("XNSJD-JFIR", customer2, product5, 70);
		this.orderManager.createOrder("XNSJD-ENFU", customer3, product5, 50);
		this.orderManager.createOrder("NC4UI-DN34", customer4, product6, 80);
		this.orderManager.createOrder("NC4UI-3N4H", customer5, product6, 100);
		this.orderManager.createOrder("NC4UI-I6J5", customer6, product6, 20);
		
		CheapestShippingService shipping1 = this.shippingManager.getInformed(eShippingType.Standard, product7);
		this.orderManager.createOrder("NVHD8-OPE34", customer1, product7, 1, eShippingType.Standard, shipping1.getPrice(), shipping1.getShippingService());
		this.orderManager.createOrder("NVHD8-JWEUE", customer2, product7, 2, eShippingType.Standard, shipping1.getPrice(), shipping1.getShippingService());
		this.orderManager.createOrder("NVHD8-CKI5K", customer3, product7, 1, eShippingType.Standard, shipping1.getPrice(), shipping1.getShippingService());
		
		CheapestShippingService shipping2standard = this.shippingManager.getInformed(eShippingType.Standard, product8);
		CheapestShippingService shipping2express = this.shippingManager.getInformed(eShippingType.Express, product8);
		this.orderManager.createOrder("CIRN3-83UD5", customer4, product8, 4, eShippingType.Standard, shipping2standard.getPrice(), shipping2standard.getShippingService());
		this.orderManager.createOrder("CIRN3-JFNR3", customer5, product8, 2, eShippingType.Express, shipping2express.getPrice(), shipping2express.getShippingService());
		this.orderManager.createOrder("CIRN3-CKRIF", customer6, product8, 1, eShippingType.Standard, shipping2standard.getPrice(), shipping2standard.getShippingService());
		
		CheapestShippingService shipping3 = this.shippingManager.getInformed(eShippingType.Express, product9);
		this.orderManager.createOrder("JDNF3-KD3I5", customer1, product9, 1, eShippingType.Express, shipping3.getPrice(), shipping3.getShippingService());
		this.orderManager.createOrder("JDNF3-JENRC", customer2, product9, 1, eShippingType.Express, shipping3.getPrice(), shipping3.getShippingService());
		this.orderManager.createOrder("JDNF3-4958C", customer3, product9, 3, eShippingType.Express, shipping3.getPrice(), shipping3.getShippingService());
	}

}
