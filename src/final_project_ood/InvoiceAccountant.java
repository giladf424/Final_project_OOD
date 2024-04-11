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
		StringBuffer invoice = new StringBuffer("Invoice for accountant: \n");
		invoice.append("ID: " + productID  + "\t" + productName + "\t Price: " + sellingPrice + " X " + quantity + "\n");
		invoice.append("Total: " + orderCost + "\t Store Profit: " + orderProfit);
		return invoice.toString();
	}

	
}
