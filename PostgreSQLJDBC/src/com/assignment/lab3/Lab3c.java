package com.assignment.lab3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * =========================
 * Lab3c Assignment
 * CSE3010 Database
 * =========================
 * 
 * -----------
 * Description
 * -----------
 * 
 * This is the skeleton code for the Lab3c assignment.
 * 
 * -------
 * Grading
 * -------
 * 
 * Total: 4 points
 * 1 point for each task (no partial mark)
 * 0 if compilation fails.
 * 
 */

public class Lab3c implements ActionListener {
		
		private String url;
	    private String user;
	    private String password;
		private Connection conn;
		
		private JFrame frame;
		private JPanel panel;
		private JLabel idLabel;
		private JLabel pwdLabel;
		private JTextField idInput;
		private JPasswordField pwdInput;
		private JButton loginButton;
		
		private JTextArea check_area;
		private JComboBox<String> check_box;

		
		
		String[] univDBTableNames = {
				"classroom",
				"department",
				"course",
				"instructor",
				"section",
				"teaches",
				"student",
				"takes",
				"advisor",
				"time_slot",
				"prereq"
			};
		String[] queries = {
				"SELECT * FROM classroom",
				"SELECT * FROM department",
				"SELECT * FROM course",
				"SELECT * FROM instructor",
				"SELECT * FROM section",
				"SELECT * FROM teaches",
				"SELECT * FROM student",
				"SELECT * FROM takes",
				"SELECT * FROM advisor",
				"SELECT * FROM time_slot",
				"SELECT * FROM prereq"
				};
		
		/*
		 * Replace url, user and password, if preferred.
		 */
		public Lab3c() {
			url = "jdbc:postgresql://localhost:5432/postgres";
			user = "jinmyeong-in";
			password = "";

			frame = new JFrame();
			panel = new JPanel();
			idLabel = new JLabel("ID");
			pwdLabel = new JLabel("Password");
			idInput = new JTextField(user);
			pwdInput = new JPasswordField(password);
			loginButton = new JButton("Login");
			
			panel.setLayout(null);
			
			// Specify location of Components
			idLabel.setBounds(20, 10, 60, 30);
			pwdLabel.setBounds(20, 50, 60, 30);
			idInput.setBounds(100, 10, 80, 30);
			pwdInput.setBounds(100, 50, 80, 30);
			loginButton.setBounds(200, 25,  80, 35);
			
			// Add an ActionListener to the Login Button
			loginButton.addActionListener(this);
			
			// Add Components to Panel
			panel.add(idLabel);
			panel.add(pwdLabel);
			panel.add(idInput);
			panel.add(pwdInput);
			panel.add(loginButton);
			// Add Panel to Frame
			frame.add(panel);
			
			frame.setTitle("Lab3c Assignment");					// name on the top of the frame
			frame.setSize(320, 130);								// size of the frame
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// call System.exit() on closing
			frame.setVisible(true);									// display the frame on the screen
		}
		
		/*
		 * Task 1: Modify this method.
		 * 
		 * This method pops up University Info window
		 * replacing Login window.
		 * University Info window must be shown after 
		 * the user successfully log in (and the 
		 * connection with the database server is
		 * successfully established).
		 * 
		 */
		private void universityInfo() throws SQLException {
			check_area = new JTextArea();
			check_box = new JComboBox<String>();
			
			frame.setVisible(true);
			
			frame = new JFrame();
			panel = new JPanel();
			
			frame.setLocation(400, 0);
			
			panel.setFont(new Font(null, 1, 12));
			panel.setBorder(new TitledBorder("Inquiry"));
			panel.setBounds(380, 80, 490, 280);
			panel.setLayout(null);
			
			addAllTableNamesToCheckBox();
			
			check_area.setBorder(new LineBorder(Color.gray, 2));
			check_area.setEditable(false);
			
			JScrollPane scroll = new JScrollPane();
			scroll.setViewportView(check_area);
			
			check_box.setBounds(20, 40, 120, 30);
			scroll.setBounds(10, 80, 460, 270);
			
			check_box.addActionListener(this);
			
			panel.add(check_box);
			panel.add(scroll);
			
			frame.add(panel);
			
			frame.setTitle("University Info");              
			frame.setSize(500, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		
		/*
		 * Task 2: Implement this method.
		 * 
		 * This method gets table names in University DB 
		 * and add those to the check box.
		 * University DB's relations are hard-coded and
		 * can be found in univDBTableNames
		 * 
		 */
		private void addAllTableNamesToCheckBox() throws SQLException {
			// fill in here
			try {
		
				conn = connect();
				ResultSet rs = conn.getMetaData().getTables("", "", "%", new String[]{"TABLE"});
				while(rs.next()) {
				    String table = rs.getString("TABLE_NAME");
				    check_box.addItem(table);
				}
			}
			catch (NullPointerException ne) {
				ne.printStackTrace();
			}
			// end
		}

		/*
		 * This method pops up University Info window
		 * alongside the Login window. 
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loginButton) {
				// Get the text entered in JTextField and JPasswordField
				user = idInput.getText();
				password = new String(pwdInput.getPassword());
				
				conn = this.connect();
				if (conn != null) {
					try {
						universityInfo();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} else if (e.getSource() == check_box) {
				try {
					showTable();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
		
		/*
		 * Task 3: Implement this method.
		 * 
		 * Depending on the given tn, this method gets a right
		 * SQL query hard-coded in queries above.
		 * 
		 */ 
		private String getQuery(String tn) {
			// fill in here
			int index = Arrays.asList(univDBTableNames).indexOf(tn);
			
			return queries[index];
			// end
		}
		
		/*
		 * Task 4: Implement this method.
		 * 
		 * This method displays table contents in
		 * the University Info window's JTextArea.
		 * 
		 * First row of the displayed table content
		 * must be the name of columns separated by
		 * a tab ('\t').
		 * 
		 * Second row of the displayed table content
		 * must be dash (-) as many times as the sum
		 * of length of column name string times 3.
		 * (# of dash = length of all column names * 3)
		 * 
		 * Then, each row of the table should be 
		 * displayed line by line.
		 * 
		 * The display should be as follow:
		 * <Column names separated by a tab>
		 * ----------------------------------- 
		 * <The 1st row of the chosen table>
		 * <The 2nd row of the chosen table>
		 * ...
		 * <The last row of the chosen table>
		 *  
		 */
		private void showTable() throws SQLException {
		    // fill in here
		    try {
		        String tableName = check_box.getSelectedItem().toString();
		        String query = getQuery(tableName);

		        if (query != null) {
		            PreparedStatement pstmt = conn.prepareStatement(query);
		            ResultSet rs = pstmt.executeQuery();

		            ResultSetMetaData rsmd = rs.getMetaData();
		            int columnCount = rsmd.getColumnCount();

		            StringBuilder columnNames = new StringBuilder();
		            StringBuilder lineSeparator = new StringBuilder();

		            for (int i = 1; i <= columnCount; i++) {
		                String columnName = rsmd.getColumnName(i);
		                int columnWidth = columnName.length() * 3;
		                columnNames.append(columnName).append("\t");
		                for (int j = 0; j < columnWidth; j++) {
		                    lineSeparator.append("-");
		                }
		                lineSeparator.append("\t");
		            }

		            check_area.setText(columnNames.toString() + "\n" + lineSeparator.toString() + "\n");

		            while (rs.next()) {
		                StringBuilder rowData = new StringBuilder();
		                for (int i = 1; i <= columnCount; i++) {
		                    rowData.append(rs.getString(i)).append("\t");
		                }
		                check_area.append(rowData.toString().replace("\n", " ") + "\n");
		            }
		        } else {
		            System.out.println("Query not found for the table");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    // end
		}


		
	    /**
	     * Connect to the PostgreSQL database
	     *
	     * @return a Connection object
	     */
	    public Connection connect() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the PostgreSQL server successfully.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	        return conn;
	    }
		
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        new Lab3c();
	    }
	
}
