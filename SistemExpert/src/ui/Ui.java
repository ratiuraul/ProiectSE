package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;
import org.json.JSONObject;

import logic.InferenceMachine;
import logic.Triage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import java.awt.Font;

public class Ui extends JFrame {

	private JPanel contentPane;
	private JTextField questionBox;
	private int question_index = 0;
	private int type_index = 0;
	private int cpu_index = 0;
	private int dimension_index = 0;
	private int memory_index = 0;
	private int weight_index = 0;
	private int price_index = 0;
	private int brand_index = 0;
	private Boolean start_pressed = false;
	private Boolean da_pressed = false;
	private JSONObject response;

	// private int question_index = 0;
	// private int question_index = 0;
	// private int question_index = 0;
	Question q = new Question("test", "test", "test");
	InferenceMachine m = new InferenceMachine();
	List<JSONObject> l = new ArrayList<>();
	List<JSONObject> partial_list;
	Triage t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ui frame = new Ui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start_pressed = true;
				questionBox.setText("Va rog sa raspundeti cu DA, NU sau Irelevant.Apasa Next");
				q.init();
				try {
					m.initList();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		startBtn.setForeground(Color.GREEN);
		startBtn.setBackground(Color.WHITE);
		startBtn.setBounds(143, 121, 127, 31);
		contentPane.add(startBtn);

		questionBox = new JTextField();
		questionBox.setBounds(0, 39, 432, 43);
		contentPane.add(questionBox);
		questionBox.setColumns(10);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			// TODO add this into DA/NU blocks la irelevant doar cresc indexu si afisez urma
			// intrebare
			public void actionPerformed(ActionEvent arg0) {
				if (question_index <= q.questionList.size() - 1) {
					System.out.print(q.questionList.size());
					questionBox.setText(q.questionList.get(question_index).text);

					System.out.print(question_index);
				}
			}
		});
		btnNext.setBounds(293, 121, 115, 31);
		contentPane.add(btnNext);

		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				question_index = 0;
				type_index = 0;
				cpu_index = 0;
				dimension_index = 0;
				memory_index = 0;
				weight_index = 0;
				price_index = 0;
				brand_index = 0;
				System.out.print(question_index);
				q.init();
				try {
					m.initList();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				questionBox.setText(q.questionList.get(question_index).text);
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(12, 121, 115, 31);
		contentPane.add(btnNewButton);

		JButton btnDa = new JButton("Da");
		btnDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				da_pressed = true;
				if (start_pressed) {
					if (question_index <= 14) {
						try {
							if (question_index == 0) {
								l = t.sortList(m.initialList, q.questionList.get(question_index).type,
										q.questionList.get(question_index).value);
								// l = t.sortList(m.initialList,"BRAND","DELL");
								partial_list = l;
								type_index = 2;
								question_index = type_index;
								questionBox.setText(q.questionList.get(question_index).text);
								System.out.println(question_index);
							} else if (question_index == 2) {
								l = t.sortList(partial_list, q.questionList.get(question_index).type,
										q.questionList.get(question_index).value);
								// l = t.sortList(m.initialList,"BRAND","DELL");
								partial_list = l;
								dimension_index = 4;
								question_index = dimension_index;
								questionBox.setText(q.questionList.get(question_index).text);
								// question_index = question_index + 1;
								System.out.println(question_index);
							} else if (question_index >= 4 && question_index < 7) {
								l = t.sortList(partial_list, q.questionList.get(question_index).type,
										q.questionList.get(question_index).value);
								// l = t.sortList(m.initialList,"BRAND","DELL");
								partial_list = l;
								cpu_index = 7;
								question_index = cpu_index;
								questionBox.setText(q.questionList.get(question_index).text);
								// question_index = question_index + 1;
								System.out.println(question_index);
							} else if (question_index >= 7 && question_index < 10) {
								l = t.sortList(partial_list, q.questionList.get(question_index).type,
										q.questionList.get(question_index).value);
								// l = t.sortList(m.initialList,"BRAND","DELL");
								partial_list = l;
								memory_index = 14;
								question_index = memory_index;
								questionBox.setText(q.questionList.get(question_index).text);
								// question_index = question_index + 1;
								System.out.println(question_index);
							} else if (question_index >= 10 && question_index < 14) {
								l = t.sortList(partial_list, q.questionList.get(question_index).type,
										q.questionList.get(question_index).value);
								// l = t.sortList(m.initialList,"BRAND","DELL");
								partial_list = l;
								price_index = 10;
								question_index = price_index;
								questionBox.setText(q.questionList.get(question_index).text);
								// question_index = question_index + 1;
								System.out.println(question_index);
							} else if (question_index >= 10 && question_index <= 23) {
								l = t.sortList(partial_list, q.questionList.get(question_index).type,
										q.questionList.get(question_index).value);
								// l = t.sortList(m.initialList,"BRAND","DELL");
								partial_list = l;
								brand_index = 15;
								question_index = brand_index;
								questionBox.setText(q.questionList.get(question_index).text);
								// question_index = question_index + 1;
								System.out.println(question_index);
							} else {
								System.out.println(question_index);
								if (question_index < 24) {
									question_index = question_index + 1;
									questionBox.setText(q.questionList.get(question_index).text);
								} else {
									try {
										questionBox.setText("Raspuns: " + response.getString("BRAND")
												+ response.getString("MODEL") + " Dimensiune:"
												+ response.getString("SIZE") + " TIP " + response.getString("TYPE")
												+ " CPU:" + response.getString("CPU") + " PRET:"
												+ response.getString("PRET"));
									} catch (JSONException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}

							}

							// else if(question_index <= 23) {
							// l = t.sortList(partial_list, q.questionList.get(question_index).type,
							// q.questionList.get(question_index).value);
							// partial_list = l;
							// question_index = question_index + 1;
							// questionBox.setText(q.questionList.get(question_index).text);
							// System.out.println(question_index);
							// }
							if (!(l.isEmpty())) {
								response = l.get(0);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JSONException e1) {
							// TODO Auto-generated caStch block
							e1.printStackTrace();
						}
						for (int i = 0; i < l.size(); i++) {
							System.out.println(l.get(i));
						}
					} else {
						try {
							questionBox.setText("Raspuns:" + response.getString("BRAND") + response.getString("MODEL")
									+ "Dimensiune:" + response.getString("SIZE") + " TIP " + response.getString("TYPE")
									+ "CPU:" + response.getString("CPU") + " PRET:" + response.getString("PRET"));
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else {
					questionBox.setText("Please press start");
				}
			}
		});
		btnDa.setBounds(293, 194, 115, 47);
		contentPane.add(btnDa);

		JButton btnIrelevant = new JButton("Irelevant");
		btnIrelevant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (start_pressed) {
					question_index = question_index + 1;
					questionBox.setText(q.questionList.get(question_index).text);
					System.out.println(question_index);
					if (!(l.isEmpty())) {
						response = l.get(0);	
					}
				} else {
					questionBox.setText("Please press start");
				}
			}
		});
		btnIrelevant.setBounds(143, 194, 127, 47);
		contentPane.add(btnIrelevant);

		JButton btnNu = new JButton("Nu");
		btnNu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (start_pressed) {
					if (question_index <= 24) {
						if (question_index <= 1) {
							question_index = question_index + 1;
							questionBox.setText(q.questionList.get(question_index).text);
							partial_list = m.initialList;
							System.out.println(question_index);
						} else if ((question_index >= 2) && (question_index < 4)) {
							question_index = question_index + 1;
							questionBox.setText(q.questionList.get(question_index).text);
							System.out.println(question_index);
						} else if ((question_index >= 4) && (question_index < 7)) {
							question_index = question_index + 1;
							questionBox.setText(q.questionList.get(question_index).text);
							System.out.println(question_index);
						} else if ((question_index >= 7) && (question_index < 10)) {
							question_index = question_index + 1;
							questionBox.setText(q.questionList.get(question_index).text);
							System.out.println(question_index);
						} else if ((question_index >= 10) && (question_index < 14)) {
							question_index = question_index + 1;
							questionBox.setText(q.questionList.get(question_index).text);
							System.out.println(question_index);
						} else if ((question_index >= 14) && (question_index <= 23)) {
							question_index = question_index + 1;
							if (question_index < 23) {
								questionBox.setText(q.questionList.get(question_index).text);
								System.out.println(question_index);
							} else
								try {
									questionBox.setText("Raspuns: " + response.getString("BRAND")
											+ response.getString("MODEL") + " Dimensiune:" + response.getString("SIZE")
											+ " TIP " + response.getString("TYPE") + " CPU:" + response.getString("CPU")
											+ " PRET:" + response.getString("PRET"));
								} catch (JSONException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						}

					} else {
						try {
							questionBox.setText("Raspuns: " + response.getString("BRAND") + response.getString("MODEL")
									+ " Dimensiune:" + response.getString("SIZE") + " TIP " + response.getString("TYPE")
									+ " CPU:" + response.getString("CPU") + " PRET:" + response.getString("PRET"));
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else {
					questionBox.setText("Please press start");
				}
				if (da_pressed) {
					if (!(l.isEmpty())) {
						response = l.get(0);
					}
				}
			}
		});
		btnNu.setBounds(12, 194, 115, 47);
		contentPane.add(btnNu);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(24, 95, 396, 14);
		contentPane.add(progressBar);
	}
}
