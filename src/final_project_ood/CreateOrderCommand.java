package final_project_ood;

import java.util.Scanner;

import final_project_ood.ShippingManager.eShippingType;

public class CreateOrderCommand extends Informer implements ICommand{
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
		Product product = getProduct();
		int quantity = getQuantity();
		if(product.getStock() < quantity) {
			System.out.println("These isn't enough of " + product.getProductName() + " in stock to make that order.");
			return;
		}
		Store.getStoreInstance().getStorageManager().updateQuantity(product, quantity);
		Store.getStoreInstance().getStorageManager().addOrderToProduct(product, orderID);
		if(!(product instanceof ProductWebsite)) {
			Order newOrder = Store.getStoreInstance().getOrderManager().createOrder(orderID, customer, product.getProductID(), quantity);
		}
		else {
			eShippingType shippingType = getShippingType(product);
			CheapestShippingService cheapestShipping = inform((ProductWebsite)product, shippingType);
			OrderShipped newOrder = Store.getStoreInstance().getOrderManager().createOrder(orderID, customer, product.getProductID(), quantity,
					shippingType, cheapestShipping.getPrice(), cheapestShipping.getShippingService());
		}
	}
	
	private eShippingType getShippingType(Product product) {
		ProductWebsite webProduct = (ProductWebsite)product;
		System.out.println("This product supports the following shipping types:");
		for(int i = 0; i < eShippingType.NofTypes.ordinal(); i++) {
			System.out.print("" + eShippingType.values()[i] + " shipping: ");
			if(!webProduct.getSupportedShippings()[i]) {
				System.out.println("not ");
			}
			System.out.println("supported.");
		}
		System.out.println();
		eShippingType type = eShippingType.Standard;
		boolean typeChosen;
		do {
			typeChosen = true;
			System.out.println("Choose desired shipping type:");
			try {
				type = eShippingType.valueOf(this.input.next());
			} catch (Exception e) {
				System.out.println("Unknown shipping type.");
				typeChosen = false;
			}
		}while(typeChosen == false);
		return type;
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

	private Product getProduct() {
		String productID;
		Product requestedProduct;
		do {
			int requestedType = printProductsOfType();
			System.out.println("Enter product ID:");
			productID = this.input.nextLine();
			requestedProduct = Store.getStoreInstance().getStorageManager().getProductByID(productID);
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
		return requestedProduct;
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
