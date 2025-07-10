// Add the following dependency to your project if you don't have org.json:
// Download from: https://mvnrepository.com/artifact/org.json/json
// Or add to your build path: json-20210307.jar (or similar)
package walterHWhite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProfileDashboard extends JFrame {

    private String firstName = "N/A";
    private String lastName = "N/A";
    private String email = "N/A";
    private int age = 0;
    private String profilePicPath = "SmartBatllot/pictures/Profile pic.jpg";

    public ProfileDashboard() {
        setTitle("Profile Dashboard");
        setSize(1016, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Read user information from the JSON file (last user for now)
        readUserInfoFromJson("users.json");

        JPanel profilePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(new Color(245, 245, 245));
                g2.fillRoundRect(30, 30, 350, 350, 40, 40);
            }
        };
        profilePanel.setLayout(null);
        profilePanel.setBackground(new Color(230, 230, 250));

        JLabel profilePicLabel = new JLabel("User Profile");
        profilePicLabel.setForeground(new Color(44, 62, 80));
        profilePicLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        profilePicLabel.setBounds(60, 45, 200, 30);

        // Load the profile picture from the file (relative path)
        ImageIcon imageIcon = new ImageIcon(profilePicPath);
        Image image = imageIcon.getImage();

        // Creating a circular profile picture with border
        JLabel profilePicture = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                int diameter = 120;
                Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, diameter, diameter);
                g2.setClip(circle);
                g2.drawImage(image, 0, 0, diameter, diameter, null);
                g2.setClip(null);
                g2.setStroke(new BasicStroke(4f));
                g2.setColor(new Color(52, 152, 219));
                g2.drawOval(0, 0, diameter, diameter);
                g2.dispose();
            }
        };
        profilePicture.setBounds(50, 80, 120, 120);

        String fullName = firstName + " " + lastName;
        JLabel nameLabel = new JLabel(fullName);
        nameLabel.setForeground(new Color(44, 62, 80));
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        nameLabel.setBounds(50, 210, 300, 30);

        JLabel emailLabel = new JLabel("Email: " + email);
        emailLabel.setForeground(new Color(44, 62, 80));
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        emailLabel.setBounds(50, 250, 300, 30);

        JLabel ageLabel = new JLabel("Age: " + (age > 0 ? age : "N/A"));
        ageLabel.setForeground(new Color(44, 62, 80));
        ageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        ageLabel.setBounds(50, 290, 150, 30);

        JButton backButton = new JButton("Back");
        backButton.setBounds(850, 500, 100, 30);
        backButton.setBackground(new Color(52, 152, 219));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
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

    // Method to read user information from the JSON file (last user for now)
    private void readUserInfoFromJson(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray users = new JSONArray(content);
            if (users.length() > 0) {
                JSONObject user = users.getJSONObject(users.length() - 1); // Last registered user
                firstName = user.optString("firstName", "N/A");
                lastName = user.optString("lastName", "N/A");
                email = user.optString("email", "N/A");
                age = user.optInt("age", 0);
            }
        } catch (Exception e) {
            // If file missing or invalid, use defaults
        }
    }

    public static void main(String[] args) {
        new ProfileDashboard();
    }
}
