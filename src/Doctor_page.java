import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLWriter;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.*;

public class Doctor_page extends JFrame {

	private final JLabel lblPatientId = new JLabel("Patient ID");
	private JTextField reg;
	private JTextField pname;
	private JTextField age;
	private JTextField pcomplaint;
	private JComboBox comboBox;
	private JTable table;
	private JPanel panel;

	private String medi;
	private String type;
	private String dos;
	private String day;
	private String tot;
	private String remark;
	private String ie;
	private JTextField EditDay;
	private String gender; 

	private String add;
	private String add1;
	private String add2;
	private int b;
	private String Address;
	private String r_no;
	private String p_name;
	private String Age;
	private JLabel date_1;
	private String s_date;
	
	
	
	
	
	
	

	public void addMedi() {

		Connection conn = DbConnection.dbConnector();

		try {
			String sql = "insert into medi(MedicineName,Type,Dosage,Day,Total,DosageRemarks,IE) values (?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, medi);
			pst.setString(2, type);
			pst.setString(3, dos);
			pst.setString(4, day);
			pst.setString(5, tot);
			pst.setString(6, remark);
			pst.setString(7, ie);
			pst.execute();
			pst.close();
			updateTable();
			// JOptionPane.showMessageDialog(null, "Done");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void fillCombo() {

	}

	public void updateTable() {

		Connection conn = DbConnection.dbConnector();

		try {
			String sql = "select * from medi";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}
	
	
	public void deleteTable(){
		
		reg.setText("");
		pname.setText("");
		age.setText("");
		pcomplaint.setText("");
		
		Connection conn = DbConnection.dbConnector();
		try {

			String query = "delete from medi where rowid >=1";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.execute();
			//JOptionPane.showMessageDialog(null, "Done");
			pst.close();
			updateTable();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void close()
    {
    WindowEvent w=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(w);
    }
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_page frame = new Doctor_page();
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
	public Doctor_page() {
		getContentPane().setBackground(SystemColor.controlShadow);
		getContentPane().setForeground(Color.BLACK);

		fillCombo();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 601);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		lblPatientId.setBounds(41, 88, 98, 31);
		getContentPane().add(lblPatientId);

		reg = new JTextField();
		reg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				Connection conn = ConnectionMain.dbConnector();
				try {

					String sql = "select * from patient where reg=?";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1, reg.getText());
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						r_no = rs.getString("reg");
						reg.setText(r_no);
						Age = rs.getString("age");
						age.setText(Age);
						p_name = rs.getString("pname");
						pname.setText(p_name);
						gender=rs.getString("gender");
						Address=rs.getString("address");
					}
					rs.close();
					pst.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		reg.setBounds(168, 93, 160, 20);
		getContentPane().add(reg);
		reg.setColumns(10);

		JLabel lblPatient = new JLabel("Patient Name");
		lblPatient.setBounds(40, 130, 80, 14);
		getContentPane().add(lblPatient);

		pname = new JTextField();
		pname.setBounds(168, 127, 160, 20);
		getContentPane().add(pname);
		pname.setColumns(10);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(41, 161, 46, 14);
		getContentPane().add(lblAge);

		age = new JTextField();
		age.setBounds(168, 162, 46, 20);
		getContentPane().add(age);
		age.setColumns(10);

		JLabel lblNewLabel = new JLabel("Complaint");
		lblNewLabel.setBounds(41, 197, 79, 14);
		getContentPane().add(lblNewLabel);

		pcomplaint = new JTextField();
		pcomplaint.setBounds(168, 195, 160, 20);
		getContentPane().add(pcomplaint);
		pcomplaint.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/medical.png"))
				.getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(338, 22, 253, 228);
		getContentPane().add(lblNewLabel_1);

		JLabel lblM = new JLabel("Medicine Name");
		lblM.setBounds(41, 236, 90, 14);
		getContentPane().add(lblM);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connection conn = ConnectionMain.dbConnector();
				try {
					String query = "select * from medicine where MedicineName=?";

					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, (String) comboBox.getSelectedItem());
					ResultSet rs = pst.executeQuery();

					if (rs.next()) {

						medi = rs.getString("MedicineName");
						type = rs.getString("Type");
						dos = rs.getString("Dosage");
						day = rs.getString("Day");
						tot = rs.getString("Total");
						remark = rs.getString("DosageRemarks");
						ie = rs.getString("IE");

					}

					pst.close();
					rs.close();
					addMedi();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				Connection conn = ConnectionMain.dbConnector();
				try {
					String query = "select * from medicine";

					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						comboBox.addItem(rs.getString("MedicineName"));

					}
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		comboBox.setBounds(168, 233, 179, 20);
		getContentPane().add(comboBox);

		JButton btnNewButton = new JButton("Reset All");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteTable();

			}
		});
		btnNewButton.setBounds(282, 507, 89, 23);
		getContentPane().add(btnNewButton);

		JList list = new JList();
		list.setBounds(65, 458, 199, -101);
		getContentPane().add(list);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 319, 706, 145);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				panel.setVisible(true);
				Connection conn = DbConnection.dbConnector();
				try {

					int row = table.getSelectedRow();
					String Table_click = (table.getModel().getValueAt(row, 0))
							.toString();

					String query = "select * from  medi where MedicineName='"
							+ Table_click + "' ";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();

					if (rs.next()) {

						add1 = rs.getString("Dosage");
						add = rs.getString("MedicineName");

					}

					int[] a = new int[5];
					b = 0;
					String[] temp;
					String delimeter = "-";
					temp = add1.split(delimeter);
					for (int i = 0; i < temp.length; i++) {
						a[i] = Integer.parseInt(temp[i]);
						b = b + a[i];

					}

					rs.close();
					pst.close();
				}

				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			}
		});
		scrollPane.setViewportView(table);

		panel = new JPanel();
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(504, 219, 199, 74);
		getContentPane().add(panel);
		panel.setLayout(null);

		EditDay = new JTextField();
		EditDay.setBounds(10, 11, 58, 20);
		panel.add(EditDay);
		EditDay.setColumns(10);

		JButton Update = new JButton("Day Change");
		Update.setBounds(78, 10, 111, 23);
		panel.add(Update);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(49, 51, 89, 23);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connection conn = DbConnection.dbConnector();
				try {

					String sql = "delete from  medi where MedicineName=='"
							+ add + "' ";

					PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Done");
					pst.close();
					updateTable();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		JButton btnFile = new JButton("Receipt");
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection conn = DbConnection.dbConnector();
					PreparedStatement pst = conn
							.prepareStatement("select * from medi");
					ResultSet rs = pst.executeQuery();
					File file = new File("D:/evision/bin/myfile.doc");
				//	file.createNewFile();

					FileWriter w = new FileWriter(file);
					w.write("\t\t\t\tRECEIPT PRESCRIPTION REQUEST FORM\n");
					w.write("\t\t\t\t--------------------------------\n");
					w.write("\n\n\t\t\t\t\t\t\t\t\tDr. Gurpreet Singh\n\t\t\t\t\t\t\t\t\tPhone : 9876545678\n");
					w.write("_________________________________________________________________________\n\n");
					w.write("Registration Number :- "+r_no+"\n\nPatient Name :- "+p_name+"\t\t\t\t\t\tAge :- "+Age);
					w.write("\n\nGender :- "+gender+"\t\t\t\t\t\t\tDate :- "+s_date+"\n\nAddress :- "+Address);
					w.write("\n\n\n=========================================================================\n");
					
					w.write("Medicine Name\tDay\t\tTotal\t\tDosage Remarks\tIE");
					w.write("\n_________________________________________________________________________\n\n");

					while (rs.next()) {

						w.write(rs.getString("MedicineName") + "\t\t");
						w.write(rs.getString("Day") + "\t\t");
						w.write(rs.getString("Total") + "\t\t");
						w.write(rs.getString("DosageRemarks") + "\t\t");
						w.write(rs.getString("IE") + "\n\n\n");
					}
					rs.close();
					pst.close();

					w.flush();
					w.close();
					 if (Desktop.isDesktopSupported()) {
					       Desktop.getDesktop().open(new File("D:/evision/bin/myfile.doc"));
					     }
					 
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnFile.setBounds(133, 507, 89, 23);
		getContentPane().add(btnFile);
		
		JLabel lblDat = new JLabel("Date");
		lblDat.setBounds(41, 279, 46, 14);
		getContentPane().add(lblDat);
		
		JLabel date_1 = new JLabel("");
		date_1.setBounds(168, 279, 124, 14);
		getContentPane().add(date_1);
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				add2 = EditDay.getText();
				int c = Integer.parseInt(add2), n;
				n = c * b;

				Connection conn = DbConnection.dbConnector();

				try {
					String sql = "Update medi set Day='" + EditDay.getText()
							+ "', Total='" + n + "' where MedicineName='" + add
							+ "' ";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					pst.close();
					updateTable();
					// JOptionPane.showMessageDialog(null, "Done");

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			}
		});

		panel.setVisible(false);
		

		DateFormat d=new SimpleDateFormat("dd/MM/yyyy");
		Date d2=new Date();
		String d3=d.format(d2);
		date_1.setText(d3);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnExit.setBounds(424, 507, 89, 23);
		getContentPane().add(btnExit);
		s_date=date_1.getText();
		
	}
}
