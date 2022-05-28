package myStore;


public class SortName implements Comparator<Goods> {
	public int compare(Goods ob1, Goods ob2) {
		return ob1.getName().compareTo(ob2.getName());
	}
}
