package final_project_ood;

public class InvoiceCustomer extends Invoice implements Cloneable {
	public static final double TAX = 17.0;
	private double TaxValue;

	public InvoiceCustomer(String productID, String productName, int quantity, int sellingPrice) {
		super(productID, productName, quantity, sellingPrice);
		this.setTaxValue();
	}

	private void setTaxValue() {
		this.TaxValue = (this.orderCost * 17) / 117; // calculation
	}

	@Override
	public String toString() {
		StringBuffer invoice = new StringBuffer("Invoice for customer: \n");
		invoice.append("ID: " + productID + "\t" + productName + "\t Price: " + sellingPrice + " X " + quantity + " units\n");
		invoice.append("Tax: " + TaxValue + " NIS\t Total: " + orderCost + "NIS");
		return invoice.toString();
	}

	@Override
	public InvoiceCustomer clone() {
		try {
			InvoiceCustomer clonedInvoice = (InvoiceCustomer) super.clone();
			// Perform deep copy of attributes
			clonedInvoice.TaxValue = this.TaxValue;
			return clonedInvoice;
		} catch (Exception e) {
			throw new AssertionError(); // Can't happen
		}
	}

}
