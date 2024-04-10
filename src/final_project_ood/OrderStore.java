package final_project_ood;

public class OrderStore extends Order{
	private InvoiceCustomer invoiceCustomer;
	private InvoiceAccountant invoiceAccountant;

	public OrderStore(String orderID, Customer customer, Product product, int quantity) {
		super(orderID, customer, product, quantity);
		this.invoiceCustomer = new InvoiceCustomer(product.getProductID(), product.getProductName(), quantity, product.getSellingPrice());
	}
	
	public InvoiceCustomer getInvoiceCustomer() {
		return this.invoiceCustomer;
	}
	
	public InvoiceAccountant getInvoiceAccountant() {
		return this.invoiceAccountant;
	}

}
