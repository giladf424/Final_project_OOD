package final_project_ood;

import java.util.LinkedHashSet;

public abstract class Product {
	protected String productName;
	protected int costPrice;
	protected int sellingPrice;
	protected int stock;
	protected int profit;
	protected String productID;
	protected int productWeight;
	public enum eCurrency { eNIS, eUSD };
	protected eCurrency currency;
	protected LinkedHashSet<String> productOrdersID;

	public Product(String name, int costPrice, int sellingPrice, String productID, int weight) {
		this.productName = name;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.stock = 0;
		this.profit = 0;
		this.productID = productID;
		this.productWeight = weight;
		this.productOrdersID = new LinkedHashSet<>();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	public int getWeight() {
		return productWeight;
	}
	
	public void setWeight(int weight) {
		this.productWeight = weight;
	}

}
