
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ForgotPassword extends JFrame implements ActionListener {

    JTextField emailField, usernameField;
    JPasswordField newPasswordField, confirmPasswordField;
    JButton resetButton, cancelButton;

    public ForgotPassword()
    {
        setTitle("Forgot Password");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(0, 0, 700, 700);
        formPanel.setBackground(new Color(255, 255, 255, 200));

        JLabel title = new JLabel("Forgot Password ?");
        title.setFont(new Font("Serif", Font.BOLD, 50));
        title.setForeground(new Color(0xC9184A));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(100, 30, 500, 60);
        formPanel.add(title);

        ImageIcon forgotIcon = new ImageIcon("forgot_password.jpg");
	    Image forgotImg = forgotIcon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
	    JLabel forgot = new JLabel(new ImageIcon(forgotImg));
		forgot.setBounds(40, 20, 110, 110);
	    formPanel.add(forgot);

        Font labelFont = new Font("SansSerif", Font.BOLD, 18);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        emailLabel.setForeground(new Color(0x4A158D));
        emailLabel.setBounds(100, 160, 180, 30);
        formPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(300, 160, 250, 30);
        formPanel.add(emailField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(new Color(0x4A158D));
        usernameLabel.setBounds(100, 220, 180, 30);
        formPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(300, 220, 250, 30);
        formPanel.add(usernameField);

        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setFont(labelFont);
        newPasswordLabel.setForeground(new Color(0x4A158D));
        newPasswordLabel.setBounds(100, 280, 180, 30);
        formPanel.add(newPasswordLabel);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(300, 280, 250, 30);
        formPanel.add(newPasswordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(labelFont);
        confirmPasswordLabel.setForeground(new Color(0x4A158D));
        confirmPasswordLabel.setBounds(100, 340, 180, 30);
        formPanel.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(300, 340, 250, 30);
        formPanel.add(confirmPasswordField);

        resetButton = new JButton("Reset Password");
        resetButton.setFont(new Font("Arial", Font.BOLD, 24));
        resetButton.setBackground(new Color(0xC9184A));
        resetButton.setForeground(new Color(0xFCE4EC));
        resetButton.setFocusPainted(false);
        resetButton.setBounds(200, 460, 300, 50);
        resetButton.addActionListener(this);
        formPanel.add(resetButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 24));
        cancelButton.setBackground(new Color(0x6C757D));
        cancelButton.setForeground(new Color(0xFCE4EC));
        cancelButton.setFocusPainted(false);
        cancelButton.setBounds(200, 540, 300, 50);
        cancelButton.addActionListener(this);
        formPanel.add(cancelButton);

        add(formPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == cancelButton) {
	        new SchoolLogin().setVisible(true);
	        this.dispose();
	    }

	   if (e.getSource() == resetButton) {
	       String email = emailField.getText().trim();
	       String username = usernameField.getText().trim();
	       String newPassword = new String(newPasswordField.getPassword()).trim();
	       String confirmPassword = new String(confirmPasswordField.getPassword()).trim();

	       if (email.isEmpty() || username.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
	           JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
	           return;
	       }

	       if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	           JOptionPane.showMessageDialog(this, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
	           return;
	       }

	       if (!username.matches("^[A-Za-z0-9_]{3,}$")) {
	           JOptionPane.showMessageDialog(this, "Invalid username. Use at least 3 characters, letters, digits or underscores only.", "Error", JOptionPane.ERROR_MESSAGE);
	           return;
	       }

	       if (!newPassword.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")) {
	           JOptionPane.showMessageDialog(this, "Password must be at least 6 characters and include both letters and digits.", "Error", JOptionPane.ERROR_MESSAGE);
	           return;
	       }

	       if (!newPassword.equals(confirmPassword)) {
	           JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
	           return;
	       }

	       boolean success = Connect_Database.resetPassword(email, username, newPassword);

	       if (success) {
	           JOptionPane.showMessageDialog(this, "Password reset successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	           new SchoolLogin().setVisible(true);
	           dispose();
	       } else {
	           JOptionPane.showMessageDialog(this, "Invalid username or email.", "Error", JOptionPane.ERROR_MESSAGE);
	       }
	   }
   }


    public static void main(String[] args) {
        new ForgotPassword();
    }
}



