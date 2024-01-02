package walterHWhite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProfileDashboard extends JFrame {

    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public ProfileDashboard() {
        setTitle("Profile Dashboard");
        setSize(1016, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Read user information from the file
        readUserInfoFromFile("user_info.txt");

        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(null);
        profilePanel.setBackground(Color.WHITE);

        JLabel profilePicLabel = new JLabel("User Profile");
        profilePicLabel.setForeground(Color.BLACK);
        profilePicLabel.setFont(new Font("Arial", Font.BOLD, 18));
        profilePicLabel.setBounds(60, 45, 120, 30);

        // Load the profile picture from the file
        String imagePath = "D:\\Project(Software)\\SmartBatllot\\SmartBatllot\\pictures/Profile pic.jpg";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();

        // Creating a circular profile picture
        JLabel profilePicture = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                int diameter = 120;
                Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, diameter, diameter);
                g2.setClip(circle);
                g2.drawImage(image, 0, 0, diameter, diameter, null);
                g2.dispose();
            }
        };
        profilePicture.setBounds(50, 80, 120, 120);

        String fullName = firstName + " " + lastName; // Combine first name and last name
        JLabel nameLabel = new JLabel(fullName); // Display full name obtained from the file
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setBounds(50, 210, 300, 30);

        JLabel emailLabel = new JLabel("Email: " + email); // Display email obtained from the file
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        emailLabel.setBounds(50, 250, 300, 30);

        JLabel ageLabel = new JLabel("Age: " + age); // Display age obtained from the file
        ageLabel.setForeground(Color.BLACK);
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        ageLabel.setBounds(50, 290, 150, 30);

        // Creating the back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(850, 500, 100, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform action to go back to the previous page here
                // For example, you could close this window
                dispose(); // Close the profile dashboard window
                // Add code here to navigate back to the previous page
            }
        });

        profilePanel.add(profilePicLabel);
        profilePanel.add(profilePicture);
        profilePanel.add(nameLabel);
        profilePanel.add(emailLabel);
        profilePanel.add(ageLabel);
        profilePanel.add(backButton);

        add(profilePanel);
        setVisible(true);
    }

    // Method to read user information from the file
    private void readUserInfoFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("First Name:")) {
                    firstName = line.substring(11).trim();
                } else if (line.startsWith("Last Name:")) {
                    lastName = line.substring(10).trim();
                } else if (line.startsWith("Email:")) {
                    email = line.substring(7).trim();
                } else if (line.startsWith("Age:")) {
                    age = Integer.parseInt(line.substring(5).trim());
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(); // Handle exceptions properly in your application
        }
    }

    public static void main(String[] args) {
        new ProfileDashboard();
    }
}
