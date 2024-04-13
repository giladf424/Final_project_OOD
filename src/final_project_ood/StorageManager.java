package final_project_ood;

import java.util.ArrayList;
import java.util.Iterator;

public class StorageManager implements Cloneable{
	private ArrayList<Product> allProducts;
	private ProductComparator productComparator;
	
	public StorageManager() {
		this.allProducts = new ArrayList<>();
		this.productComparator = new ProductComparator();
	}
	
	public ArrayList<Product> getAllProducts(){
		return this.allProducts;
	}
	
	public void setAllProducts(ArrayList<Product> allProducts) {
		this.allProducts = allProducts;
	}
	
	public ProductWebsite createProductWebsite(String name, int costPrice, int sellingPrice, String productID, int weight, boolean regular, boolean express, String dest) {
		ProductWebsite product = new ProductWebsite(name, costPrice, sellingPrice, productID, weight, regular, express, dest);
		if(this.allProducts.contains(product)) {
			ProductWebsite existingProduct = (ProductWebsite)this.getProductByID(product.productID);
			existingProduct.setIsActive(true);
		}
		else {
			this.allProducts.add(product);
			this.allProducts.sort(this.productComparator);
		}
		return product;
	}
	
	public ProductInStore createProductStore(String name, int costPrice, int sellingPrice, String productID, int weight) {
		ProductInStore product = new ProductInStore(name, costPrice, sellingPrice, productID, weight);
		if(this.allProducts.contains(product)) {
			ProductInStore existingProduct = (ProductInStore)this.getProductByID(product.productID);
			existingProduct.setIsActive(true);
		}
		else {
			this.allProducts.add(product);
			this.allProducts.sort(this.productComparator);
		}
		return product;
	}
	
	public ProductWholesalers createProductWholesalers(String name, int costPrice, int sellingPrice, String productID, int weight) {
		ProductWholesalers product = new ProductWholesalers(name, costPrice, sellingPrice, productID, weight);
		if(this.allProducts.contains(product)) {
			ProductWholesalers existingProduct = (ProductWholesalers)this.getProductByID(product.productID);
			existingProduct.setIsActive(true);
		}
		else {
			this.allProducts.add(product);
			this.allProducts.sort(this.productComparator);
		}
		return product;
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
	
	public void setProductActivity(String productID, boolean value) {
		Product product = this.getProductByID(productID);
		product.setIsActive(value);
	}
	
	public void setProductStock(String productID, int quantity) {
		Product product = this.getProductByID(productID);
		product.setStock(quantity);
	}

	@Override
	public StorageManager clone() {
		try {
			StorageManager clonedManager = (StorageManager) super.clone();
			clonedManager.allProducts = new ArrayList<Product>();
			for(Product product : this.allProducts) {
				if(product instanceof ProductInStore) {
					clonedManager.allProducts.add(((ProductInStore)product).clone());
				}
				else if(product instanceof ProductWebsite) {
					clonedManager.allProducts.add(((ProductWebsite)product).clone());
				}
				else if(product instanceof ProductWholesalers) {
					clonedManager.allProducts.add(((ProductWholesalers)product).clone());
				}
			}
			return clonedManager;
		} catch (Exception e) {
			throw new AssertionError();
		}
	}
	
	@Override
	public String toString() {
		return "StorageManager [allProducts=" + allProducts + "]";
	}

}
