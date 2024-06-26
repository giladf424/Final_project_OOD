package final_project_ood;

public abstract class Invoice implements Cloneable{
	protected String productID;
	protected String productName;
	protected int quantity;
	protected int sellingPrice;
	protected int orderCost;
	
	public Invoice(String productID, String productName, int quantity, int sellingPrice) {
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
		this.sellingPrice = sellingPrice;
		this.orderCost = quantity * sellingPrice;
	}
	
	public abstract String toString();
	
	@Override
	public Invoice clone() {
	    try {
	        return (Invoice) super.clone();
	    } catch (CloneNotSupportedException e) {
	            throw new AssertionError();
	    }
	}
}
