package final_project_ood;

import java.util.Scanner;
import java.util.Stack;

import final_project_ood.Product.eProductType;
import final_project_ood.ShippingManager.eShippingType;

public class Program {
	private static Scanner input = new Scanner(System.in);
	public static final int WEBSITE_PRODUCTS = 1;
	public static final int STORE_PRODUCTS = 2;
	public static final int WHOLESALERS_PRODUCTS = 3;
	private static Stack<CreateOrderCommand> commandStack = new Stack<>();
	
	public static eShippingType getShippingType(Product product) {
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
				type = eShippingType.valueOf(input.next());
			} catch (Exception e) {
				System.out.println("Unknown shipping type.");
				typeChosen = false;
			}
		}while(typeChosen == false);
		return type;
	}
	
	public static String getOrderID() {
		String orderID;
		System.out.println("Enter order ID:");
		do {
			orderID = input.nextLine();
			if(Store.getStoreInstance().getOrderManager().doesOrderExist(orderID))
				System.out.println("There is already an order with that ID, try again.");
		} while (Store.getStoreInstance().getOrderManager().doesOrderExist(orderID));
		
		return orderID;
	}
	
	public static Customer getCustomerInfo() {
		String customerName;
		int mobileNumber;
		System.out.println("Enter customer name:");
		customerName = input.nextLine();
		System.out.println("Enter customer mobile number:");
		mobileNumber = input.nextInt();
		Customer customer = new Customer(customerName, mobileNumber);
		return customer;
	}

	public static Product getProduct() {
		String productID;
		Product requestedProduct;
		do {
			int requestedType = printProductsOfType();
			System.out.println("Enter product ID:");
			productID = input.nextLine();
			requestedProduct = Store.getStoreInstance().getStorageManager().getProductByID(productID);
			if(requestedProduct == null || !requestedProduct.getIsActive()){
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
	
	public static int printProductsOfType() {
		int userChoice;
		StorageManager storage = Store.getStoreInstance().getStorageManager();
		do {
			System.out.println("Choose product type you want to order:");
			System.out.println("" + WEBSITE_PRODUCTS + " - Sold on Website");
			System.out.println("" + STORE_PRODUCTS + " - Sold in Store");
			System.out.println("" + WHOLESALERS_PRODUCTS + " - Sold to Wholesalers");
			userChoice = input.nextInt();
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

	public static int getQuantity(Product product) {
		System.out.println("Enter product quantity for the order:");
		int quantity;
		do {
			quantity = input.nextInt();
			if(product.getStock() < quantity) {
				System.out.println("These isn't enough of " + product.getProductName() + " in stock to make that order, try again.");
			}
		} while (product.getStock() < quantity);
		return quantity;
	}
	
	public static eProductType getTypeOfProduct() {
		int userChoice;
		do {
			System.out.println("Choose type of product:");
			System.out.println("" + WEBSITE_PRODUCTS + " - Sold on Website");
			System.out.println("" + STORE_PRODUCTS + " - Sold in Store");
			System.out.println("" + WHOLESALERS_PRODUCTS + " - Sold to Wholesalers");
			userChoice = input.nextInt();
			switch(userChoice) {
			case WEBSITE_PRODUCTS:
				return eProductType.WebsiteProduct;
			case STORE_PRODUCTS:
				return eProductType.StoreProduct;
			case WHOLESALERS_PRODUCTS:
				return eProductType.WholesalerProduct;
			default:
				System.out.print("No such type. ");
			}
			
		}while(userChoice != WEBSITE_PRODUCTS && userChoice != STORE_PRODUCTS && userChoice != WHOLESALERS_PRODUCTS);
		return eProductType.StoreProduct;
	}

	public static String getProductName() {
		String name = new String();
		System.out.println("Enter product name:");
		name = input.nextLine();
		return name;
	}
	
	public static String getProductID() {
		String id = new String();
		System.out.println("Enter product ID:");
		id = input.nextLine();
		return id;
	}
	
	public static int getCostPrice() {
		int costPrice;
		do {
			System.out.println("Enter cost price:");
			costPrice = input.nextInt();
			if(costPrice <= 0) {
				System.out.println("Cost price must be a positive number.");
			}
		}while(costPrice <= 0);
		return costPrice;
	}
	
	public static int getSellingPrice() {
		int sellingPrice;
		do {
			System.out.println("Enter selling price:");
			sellingPrice = input.nextInt();
			if(sellingPrice <= 0) {
				System.out.println("Selling price must be a positive number.");
			}
		}while(sellingPrice <= 0);
		return sellingPrice;
	}
	
	public static int getWeight() {
		int weight;
		do {
			System.out.println("Enter product weight:");
			weight = input.nextInt();
			if(weight <= 0) {
				System.out.println("Product weight must be a positive value.");
			}
		}while(weight <= 0);
		return weight;
	}
	
	public static boolean getStandardShippingSupport() {
		boolean standardSupport = true;
		char value;
		do {
			System.out.println("Does the product support standard shipping? (T/F)");
			value = input.next().charAt(0);
			switch(value) {
			case 'T':
			case 't':
				standardSupport = true;
				break;
			case 'F':
			case 'f':
				standardSupport = false;
				break;
			default:
				System.out.println("Unknown character.");
			}
		}while(value != 'T' && value != 't' && value != 'F' && value != 'f');
		return standardSupport;
	}
	
	public static boolean getExpressShippingSupport() {
		boolean expressSupport = true;
		char value;
		do {
			System.out.println("Does the product support express shipping? (T/F)");
			value = input.next().charAt(0);
			switch(value) {
			case 'T':
			case 't':
				expressSupport = true;
				break;
			case 'F':
			case 'f':
				expressSupport = false;
				break;
			default:
				System.out.println("Unknown character.");
			}
		}while(value != 'T' && value != 't' && value != 'F' && value != 'f');
		return expressSupport;
	}
	
	public static String getDestCountry() {
		String dest = new String();
		dest = input.nextLine();
		return dest;
	}

	public static void main(String[] args) {
		CreateOrderCommand cmd = new CreateOrderCommand(getOrderID(), getCustomerInfo(), getProduct(), STORE_PRODUCTS, null);
		commandStack.add(cmd);
		UndoOrderCommand cmd1 = new UndoOrderCommand(commandStack.pop());
		
		CreateProductCommand cmdCreateProduct;
		eProductType productType = getTypeOfProduct();
		if(productType == eProductType.WebsiteProduct) {
			cmdCreateProduct = new CreateProductCommand(productType, getProductName(), getCostPrice(), getSellingPrice(), getProductID(), getWeight(),
					getStandardShippingSupport(), getExpressShippingSupport(), getDestCountry());
		}
		else {
			cmdCreateProduct = new CreateProductCommand(productType, getProductName(), getCostPrice(), getSellingPrice(), getProductID(), getWeight());
		}
		cmd.setOrderID(getOrderID());
	}

}
