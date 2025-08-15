import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ReportCardView extends JFrame {

    JTextArea reportArea;

    public ReportCardView(String studentId)
    {
        setTitle("Report Card");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(50, 30, 700, 700);
        add(formPanel);


        ImageIcon logoIcon = new ImageIcon("bspa_logo.jpg");
        Image logoImg = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImg));
        logoLabel.setBounds(20, 10, 100, 100);
        formPanel.add(logoLabel);

        JLabel schoolName = new JLabel("BHEL SECONDARY SCHOOL");
        schoolName.setFont(new Font("Serif", Font.BOLD, 26));
        schoolName.setForeground(new Color(0xD32E2E));
        schoolName.setBounds(130, 10, 550, 30);
        formPanel.add(schoolName);

        JLabel trustName = new JLabel("Bhartiya Shikshan Prasarak Sanstha, Ambajogai");
        trustName.setFont(new Font("SansSerif", Font.BOLD, 16));
        trustName.setBounds(130, 45, 550, 25);
        formPanel.add(trustName);

        JLabel location = new JLabel("PARLI VAIJNATH");
        location.setFont(new Font("SansSerif", Font.BOLD, 18));
        location.setBounds(130, 75, 400, 25);
        formPanel.add(location);

        JLabel affiliation = new JLabel("Affiliated to CBSE | Affiliation No: 11223344 | School Code: 45386");
        affiliation.setFont(new Font("SansSerif", Font.PLAIN, 14));
        affiliation.setBounds(130, 100, 550, 25);
        formPanel.add(affiliation);

        JSeparator separator = new JSeparator();
        separator.setBounds(20, 130, 660, 2);
        formPanel.add(separator);


        reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(reportArea);
        scrollPane.setBounds(30, 150, 640, 700);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Report Card"));
        formPanel.add(scrollPane);


        loadReportCard(studentId);

        setVisible(true);
    }

   private void loadReportCard(String studentId)
   {
       try (Connection conn = Connect_Database.getConnection())
       {
           StringBuilder report = new StringBuilder();

           String studentSql = "SELECT sname, roll_no, standard, division FROM student WHERE student_id = ?";
           PreparedStatement ps = conn.prepareStatement(studentSql);
           ps.setInt(1, Integer.parseInt(studentId));
           ResultSet rs = ps.executeQuery();

           if (rs.next())
           {
               report.append("Student Name   : ").append(rs.getString("sname")).append("\n");
               report.append("Roll No        : ").append(rs.getString("roll_no")).append("\n");
               report.append("Standard       : ").append(rs.getString("standard")).append("\n");
               report.append("Division       : ").append(rs.getString("division")).append("\n");
               report.append("Student ID     : ").append(studentId).append("\n");
           }
           else
           {
               reportArea.setText("No student record found.");
               return;
           }

           String markId = null;
           String markIdSql = "SELECT mark_id FROM marks WHERE student_id = ?";
           ps = conn.prepareStatement(markIdSql);
           ps.setInt(1, Integer.parseInt(studentId));
           ResultSet midRs = ps.executeQuery();

           if (midRs.next())
           {
               markId = midRs.getString("mark_id");

               report.append("\n------------------------------\n");
               report.append(String.format("%-20s %s\n", "Subject", "Marks"));
               report.append("------------------------------\n");

               String marksSql = "SELECT subject_name, mark FROM marks_details WHERE mark_id = ?";
               ps = conn.prepareStatement(marksSql);
               ps.setString(1, markId);
               ResultSet marksRs = ps.executeQuery();

               int total = 0, count = 0;
               while (marksRs.next())
               {
                   String subject = marksRs.getString("subject_name");
                   int mark = marksRs.getInt("mark");
                   report.append(String.format("%-20s %d\n", subject, mark));
                   total += mark;
                   count++;
               }

               if (count > 0)
               {
                   float percentage = total / (float) count;
                   String grade;
                   if (percentage >= 90) grade = "A+";
                   else if (percentage >= 75) grade = "A";
                   else if (percentage >= 60) grade = "B";
                   else if (percentage >= 50) grade = "C";
                   else grade = "D";

                   report.append("\n------------------------------\n");
                   report.append("Total Marks     : ").append(total).append("\n");
                   report.append(String.format("Percentage      : %.2f%%\n", percentage));
                   report.append("Grade           : ").append(grade).append("\n");
               } else {
                   report.append("No marks found.\n");
               }

           } else {
               report.append("\nNo marks available for this student.\n");
           }

           reportArea.setText(report.toString());

       } catch (Exception e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
       }
   }
}
