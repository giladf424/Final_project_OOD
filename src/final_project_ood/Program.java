package final_project_ood;

import java.util.ArrayList;
import java.util.Iterator;
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
		orderID = input.next();
		return orderID;
	}
	
	public static Customer getCustomerInfo() {
		String customerName;
		int mobileNumber;
		System.out.println("Enter customer name:");
		customerName = input.nextLine();
		System.out.println("Enter customer mobile number: (only numbers)");
		mobileNumber = input.nextInt();
		Customer customer = new Customer(customerName, mobileNumber);
		return customer;
	}

	public static Product getProduct() {
		String productID;
		Product requestedProduct;
		eProductType type = getTypeOfProduct();
		ArrayList<Product> products;
		if(type.equals(eProductType.WebsiteProduct)) {
			products = Store.getStoreInstance().getStorageManager().getAllWebsiteProducts();
		}
		else if(type.equals(eProductType.StoreProduct)) {
			products = Store.getStoreInstance().getStorageManager().getAllInStoreProducts();
		}
		else {
			products = Store.getStoreInstance().getStorageManager().getAllWholesalersProducts();
		}
		
		if(products.isEmpty()) {
			System.out.println("There are no products of that type.");
			return null;
		}
		//printProductsOfType();
		System.out.println("Enter product ID:");
		productID = input.next();
		requestedProduct = Store.getStoreInstance().getStorageManager().getProductByID(productID);
		return requestedProduct;
	}
	
	public static int printProductsOfType() {
		int userChoice;
		StorageManager storage = Store.getStoreInstance().getStorageManager();
		do {
			System.out.println("Choose product type:");
			System.out.println("" + WEBSITE_PRODUCTS + " - Sold on Website");
			System.out.println("" + STORE_PRODUCTS + " - Sold in Store");
			System.out.println("" + WHOLESALERS_PRODUCTS + " - Sold to Wholesalers");
			userChoice = input.nextInt();
			switch(userChoice) {
			case WEBSITE_PRODUCTS:
				printProducts(storage.getAllWebsiteProducts());
				break;
			case STORE_PRODUCTS:
				printProducts(storage.getAllInStoreProducts());
				break;
			case WHOLESALERS_PRODUCTS:
				printProducts(storage.getAllWholesalersProducts());
				break;
			default:
				System.out.print("No such category. ");
			}
		}while(userChoice != WEBSITE_PRODUCTS && userChoice != STORE_PRODUCTS && userChoice != WHOLESALERS_PRODUCTS);
		
		return userChoice;
	}
	
	public static void printProducts(ArrayList<Product> products) {
		if(products.isEmpty()) {
			System.out.println("There are no products in the collection.");
		}
		else {
			for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
				System.out.println(product.toString());
			}
		}
	}

	public static int getQuantity(Product product) {
		System.out.println("Enter product quantity for the order:");
		int quantity = input.nextInt();
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
		name = input.next();
		return name;
	}
	
	public static String getProductID() {
		String id = new String();
		System.out.println("Enter product ID:");
		id = input.next();
		return id;
	}
	
	public static int getCostPrice() {
		System.out.println("Enter cost price:");
		int costPrice = input.nextInt();
		return costPrice;
	}
	
	public static int getSellingPrice() {
		System.out.println("Enter selling price:");
		int sellingPrice = input.nextInt();
		return sellingPrice;
	}
	
	public static int getWeight() {
		System.out.println("Enter product weight:");
		int weight = input.nextInt();
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
		dest = input.next();
		return dest;
	}

	public static void printMenu() {
		System.out.println("Choose an action to perform:");
		System.out.println("1 - Automatic System Test.");
		System.out.println("2 - Add a Product to the Store.");
		System.out.println("3 - Remove a Product from the Store.");
		System.out.println("4 - Update the Stock of a Product.");
		System.out.println("5 - Add an Order of a Product.");
		System.out.println("6 - Delete the Last Order.");
		System.out.println("7 - Display the Details of a Product.");
		System.out.println("8 - Display All the Products and Orders.");
		System.out.println("9 - Display the Orders of a Product.");
		System.out.println("10 - Create a System Backup.");
		System.out.println("11 - Restore the System from the Last Backup.");
		System.out.println("E/e - Exit the System.");
	}
	
	public static void main(String[] args) {
		String userChoice = new String();
		ICommand cmd;
		System.out.println("Welcome to our store system!");
		do {
			printMenu();
			userChoice = input.next().substring(0, 1);
			switch(userChoice) {
			case "1":
				cmd = new SystemTestCommand();
				cmd.execute();
				System.out.println("Action complete.");
				break;
			case "2":
				eProductType type = getTypeOfProduct();
				if(type.ordinal() == eProductType.WebsiteProduct.ordinal()) {
					cmd = new CreateProductCommand(type, getProductName(), getCostPrice(), getSellingPrice(), getProductID(), getWeight(), getStandardShippingSupport(), getExpressShippingSupport(), getDestCountry());
				}
				else {
					cmd = new CreateProductCommand(type, getProductName(), getCostPrice(), getSellingPrice(), getProductID(), getWeight());
				}
				cmd.execute();
				System.out.println("Action complete.");
				printProducts(Store.getStoreInstance().getStorageManager().getAllInStoreProducts());
				System.out.println();
				printProducts(Store.getStoreInstance().getStorageManager().getAllWholesalersProducts());
				System.out.println();
				printProducts(Store.getStoreInstance().getStorageManager().getAllProducts());
				break;
			case "3":
				cmd = new RemoveProductCommand(getProduct());
				cmd.execute();
				System.out.println("Action complete.");
				break;
			case "E":
			case "e":
				System.out.println("Exiting system.");
				break;
			default:
				System.out.println("Unknown input detected. Try again.");
			}
		}while(!userChoice.equals("E") && !userChoice.equals("e"));
		/*CreateOrderCommand cmd = new CreateOrderCommand(getOrderID(), getCustomerInfo(), getProduct(), STORE_PRODUCTS, null);
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
		}*/
	}

}
