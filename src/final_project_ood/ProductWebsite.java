package final_project_ood;

import final_project_ood.ShippingManager.eShippingType;

public class ProductWebsite extends Product {
	public final double exchangeRate = 4.0;
	private boolean shippingSupport[];
	private String destCountry;
	
	public ProductWebsite(String name, int cost_price, int selling_price, String catalog_number, int weight, boolean regular, boolean express, String dest) {
		super(name, cost_price, selling_price, catalog_number, weight);
		this.shippingSupport = new boolean[eShippingType.NofTypes.ordinal()];
		this.shippingSupport[eShippingType.Standard.ordinal()] = regular;
		this.shippingSupport[eShippingType.Express.ordinal()] = express;
		this.destCountry = dest;
		this.currency = eCurrency.USD;
	}

	public boolean isRegularShippingSupport() {
		return this.shippingSupport[eShippingType.Standard.ordinal()];
	}

	public void setRegularShippingSupport(boolean regularShippingSupport) {
		this.shippingSupport[eShippingType.Standard.ordinal()] = regularShippingSupport;
	}

	public boolean isExpressShippingSupport() {
		return shippingSupport[eShippingType.Express.ordinal()];
	}

	public void setExpressShippingSupport(boolean expressShippingSupport) {
		this.shippingSupport[eShippingType.Express.ordinal()] = expressShippingSupport;
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

	@Override
	public String toString() {
		StringBuffer productDesc = new StringBuffer();
		productDesc.append("Destination: " + destCountry);
		for(int i = 0; i < eShippingType.NofTypes.ordinal(); i++) {
			productDesc.append("\t" + eShippingType.values()[i] + " shipping: ");
			if(!shippingSupport[i]) {
				productDesc.append("not ");
			}
			productDesc.append("supported.");
		}
		return super.toString() + productDesc.toString();
	}
	
	
	

}
