package final_project_ood;

public class Customer implements Cloneable {
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

	@Override
	public String toString() {
		StringBuffer customerDesc = new StringBuffer();
		customerDesc.append("Customer name: " + this.customerName + "\t mobile: " + this.mobile + "\n");
		return customerDesc.toString();
	}

	@Override
	public Customer clone() {
		try {
			return (Customer) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

}
