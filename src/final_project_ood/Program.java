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
		if(!(product instanceof ProductWebsite)) {
			return eShippingType.Standard;
		}
		ProductWebsite webProduct = (ProductWebsite)product;
		System.out.println("This product supports the following shipping types:");
		for(int i = 0; i < eShippingType.NofTypes.ordinal(); i++) {
			System.out.print("" + eShippingType.values()[i] + " shipping: ");
			if(!webProduct.getSupportedShippings()[i]) {
				System.out.print("not ");
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
				type = eShippingType.valueOf(input.nextLine());
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
		orderID = input.nextLine();
		return orderID;
	}
	
	public static Customer getCustomerInfo() {
		String customerName;
		int mobileNumber;
		System.out.println("Enter customer name:");
		customerName = input.nextLine();
		System.out.println("Enter customer mobile number: (only numbers)");
		mobileNumber = input.nextInt();
		input.nextLine();
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
		printProducts(products);
		System.out.println("Enter product ID:");
		productID = input.nextLine();
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

	public static int getQuantity() {
		System.out.println("Enter product quantity:");
		int quantity = input.nextInt();
		input.nextLine();
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
			input.nextLine();
			switch(userChoice) {
			case WEBSITE_PRODUCTS:
				return eProductType.WebsiteProduct;
			case STORE_PRODUCTS:
				return eProductType.StoreProduct;
			case WHOLESALERS_PRODUCTS:
				return eProductType.WholesalerProduct;
			default:
				System.out.println("No such type. ");
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
		System.out.println("Enter cost price:");
		int costPrice = input.nextInt();
		input.nextLine();
		return costPrice;
	}
	
	public static int getSellingPrice() {
		System.out.println("Enter selling price:");
		int sellingPrice = input.nextInt();
		input.nextLine();
		return sellingPrice;
	}
	
	public static int getWeight() {
		System.out.println("Enter product weight:");
		int weight = input.nextInt();
		input.nextLine();
		return weight;
	}
	
	public static boolean getStandardShippingSupport() {
		boolean standardSupport = true;
		char value;
		do {
			System.out.println("Does the product support standard shipping? (T/F)");
			value = input.nextLine().charAt(0);
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
			value = input.nextLine().charAt(0);
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
		System.out.println("Enter the destination country:");
		dest = input.nextLine();
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
	
	public static void initializeShippingCompanies() {
		Store.getStoreInstance().getShippingManager().addShippingCompany(new DHL("Bob", 84969383));
		Store.getStoreInstance().getShippingManager().addShippingCompany(new FedEx("Jim", 48453957));
	}
	
	public static void main(String[] args) {
		String userChoice = new String();
		ICommand cmd = null;
		Product product = null;
		System.out.println("Welcome to our store system!");
		initializeShippingCompanies();
		do {
			printMenu();
			userChoice = (input.next() + "\0").substring(0, 2).trim();
			input.nextLine();
			System.out.println();
			switch(userChoice) {
			case "1":
				menuCase1(cmd);
				break;
			case "2":
				menuCase2(cmd);
				break;
			case "3":
				menuCase3(cmd, product);
				break;
			case "4":
				menuCase4(cmd, product);
				break;
			case "5":
				menuCase5(cmd, product);
				break;
			case "6":
				menuCase6(cmd);
				break;
			case "7":
				menuCase7(cmd, product);
				break;
			case "8":
				menuCase8(cmd);
				break;
			case "9":
				menuCase9(cmd, product);
				break;
			case "10":
				menuCase10(cmd);
				break;
			case "11":
				menuCase11(cmd);
				break;
			case "E":
			case "e":
				System.out.println("Exiting system.");
				break;
			default:
				System.out.println("Unknown input detected. Try again.");
			}
		}while(!userChoice.equals("E") && !userChoice.equals("e"));
	}
	
	public static void menuCase1(ICommand cmd) {
		cmd = new SystemTestCommand();
		cmd.execute();
		System.out.println("Action complete.\n");
	}
	
	public static void menuCase2(ICommand cmd) {
		eProductType type = getTypeOfProduct();
		String productID = getProductID();
		Product product = Store.getStoreInstance().getStorageManager().getProductByID(productID);
		if(product != null && !product.getIsActive()) {
			System.out.println("A product with this ID already exists in the system. Making it available again.");
			if(type.ordinal() == eProductType.WebsiteProduct.ordinal()) {
				cmd = new CreateProductCommand(type, "tmp", 1, 2, productID, 1, true, true, "tmp");
			}
			else {
				cmd = new CreateProductCommand(type, "tmp", 1, 2, productID, 1);
			}
		}
		else {
			if(type.ordinal() == eProductType.WebsiteProduct.ordinal()) {
				cmd = new CreateProductCommand(type, getProductName(), getCostPrice(), getSellingPrice(), productID, getWeight(), getStandardShippingSupport(), getExpressShippingSupport(), getDestCountry());
			}
			else {
				cmd = new CreateProductCommand(type, getProductName(), getCostPrice(), getSellingPrice(), productID, getWeight());
			}
		}
		cmd.execute();
		System.out.println("Action complete.\n");
	}

	public static void menuCase3(ICommand cmd, Product product) {
		product = getProduct();
		if(product == null) {
			System.out.println("A product with this ID doesn't exist.");
		}
		else {
			cmd = new RemoveProductCommand(product);
			cmd.execute();
		}
		System.out.println("Action complete.\n");
	}

	public static void menuCase4(ICommand cmd, Product product) {
		product = getProduct();
		if(product != null) {
			cmd = new UpdateQuantityCommand(product, getQuantity());
			cmd.execute();
		}
		else {
			System.out.println("A product with this ID doesn't exist.");
		}
		System.out.println("Action complete.\n");
	}
	
	public static void menuCase5(ICommand cmd, Product product) {
		product = getProduct();
		if(product != null) {
			cmd = new CreateOrderCommand(getOrderID(), getCustomerInfo(), product, getQuantity(), getShippingType(product));
			cmd.execute();
			commandStack.push((CreateOrderCommand)cmd);
		}
		else {
			System.out.println("A product with this ID doesn't exist");
		}
		System.out.println("Action complete.\n");
	}
	
	public static void menuCase6(ICommand cmd) {
		if(commandStack.isEmpty()) {
			System.out.println("There aren't any orders to undo.");
		}
		else {
			cmd = new UndoOrderCommand(commandStack.pop());
			cmd.execute();
		}
		System.out.println("Action complete.\n");
	}

	public static void menuCase7(ICommand cmd, Product product) {
		product = getProduct();
		if(product != null) {
			cmd = new PrintProductCommand(product.getProductID());
			cmd.execute();
		}
		else {
			System.out.println("A product with this ID doesn't exist");
		}
		System.out.println("Action complete.\n");
	}
	
	public static void menuCase8(ICommand cmd) {
		if(Store.getStoreInstance().getStorageManager().getAllProducts().isEmpty()) {
			System.out.println("There aren't any products in the store.");
		}
		else {
			cmd = new PrintAllProductsCommand();
			cmd.execute();
		}
		System.out.println("Action complete.\n");
	}
	
	public static void menuCase9(ICommand cmd, Product product) {
		product = getProduct();
		if(product != null) {
			cmd = new PrintOrdersForProductCommand(product.getProductID());
			cmd.execute();
		}
		else {
			System.out.println("A product with this ID doesn't exist");
		}
		System.out.println("Action complete.\n");
	}
	
	public static void menuCase10(ICommand cmd) {
		cmd = new BackupCommand();
		cmd.execute();
		System.out.println("Action complete.\n");
	}
	
	public static void menuCase11(ICommand cmd) {
		cmd = new RestoreCommand();
		cmd.execute();
		System.out.println("Action complete.\n");
	}
}
