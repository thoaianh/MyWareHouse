package myStore;


public class SortInput implements Comparator<Goods> {
	public int compare(Goods ob1, Goods ob2) {
		if(ob1.getInputAmount()-ob2.getInputAmount()==0) return 0;
		else if(ob1.getInputAmount()-ob2.getInputAmount()>0) return 1;
		else return -1;
	}
}
