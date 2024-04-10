package Pizu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;

public class Pizza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
//	private JTextField txtAddr;
	private JTextField txtMob;
	JTextField txtAddr;
	JList lstToppings;
	JComboBox cbBase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pizza frame = new Pizza();
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
	public Pizza() {
		setTitle("PIZZA ORDER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(35, 42, 108, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER ADDRESS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 93, 133, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ENTER MOBILE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 171, 133, 13);
		contentPane.add(lblNewLabel_2);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtName.setBounds(172, 39, 205, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAddr = new JTextField();
		txtAddr.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAddr.setBounds(172, 90, 205, 45);
		contentPane.add(txtAddr);
		txtAddr.setColumns(10);
		
		txtMob = new JTextField();
		txtMob.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMob.setBounds(172, 161, 205, 45);
		contentPane.add(txtMob);
		txtMob.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("BASE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(35, 234, 108, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TOPPINGS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(35, 306, 108, 13);
		contentPane.add(lblNewLabel_4);
		
		 cbBase = new JComboBox();
		cbBase.setModel(new DefaultComboBoxModel(new String[] {"BASIC", "THICK & CRISPY", "CHESSY", "SALTY", "NON VEG"}));
		cbBase.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbBase.setBounds(172, 230, 205, 21);
		contentPane.add(cbBase);
		
		JList list = new JList();
		list.setBounds(237, 246, 1, 1);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(248, 246, 1, 1);
		contentPane.add(list_1);
		
		JList list_2 = new JList();
		list_2.setBounds(248, 246, 1, 1);
		contentPane.add(list_2);
		
		JButton btnNewButton = new JButton("PLACE ORDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg=txtName.getText() + "\n Your Details are :\n";
				msg+="Address:" + txtAddr.getText() + "\n";
				msg+="Mobile No :" + txtMob.getText()+ "\n";
				msg+= "Base" + cbBase.getSelectedItem()+"\n";
				msg+= "Toppings: ";
				String str = "";
				Object[] tops = lstToppings.getSelectedValues();
				for(int i=0; i<tops.length; i++)
					str+=tops[i]+" , ";
				msg+=str+"\n YOUR ORDER WILL REACH SOON.....!!!!";
				
				JOptionPane.showMessageDialog(btnNewButton, msg);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(58, 384, 138, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAddr.setText("");
				txtMob.setText("");
				cbBase.setSelectedIndex(-1);
				lstToppings.clearSelection();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(217, 386, 147, 26);
		contentPane.add(btnNewButton_1);
		
		 lstToppings = new JList();
		lstToppings.setModel(new AbstractListModel() {
			String[] values = new String[] {"PEPPERCORN", "SAUSAGE", "CHILLYCHICKEN", "VEG KORMA"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lstToppings.setFont(new Font("Tahoma", Font.BOLD, 14));
		lstToppings.setBounds(172, 278, 205, 84);
		contentPane.add(lstToppings);
	}
}
