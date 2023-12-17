package com.assignment.lab3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * =========================
 * Lab3b  
 * CSE3010 Database
 * =========================
 * 
 * -----------
 * Description
 * -----------
 * 
 * This is the skeleton code for the Lab3b assignment.
 * 
 * -------
 * Grading
 * -------
 * 
 * 1 point for each task (no partial mark)
 * Total: 4 points
 *
 */
public class Lab3b implements ActionListener {

    private String url;
    private String user;
    private String password;
	
	private JFrame frame;
	private JPanel panel;
	private JLabel idLabel;
	private JLabel pwdLabel;
	private JTextField idInput;
	private JPasswordField pwdInput;
	private JButton loginButton;
	private JButton getTablesButton;
	private JLabel statusLabel;
	private JTextField statusMessageLabel;
	
	private Connection conn;
	
	public Lab3b() {
		
	}
	
	/*
	 * Task 1. 
	 * Implement this method to properly initialize 
	 * GUI components. 
	 */
	
	public void task1() {
		url = "jdbc:postgresql://localhost:5432/postgres";
		user = "jinmyeong-in";
		password = "";
		
		// fill in here
		frame = new JFrame();
		panel = new JPanel();
		
		
	    idLabel = new JLabel("ID");
	    pwdLabel = new JLabel("PASSWORD");
	    idInput = new JTextField(user);
	    pwdInput = new JPasswordField(password);
	    loginButton = new JButton("Login");
	    getTablesButton = new JButton("Tables");
	    statusLabel = new JLabel("Status");
	    
	    statusMessageLabel = new JTextField("OK");
	    
	    
		// end
	}
	
	/*
	 * Task 2. 
	 * Implement this method to properly display 
	 * GUI components. 
	 */
	public void task2() {
		// fill in here
		panel.setLayout(null);
		
		idLabel.setBounds(55,10,250,30);
		pwdLabel.setBounds(205,10,250,30);
		idInput.setBounds(50,50,100,30);
		pwdInput.setBounds(200,50,100,30);
		loginButton.setBounds(50,90,100,35);
		getTablesButton.setBounds(200,90,100,35);
		statusLabel.setBounds(30,150,350,35);
		statusMessageLabel.setBounds(25,180,300,35);
		
		
		loginButton.addActionListener(this);
		getTablesButton.addActionListener(this);
		
		panel.add(idLabel);
		panel.add(idInput);
		panel.add(loginButton);
		panel.add(pwdLabel);
		panel.add(idInput);
		panel.add(pwdInput);
		
		panel.add(getTablesButton);
		panel.add(statusLabel);
		panel.add(statusMessageLabel);
		
		frame.add(panel);
		
		frame.setTitle("Week10 Assignment");
		frame.setSize(350, 280);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// end
	}
	
	/*
	 * Task 3. 
	 * Implement this method to connect to the database 
	 * with the input user ID and password. 
	 */
	public Connection task3() {
		String statusMessageString = "Connected";
		// fill in here
		statusMessageLabel.setText(statusMessageString);
		user = idInput.getText();
		password = new String(pwdInput.getPassword());
		// end
		return this.connect();
	}
	
	/*
	 * Task 4.
	 * Implement this method to retrieve the list of tables
	 * and print out on Console.
	 */
	public void task4() throws SQLException {
		System.out.println("=====");
		System.out.println("Task4");
		System.out.println("=====");	
		String statusMessageString = "Available Tables are printed out on Console";
		try {
			// fill in here
			conn = connect();
			ResultSet rs = conn.getMetaData().getTables("", "", "%", new String[]{"TABLE"});
			while(rs.next()) {
			    String table = rs.getString("TABLE_NAME");
			    System.out.println(table);
			}
			
			
			statusMessageLabel.setText(statusMessageString);
			// end
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			statusMessageLabel.setText("NullPointerException: Did you Login?");
		}
		System.out.println("");
		System.out.println("");
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
     * Disconnect from the PostgreSQL database
     *
     */
    public void disconnect(Connection conn) {
        try {
        	conn.close();
            System.out.println("Connection is closed successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == loginButton) {
    		conn = task3();
    	} else if (e.getSource() == getTablesButton) {
    		try {
				task4();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
    	}
	}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lab3b sub = new Lab3b();
        sub.task1();
        sub.task2();

    }

	
	
}
