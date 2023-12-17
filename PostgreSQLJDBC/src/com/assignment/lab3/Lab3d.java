package com.assignment.lab3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


/**
 * =========================
 * Lab3d Assignment
 * CSE3010 Database
 * =========================
 * 
 * -----------
 * Description
 * -----------
 * 
 * This is the skeleton code for the Lab3d assignment.
 * 
 * -------
 * Grading
 * -------
 * 
 * Total: 1 points
 * 1 point for each task (no partial mark)
 * 0 if compilation fails.
 * 
 */
public class Lab3d implements ActionListener {
	
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
	private JLabel courseIDLabel;
	private JLabel sectionIDLabel;
	private JLabel semesterLabel;
	private JLabel yearLabel;
	private JTextField courseIDTextField;
	private JTextField sectionIDTextField;
	private JTextField semesterTextField;
	private JTextField yearTextField;
	private JButton registerButton;
	private String courseIDInput;
	private String sectionIDInput;
	private String semesterInput;
	private String yearInput;
	
	
	private JTextArea check_area;
	private JComboBox<String> check_box;
	
	String[] queries = {"SELECT * FROM course", 
			"SELECT * FROM section", "SELECT * FROM prereq"};
	
	/*
	 * Replace url, user and password, if preferred.
	 */
	public Lab3d() {
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
		
		frame.setTitle("Week11Lab JDBC Lab 4");					// name on the top of the frame
		frame.setSize(320, 130);								// size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// call System.exit() on closing
		frame.setVisible(true);									// display the frame on the screen
	}
	
	/*
	 * This method pops up Course Info window
	 * replacing Login window.
	 * Course Info window must be shown after 
	 * the user successfully log in (and the 
	 * connection with the database server is
	 * successfully established).
	 * 
	 */
	private void courseInfo() {
		check_area = new JTextArea();
		check_box = new JComboBox<String>();
		
		courseIDLabel = new JLabel("CourseId");
		sectionIDLabel = new JLabel("SectionID");
		semesterLabel = new JLabel("Semester");
		yearLabel = new JLabel("Year");
		courseIDTextField = new JTextField();
		sectionIDTextField = new JTextField();
		semesterTextField = new JTextField();
		yearTextField = new JTextField();
		registerButton = new JButton("Register");
		registerButton.addActionListener(this);
		
		
		frame.setVisible(false);
		
		frame = new JFrame();
		panel = new JPanel();
		
		panel.setFont(new Font(null, 1, 12));
		panel.setBorder(new TitledBorder("Inquiry"));
		panel.setBounds(380, 80, 490, 280);
		panel.setLayout(null);
		
		check_box.addItem("Course");
		check_box.addItem("Section");
		check_box.addItem("Prereq");
		
		check_area.setBorder(new LineBorder(Color.gray, 2));
		check_area.setEditable(false);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(check_area);
		
		check_box.setBounds(20, 40, 70, 30);
		scroll.setBounds(10, 80, 460, 270);
		
		courseIDLabel.setBounds(100, 10, 60, 30);
		sectionIDLabel.setBounds(170, 10, 60, 30);
		semesterLabel.setBounds(240, 10, 60, 30);
		yearLabel.setBounds(310, 10, 60, 30);
		courseIDTextField.setBounds(100, 40, 60, 30);
		sectionIDTextField.setBounds(170, 40, 60, 30);
		semesterTextField.setBounds(240, 40, 60, 30);
		yearTextField.setBounds(310, 40, 60, 30);
		registerButton.setBounds(380, 40, 90, 30);

		
		check_box.addActionListener(this);
		
		panel.add(check_box);
		panel.add(scroll);
		
		panel.add(courseIDLabel);
		panel.add(sectionIDLabel);
		panel.add(semesterLabel);
		panel.add(yearLabel);
		panel.add(courseIDTextField);
		panel.add(sectionIDTextField);
		panel.add(semesterTextField);
		panel.add(yearTextField);
		panel.add(registerButton);
		
		frame.add(panel);
		
		frame.setTitle("Course Info");
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	

	private void insertItem(String courseID, String sectionID, String semester, String year) 
	        throws SQLException {
	    String sqlStr = getQuery("section") +
	            " where course_id = ?" +
	            " and sec_id = ?" +
	            " and semester = ?" +
	            " and year = ?";
	    System.out.println("insertItem sqlStr=" + sqlStr);
	    PreparedStatement pstmt = conn.prepareStatement (sqlStr);
	    pstmt.setString(1, courseID);
	    pstmt.setString(2, sectionID);
	    pstmt.setString(3, semester);
	    pstmt.setInt(4, Integer.parseInt(year));
	    System.out.println(pstmt.toString()); 
	    ResultSet result = pstmt.executeQuery();
	    if (result.next()) {
	        sqlStr = "insert into enrollment (course_id, sec_id, semester, year) "
	                + "values (?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(sqlStr);
	        pstmt.setString(1, courseID); 
	        pstmt.setString(2, sectionID); 
	        pstmt.setString(3, semester); 
	        pstmt.setInt(4, Integer.parseInt(year)); 
	        pstmt.executeUpdate();
	
	        JOptionPane.showMessageDialog(null, "Registered in the course "+ courseID
	        +" section " + sectionID + " for the " + semester + " semester in " + year);
	        } else {
	            String errorMsg = user + "! You cannot register in the course " + courseID
	                    + " section " + sectionID + " for the " + semester + " semester in " + year
	                    + ", because such a course is not offered!";
	            JOptionPane.showMessageDialog(null, errorMsg, "Registration Error", JOptionPane.ERROR_MESSAGE);
	        }
	        result.close(); 
	        pstmt.close();
	    }


	

	/*
	 * Modify this method to pop up Course Info window
	 * replacing the Login window. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			// Get the text entered in JTextField and JPasswordField
			user = idInput.getText();
			password = new String(pwdInput.getPassword());
			
			conn = this.connect();
			if (conn != null) {
				courseInfo();
			}
		} else if (e.getSource() == check_box) {
			try {
				showTable();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} else if (e.getSource() == registerButton) { 
		    System.out.println("actionperformed registerButton"); 
		    courseIDInput = courseIDTextField.getText(); 
		    sectionIDInput = sectionIDTextField.getText(); 
		    semesterInput = semesterTextField.getText(); 
		    yearInput = yearTextField.getText();
		    try {
		        insertItem(courseIDInput, sectionIDInput, semesterInput, yearInput);
		    } catch (SQLException e1) {
		        e1.printStackTrace();
		    }
		}
	}
	
	private String getQuery(String tn) {
		String retQuery = null;
		if (tn.equalsIgnoreCase("course")) {
			retQuery = queries[0];
		} else if (tn.equalsIgnoreCase("section")) {
			retQuery = queries[1];
		} else if (tn.equalsIgnoreCase("prereq")) {
			retQuery = queries[2];
		}
		return retQuery;
	}
	
	/*
	 * Implement this method.
	 * The table content must be displayed on
	 * the Course Info window's JTextArea.
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
		
		String displayMsg = "";
		PreparedStatement pstmt = conn.prepareStatement(
				getQuery((String) check_box.getSelectedItem()));
		ResultSet result = pstmt.executeQuery();
		ResultSetMetaData rsmd = result.getMetaData();
		int numCols = rsmd.getColumnCount();
		int tableCharWidth = 0;
		for (int i = 1; i<= numCols; i++) {
			//System.out.print(rsmd.getColumnName(i) + "\t");
			displayMsg += rsmd.getColumnName(i) + "\t";
			tableCharWidth += rsmd.getColumnName(i).length();
		}
		//System.out.println();
		displayMsg += "\n";
		for (int i = 1; i <= tableCharWidth * 3; i++) {
			//System.out.print("-");
			displayMsg += "-";
		}
		//System.out.println();
		displayMsg += "\n";
		while (result.next()) {
			for (int i = 1; i <= numCols; i++) {
				//System.out.print(result.getString(i) + "\t");
				displayMsg += result.getString(i) + "\t";
			}
			//System.out.println();
			displayMsg += "\n";
		}

		check_area.setText(displayMsg);
		
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
        new Lab3d();
        
    }

}
