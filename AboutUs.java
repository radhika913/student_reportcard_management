import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class AboutUs extends JFrame implements ActionListener
{
	JButton backButton;

        AboutUs() {
        setTitle("About Us - BHEL Secondary School");
        setFullScreen();
        getContentPane().setBackground(new Color(0xFDF6F0));
        setLayout(null);


        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(0xFFE3E3));
        infoPanel.setBounds(150, 180, 1600, 650);
        infoPanel.setLayout(null);
        infoPanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF6F61), 4, true));
        add(infoPanel);


        JLabel heading = new JLabel("ABOUT US");
        heading.setFont(new Font("Serif", Font.BOLD, 70));
        heading.setForeground(new Color(0x4A148C));
        heading.setBounds(700, 60, 500, 70);
        add(heading);


        ImageIcon icon = new ImageIcon("aboutus.jpg");
        Image aboutImg = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(aboutImg));
        iconLabel.setBounds(540, 45, 120, 120);
        add(iconLabel);


        JLabel subHeading = new JLabel("Welcome to BHEL Secondary School!");
        subHeading.setFont(new Font("SansSerif", Font.BOLD, 32));
        subHeading.setForeground(new Color(0x1A237E));
        subHeading.setBounds(50, 20, 900, 40);
        infoPanel.add(subHeading);


        JSeparator underline = new JSeparator();
        underline.setBounds(50, 65, 700, 3);
        underline.setBackground(new Color(0x1A237E));
        infoPanel.add(underline);


        JTextArea description = new JTextArea(
                "\u2022 BHEL Secondary School is a CBSE-affiliated institution under the Bhartiya Shikshan Prasarak Sanstha.\n\n" +
                "\u2022 Our mission is to nurture students through academic excellence and moral values.\n\n" +
                "\u2022 We believe in holistic growth – empowering students with leadership, empathy, and creativity.\n\n" +
                "\u2022 The campus features digital classrooms, labs, library, and vibrant student clubs.\n\n" +
                "\u2022 Our faculty is committed to bringing out the best in each child through interactive learning.\n\n" +
                "\u2022 Our motto: \"Inspire. Educate. Empower.\"\n"
        );
        description.setFont(new Font("SansSerif", Font.PLAIN, 26));
        description.setEditable(false);
        description.setOpaque(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setForeground(new Color(0x4E342E));
        description.setBounds(50, 100, 1500, 500);
        infoPanel.add(description);

        backButton = new JButton("Back");
		backButton.setFont(new Font("Arial", Font.BOLD, 25));
		backButton.setBackground(new Color(0x4A148C));
		backButton.setForeground(Color.WHITE);
		backButton.setFocusPainted(false);
		backButton.setBounds(50, 50, 150, 50);
		backButton.addActionListener(this);
        add(backButton);



        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
	    if (ae.getSource() == backButton) {
	        new homescreen().setVisible(true);
	        this.dispose();
	    }
}

    private void setFullScreen() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new AboutUs();
    }
}
