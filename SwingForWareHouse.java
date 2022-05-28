package myStore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import java.awt.Font;

public class SwingForWareHouse extends JPanel {

	JLabel sttLB, nameLB, idLB, priceLB, dayInputLB, inputLB, outLB, dayOutLB, noteLB, conditionLB, amountLB, titleLB;
	JTextField sttTxt, nameTxt, idTxt, priceTxt, dayInputTxt, inputTxt, outTxt, dayOutTxt, nameConditionTxt,
			dayConditionTxt, displayConditionTxt, amountTxt;
	JButton addBtn, editBtn, removeBtn, searchBtn, sortName, sortID, sortPrice, sortInput, clearBtn, homeBtn;
	JTextArea textArea;
	String name;
	int index;
	int id;
	double price;
	int input;
	int output;
	String inputDay;
	String outputDay;

	public SwingForWareHouse() {

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(770, 550));

		JPanel pane1 = new JPanel();
		pane1.setLayout(new GridLayout(3, 4, 10, 7));
		pane1.add(sttLB = new JLabel("STT(*)"));
		pane1.add(sttTxt = new JTextField(15));
		pane1.add(priceLB = new JLabel("Giá bán/SP"));
		pane1.add(priceTxt = new JTextField(14));

		pane1.add(nameLB = new JLabel("Tên sản phẩm"));
		pane1.add(nameTxt = new JTextField(14));
		pane1.add(dayInputLB = new JLabel("Ngày nhập hàng/đợt (**)"));
		pane1.add(dayInputTxt = new JTextField("VD: dd/mm/yyyy"));

		pane1.add(idLB = new JLabel("Mã sản phẩm"));
		pane1.add(idTxt = new JTextField());
		pane1.add(inputLB = new JLabel("Số hàng nhập/đợt"));
		pane1.add(inputTxt = new JTextField());

		JPanel pane3 = new JPanel();
		pane3.setLayout(new FlowLayout(FlowLayout.CENTER));
		pane3.add(noteLB = new JLabel("(*) Nhập để chèn vị trí bất kỳ. Không nhập sẽ chèn vào vị trí tiếp theo."));
		noteLB.setFont(new Font("Tahoma", Font.ITALIC, 10));

		JPanel pane2 = new JPanel();
		pane2.setLayout(new FlowLayout(FlowLayout.CENTER));
		pane2.add(outLB = new JLabel("Số lượng bán/ngày"));
		pane2.add(outTxt = new JTextField(10));
		pane2.add(dayOutLB = new JLabel("Ngày bán(**)"));
		pane2.add(dayOutTxt = new JTextField("VD: dd/mm/yyyy", 15));

		JPanel pane13 = new JPanel();
		pane13.setLayout(new BoxLayout(pane13, BoxLayout.Y_AXIS));
		pane13.setBorder(BorderFactory.createTitledBorder("Thông tin hàng nhập"));
		pane13.add(pane1);
		pane13.add(pane3);

		JPanel pane5 = new JPanel();
		pane5.add(addBtn = new JButton("Thêm mới"));
		pane5.add(editBtn = new JButton("Sửa"));
		pane5.add(removeBtn = new JButton("Xóa"));
		pane5.add(searchBtn = new JButton("Tìm kiếm"));

		JPanel pane6 = new JPanel();
		pane6.add(sortID = new JButton("Theo mã"));
		pane6.add(sortName = new JButton("Theo tên"));
		pane6.add(sortPrice = new JButton("Theo Giá/SP"));
		pane6.add(sortInput = new JButton("Theo SL nhập/đợt"));

		JPanel pane7 = new JPanel();
		pane7.add(clearBtn = new JButton("Clear"));
		pane7.add(homeBtn = new JButton("Home"));

		JPanel pane67 = new JPanel();
		pane67.setLayout(new BoxLayout(pane67, BoxLayout.Y_AXIS));
		pane67.setBorder(BorderFactory.createTitledBorder("Sắp xếp"));
		pane67.add(pane6);
		pane67.add(pane7);

		JPanel paneI = new JPanel();
		JPanel paneTitle = new JPanel();
		paneTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		paneTitle.add(titleLB = new JLabel("QUẢN L�? KHO HÀNG"));
		titleLB.setFont(new Font("Tahoma", Font.BOLD, 18));
		paneI.setLayout(new BoxLayout(paneI, BoxLayout.Y_AXIS));
		add(paneI, BorderLayout.NORTH);
		paneI.add(paneTitle);
		paneI.add(pane13);
		paneI.add(pane2);
		paneI.add(pane5);
		paneI.add(pane67);
		JTextArea txtArea2 = new JTextArea(
				"STT" + "\t" + "Mã SP" + "\t" + "Tên SP" + "\t" + "Giá SP" + "\t" + "Ngày nhập/đợt" + "                "
						+ "Số lượng nhập" + "     " + "Ngày bán" + "\t           " + "Số lượng bán/ngày");
		paneI.add(txtArea2);

		JPanel paneII = new JPanel();
		paneII.setLayout(new BoxLayout(paneII, BoxLayout.LINE_AXIS));
		add(paneII, BorderLayout.CENTER);
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		paneII.add(scroll);

		Store st = new Store();

		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					id = Integer.parseInt(idTxt.getText());
					price = Double.parseDouble(priceTxt.getText());
					input = Integer.parseInt(inputTxt.getText());
					output = Integer.parseInt(outTxt.getText());
					name = nameTxt.getText();
					inputDay = dayInputTxt.getText();
					outputDay = dayOutTxt.getText();

					Goods goods = new Goods(name, id, price, input, output, inputDay, outputDay);

					String sttText = sttTxt.getText();

					if (!sttText.isEmpty()) {
						index = Integer.parseInt(sttText);
						if (index == 0) {
							JOptionPane.showMessageDialog(null, "Số thứ tự bắt đầu từ 1");
						}
						if (output <= input) {
							JOptionPane.showMessageDialog(null, "Số hàng nhập vào phải lớn hơn hoặc bằng số hàng bán ra");
						}
						st.addGoods(goods, index - 1);
					} else {
						st.addGoods(goods);
					}
					textArea.setText(/* textArea.getText() + "\n" + */ st.print());
					sttTxt.setText("");
					idTxt.setText("");
					priceTxt.setText("");
					inputTxt.setText("");
					outTxt.setText("");
					nameTxt.setText("");
					dayInputTxt.setText("");
					dayOutTxt.setText("");
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Mã, Số lượng, Giá phải là số. Vui lòng kiểm tra và nhập lại");
				} catch (IndexOutOfBoundsException exc2) {
					JOptionPane.showMessageDialog(null, "Số thứ tự không vượt quá số thứ tự lớn nhất");

				}
			}

			// cách 2
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					int i = -1;
//				
//					id = Integer.parseInt(idTxt.getText());
//					price = Double.parseDouble(priceTxt.getText());
//					input = Integer.parseInt(inputTxt.getText());
//					output = Integer.parseInt(outTxt.getText());
//					name = nameTxt.getText();
//					inputDay = dayInputTxt.getText();
//					outputDay = dayOutTxt.getText();
//					Goods goods = new Goods(name, id, price, input, output, inputDay, outputDay);
//				
//					String sttText = sttTxt.getText();
//					i = Integer.parseInt(sttText);
//
//					if (i > -1) {
//						st.addGoods(goods, i);
//						i = -1;
//					} else {
//						st.addGoods(goods);
//					}
//						textArea.setText(/* textArea.getText() + "\n" + */ st.print());
//					} catch (NumberFormatException exception) {
//						JOptionPane.showMessageDialog(null, "Vui lòng nhập số");
//					} catch (IndexOutOfBoundsException exc2) {
//						JOptionPane.showMessageDialog(null, "Số thứ tự không vượt quá số thứ tự lớn nhất");
//	
//				}
//			}
		});

		removeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!nameTxt.getText().isEmpty() && idTxt.getText().isEmpty() && sttTxt.getText().isEmpty()
						&& priceTxt.getText().isEmpty() && dayInputTxt.getText().isEmpty()
						&& dayOutTxt.getText().isEmpty() && inputTxt.getText().isEmpty()
						&& outTxt.getText().isEmpty()) {
					st.rmByName(nameTxt.getText());
					textArea.setText(st.print());
					nameTxt.setText("");
				} else if (nameTxt.getText().isEmpty() && !idTxt.getText().isEmpty() && sttTxt.getText().isEmpty()
						&& priceTxt.getText().isEmpty() && dayInputTxt.getText().isEmpty()
						&& dayOutTxt.getText().isEmpty() && inputTxt.getText().isEmpty()
						&& outTxt.getText().isEmpty()) {
					st.rmById(Integer.parseInt(idTxt.getText()));
					textArea.setText(st.print());
					idTxt.setText("");
				} else if (nameTxt.getText().isEmpty() && idTxt.getText().isEmpty() && sttTxt.getText().isEmpty()
						&& !priceTxt.getText().isEmpty() && dayInputTxt.getText().isEmpty()
						&& dayOutTxt.getText().isEmpty() && inputTxt.getText().isEmpty()
						&& outTxt.getText().isEmpty()) {
					st.removeElements(Double.parseDouble(priceTxt.getText()));
					textArea.setText(st.print());
					priceTxt.setText("");
				}
			}

		});

		clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});

		homeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(st.print());
			}
		});

		editBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				id = Integer.parseInt(idTxt.getText());
				if (!idTxt.getText().isEmpty()) {
					if (!nameTxt.getText().isEmpty()) {
						name = nameTxt.getText();
						st.edName(id, name);
						textArea.setText(st.print());
						nameTxt.setText("");
					}
					if (!priceTxt.getText().isEmpty()) {
						price = Double.parseDouble(priceTxt.getText());
						st.edPrice(id, price);
						textArea.setText(st.print());
						priceTxt.setText("");
					}
					if (!inputTxt.getText().isEmpty()) {
						input = Integer.parseInt(inputTxt.getText());
						st.edInput(id, input);
						textArea.setText(st.print());
						inputTxt.setText("");
					}
					if (!dayInputTxt.getText().isEmpty()) {
						inputDay = dayInputTxt.getText();
						st.edInputDay(id, inputDay);
						textArea.setText(st.print());
						dayInputTxt.setText("");
					}
					idTxt.setText("");
				}

			}
		});

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// search id
				try {
					if (nameTxt.getText().isEmpty() && !idTxt.getText().isEmpty() && sttTxt.getText().isEmpty()
							&& priceTxt.getText().isEmpty() && dayInputTxt.getText().isEmpty()
							&& dayOutTxt.getText().isEmpty() && inputTxt.getText().isEmpty()
							&& outTxt.getText().isEmpty()) {
						st.search(id);
						id = Integer.parseInt(idTxt.getText());
						textArea.setText(st.search(id));
						idTxt.setText("");

					}
					if (!nameTxt.getText().isEmpty() && idTxt.getText().isEmpty() && sttTxt.getText().isEmpty()
							&& priceTxt.getText().isEmpty() && dayInputTxt.getText().isEmpty()
							&& dayOutTxt.getText().isEmpty() && inputTxt.getText().isEmpty()
							&& outTxt.getText().isEmpty()) {
						st.search(name);
						name = nameTxt.getText();
						textArea.setText(st.search(name));
						nameTxt.setText("");
					}
					if (nameTxt.getText().isEmpty() && idTxt.getText().isEmpty() && sttTxt.getText().isEmpty()
							&& !priceTxt.getText().isEmpty() && dayInputTxt.getText().isEmpty()
							&& dayOutTxt.getText().isEmpty() && inputTxt.getText().isEmpty()
							&& outTxt.getText().isEmpty()) {
						st.search(price);
						price = Double.parseDouble(priceTxt.getText());
						textArea.setText(st.search(price));
						priceTxt.setText("");

					}
					if (nameTxt.getText().isEmpty() && idTxt.getText().isEmpty() && sttTxt.getText().isEmpty()
							&& priceTxt.getText().isEmpty() && dayInputTxt.getText().isEmpty()
							&& dayOutTxt.getText().isEmpty() && !inputTxt.getText().isEmpty()
							&& outTxt.getText().isEmpty()) {
						st.searchInput(input);
						input = Integer.parseInt(inputTxt.getText());
						textArea.setText(st.searchInput(input));
						inputTxt.setText("");
					}
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, " Mã, Số lượng, Giá phải là số. Vui lòng kiểm tra và nhập lại");
				}
			}
		});

		sortName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				st.sort(st.lis, new SortName());
				textArea.setText(st.print());
			}
		});

		sortID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				st.sort(st.lis, new SortId());
				textArea.setText(st.print());
			}
		});

		sortPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				st.sort(st.lis, new SortPrice());
				textArea.setText(st.print());

			}
		});

		sortInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				st.sort(st.lis, new SortInput());
				textArea.setText(st.print());
			}
		});

	}

}
