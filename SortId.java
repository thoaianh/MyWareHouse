package myStore;


public class SortId implements Comparator<Goods> {

	@Override
	public int compare(Goods ob1, Goods ob2) {
		if (ob1.getId() - ob2.getId() == 0)
			return 0;
		else if (ob1.getId() - ob2.getId() > 0)
			return 1;
		else
			return -1;
//		ob1.getId()-ob2.getId() tang dan
//		ob2.getId()-ob1.getId() giam dan
	}

}
