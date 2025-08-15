import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class homescreen extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4;
	JLabel l1,l2,l3,l4,l5,l6,l7;



homescreen()
{
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        Dimension screenSize = toolkit.getScreenSize();
	        int screenWidth = screenSize.width;
	        int screenHeight = screenSize.height;
	        setSize(screenWidth, screenHeight);
	        setLayout(null);
	        getContentPane().setBackground(Color.WHITE);


	        JLayeredPane layeredPane = getLayeredPane();

            l4 = new JLabel("Bhartiya Shikshan Prasarak Sanstha,Ambajogai");
			l4.setFont(new Font("SansSerif", Font.BOLD, 20));
		    l4.setForeground(new Color(59, 47, 47));
			//l4.setHorizontalAlignment(SwingConstants.CENTER);
			l4.setBounds(300, 70, 1200, 60);
		    add(l4);



	        l2 = new JLabel("BHEL SECONDARY SCHOOL");
	        l2.setFont(new Font("Serif", Font.BOLD, 100));
	        l2.setForeground(new Color(0xDC143C));
	        //l2.setBackground(new Color(245, 236, 217, 240));
	        l2.setOpaque(false);
	        //l2.setHorizontalAlignment(SwingConstants.CENTER);
	        l2.setBounds(290,110,2500, 100);
	        add(l2);

	        ImageIcon logoIcon = new ImageIcon("bspa_logo.jpg");
		    Image logoImg = logoIcon.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
		    JLabel logo1 = new JLabel(new ImageIcon(logoImg));
		    logo1.setBounds(60, 90, 210, 210);
	        add(logo1);


	        l5 = new JLabel("PARLI VAIJNATH");
	        l5.setFont(new Font("SansSerif", Font.BOLD, 40));
	        l5.setForeground(new Color(0x4A158D));
	        l5.setBounds(300, 220, 600, 40);
	        add(l5);

            l3 = new JLabel("Affiliated to CBSE      Affiliation number:11223344      School code:45386");
	        l3.setFont(new Font("SansSerif", Font.BOLD, 25));
	        l3.setForeground(new Color(59, 47, 47));
	        //l3.setHorizontalAlignment(SwingConstants.CENTER);
	        l3.setBounds(300, 260, 1200, 50);
	        add(l3);


	        ImageIcon bookIcon = new ImageIcon("school_logo.jpg");
	        Image bookImg = bookIcon.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
	        JLabel book1 = new JLabel(new ImageIcon(bookImg));
	        book1.setBounds(600, 280, 600, 600);
	        add(book1);


	       JLabel bullets = new JLabel("<html>" +
		       "<div style='padding-left:20px;'>" +
		       "&#8226; CBSE Curriculum<br><br>" +
		       "&#8226; Experienced Faculty<br><br>" +
		       "&#8226; Science & Computer Labs<br><br>" +
		       "&#8226; Spacious Campus<br><br>" +
		       "&#8226; Sports & Activities" +
		       "</div>" +
		       "</html>");


           bullets.setFont(new Font("SansSerif", Font.PLAIN, 35));
		   bullets.setBounds(120, 370, 500, 450);
		   bullets.setHorizontalAlignment(SwingConstants.CENTER);
		   bullets.setForeground(new Color(0xED417A));
		   add(bullets);



	        l1 = new JLabel("Contact:9970692740");
	        l1.setFont(new Font("SansSerif", Font.BOLD, 25));
	        l1.setForeground(new Color(0x7B1FA2));
	        l1.setBounds(200, 905, 300, 30);
	        add(l1);

	        ImageIcon contactIcon = new ImageIcon("contacts.jpg");
		    Image contactImg  = contactIcon .getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			JLabel contact = new JLabel(new ImageIcon(contactImg));
			contact.setBounds(150, 900, 40, 40);
	        add(contact);


	        l6 = new JLabel("Telephone:54321");
		    l6.setFont(new Font("SansSerif", Font.BOLD, 25));
			l6.setForeground(new Color(0x7B1FA2));
		    l6.setBounds(800, 910, 300, 30);
	        add(l6);

	        ImageIcon telephoneIcon = new ImageIcon("telephone1.jpg");
			Image telephoneImg = telephoneIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			JLabel telephone = new JLabel(new ImageIcon(telephoneImg));
			telephone.setBounds(750, 905, 50, 50);
	        add(telephone);



	        l7 = new JLabel("Email id:bhel_school@reddifmail.com");
		    l7.setFont(new Font("SansSerif", Font.BOLD, 25));
			l7.setForeground(new Color(0x7B1FA2));
			l7.setBounds(1400, 905, 500, 30);
	        add(l7);

	        ImageIcon mailIcon = new ImageIcon("email1.jpg");
		    Image mailImg = mailIcon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		    JLabel mail = new JLabel(new ImageIcon(mailImg));
			mail.setBounds(1350, 900, 45, 45);
	        add(mail);


	        b1 = new JButton("LOGIN");
		    b1.setFont(new Font("Arial", Font.BOLD, 30));
		    b1.setBackground(new Color(0x4169E1));
			b1.setForeground(Color.WHITE);
			b1.setFocusPainted(false);
			b1.setBounds(1300, 500, 300, 70);
			b1.addActionListener(this);
	        add(b1);

	        b2 = new JButton("EXIT");
	        b2.setFont(new Font("Arial", Font.BOLD, 30));
	        b2.setBackground(new Color(0x4169E1));
	        b2.setForeground(Color.WHITE);
	        b2.setFocusPainted(false);
	        b2.setBounds(1300, 700, 300, 70);
	        b2.addActionListener(this);
	        add(b2);

	        JSeparator sep = new JSeparator();
			sep.setBounds(100, 350, screenWidth - 200, 2);
			add(sep);

			JPanel navBar=new JPanel();
			navBar.setBounds(0,0,screenWidth,50);
			navBar.setBackground(new Color(0x1A237E));
			navBar.setLayout(null);
			add(navBar);

			b3 = new JButton("About us");
		    b3.setFont(new Font("Arial", Font.BOLD, 25));
		    b3.setBackground(new Color(0x1A237E));
			b3.setForeground(Color.WHITE);
			b3.setFocusPainted(false);
			b3.setBounds(1400, 10, 150, 30);
			b3.addActionListener(this);
	        navBar.add(b3);



	        b4 = new JButton("Enquiry");
			b4.setFont(new Font("Arial", Font.BOLD,25));
			b4.setBackground(new Color(0x1A237E));
			b4.setForeground(Color.WHITE);
			b4.setFocusPainted(false);
			b4.setBounds(1600, 10, 160, 30);
			b4.addActionListener(this);
	        navBar.add(b4);


            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	    }

	    public void actionPerformed(ActionEvent ae)
	    {
			if (ae.getSource() == b1)
			{
			    new SchoolLogin().setVisible(true);
			    this.dispose();
		    }
			else if (ae.getSource() == b2)
			 {
			     JOptionPane.showMessageDialog(this, "Logout Clicked");
			 }
			 else if (ae.getSource() == b3)
			 {
			      new AboutUs().setVisible(true);
			      this.dispose();
			 }
			 else if (ae.getSource() == b4)
			 {
			     new Enquiry().setVisible(true);
			     this.dispose();
			 }
	   }

	    public static void main(String args[]) {
	        homescreen h = new homescreen();
	        h.setVisible(true);
	    }
	}

