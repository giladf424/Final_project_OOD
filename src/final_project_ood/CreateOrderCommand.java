package final_project_ood;

import java.util.Scanner;

public class CreateOrderCommand implements ICommand{
	private Scanner input;
	public static final int WEBSITE_PRODUCTS = 1;
	public static final int STORE_PRODUCTS = 2;
	public static final int WHOLESALERS_PRODUCTS = 3;
	
	public CreateOrderCommand() {
		this.input = new Scanner(System.in);
	}
	
	@Override
	public void execute() {
		String orderID = getOrederID();
		if(orderID.equals(null))
			return;
		Customer customer = getCustomerInfo();
		String productID = getProductID();
		int quantity = getQuantity();
		Order newOrder = Store.getStoreInstance().getOrderManager().createOrder(orderID, customer, productID, quantity);
	}
	
	private String getOrederID() {
		String orderID;
		System.out.println("Enter order ID:");
		orderID = this.input.nextLine();
		if(Store.getStoreInstance().getOrderManager().doesOrderExist(orderID))
		{
			System.out.println("There is already an order with that ID.");
			return null;
		}
		return orderID;
	}
	
	private Customer getCustomerInfo() {
		String customerName;
		int mobileNumber;
		System.out.println("Enter customer name:");
		customerName = this.input.nextLine();
		System.out.println("Enter customer mobile number:");
		mobileNumber = this.input.nextInt();
		Customer customer = new Customer(customerName, mobileNumber);
		return customer;
	}

	private String getProductID() {
		String productID;
		do {
			int requestedType = printProductsOfType();
			System.out.println("Enter product ID:");
			productID = this.input.nextLine();
			Product requestedProduct = Store.getStoreInstance().getStorageManager().getProductByID(productID);
			if(requestedProduct == null){
				System.out.println("No product with this ID.");
			}
			else {
				switch(requestedType){
				case WEBSITE_PRODUCTS:
					if(!(requestedProduct instanceof ProductWebsite)) {
						System.out.println("The product ID entered doesn't belong to a product sold through the website.");
						productID = null;
					}
					break;
				case STORE_PRODUCTS:
					if(!(requestedProduct instanceof ProductInStore)) {
						System.out.println("The product ID entered doesn't belong to a product sold in the store.");
						productID = null;
					}
					break;
				case WHOLESALERS_PRODUCTS:
					if(!(requestedProduct instanceof ProductWholesalers)) {
						System.out.println("The product ID entered doesn't belong to a product sold to wholesalers.");
						productID = null;
					}
					break;
				}
			}
		}while(productID == null);
		return productID;
	}
	
	private int printProductsOfType() {
		int userChoice;
		StorageManager storage = Store.getStoreInstance().getStorageManager();
		do {
			System.out.println("Choose product type you want to order:");
			System.out.println("" + WEBSITE_PRODUCTS + " - Sold on Website");
			System.out.println("" + STORE_PRODUCTS + " - Sold in Store");
			System.out.println("" + WHOLESALERS_PRODUCTS + " - Sold to Wholesalers");
			userChoice = this.input.nextInt();
			switch(userChoice) {
			case WEBSITE_PRODUCTS:
				storage.printProducts(storage.getAllWebsiteProducts());
				break;
			case STORE_PRODUCTS:
				storage.printProducts(storage.getAllInStoreProducts());
				break;
			case WHOLESALERS_PRODUCTS:
				storage.printProducts(storage.getAllWholesalersProducts());
				break;
			default:
				System.out.print("No such category. ");
			}
		}while(userChoice != WEBSITE_PRODUCTS && userChoice != STORE_PRODUCTS && userChoice != WHOLESALERS_PRODUCTS);
		
		return userChoice;
	}

	private int getQuantity() {
		System.out.println("Enter product quantity for the order:");
		int quantity = this.input.nextInt();
		return quantity;
	}
}