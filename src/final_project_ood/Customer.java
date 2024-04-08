package final_project_ood;

public class Customer {
	private String customerName;
	private int mobile;
	
	public Customer(String customerName, int mobile) {
		this.customerName = customerName;
		this.mobile = mobile;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	
	

}
