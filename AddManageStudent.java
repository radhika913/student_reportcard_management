import javax.swing.*;  //predefine package use to create GUI
import java.awt.*;   //predefine package use to create GUI
import java.awt.event.ActionEvent;   //predefine package use to handle events (user action)
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class AddManageStudent extends JFrame implements ActionListener {

    JTextField idField, rnoField, nameField, standardField , divisionField,subjectsField;
    JButton addnewButton, editButton,cancelButton,backButton;
    private JComboBox<String> cb1;
    private JComboBox<String> cb2;

    JList <String> lst1;
	JScrollPane pan ;

    private String[] standard;
	private String[] division;

	String std= new String("Standard : ");
	String div = new String("Division : ");

    public AddManageStudent()
    {


        setTitle(" add and manage students");
        setSize(700, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(0, 0, 700, 900);
        formPanel.setBackground(new Color(255, 255, 255, 200));

        JLabel title = new JLabel("Add and Manage Students");
        title.setFont(new Font("Serif", Font.BOLD, 35));
        title.setForeground(new Color(0x653819));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(100, 30, 500, 60);
        formPanel.add(title);

        ImageIcon signupIcon = new ImageIcon("addmanage.jpg");
	    Image signupImg = signupIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	    JLabel signup = new JLabel(new ImageIcon(signupImg));
	    signup.setBounds(40, 20, 120, 120);
        formPanel.add(signup);

        Font labelFont = new Font("SansSerif", Font.BOLD, 20);

        JLabel idLabel = new JLabel("Student Id:");
        idLabel.setFont(labelFont);
        idLabel.setBounds(100, 140, 180, 30);
        formPanel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(300, 140, 250, 30);
        formPanel.add(idField);

        JLabel rnoLabel = new JLabel("Roll No:");
        rnoLabel.setFont(labelFont);
        rnoLabel.setBounds(100, 210, 180, 30);
        formPanel.add(rnoLabel);

        rnoField = new JTextField();
        rnoField.setBounds(300, 210, 250, 30);
        formPanel.add(rnoField);

         JLabel nameLabel = new JLabel("Name:");
         nameLabel.setFont(labelFont);
         nameLabel.setBounds(100, 270, 180, 30);
         formPanel.add( nameLabel);

         nameField = new JTextField();
		 nameField.setBounds(300, 270, 250, 30);
         formPanel.add( nameField);


        JLabel standardLabel = new JLabel("Standard:");
        standardLabel.setFont(labelFont);
        standardLabel.setBounds(100, 320, 180, 30);
        formPanel.add(standardLabel);

        standard = new String[] {"1st","2nd","3rd","4th","5th","6th","7th","8th","9th","10th"};

        cb1 = new JComboBox<>(standard);
        cb1.setBounds(300, 320, 250, 30);
       // cb1.addItemListener(this);
        formPanel.add(cb1);

        JLabel divisionLabel = new JLabel("Division:");
		divisionLabel.setFont(labelFont);
		divisionLabel.setBounds(100, 370, 180, 30);
        formPanel.add(divisionLabel);

        division = new String[] {"A","B","C","D"};

        cb2 = new JComboBox<>(division);
        cb2.setBounds(300, 370, 250, 30);
        //cb2.addItemListener(this);
        formPanel.add(cb2);

        JLabel subjectsLabel = new JLabel("No of Subjects:");
        subjectsLabel.setFont(labelFont);
        subjectsLabel.setBounds(100, 420, 180, 30);
        formPanel.add(subjectsLabel);

        subjectsField = new JTextField();
        subjectsField.setBounds(300, 420, 250, 30);
        formPanel.add(subjectsField);


        addnewButton = new JButton("Add New");
        addnewButton.setFont(new Font("Arial", Font.BOLD, 25));
        addnewButton.setBackground(new Color(0x653819));
        addnewButton.setForeground(new Color(0xFCE4EC));
        addnewButton.setFocusPainted(false);
        addnewButton.setBounds(80, 550, 210, 50);
        addnewButton.addActionListener(this);
        formPanel.add(addnewButton);

        editButton = new JButton("Edit");
        editButton.setFont(new Font("Arial", Font.BOLD, 25));
        editButton.setBackground(new Color(0x653819));
        editButton.setForeground(new Color(0xFCE4EC));
        editButton.setFocusPainted(false);
        editButton.setBounds(80, 650, 210, 50);
        editButton.addActionListener(this);
        formPanel.add(editButton);

        cancelButton = new JButton("Delete");
		cancelButton.setFont(new Font("Arial", Font.BOLD, 25));
		cancelButton.setBackground(new Color(0x653819));
		cancelButton.setForeground(new Color(0xFCE4EC));
		cancelButton.setFocusPainted(false);
		cancelButton.setBounds(350, 550, 210, 50);
		cancelButton.addActionListener(this);
        formPanel.add(cancelButton);

        backButton = new JButton("Back");
	    backButton.setFont(new Font("Arial", Font.BOLD, 25));
	    backButton.setBackground(new Color(0x653819));
		backButton.setForeground(new Color(0xFCE4EC));
		backButton.setFocusPainted(false);
		backButton.setBounds(350, 650, 210, 50);
		backButton.addActionListener(this);
        formPanel.add(backButton);

        add(formPanel);
        setVisible(true);
    }

   public void actionPerformed(ActionEvent e) {
       try {

           String idText = idField.getText().trim();
           String rnoText = rnoField.getText().trim();
           String name = nameField.getText().trim();
           String subText = subjectsField.getText().trim();

           if (idText.isEmpty() || rnoText.isEmpty() || name.isEmpty() || subText.isEmpty()) {
               JOptionPane.showMessageDialog(this, "Please fill all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
               return;
           }


           int student_id = Integer.parseInt(idText);
           int roll_no = Integer.parseInt(rnoText);
           int total_sub = Integer.parseInt(subText);


           if (!name.matches("^[A-Za-z ]{2,}$")) {
               JOptionPane.showMessageDialog(this, "Invalid name. Only alphabets and spaces allowed.", "Input Error", JOptionPane.ERROR_MESSAGE);
               return;
           }


           if (total_sub < 1 || total_sub > 10) {
               JOptionPane.showMessageDialog(this, "No. of subjects must be between 1 and 10.", "Input Error", JOptionPane.ERROR_MESSAGE);
               return;
           }


           String standard = (String) cb1.getSelectedItem();
           String division = (String) cb2.getSelectedItem();

           if (standard == null || division == null) {
               JOptionPane.showMessageDialog(this, "Please select Standard and Division.", "Input Error", JOptionPane.ERROR_MESSAGE);
               return;
           }

           if (e.getSource() == addnewButton) {
               try (Connection conn = Connect_Database.getConnection()) {
                   Connect_Database.insertStudent(student_id, roll_no, name, standard, division, total_sub);
                   JOptionPane.showMessageDialog(this, "Student added successfully.");
               } catch (SQLException ex) {
                   ex.printStackTrace();
                   JOptionPane.showMessageDialog(this, "Insert failed: " + ex.getMessage());
               }
           }

           if (e.getSource() == editButton) {
               try (Connection conn = Connect_Database.getConnection()) {
                   Connect_Database.updateStudent(student_id, roll_no, name, standard, division, total_sub);
                   JOptionPane.showMessageDialog(this, "Student updated successfully.");
               } catch (SQLException ex) {
                   ex.printStackTrace();
                   JOptionPane.showMessageDialog(this, "Update failed: " + ex.getMessage());
               }
           }

           if (e.getSource() == cancelButton) {
               int confirm = JOptionPane.showConfirmDialog(this, "Delete student with ID: " + student_id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
               if (confirm == JOptionPane.YES_OPTION) {
                   try (Connection conn = Connect_Database.getConnection()) {
                       Connect_Database.deleteStudent(student_id);
                       JOptionPane.showMessageDialog(this, "Student deleted successfully.");
                   } catch (SQLException ex) {
                       ex.printStackTrace();
                       JOptionPane.showMessageDialog(this, "Delete failed: " + ex.getMessage());
                   }
               }
           }

           if (e.getSource() == backButton) {
               new SchoolDashboard("testuser", "testuser@example.com").setVisible(true);
               this.dispose();
           }

       } catch (NumberFormatException ex) {
           JOptionPane.showMessageDialog(this, "Please enter valid numeric values for ID, Roll No, and No. of Subjects.", "Input Error", JOptionPane.ERROR_MESSAGE);
       }
   }


    public static void main(String[] args) {
        new AddManageStudent();
    }
}
