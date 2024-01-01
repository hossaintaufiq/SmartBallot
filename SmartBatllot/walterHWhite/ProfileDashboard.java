package walterHWhite;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ProfileDashboard extends JFrame {

    public ProfileDashboard() {
        setTitle("Profile Dashboard");
        setSize(1016, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(null);
        profilePanel.setBackground(Color.WHITE);

        JLabel profilePicLabel = new JLabel("User Profile");
        profilePicLabel.setForeground(Color.BLACK);
        profilePicLabel.setFont(new Font("Arial", Font.BOLD, 18));
        profilePicLabel.setBounds(60, 45, 120, 30); // Adjust position for the profile picture label

        String imagePath = "D:\\Project(Software)\\SmartBatllot\\SmartBatllot\\pictures/Profile pic.jpg"; // Replace with your image path
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        // Creating a circular profile picture
        JLabel profilePicture = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                int diameter = 120; // Diameter of the circular area
                Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, diameter, diameter);
                g2.setClip(circle);
                g2.drawImage(image, 0, 0, diameter, diameter, null); // Replace with your image
                g2.dispose();
            }
        };
        profilePicture.setBounds(50, 80, 120, 120); // Adjust position for the circular profile picture
        // profilePicture.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border for the circle

        JLabel nameLabel = new JLabel("Walter White");
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setBounds(50, 210, 150, 30); // Adjust position for the name

        profilePanel.add(profilePicLabel);
        profilePanel.add(profilePicture);
        profilePanel.add(nameLabel);

        add(profilePanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ProfileDashboard();
    }
}
