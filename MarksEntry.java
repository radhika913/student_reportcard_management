import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MarksEntry extends JFrame implements ActionListener {
    JTextField studentIdField, divisionField,nameField,standardField, mathMarksField, englishMarksField , MarksField, scienceMarksField,ssevsMarksField;
    JLabel totalMarksValueLabel, percentageValueLabel ,gradeValueLabel;
    JButton submitButton, backButton, fetchButton;
    private JComboBox<String> cb1;
    JRadioButton rb1,rb2;
    JList <String> lst1;

    String username,email;
    int mkid=0;



    private String[] language;
    String lng= new String("2nd Language: ");


    public MarksEntry(String username, String email)
    {
		this.username = username;
        this.email = email;


        setTitle(" marks entry");
		setSize(700, 1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0,700, 1000);
        mainPanel.setBackground(new Color(255, 255, 255));


        JLabel title = new JLabel("Marks Entry");
        title.setFont(new Font("Serif", Font.BOLD, 42));
        title.setForeground(new Color(0x1b4973));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(160, 35, 250, 50);
        mainPanel.add(title);

        ImageIcon signupIcon = new ImageIcon("marks_entry3.jpg");
	    Image signupImg = signupIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	    JLabel signup = new JLabel(new ImageIcon(signupImg));
	    signup.setBounds(60, 20, 100, 100);
        mainPanel.add(signup);

        JLabel studentIdLabel = new JLabel("Student Id:");
        studentIdLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        studentIdLabel.setBounds(50, 120, 120, 25);
        mainPanel.add(studentIdLabel);

        studentIdField = new JTextField();
        studentIdField.setBounds(180, 120, 120, 25);
        mainPanel.add(studentIdField);

        JLabel divisionLabel = new JLabel("Division:");
        divisionLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        divisionLabel.setBounds(50, 240, 100, 25);
        mainPanel.add(divisionLabel);

        divisionField = new JTextField();
        divisionField.setBounds(180, 240, 120, 25);
        divisionField.setEditable(false);
        mainPanel.add(divisionField);

        JLabel standardLabel = new JLabel("Standard:");
        standardLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        standardLabel.setBounds(50, 200, 150, 25);
        mainPanel.add(standardLabel);

        standardField = new JTextField();
        standardField.setBounds(180, 200, 120, 25);
        standardField.setEditable(false);
        mainPanel.add(standardField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        nameLabel.setBounds(50, 160, 100, 25);
        mainPanel.add(nameLabel);

        nameField = new JTextField();
	    nameField.setBounds(180, 160, 120, 25);
	    nameField.setEditable(false);
	    mainPanel.add(nameField);


        JLabel subjectHeader = new JLabel("Subject");
        subjectHeader.setFont(new Font("SansSerif", Font.BOLD, 25));
        subjectHeader.setForeground(new Color(0x1b4973));
        subjectHeader.setBounds(100, 290, 100, 30);
        mainPanel.add(subjectHeader);

        JLabel marksHeader = new JLabel("Marks");
        marksHeader.setFont(new Font("SansSerif", Font.BOLD, 25));
        marksHeader.setForeground(new Color(0x1b4973));
        marksHeader.setBounds(300, 290, 100, 30);
        mainPanel.add(marksHeader);


        JLabel mathLabel = new JLabel("1. Math");
        mathLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        mathLabel.setBounds(90, 340, 100, 25);
        mainPanel.add(mathLabel);

        mathMarksField = new JTextField();
        mathMarksField.setBounds(280, 340, 100, 25);
        mainPanel.add(mathMarksField);


        JLabel englishLabel = new JLabel("2. English");
        englishLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        englishLabel.setBounds(90, 380, 100, 25);
        mainPanel.add(englishLabel);

        englishMarksField = new JTextField();
        englishMarksField.setBounds(280, 380, 100, 25);
        mainPanel.add(englishMarksField);


        JLabel scienceLabel = new JLabel("3. Science");
        scienceLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        scienceLabel.setBounds(90, 420, 100, 25);
        mainPanel.add(scienceLabel);

        scienceMarksField = new JTextField();
        scienceMarksField.setBounds(280, 420, 100, 25);
        mainPanel.add(scienceMarksField);

        /*JLabel sstLabel = new JLabel("4.2nd Language");
	    sstLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
	    sstLabel.setBounds(90, 460, 100, 25);
	    mainPanel.add(sstLabel);*/

	    language = new String[] {"Select Language", "Hindi", "Marathi", "Sanskrit"};





	    cb1 = new JComboBox<>(language);
	    cb1.setBounds(110, 460, 120, 25);
	    cb1.setSelectedIndex(0);
	    cb1.addActionListener(this);
		mainPanel.add(cb1);


	    JLabel numberLabel = new JLabel("4.");
	    numberLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
	    numberLabel.setBounds(90, 460, 100, 25);
        mainPanel.add (numberLabel);

		MarksField = new JTextField();
		MarksField.setBounds(280, 460, 100, 25);
        mainPanel.add(MarksField);

        /*JLabel scienceLabel = new JLabel("5.sst");
	    scienceLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
	    scienceLabel.setBounds(90, 500, 100, 25);
	    mainPanel.add(scienceLabel);*/

	    ssevsMarksField = new JTextField();
		ssevsMarksField.setBounds(280, 500, 100, 25);
        mainPanel.add( ssevsMarksField);

        JLabel numLabel = new JLabel("5.");
		numLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		numLabel.setBounds(90, 500, 100, 25);
		mainPanel.add(numLabel);

		rb1 = new JRadioButton("SST");
		rb1.setBounds(110, 500, 60, 25);
		rb1.addActionListener(this);
		mainPanel.add(rb1);

		rb2 = new JRadioButton("EVS");
		rb2.setBounds(190, 500, 60, 25);
		rb2.addActionListener(this);
		mainPanel.add(rb2);

		ButtonGroup subjectGroup = new ButtonGroup();
		subjectGroup.add(rb1);
		subjectGroup.add(rb2);




        JLabel totalMarksLabel = new JLabel("Total Marks:");
        totalMarksLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        totalMarksLabel.setBounds(90, 560, 120, 25);
        mainPanel.add(totalMarksLabel);

        totalMarksValueLabel = new JLabel("0");
        totalMarksValueLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        totalMarksValueLabel.setBounds(280, 560, 100, 25);
        mainPanel.add(totalMarksValueLabel);

        JLabel percentageLabel = new JLabel("Percentage:");
        percentageLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        percentageLabel.setBounds(90, 600, 120, 25);
        mainPanel.add(percentageLabel);

        percentageValueLabel = new JLabel("0.0%");
        percentageValueLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        percentageValueLabel.setBounds(280, 600, 100, 25);
        mainPanel.add(percentageValueLabel);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        gradeLabel.setBounds(90, 640, 120, 25);
        mainPanel.add(gradeLabel);

        gradeValueLabel = new JLabel("N/A");
        gradeValueLabel.setFont(new Font("SansSerif",Font.BOLD, 18));
        gradeValueLabel.setBounds(280, 640, 100, 25);
        mainPanel.add(gradeValueLabel);


        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 22));
        submitButton.setBackground(new Color(0x3271A5));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBounds(200, 740, 250, 50);
        submitButton.addActionListener(this);
        mainPanel.add(submitButton);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 22));
        backButton.setBackground(new Color(0x6C757D));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBounds(200, 820, 250, 50);
        backButton.addActionListener(this);
        mainPanel.add(backButton);

        fetchButton = new JButton("Fetch");
		fetchButton.setFont(new Font("Arial", Font.BOLD, 20));
		fetchButton.setBackground(new Color(0x3271A5));
		fetchButton.setForeground(Color.WHITE);
		fetchButton.setFocusPainted(false);
		fetchButton.setBounds(340, 120, 100, 20);
		fetchButton.addActionListener(this);
        mainPanel.add(fetchButton);

        add(mainPanel);
        setVisible(true);
    }

     public void actionPerformed(ActionEvent e)
     {
		 if(e.getSource()==backButton)
		 {
			new SchoolDashboard(username, email).setVisible(true);
		    this.dispose();
		 }
		 else if (e.getSource() == fetchButton)
		 {
		    String studentIdText = studentIdField.getText().trim();

			    if (studentIdText.isEmpty()) {
			        JOptionPane.showMessageDialog(this, "Please enter Student ID.");
			        return;
			    }

			    int studentId;

			    try
			    {
			       studentId = Integer.parseInt(studentIdText);
			    } catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(this, "Student ID must be a number.");
			        return;
                }

		     try (Connection conn = Connect_Database.getConnection())
		     {
		         String sql = "SELECT sname, standard, division FROM student WHERE student_id = ?";
		         PreparedStatement ps = conn.prepareStatement(sql);
		         ps.setInt(1, studentId);
		         ResultSet rs = ps.executeQuery();

		         if (rs.next())
		         {
		             nameField.setText(rs.getString("sname"));
		             standardField.setText(rs.getString("standard"));
		             divisionField.setText(rs.getString("division"));
		         }
		         else
		         {
		             JOptionPane.showMessageDialog(this, "Student not found");
		             nameField.setText("");
		             standardField.setText("");
		             divisionField.setText("");
		         }
		     } catch (Exception ex) {
		         ex.printStackTrace();
		         JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		     }
		 }
         else if(e.getSource()==submitButton)
         {

			 String studentIdText = studentIdField.getText().trim();

			     if (studentIdText.isEmpty()) {
			         JOptionPane.showMessageDialog(this, "Please enter Student ID.");
			         return;
			     }

			     int studentId;
			     try
			     {
			        studentId = Integer.parseInt(studentIdText);
			     }
			     catch (NumberFormatException ex)
			     {
			         JOptionPane.showMessageDialog(this, "Student ID must be a valid number.");
			         return;
                  }

                  if (mathMarksField.getText().trim().isEmpty() ||
				      englishMarksField.getText().trim().isEmpty() ||
				      scienceMarksField.getText().trim().isEmpty() ||
				      MarksField.getText().trim().isEmpty() ||
				      ssevsMarksField.getText().trim().isEmpty()) {

				      JOptionPane.showMessageDialog(this, "Please fill in all the marks fields.");
				      return;
				  }




			 try (Connection conn = Connect_Database.getConnection())
			 {
			        studentId = Integer.parseInt(studentIdField.getText().trim());
				   int math = Integer.parseInt(mathMarksField.getText().trim());
				   int english = Integer.parseInt(englishMarksField.getText().trim());
				   int science = Integer.parseInt(scienceMarksField.getText().trim());
				   int secondLang = Integer.parseInt(MarksField.getText().trim());
                   int ssevs = Integer.parseInt(ssevsMarksField.getText().trim());

                   if (cb1.getSelectedIndex() == 0)
                   {
				         JOptionPane.showMessageDialog(this, "Please select a 2nd Language.");
				         return;
				    }

				    if (!rb1.isSelected() && !rb2.isSelected())
				    {
				           JOptionPane.showMessageDialog(this, "Please select SST or EVS.");
				            return;
                    }

                   String regex = "^(100|[1-9]?[0-9])$";

				   if (!mathMarksField.getText().trim().matches(regex)) {
				       JOptionPane.showMessageDialog(this, "Invalid Math marks. Must be between 0 and 100.");
				       return;
				   }
				   if (!englishMarksField.getText().trim().matches(regex)) {
				       JOptionPane.showMessageDialog(this, "Invalid English marks. Must be between 0 and 100.");
				       return;
				   }
				   if (!scienceMarksField.getText().trim().matches(regex)) {
				       JOptionPane.showMessageDialog(this, "Invalid Science marks. Must be between 0 and 100.");
				       return;
				   }
				   if (!MarksField.getText().trim().matches(regex)) {
				       JOptionPane.showMessageDialog(this, "Invalid 2nd Language marks. Must be between 0 and 100.");
				       return;
				   }
				   if (!ssevsMarksField.getText().trim().matches(regex)) {
				       JOptionPane.showMessageDialog(this, "Invalid SST/EVS marks. Must be between 0 and 100.");
				       return;
				   }

				   String checkQuery = "SELECT * FROM marks WHERE student_id = ?";
				   PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
				   checkStmt.setInt(1, studentId);
				    ResultSet checkRs = checkStmt.executeQuery();

				    if (checkRs.next()) {
				   	     JOptionPane.showMessageDialog(this, "Marks have already been entered for this student.");
				   	     return;
                  }




                   int total = math + english + science + secondLang + ssevs;
				   float percentage = total / 5.0f;
				   String grade;

				   if (percentage >= 90)
				       grade = "A+";
				   else if (percentage >= 75)
				       grade = "A";
				   else if (percentage >= 60)
				       grade = "B";
				   else if (percentage >= 40)
				      grade = "C";
                   else
                      grade = "F";

                   totalMarksValueLabel.setText(total + " / 500");
				   percentageValueLabel.setText(String.format("%.2f%%", percentage));
                   gradeValueLabel.setText(grade);




                   PreparedStatement ps1 = conn.prepareStatement(
				    "INSERT INTO marks( student_id, total_marks, percentage, grade) VALUES ( ?, ?, ?, ?)");
				     ps1.setInt(1, studentId);
					 ps1.setInt(2, total);
					 ps1.setFloat(3, percentage);
					 ps1.setString(4, grade);
                     ps1.executeUpdate();

                      String query = "SELECT mark_id FROM marks WHERE student_id = " + studentId;
					  Statement statement = conn.createStatement();
					  ResultSet resultSet = statement.executeQuery(query);

                           if (resultSet.next())  // Check if a result exists
                           {
					           mkid = resultSet.getInt("mark_id"); // Replace with your column name
					 	   	   System.out.println("Fetched Value: " + mkid);
					       }
					 	    else {
					 		        System.out.println("No data found.");
					              }

                     /*PreparedStatement psfetch = conn.prepareStatement(
		             "SELECT mark_id FROM marks WHERE student_id = ?");
					  psfetch.setInt(1, studentId);
					  psfetch.executeUpdate();*/




				     PreparedStatement ps2 = conn.prepareStatement(
					  "INSERT INTO marks_details(subject_name, mark_id, mark) VALUES (?, ?, ?)");
					  String lang = cb1.getSelectedItem().toString();
                      String sstOrEvs = rb1.isSelected() ? "SST" : "EVS";

					    String[] subjects = {"Math", "English", "Science", lang, sstOrEvs};
					    int[] marks = {math, english, science, secondLang,ssevs};
					    for (int i = 0; i < subjects.length; i++)
					    {
					       ps2.setString(1, subjects[i]);
					       ps2.setInt(2, mkid);
					       ps2.setInt(3, marks[i]);
					       ps2.addBatch ();
					    }
					    ps2.executeBatch();

					    JOptionPane.showMessageDialog(this, "Marks inserted successfully!");

					            studentIdField.setText("");
						        nameField.setText("");
						        standardField.setText("");
						        divisionField.setText("");
						        mathMarksField.setText("");
						        englishMarksField.setText("");
						        scienceMarksField.setText("");
						        MarksField.setText("");
						        ssevsMarksField.setText("");
						        cb1.setSelectedIndex(0);
						        rb1.setSelected(false);
						        rb2.setSelected(false);
						        totalMarksValueLabel.setText("0");
						        percentageValueLabel.setText("0.0%");
                                gradeValueLabel.setText("N/A");
	                    } catch (Exception ex)
	                      {
					          JOptionPane.showMessageDialog(this, "Submission failed: " + ex.getMessage());
					      }
					   }


		   }


    public static void main(String[] args)
    {
           new MarksEntry("Radhika Joshi", "joshiradhika@bhel.com");
    }
}


