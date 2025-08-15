import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener {

    JTextField nameField, emailField, contactField, usernameField , designationField;
    JTextArea addressArea;
    JPasswordField passwordField;
    JButton registerButton, cancelButton;

    public SignUp()
    {
        setTitle(" Sign up page");
        setSize(700, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(0, 0, 700, 900);
        formPanel.setBackground(new Color(255, 255, 255, 200));

        JLabel title = new JLabel("Create Your Account");
        title.setFont(new Font("Serif", Font.BOLD, 40));
        title.setForeground(new Color(0xC9184A));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(100, 30, 500, 60);
        formPanel.add(title);

        ImageIcon signupIcon = new ImageIcon("signup.jpg");
	    Image signupImg = signupIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		JLabel signup = new JLabel(new ImageIcon(signupImg));
		signup.setBounds(40, 20, 100, 100);
	    formPanel.add(signup);

        Font labelFont = new Font("SansSerif", Font.BOLD, 20);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setBounds(100, 140, 180, 30);
        formPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(300, 140, 250, 30);
        formPanel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        emailLabel.setBounds(100, 200, 180, 30);
        formPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(300, 200, 250, 30);
        formPanel.add(emailField);

        JLabel addressLabel = new JLabel("Local Address:");
        addressLabel.setFont(labelFont);
        addressLabel.setBounds(100, 260, 180, 30);
        formPanel.add(addressLabel);

        addressArea = new JTextArea();
        addressArea.setLineWrap(true);


        JScrollPane addressScroll = new JScrollPane(addressArea);
        addressScroll.setBounds(300, 260, 250, 80);
        formPanel.add(addressScroll);

        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setFont(labelFont);
        contactLabel.setBounds(100, 370, 180, 30);
        formPanel.add(contactLabel);

        contactField = new JTextField();
        contactField.setBounds(300, 370, 250, 30);
        formPanel.add(contactField);

        JLabel designationLabel = new JLabel("Designation:");
		designationLabel.setFont(labelFont);
		designationLabel.setBounds(100, 420, 180, 30);
        formPanel.add(designationLabel);

        designationField = new JTextField();
        designationField.setBounds(300, 420, 250, 30);
        formPanel.add(designationField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        usernameLabel.setBounds(100, 470, 180, 30);
        formPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(300, 470, 250, 30);
        formPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        passwordLabel.setBounds(100, 520, 180, 30);
        formPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(300, 520, 250, 30);
        formPanel.add(passwordField);

        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 26));
        registerButton.setBackground(new Color(0xC9184A));
        registerButton.setForeground(new Color(0xFCE4EC));
        registerButton.setFocusPainted(false);
        registerButton.setBounds(200, 650, 300, 50);
        registerButton.addActionListener(this);
        formPanel.add(registerButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 26));
        cancelButton.setBackground(new Color(0x6C757D));
        cancelButton.setForeground(new Color(0xFCE4EC));
        cancelButton.setFocusPainted(false);
        cancelButton.setBounds(200, 720, 300, 50);
        cancelButton.addActionListener(this);
        formPanel.add(cancelButton);

        add(formPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == registerButton) {
	        String name = nameField.getText().trim();
	        String email_id = emailField.getText().trim();
	        String contact_no = contactField.getText().trim();
	        String designation = designationField.getText().trim();
	        String password = new String(passwordField.getPassword()).trim();
	        String username = usernameField.getText().trim();

	        if (name.isEmpty() || email_id.isEmpty() || contact_no.isEmpty() || designation.isEmpty() || password.isEmpty() || username.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        if (!email_id.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
	        {
			    JOptionPane.showMessageDialog(this, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}


			if (!contact_no.matches("^[6-9]\\d{9}$"))
			{
			     JOptionPane.showMessageDialog(this, "Invalid contact. Must be 10 digits and start with 6-9.");
			     return;
		     }
		     if (!designation.matches("^[A-Za-z ]{2,}$"))
			 {
			 	  JOptionPane.showMessageDialog(this, "Invalid designation. Only alphabets and spaces allowed.");
			 	  return;
		     }

			 if (!username.matches("^[A-Za-z0-9_]{3,}$"))
			 {
			     JOptionPane.showMessageDialog(this, "Invalid username. Use at least 3 characters, letters, digits or underscores only.", "Error", JOptionPane.ERROR_MESSAGE);
			     return;
			 }


			 if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$"))
			 {
			     JOptionPane.showMessageDialog(this, "Password must be at least 6 characters and include both letters and digits.", "Error", JOptionPane.ERROR_MESSAGE);
			     return;
			 }


	        try (Connection conn = Connect_Database.getConnection()) {
	            boolean success = Connect_Database.userRegistration(name, email_id, contact_no, designation, password, username);
	            if (success) {
	                JOptionPane.showMessageDialog(this, "Registration successful!");
	                new SchoolLogin().setVisible(true);
	                this.dispose();
	            } else {
	                JOptionPane.showMessageDialog(this, "Username already exists!", "Registration Failed", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    else if (e.getSource() == cancelButton) {
	        new SchoolLogin().setVisible(true);
	        this.dispose();
	    }
	}

    public static void main(String[] args)
    {
        new SignUp();
    }
}
