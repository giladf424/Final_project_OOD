package final_project_ood;

import java.util.ArrayList;
import java.util.Iterator;

public class StorageManager {
	private ArrayList<Product> allProducts;
	private ProductComparator productComparator;
	
	public StorageManager() {
		this.allProducts = new ArrayList<>();
		this.productComparator = new ProductComparator();
	}
	
	public boolean createProductWebsite(String name, int cost_price, int selling_price, String catalog_number, int weight, boolean regular, boolean express, String dest) {
		ProductWebsite product = new ProductWebsite(name, cost_price, selling_price, catalog_number, weight, regular, express, dest);
		if(this.allProducts.contains(product)) {
			ProductWebsite existingProduct = (ProductWebsite)this.getProductByID(product.productID);
			existingProduct.setIsActive(true);
			existingProduct.setProductName(name);
			existingProduct.setCostPrice(cost_price);
			existingProduct.setSellingPrice(selling_price);
			existingProduct.setWeight(weight);
			existingProduct.setRegularShippingSupport(regular);
			existingProduct.setExpressShippingSupport(express);
			existingProduct.setDestCountry(dest);
		}
		else {
			this.allProducts.add(product);
			this.allProducts.sort(this.productComparator);
		}
		return true;
	}
	
	public boolean createProductStore(String name, int costPrice, int sellingPrice, String productID, int weight) {
		ProductInStore product = new ProductInStore(name, costPrice, sellingPrice, productID, weight);
		if(this.allProducts.contains(product)) {
			ProductInStore existingProduct = (ProductInStore)this.getProductByID(product.productID);
			existingProduct.setIsActive(true);
			existingProduct.setProductName(name);
			existingProduct.setCostPrice(costPrice);
			existingProduct.setSellingPrice(sellingPrice);
			existingProduct.setWeight(weight);
		}
		else {
			this.allProducts.add(product);
			this.allProducts.sort(this.productComparator);
		}
		return true;
	}
	
	public boolean createProductWholesalers(String name, int costPrice, int sellingPrice, String productID, int weight) {
		ProductWholesalers product = new ProductWholesalers(name, costPrice, sellingPrice, productID, weight);
		if(this.allProducts.contains(product)) {
			ProductWholesalers existingProduct = (ProductWholesalers)this.getProductByID(product.productID);
			existingProduct.setIsActive(true);
			existingProduct.setProductName(name);
			existingProduct.setCostPrice(costPrice);
			existingProduct.setSellingPrice(sellingPrice);
			existingProduct.setWeight(weight);
		}
		else {
			this.allProducts.add(product);
			this.allProducts.sort(this.productComparator);
		}
		return true;
	}
	
	public ArrayList<Product> getAllProducts(){
		return this.allProducts;
	}
	
	public void printProducts(ArrayList<Product> products) {
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			System.out.println(product.toString());
		}
	}
	
	public ArrayList<Product> getAllWebsiteProducts(){
		ArrayList<Product> allWebsiteProducts = new ArrayList<>();
		for (Iterator<Product> iterator = allProducts.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			if(product instanceof ProductWebsite && product.getIsActive()) {
				allWebsiteProducts.add(product);
			}
		}
		return allWebsiteProducts;
	}
	
	public ArrayList<Product> getAllInStoreProducts(){
		ArrayList<Product> allInStoreProducts = new ArrayList<>();
		for (Iterator<Product> iterator = allProducts.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			if(product instanceof ProductInStore && product.getIsActive()) {
				allInStoreProducts.add(product);
			}
		}
		return allInStoreProducts;
	}
	
	public ArrayList<Product> getAllWholesalersProducts(){
		ArrayList<Product> allWholesalersProducts = new ArrayList<>();
		for (Iterator<Product> iterator = allProducts.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			if(product instanceof ProductWholesalers && product.getIsActive()) {
				allWholesalersProducts.add(product);
			}
		}
		return allWholesalersProducts;
	}
	
	public Product getProductByID(String productID) {
		for (Iterator<Product> iterator = allProducts.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			if(product.getProductID().equals(productID))
				return product;
		}
		return null;
	}
	
	// updateQuantity (product)
	public void updateQuantity(Product product, int quantity) {
		int newStock = product.getStock() - quantity;
		product.setStock(newStock);
	}
	
	public void addQuantity(Product product, int quantity) {
		int newStock = product.getStock() + quantity;
		product.setStock(newStock);
	}
	
	public void addOrderToProduct(Product product, String orderID) {
		product.getProductOrdersID().add(orderID);
	}
	
	
	// enableDisableProduct (this will implement action 4.3 in the menu to remove product)
	public void setProductActivity(String productID, boolean value) {
		Product product = this.getProductByID(productID);
		product.setIsActive(value);
	}
	// addProduct ( add a product to list , if the product exists but disable we will enable it)

	@Override
	public String toString() {
		return "StorageManager [allProducts=" + allProducts + "]";
	}
	
	// 

}
