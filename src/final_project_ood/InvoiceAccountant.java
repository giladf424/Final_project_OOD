package final_project_ood;

public class InvoiceAccountant extends Invoice implements Cloneable {
	private int costPrice;
	private double orderProfit;

	public InvoiceAccountant(String productID, String productName, int quantity, int sellingPrice, int costPrice) {
		super(productID, productName, quantity, sellingPrice);
		this.costPrice = costPrice;
		this.setOrderProfit();
	}

	private void setOrderProfit() {
		this.orderProfit = quantity * (sellingPrice - costPrice);
	}

	@Override
	public String toString() {
		StringBuffer invoice = new StringBuffer("Invoice for accountant: \n");
		invoice.append("ID: " + productID + "\t" + productName + "\t Price: " + sellingPrice + " X " + quantity + " units\n");
		invoice.append("Total: " + orderCost + " NIS\t Store Profit: " + orderProfit + "NIS");
		return invoice.toString();
	}

	@Override
	public InvoiceAccountant clone() {
		try {
			InvoiceAccountant clonedInvoice = (InvoiceAccountant) super.clone();
			// Perform deep copy of attributes
			clonedInvoice.costPrice = this.costPrice;
			clonedInvoice.orderProfit = this.orderProfit;
			return clonedInvoice;
		} catch (Exception e) {
			throw new AssertionError(); // Can't happen
		}
	}

}
