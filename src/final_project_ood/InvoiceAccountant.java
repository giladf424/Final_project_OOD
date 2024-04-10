package final_project_ood;

public class InvoiceAccountant extends Invoice{
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
		StringBuffer invoice = new StringBuffer();
		invoice.append(this.productName + "\n" + this.productID + "\nPrice:	" + this.sellingPrice + "	X	" + this.quantity + "\n");
		invoice.append("Total:	" + this.orderCost + "\nStore Profit:	" + this.orderProfit);
		return invoice.toString();
	}

	
}
