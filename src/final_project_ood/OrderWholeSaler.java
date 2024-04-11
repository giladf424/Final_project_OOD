package final_project_ood;

public class OrderWholeSaler extends Order implements Cloneable {
	private InvoiceAccountant invoiceAccountant;

	public OrderWholeSaler(String orderID, Customer customer, Product product, int quantity) {
		super(orderID, customer, product, quantity);
		this.invoiceAccountant = new InvoiceAccountant(product.getProductID(), product.getProductName(), quantity,
				product.getSellingPrice(), product.getCostPrice());
	}

	public InvoiceAccountant getInvoiceAccountant() {
		return this.invoiceAccountant;
	}

	@Override
	public String toString() {
		return super.toString() + invoiceAccountant.toString();
	}

	@Override
	public OrderWholeSaler clone() {
		try {
			OrderWholeSaler clonedOrder = (OrderWholeSaler) super.clone();
			clonedOrder.invoiceAccountant = this.invoiceAccountant.clone();
			return clonedOrder;
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

}
