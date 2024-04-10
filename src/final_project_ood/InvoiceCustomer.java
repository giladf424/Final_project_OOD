package final_project_ood;

public class InvoiceCustomer extends Invoice{
	public static final double TAX = 17.0;
	private double priceBeforeTax;

	public InvoiceCustomer(String productID, String productName, int quantity, int sellingPrice) {
		super(productID, productName, quantity, sellingPrice);
		this.setPriceBeforeTax();
	}
	
	private void setPriceBeforeTax() {
		this.priceBeforeTax = (this.orderCost * 100) / 117;	//calculation
	}

	@Override
	public String toString() {
		StringBuffer invoice = new StringBuffer();
		invoice.append(this.productName + "\n" + this.productID + "\nPrice:	" + this.sellingPrice + "	X	" + this.quantity + "\n");
		invoice.append("\nBefore Tax:	" + this.priceBeforeTax + "\nTotal:	" + this.orderCost);
		return invoice.toString();
	}

}
