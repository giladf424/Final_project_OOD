package final_project_ood;

import java.util.LinkedHashSet;
import java.util.Objects;

public abstract class Product implements Cloneable{
	protected String productName;
	protected int costPrice;
	protected int sellingPrice;
	protected int stock;
	protected int profit;
	protected String productID;
	protected int productWeight;

	public enum eCurrency {
		NIS, USD
	};

	protected eCurrency currency;
	
	public enum eProductType{
		WebsiteProduct, StoreProduct, WholesalerProduct
	};
	
	protected LinkedHashSet<String> productOrdersID;
	protected boolean isActive;

	public Product(String name, int costPrice, int sellingPrice, String productID, int weight) {
		this.productName = name;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.stock = 0;
		this.profit = 0;
		this.productID = productID;
		this.productWeight = weight;
		this.productOrdersID = new LinkedHashSet<>();
		this.isActive = true;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
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
	
	public eCurrency getCurrency() {
		return currency;
	}

	public LinkedHashSet<String> getProductOrdersID() {
		return this.productOrdersID;
	}
	
	@Override
	public Product clone() {
		try {
			Product clonedProduct = (Product)super.clone();
			clonedProduct.productOrdersID = new LinkedHashSet<String>(this.productOrdersID);
			return clonedProduct;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(productID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productID, other.productID);
	}

	@Override
	public String toString() {
		StringBuffer productDesc = new StringBuffer();
		productDesc
				.append("\t ID: " + this.productID + "\t" + "Name:" + this.productName + "\t" + "Weight: "
						+ this.productWeight + "kg\n")
				.append("Cost price: " + this.costPrice + " " + this.currency + "\t Selling price: " + this.sellingPrice
						+ " " + this.currency + "\t Quantity: " + this.stock + "\n");
		return productDesc.toString();
	}
}
