import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SchoolDashboard extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5;
	JLabel l1,l2,l3,l4,l5;

	String username, email;

	SchoolDashboard(String username, String email)
	{
		 this.username = username;
         this.email = email;

	    Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = toolkit.getScreenSize();
	    int screenWidth = screenSize.width;
	    int screenHeight = screenSize.height;
	    setSize(screenWidth, screenHeight);
	    setLayout(null);
	    getContentPane().setBackground(Color.WHITE);

        JLayeredPane layeredPane = getLayeredPane();

       l2 = new JLabel("Bhartiya Shikshan Prasarak Sanstha,Ambajogai");
	   l2.setFont(new Font("SansSerif", Font.BOLD, 20));
	   l2.setForeground(new Color(59, 47, 47));
	   //l2.setHorizontalAlignment(SwingConstants.CENTER);
	   l2.setBounds(300, 50, 1200, 60);
	   add(l2);

	   l1 = new JLabel("BHEL SECONDARY SCHOOL");
	   l1.setFont(new Font("Serif", Font.BOLD, 100));
	   l1.setForeground(new Color(0xDC143C));
	   //l1.setBackground(new Color(245, 236, 217, 240));
	   l1.setOpaque(false);
	   //l1.setHorizontalAlignment(SwingConstants.CENTER);
	   l1.setBounds(290,90,2500, 100);
	   add(l1);

	   ImageIcon logoIcon = new ImageIcon("bspa_logo.jpg");
	   Image logoImg = logoIcon.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
	   JLabel logo1 = new JLabel(new ImageIcon(logoImg));
	   logo1.setBounds(60, 70, 210, 210);
	   add(logo1);

      l4 = new JLabel("PARLI VAIJNATH");
	  l4.setFont(new Font("SansSerif", Font.BOLD, 40));
	  l4.setForeground(new Color(0x4A158D));
	  l4.setBounds(300, 200, 600, 40);
	  add(l4);

	  l3 = new JLabel("Affiliated to CBSE      Affiliation number:11223344      School code:45386");
	  l3.setFont(new Font("SansSerif", Font.BOLD, 25));
	  l3.setForeground(new Color(59, 47, 47));
	  //l3.setHorizontalAlignment(SwingConstants.CENTER);
	  l3.setBounds(300, 240, 1200, 50);
	  add(l3);

	   l5 = new JLabel("DASHBOARD");
	   l5.setFont(new Font("SansSerif", Font.BOLD, 60));
	   l5.setForeground(new Color(0xff6f61));
	   l5.setBounds(700, 360, 600, 90);
	   add(l5);

	   ImageIcon dashboardIcon = new ImageIcon("dashboard.jpg");
	   Image dashboardImg = dashboardIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	   JLabel dashboard = new JLabel(new ImageIcon(dashboardImg));
	   dashboard.setBounds(580, 370, 100, 100);
	   add(dashboard);

	  /* JFrame frame = new JFrame("Button with Image Example");
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setSize(200, 200);
       frame.setLayout(new FlowLayout());

       Icon icon = new ImageIcon("add_student.jpg");
       JButton button = new JButton(icon);
       button.setText("Add and Manage Students");
       add(button);
       button.setBounds(100,500,200,200);
	   button.setHorizontalTextPosition(SwingConstants.CENTER);
       button.setVerticalTextPosition(SwingConstants.BOTTOM);

       frame.add(button);
       frame.setVisible(true);*/

	 ImageIcon studentIcon = new ImageIcon("add_student.jpg");
	 Image studentImg = studentIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	 JLabel student = new JLabel(new ImageIcon(studentImg));
	 student.setBounds(340, 560, 200, 200);
	 add(student);

	 b1 = new JButton("Add and Manage Students");
	 b1.setFont(new Font("Arial", Font.PLAIN, 25));
	 b1.setBounds(280, 800, 340, 50);
	 b1.setBackground(new Color(0x4E8EA2));
	 b1.setForeground(Color.WHITE);
	 b1.addActionListener(this);
     add(b1);

     ImageIcon marksIcon = new ImageIcon("input_marks.jpg");
	 Image marksImg = marksIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	 JLabel marks = new JLabel(new ImageIcon(marksImg));
	 marks.setBounds(800,560, 200, 200);
	 add(marks);

     b2 = new JButton("Input Student Marks");
     b2.setFont(new Font("Arial", Font.PLAIN, 25));
	 b2.setBounds(750, 800, 300, 50);
	 b2.setBackground(new Color(0x4E8EA2));
	 b2.setForeground(Color.WHITE);
	 b2.addActionListener(this);
     add(b2);

     ImageIcon viewReportIcon = new ImageIcon("view_report.jpg");
	 Image viewReportImg = viewReportIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
	 JLabel viewReport = new JLabel(new ImageIcon(viewReportImg));
	 viewReport.setBounds(1250,530, 250, 250);
	 add(viewReport);

      b3 = new JButton("View Report Card");
	  b3.setFont(new Font("Arial", Font.PLAIN, 25));
	  b3.setBounds(1200, 800, 300, 50);
	  b3.setBackground(new Color(0x4E8EA2));
	  b3.setForeground(Color.WHITE);
	  b3.addActionListener(this);
      add(b3);

     /* ImageIcon downloadIcon = new ImageIcon("download_report.jpg");
	  Image downloadImg = downloadIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
	  JLabel download = new JLabel(new ImageIcon(downloadImg));
	  download.setBounds(1550,530, 250, 250);
	  add(download);

      b4 = new JButton("Print Report Card");
	  b4.setFont(new Font("Arial", Font.PLAIN, 25));
	  b4.setBounds(1500, 800, 300, 50);
	  b4.setBackground(new Color(0x4E8EA2));
	  b4.setForeground(Color.WHITE);
	  b4.addActionListener(this);
      add(b4);*/

      b5 = new JButton("Logout");
	  b5.setFont(new Font("Arial", Font.PLAIN, 25));
	  b5.setBounds(1700, 20, 180, 40);
	  b5.setBackground(new Color(0x4E8EA2));
	  b5.setForeground(Color.WHITE);
	  b5.addActionListener(this);
      add(b5);

      ImageIcon profileIcon = new ImageIcon("profile.jpg");
	  Image profileImg = profileIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	  JLabel profilePic = new JLabel(new ImageIcon(profileImg));
	  profilePic.setBounds(1510, 270, 70, 70);
	  add(profilePic);

	  JLabel usernameLabel = new JLabel( username);
	  usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));
	  usernameLabel.setBounds(1600, 290, 300, 20);
	  usernameLabel.setForeground(Color.decode("#3B2F2F"));
	  add(usernameLabel);


	  JLabel emailLabel = new JLabel(email);
	  emailLabel.setFont(new Font("Arial", Font.PLAIN, 18));
	  emailLabel.setBounds(1600, 320, 300, 20);
	  emailLabel.setForeground(Color.decode("#3B2F2F"));
      add(emailLabel);

      JSeparator sep = new JSeparator();
	  sep.setBounds(100, 350, screenWidth - 200, 2);
	  add(sep);


     setTitle("School Dashboard");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLocationRelativeTo(null);

 }

    public void actionPerformed(ActionEvent ae)
    {
		if(ae.getSource()==b1)
		{
			new AddManageStudent().setVisible(true);
		}
		else if(ae.getSource()==b2)
		{
			new MarksEntry(username,email).setVisible(true);
		}
		else if(ae.getSource()==b3)
		{
			new viewReport().setVisible(true);
		}
		else if (ae.getSource()==b5)
		{
			new SchoolLogin().setVisible(true);
		}

	}

	public static void main(String[] args)
	{
	    new SchoolDashboard("testuser", "testuser@example.com").setVisible(true);
	}


}
