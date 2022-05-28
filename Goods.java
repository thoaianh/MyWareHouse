package myStore;

public class Goods implements Comparable<Goods> {

	private String name;
	private int id;
	private double price;
	private int inputAmount;
	private int outputAmount;
	private String dayInput;
	private String dayOutput;

	public Goods(String name, int id, double price, int inputAmount, int outputAmount, String dayInput,
			String dayOutput) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
		this.inputAmount = inputAmount;
		this.outputAmount = outputAmount;
		this.dayInput = dayInput;
		this.dayOutput = dayOutput;
	}

	public boolean exactlyDay(String calendar) {

		int start = calendar.indexOf("/");
		int end = calendar.lastIndexOf("/");

		String day = calendar.substring(0, start);

		String year = calendar.substring(end + 1);

		String month = calendar.substring(start + 1, end);
		try {
			int monthInt = Integer.parseInt(month);
			int dayInt = Integer.parseInt(day);
			int yearInt = Integer.parseInt(year);

			if (dayInt < 1 || dayInt > 31 || monthInt < 1 || monthInt > 12 || yearInt < 1 || yearInt > 10000) {
				return false;
			}
			if (monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11) {
				if (dayInt > 30)
					return false;
			}

			if (monthInt == 2 && dayInt > 29) {
				return false;
			}
			if ((monthInt == 2) && (dayInt == 29)
					&& ((!(yearInt % 4 == 0) && (yearInt % 100 == 0) || !(yearInt % 400 == 0))))
				return false;

		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

	public boolean compare2Days(String dayInPut, String dayOutput) {
		int start = dayInPut.indexOf("/");
		int end = dayInPut.lastIndexOf("/");
		int startII = dayOutput.indexOf("/");
		int endII = dayOutput.lastIndexOf("/");

		String day = dayInPut.substring(0, start);

		String year = dayInPut.substring(end + 1);

		String month = dayInPut.substring(start + 1, end);

		String dayII = dayOutput.substring(0, start);

		String yearII = dayOutput.substring(end + 1);

		String monthII = dayOutput.substring(start + 1, end);

		try {
			int monthInt1 = Integer.parseInt(month);
			int dayInt1 = Integer.parseInt(day);
			int yearInt1 = Integer.parseInt(year);

			int monthInt2 = Integer.parseInt(monthII);
			int dayInt2 = Integer.parseInt(dayII);
			int yearInt2 = Integer.parseInt(yearII);

			if (yearInt1 > yearInt2) {
				return false;
			} else if (yearInt1 == yearInt2 && monthInt1 > monthInt2) {
				return false;
			} else if (yearInt1 == yearInt2 && monthInt1 == monthInt2 && dayInt1 > dayInt2) {
				return false;
			}
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;

	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public int getInputAmount() {
		return inputAmount;
	}

	public int getOutputAmount() {
		return outputAmount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOutput(int outputAmount) {
		this.outputAmount = outputAmount;
	}

	public void setInput(int inputAmount) {
		this.inputAmount = inputAmount;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean checkID(int id2) {
		return this.id == id2;
	}

	public int addOutputAmount(int output) {
		return this.outputAmount = output;
	}

	public String toString() {
		String result = "";
		result = id + "\t" + name + "\t" + price + "\t" + dayInput + "\t\t" + inputAmount + "\t" + "\t" + dayOutput
				+ "\t\t" + outputAmount;
		return result;
	}

	public String getDayInput() {
		if (exactlyDay(dayInput) == true && compare2Days(dayInput, dayOutput) == true) {
			return dayInput;
		}
		return "Ngày nhập sai. Nhập lại";
	}

	public void setDayInput(String dayInput) {
		this.dayInput = dayInput;
	}

	public String getDayOutput() {
		if (exactlyDay(dayOutput) == true && compare2Days(dayInput, dayOutput) == true) {
			return dayOutput;
		}
		return "Ngày nhập sai. Nhập lại";
	}

	public void setDayOutput(String dayOutput) {
		this.dayOutput = dayOutput;
	}

	@Override
	public int compareTo(Goods gd) {
		return 0;
	}

}
