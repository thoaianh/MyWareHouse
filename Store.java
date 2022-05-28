package myStore;

import javax.swing.JOptionPane;

public class Store {
	ArrayList<Goods> lis;

	public Store() {
		this.lis = new ArrayList<Goods>(1000);
	}

	// Kiem tra id mat hang
	public Goods findIdGds(int id) {
		for (int i = 0; i < lis.sizeOfArray(); i++) {
			if (lis.get(i).checkID(id))
				return lis.get(i);
		}
		return null;
	}

	// Tim theo ten

	public String search(int id) {
		String res = "*Tìm kiếm:      ";
		for (int i = 0; i < lis.sizeOfArray(); i++) {
			if (id == lis.get(i).getId()) {
				res += lis.get(i).toString() + "\n";
			}
		}
		return res;
	}

	public String search(String name) {
		String res = "*Tìm kiếm:      ";
		for (int i = 0; i < lis.sizeOfArray(); i++) {
			if (name.equals(lis.get(i).getName())) {
				res += lis.get(i).toString() + "\n";
			}
		}
		return res;
	}

	public String search(double price) {
		String res = "*Tìm kiếm:      ";
		for (int i = 0; i < lis.sizeOfArray(); i++) {
			if (price == lis.get(i).getPrice()) {
				res += lis.get(i).toString() + "\n";
			}
		}
		return res;
	}

	public String searchInput(int input) {
		String res = "*Tìm kiếm:      ";
		for (int i = 0; i < lis.sizeOfArray(); i++) {
			if (input == lis.get(i).getInputAmount()) {
				res += lis.get(i).toString() + "\n";
			}
		}
		return res;
	}

	// Them mot mat hang vao cua hang
	public void addGoods(Goods gd) {
		if (findIdGds(gd.getId()) == null && !gd.getDayInput().equals("Ngày nhập sai. Nhập lại")) {
			lis.addLast(gd);
		} else {
			JOptionPane.showMessageDialog(null, "Ngày nhập sai. Ngày nhập hàng phải nh�? hơn ngày bán");
		}
	}

	// Them hang vao vi tri bat ki
	public void addGoods(Goods gd, int i) {

		if (findIdGds(gd.getId()) == null && !gd.getDayInput().equals("Ngày nhập sai. Nhập lại")) {
			lis.addInIndex(i, gd);
		} else {
			JOptionPane.showMessageDialog(null, "Ngày nhập sai. Ngày nhập hàng phải nh�? hơn ngày bán");
		}
	}

	// Chinh sua mat hang qua ten, gia, so luong them vao, so luong ban ra
	public void edName(int id, String newName) {
		for (int i = 0; i < lis.sizeOfArray(); i++)
			if (findIdGds(id) == lis.get(i)) {
				lis.get(i).setName(newName);
			}
	}

	public void edPrice(int id, double newPrice) {
		for (int i = 0; i < lis.sizeOfArray(); i++)
			if (findIdGds(id) == lis.get(i)) {
				lis.get(i).setPrice(newPrice);
			}
	}

	public void edInput(int id, int input) {
		for (int i = 0; i < lis.sizeOfArray(); i++)
			if (findIdGds(id) == lis.get(i)) {
				lis.get(i).setInput(input);
			}
	}

	public void edInputDay(int id, String inputday) {
		for (int i = 0; i < lis.sizeOfArray(); i++)
			if (findIdGds(id) == lis.get(i) && lis.get(i).compare2Days(inputday, lis.get(i).getDayOutput()) == true) {
				lis.get(i).setDayInput(inputday);
			}
	}

	// Sap xep
	public void sort(ArrayList<Goods> li, Comparator<Goods> gd) {
		li.quickSort(0, li.sizeOfArray() - 1, gd);
	}

	// Xoa


	public void rmById(int id) {
		for (int i = 0; i < lis.sizeOfArray(); i++) {
			if (lis.get(i).getId() == id) {
				lis.remove(i);
			}
		}
	}

	public void removeElements(Double price1) {

		Iterator<Goods> itr = lis.iterator();
		while (itr.hasNext()) {
			Goods gds = itr.next();
			if (gds.getPrice() == price1)
				itr.remove();
		}

	}
	public void rmByName(String name) {
		
		Iterator<Goods> itr = lis.iterator();
		while (itr.hasNext()) {
			Goods gds = itr.next();
			if (gds.getName().equals(name))
				itr.remove();
		}
		
	}

	public String print() {
		String result = "";
		for (int i = 0; i < lis.sizeOfArray(); i++) {
			result += (i + 1) + "\t" + lis.get(i) + "\n";
		}
		return result;
	}

//	public String nameCondition(string)
	public int condition(String name, String dayInput) {
		int sumOut = 0;
		for (int i = 0; i < lis.sizeOfArray(); i++) {
			if (lis.get(i).getName().equals(name) && lis.get(i).getDayInput().equals(dayInput)) {
				sumOut += lis.get(i).getOutputAmount();
			}
		}
		return sumOut;
	}

}