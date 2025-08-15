import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Enquiry extends JFrame implements ActionListener {

    JTextField nameField, emailField, phoneField;
    JTextArea msgArea;
    JButton submitBtn, backButton;

    private JComboBox<String> standardCombo;

    public Enquiry() {
        setTitle("Enquiry - BHEL Secondary School");
        setFullScreen();
        getContentPane().setBackground(new Color(0xE3F2FD));
        setLayout(null);


        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(0xFFF3E0));
        formPanel.setBounds(300, 180, 1300, 650);
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF6F61), 4, true));
        add(formPanel);

        JLabel heading = new JLabel("ENQUIRY FORM");
        heading.setFont(new Font("Serif", Font.BOLD, 70));
        heading.setForeground(new Color(0xC62828));
        heading.setBounds(580, 50, 600, 70);
        add(heading);


        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        nameLabel.setBounds(100, 50, 200, 30);
        formPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("SansSerif", Font.PLAIN, 24));
        nameField.setBounds(300, 50, 800, 40);
        formPanel.add(nameField);

        JLabel emailLabel = new JLabel("Email ID:");
        emailLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        emailLabel.setBounds(100, 120, 200, 30);
        formPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(new Font("SansSerif", Font.PLAIN, 24));
        emailField.setBounds(300, 120, 800, 40);
        formPanel.add(emailField);

        JLabel phoneLabel = new JLabel("Contact No:");
        phoneLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        phoneLabel.setBounds(100, 190, 200, 30);
        formPanel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setFont(new Font("SansSerif", Font.PLAIN, 24));
        phoneField.setBounds(300, 190, 800, 40);
        formPanel.add(phoneField);

        JLabel standardLabel = new JLabel("Enquiry for Standard:");
		standardLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
		standardLabel.setBounds(100, 260, 300, 30);
		formPanel.add(standardLabel);

		String[] standards = {"Select", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th"};
		standardCombo = new JComboBox<>(standards);
		standardCombo.setFont(new Font("SansSerif", Font.PLAIN, 24));
		standardCombo.setBounds(400, 260, 300, 40);
		formPanel.add(standardCombo);



        JLabel msgLabel = new JLabel("Your Message:");
        msgLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        msgLabel.setBounds(100, 330, 250, 40);
        formPanel.add(msgLabel);

        msgArea = new JTextArea();
        msgArea.setFont(new Font("SansSerif", Font.PLAIN, 24));
        msgArea.setLineWrap(true);
        msgArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(msgArea);
        scrollPane.setBounds(320, 330, 800, 130);
        formPanel.add(scrollPane);

        submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("Arial", Font.BOLD, 30));
        submitBtn.setBackground(new Color(0x388E3C));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setBounds(550, 500, 200, 50);
        submitBtn.addActionListener(this);
        formPanel.add(submitBtn);


        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 25));
        backButton.setBackground(new Color(0x1565C0));
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(50, 50, 150, 50);
        backButton.setFocusPainted(false);
        backButton.addActionListener(this);
        add(backButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton)
        {
            new homescreen().setVisible(true);
            dispose();
       } else if (ae.getSource() == submitBtn)
       {
	       String name = nameField.getText().trim();
	       String email = emailField.getText().trim();
	       String contact = phoneField.getText().trim();
	       String standard = (String) standardCombo.getSelectedItem();
	       String message = msgArea.getText().trim();

	       if (name.isEmpty() || email.isEmpty() || message.isEmpty() || "Select".equals(standard))
	       {
	           JOptionPane.showMessageDialog(this, "Please fill all required fields!", "Warning", JOptionPane.WARNING_MESSAGE);
	       }
	       else
	       {
	           Connect_Database.insertEnquiry(name, email, contact, standard, message);
	           JOptionPane.showMessageDialog(this, "Thank you for your enquiry!", "Submitted", JOptionPane.INFORMATION_MESSAGE);
	           nameField.setText("");
	           emailField.setText("");
	           phoneField.setText("");
	           msgArea.setText("");
	           standardCombo.setSelectedIndex(0);
	       }
	   }


    }

    private void setFullScreen() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Enquiry();
    }
}
