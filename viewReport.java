import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class viewReport extends JFrame implements ActionListener {

    JTextField idField, nameField, rnoField,  standardField , divisionField;
    JButton viewReportButton, fetchButton;


    public viewReport()
    {


        setTitle("view report card");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(0, 0, 700, 700);
        formPanel.setBackground(new Color(255, 255, 255, 200));

        JLabel title = new JLabel("View Student Report Card");
        title.setFont(new Font("Serif", Font.BOLD, 32));
        title.setForeground(new Color(0xD32E2E));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(100, 30, 500, 60);
        formPanel.add(title);

        ImageIcon signupIcon = new ImageIcon("view_report.jpg");
	    Image signupImg = signupIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	    JLabel signup = new JLabel(new ImageIcon(signupImg));
	    signup.setBounds(40, 20, 100, 100);
        formPanel.add(signup);

        Font labelFont = new Font("SansSerif", Font.BOLD, 20);

        JLabel idLabel = new JLabel(" Enter Student Id:");
        idLabel.setFont(labelFont);
        idLabel.setBounds(100, 140, 180, 30);
        formPanel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(300, 140, 250, 30);
        formPanel.add(idField);

        JLabel nameLabel = new JLabel("  Name :");
        nameLabel.setFont(labelFont);
        nameLabel.setBounds(100, 200, 180, 30);
        formPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(300, 200, 250, 30);
        nameField.setEditable(false);
        formPanel.add(nameField);

        JLabel rnoLabel = new JLabel("  Roll No :");
		rnoLabel.setFont(labelFont);
		rnoLabel.setBounds(100, 260, 180, 30);
        formPanel.add(rnoLabel);

        rnoField = new JTextField();
	    rnoField.setBounds(300, 260, 250, 30);
		rnoField.setEditable(false);
        formPanel.add(rnoField);

        JLabel standardLabel = new JLabel("  Standard:");
        standardLabel.setFont(labelFont);
        standardLabel.setBounds(100, 320, 180, 30);
        formPanel.add(standardLabel);

        standardField = new JTextField();
		standardField.setBounds(300, 320, 250, 30);
		standardField.setEditable(false);
        formPanel.add(standardField);

        JLabel divisionLabel = new JLabel("  Division:");
		divisionLabel.setFont(labelFont);
		divisionLabel.setBounds(100, 380, 180, 30);
        formPanel.add(divisionLabel);

        divisionField = new JTextField();
	    divisionField.setBounds(300, 380, 250, 30);
		divisionField.setEditable(false);
		formPanel.add(divisionField);

        viewReportButton = new JButton("View Report Card");
        viewReportButton.setFont(new Font("Arial", Font.BOLD, 25));
        viewReportButton.setBackground(new Color(0xD32E2E));
        viewReportButton.setForeground(new Color(0xFCE4EC));
        viewReportButton.setFocusPainted(false);
        viewReportButton.setBounds(200, 500, 300, 50);
        viewReportButton.addActionListener(this);
        formPanel.add(viewReportButton);

        fetchButton = new JButton("Fetch");
	    fetchButton.setFont(new Font("Arial", Font.BOLD, 20));
	    fetchButton.setBackground(new Color(0xD32E2E));
	    fetchButton.setForeground(Color.WHITE);
	    fetchButton.setFocusPainted(false);
		fetchButton.setBounds(570, 140, 100, 20);
		fetchButton.addActionListener(this);
        formPanel.add(fetchButton);

        add(formPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
		if (e.getSource() == fetchButton)
				 {
				    int studentId = Integer.parseInt(idField.getText().trim());

				     if (studentId==0)
				     {
				         JOptionPane.showMessageDialog(this, "Please enter Student ID");
				         return;
				     }

				     try (Connection conn = Connect_Database.getConnection())
				     {
				         String sql = "SELECT sname,roll_no, standard, division FROM student WHERE student_id = ?";
				         PreparedStatement ps = conn.prepareStatement(sql);
				         ps.setInt(1, studentId);
				         ResultSet rs = ps.executeQuery();

				         if (rs.next())
				         {
				             nameField.setText(rs.getString("sname"));
				             rnoField.setText(rs.getString("roll_no"));
				             standardField.setText(rs.getString("standard"));
				             divisionField.setText(rs.getString("division"));
				         }
				         else
				         {
				             JOptionPane.showMessageDialog(this, "Student not found");
				             nameField.setText("");
				             rnoField.setText("");
				             standardField.setText("");
				             divisionField.setText("");
				         }
				     } catch (Exception ex) {
				         ex.printStackTrace();
				         JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
				     }
		 }
		  else if (e.getSource() == viewReportButton) {
		     String studentId = idField.getText().trim();
		     if (!studentId.isEmpty()) {
		         new ReportCardView(studentId);
		     } else {
		         JOptionPane.showMessageDialog(this, "Please enter Student ID");
		     }
		 }



    }

    public static void main(String[] args) {
        new viewReport();
    }
}
