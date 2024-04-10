package final_project_ood;

public class OrderWholeSaler extends Order{
	private InvoiceAccountant invoiceAccountant;
	

	public OrderWholeSaler(String orderID, Customer customer, Product product, int quantity) {
		super(orderID, customer, product, quantity);
		this.invoiceAccountant = new InvoiceAccountant(product.getProductID(), product.getProductName(), quantity, product.getSellingPrice(), product.getCostPrice());
	}
	
	public InvoiceAccountant getInvoiceAccountant() {
		return this.invoiceAccountant;
	}

}
