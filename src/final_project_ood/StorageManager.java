package final_project_ood;

import java.util.ArrayList;
import java.util.Iterator;

public class StorageManager {
	private ArrayList<Product> allProducts;
	
	public StorageManager() {
		this.allProducts = new ArrayList<>();
	}
	
	public ArrayList<Product> getAllProducts(){
		return this.allProducts;
	}
	
	public void printProducts(ArrayList<Product> products) {
		for (Iterator iterator = products.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			System.out.println(product.toString());
		}
	}
	
	public ArrayList<Product> getAllWebsiteProducts(){
		ArrayList<Product> allWebsiteProducts = new ArrayList<>();
		for (Iterator iterator = allProducts.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			if(product instanceof ProductWebsite && product.getIsActive()) {
				allWebsiteProducts.add(product);
			}
		}
		return allWebsiteProducts;
	}
	
	public ArrayList<Product> getAllInStoreProducts(){
		ArrayList<Product> allInStoreProducts = new ArrayList<>();
		for (Iterator iterator = allProducts.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			if(product instanceof ProductInStore && product.getIsActive()) {
				allInStoreProducts.add(product);
			}
		}
		return allInStoreProducts;
	}
	
	public ArrayList<Product> getAllWholesalersProducts(){
		ArrayList<Product> allWholesalersProducts = new ArrayList<>();
		for (Iterator iterator = allProducts.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			if(product instanceof ProductWholesalers && product.getIsActive()) {
				allWholesalersProducts.add(product);
			}
		}
		return allWholesalersProducts;
	}
	
	public Product getProductByID(String productID) {
		for (Iterator iterator = allProducts.iterator(); iterator.hasNext();) {
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
	
	public void addOrderToProduct(Product product, String orderID) {
		product.getProductOrdersID().add(orderID);
	}
	
	
	// enableDisableProduct (this will implement action 4.3 in the menu to remove product)
	public void setProductActivity(String productID, boolean value) {
		Product product = this.getProductByID(productID);
		product.setIsActive(value);
	}
	// addProduct ( add a product to list , if the product exists but disable we will enable it)
	
	// 

}
