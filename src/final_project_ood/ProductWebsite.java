package final_project_ood;

import final_project_ood.ShippingManager.eShippingType;

public class ProductWebsite extends Product {
	public final double exchangeRate = 4.0;
	private boolean shippingSupport[];
	private String destCountry;
	
	public ProductWebsite(String name, int cost_price, int selling_price, String catalog_number, int weight, boolean regular, boolean express, String dest) {
		super(name, cost_price, selling_price, catalog_number, weight);
		this.shippingSupport = new boolean[eShippingType.eNofTypes.ordinal()];
		this.shippingSupport[eShippingType.eStandard.ordinal()] = regular;
		this.shippingSupport[eShippingType.eExpress.ordinal()] = express;
		this.destCountry = dest;
		this.currency = eCurrency.eUSD;
	}

	public boolean isRegularShippingSupport() {
		return this.shippingSupport[eShippingType.eStandard.ordinal()];
	}

	public void setRegularShippingSupport(boolean regularShippingSupport) {
		this.shippingSupport[eShippingType.eStandard.ordinal()] = regularShippingSupport;
	}

	public boolean isExpressShippingSupport() {
		return shippingSupport[eShippingType.eExpress.ordinal()];
	}

	public void setExpressShippingSupport(boolean expressShippingSupport) {
		this.shippingSupport[eShippingType.eExpress.ordinal()] = expressShippingSupport;
	}

	public String getDestCountry() {
		return destCountry;
	}

	public void setDestCountry(String destCountry) {
		this.destCountry = destCountry;
	}
	
	public boolean[] getSupportedShippings() {
		return this.shippingSupport;
	}
	

}
