package final_project_ood;

public class ProductWebsite extends Product {
	public static final double exchangeRate = 4.0;
	private boolean regularShippingSupport;
	private boolean expressShippingSupport;
	private String destCountry;
	
	public ProductWebsite(String name, int cost_price, int selling_price, String catalog_number, int weight, boolean regular, boolean express, String dest) {
		super(name, cost_price, selling_price, catalog_number, weight);
		this.regularShippingSupport = regular;
		this.expressShippingSupport = express;
		this.destCountry = dest;
		this.currency = eCurrency.eUSD;
	}

	public boolean isRegularShippingSupport() {
		return regularShippingSupport;
	}

	public void setRegularShippingSupport(boolean regularShippingSupport) {
		this.regularShippingSupport = regularShippingSupport;
	}

	public boolean isExpressShippingSupport() {
		return expressShippingSupport;
	}

	public void setExpressShippingSupport(boolean expressShippingSupport) {
		this.expressShippingSupport = expressShippingSupport;
	}

	public String getDestCountry() {
		return destCountry;
	}

	public void setDestCountry(String destCountry) {
		this.destCountry = destCountry;
	}
	
	
	

}
