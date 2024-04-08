package final_project_ood;

public abstract class Product {
	protected String product_name;
	protected int cost_price;
	protected int selling_price;
	protected int stock;
	protected int profit;
	protected String catalog_number;
	protected int product_weight;

	public Product(String name, int cost_price, int selling_price, String catalog_number, int weight) {
		this.product_name = name;
		this.cost_price = cost_price;
		this.selling_price = selling_price;
		this.stock = 0;
		this.profit = 0;
		this.catalog_number = catalog_number;
		this.product_weight = weight;

	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getCost_price() {
		return cost_price;
	}

	public void setCost_price(int cost_price) {
		this.cost_price = cost_price;
	}

	public int getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(int selling_price) {
		this.selling_price = selling_price;
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

	public String getCatalog_number() {
		return catalog_number;
	}

	public void setCatalog_number(String catalog_number) {
		this.catalog_number = catalog_number;
	}
	
	public int getWeight() {
		return product_weight;
	}
	
	public void setWeight(int weight) {
		this.product_weight = weight;
	}

}
