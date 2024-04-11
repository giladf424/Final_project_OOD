package final_project_ood;

public class OrderStore extends Order{
	private InvoiceCustomer invoiceCustomer;
	private InvoiceAccountant invoiceAccountant;

	public OrderStore(String orderID, Customer customer, Product product, int quantity) {
		super(orderID, customer, product, quantity);
		this.invoiceCustomer = new InvoiceCustomer(product.getProductID(), product.getProductName(), quantity, product.getSellingPrice());
		this.invoiceAccountant = new InvoiceAccountant(product.getProductID(), product.getProductName(), quantity, product.getSellingPrice(), product.getCostPrice());
	}
	
	public InvoiceCustomer getInvoiceCustomer() {
		return this.invoiceCustomer;
	}
	
	public InvoiceAccountant getInvoiceAccountant() {
		return this.invoiceAccountant;
	}
	
	@Override
	public String toString() {
		return super.toString() + invoiceCustomer.toString() + "\n" + invoiceAccountant.toString();
	}

}
