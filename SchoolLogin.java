import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SchoolLogin extends JFrame implements ActionListener {
    JButton loginButton, cancelButton,registerButton;
    JTextField usernameField;
    JPasswordField passwordField;
    JLabel forgotPasswordLabel;
    String uname;
    String emailid;


    SchoolLogin() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth, screenHeight);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLayeredPane layeredPane = getLayeredPane();

        /*ImageIcon bgIcon = new ImageIcon("libraryPic2.jpg");
        Image bgImg = bgIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        JLabel bgLabel = new JLabel(new ImageIcon(bgImg));
        bgLabel.setBounds(0, 0, screenWidth, screenHeight);
        layeredPane.add(bgLabel, new Integer(0));*/

        /*formPanel = new JPanel();
        formPanel.setBackground(new Color(255, 255, 255, 200));
        formPanel.setLayout(null);
        formPanel.setBounds(600, 200, 600, 600);*/

        JLabel heading = new JLabel("Welcome to BHEL Secondary School!");
        heading.setFont(new Font("SansSerif", Font.BOLD, 60));
        heading.setForeground(new Color(0x4A158D));
        heading.setBounds(450, 50, 1200, 80);
        add(heading);

        ImageIcon educationIcon = new ImageIcon("login.jpg");
	    Image educationImg = educationIcon.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
		JLabel education = new JLabel(new ImageIcon(educationImg));
		education.setBounds(100, 170, 800, 800);
	    add(education);

	    JLabel l1 = new JLabel("STAFF LOGIN");
		l1.setFont(new Font("Serif", Font.BOLD, 40));
		//l1.setBackground(new Color(0xC9184A));
		l1.setForeground(new Color(0xC9184A));
		l1.setBounds(1200, 250, 500, 80);
		//l1.setOpaque(true);
        add(l1);



        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));
        userLabel.setBounds(1000, 400, 200, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("SansSerif", Font.PLAIN, 25));
        usernameField.setBounds(1200, 400, 440, 40);
        add(usernameField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));
        passLabel.setBounds(1000, 500, 200, 30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 25));
        passwordField.setBounds(1200, 500, 440, 40);
        add(passwordField);


        forgotPasswordLabel = new JLabel("Forgot Password?");
        forgotPasswordLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        forgotPasswordLabel.setForeground(Color.BLUE);
        forgotPasswordLabel.setBounds(1450, 550, 200, 30);
        forgotPasswordLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
				new ForgotPassword().setVisible(true);
                forgotPasswordLabel.setForeground(Color.RED);

            }
        });
        add(forgotPasswordLabel);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 30));
        loginButton.setBackground(new Color(0xC9184A));
        loginButton.setForeground(new Color(0xFCE4EC));
        loginButton.setBounds(1000, 700, 250, 50);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 30));
        cancelButton.setBackground(new Color(0xC9184A));
        cancelButton.setForeground(new Color(0xFCE4EC));
        cancelButton.setBounds(1400, 700, 250, 50);
        cancelButton.addActionListener(this);
        add(cancelButton);

        JLabel l2 = new JLabel("Don't have an account? Sign up");
		l2.setFont(new Font("SansSerif", Font.BOLD, 18));
		l2.setForeground(Color.BLUE);
		l2.setBounds(1200, 800, 500, 30);
		l2.addMouseListener(new MouseAdapter() {
		            public void mouseClicked(MouseEvent e)
		            {
						l2.setForeground(Color.RED);
						new SignUp().setVisible(true);
		            }
		        });
        add(l2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent ae)
    {
		if (ae.getSource() == loginButton) {
		    String password = new String(passwordField.getPassword());
		    String username = usernameField.getText();

		    if (password.isEmpty() || username.isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    try (Connection conn = Connect_Database.getConnection()) {
		        if (conn == null) {
		            JOptionPane.showMessageDialog(this, "Database connection failed", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        boolean success = Connect_Database.login(username, password);
		        if (success) {
		            JOptionPane.showMessageDialog(this, "Login Successful!");

		            String email = Connect_Database.getEmailByUsername(username);
		            Connect_Database.uname=username;
					Connect_Database.emailid=email;
					new SchoolDashboard(username, email).setVisible(true);
					this.dispose();
		        } else {
		            JOptionPane.showMessageDialog(this, "Invalid username or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
		        }

		    } catch (SQLException ex) {
		        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
		        ex.printStackTrace();
		    }
		}

        else if (ae.getSource()==cancelButton)
		{
			new homescreen().setVisible(true);
			this.dispose();
		}
 }

  public static void main(String[] args) {
        SchoolLogin login = new SchoolLogin();
        login.setVisible(true);
    }
}



