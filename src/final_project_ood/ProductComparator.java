package final_project_ood;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getProductID().compareTo(o2.getProductID());
	}

}
