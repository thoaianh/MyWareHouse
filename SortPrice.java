package myStore;


public class SortPrice implements Comparator<Goods>{
	@Override
	public int compare(Goods ob1, Goods ob2) {
		if(ob1.getPrice()-ob2.getPrice()==0) return 0;
		else if(ob1.getPrice()-ob2.getPrice()>0) return 1;
		else return -1;
	}
 

}
