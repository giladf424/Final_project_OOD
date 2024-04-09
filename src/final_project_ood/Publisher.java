package final_project_ood;

public abstract class Publisher {
	private Listener shippingManager;
	
	public Publisher() {
		this.shippingManager = Store.getStoreInstance().getShippingManager();
	}
	
	public void notifyShipping() {
		this.shippingManager.update();
	}
}
