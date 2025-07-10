
// Add the following dependency to your project if you don't have org.json:
// Download from: https://mvnrepository.com/artifact/org.json/json
// Or add to your build path: json-20210307.jar (or similar)

package walterHWhite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UReg extends JFrame {

    private JTextField t1, t2, t3, t4,t6;
    private JPasswordField t5;

    public UReg() {
        setTitle("Create your Voting Account");
        setSize(1366, 768);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(433, 160, 500, 450);
        panel.setBackground(new Color(220, 230, 240));

        JLabel r1 = new JLabel("Voting Account");
        r1.setBounds(150, 20, 400, 40);
        r1.setForeground(Color.BLACK);
        r1.setFont(new Font("Candara", Font.BOLD, 36));
        panel.add(r1);

        JLabel u1 = new JLabel("First Name:");
        u1.setBounds(50, 70, 200, 30);
        u1.setForeground(Color.BLACK);
        u1.setFont(new Font("Candara", Font.BOLD, 18));
        t1 = new JTextField();
        t1.setBounds(250, 70, 250, 30);

        JLabel u2 = new JLabel("Last Name:");
        u2.setBounds(50, 120, 200, 30);
        u2.setForeground(Color.BLACK);
        u2.setFont(new Font("Candara", Font.BOLD, 18));
        t2 = new JTextField();
        t2.setBounds(250, 120, 250, 30);

        JLabel u3 = new JLabel("Email:");
        u3.setBounds(50, 170, 200, 30);
        u3.setForeground(Color.BLACK);
        u3.setFont(new Font("Candara", Font.BOLD, 18));
        t3 = new JTextField();
        t3.setBounds(250, 170, 250, 30);

        JLabel u4 = new JLabel("Username:");
        u4.setBounds(50, 220, 200, 30);
        u4.setForeground(Color.BLACK);
        u4.setFont(new Font("Candara", Font.BOLD, 18));
        t4 = new JTextField();
        t4.setBounds(250, 220, 250, 30);

        JLabel u5 = new JLabel("Password:");
        u5.setBounds(50, 270, 200, 30);
        u5.setForeground(Color.BLACK);
        u5.setFont(new Font("Candara", Font.BOLD, 18));
        t5 = new JPasswordField();
        t5.setBounds(250, 270, 250, 30);

        JLabel u6 = new JLabel("Age:");
        u6.setBounds(50, 320, 200, 30);
        u6.setForeground(Color.BLACK);
        u6.setFont(new Font("Candara", Font.BOLD, 18));
        t6 = new JTextField();
        t6.setBounds(250, 320, 250, 30);
        panel.add(u6);
        panel.add(t6);

        JButton r1Button = new JButton("Create an account");
        // r1Button.setForeground(Color.WHITE);
        // r1Button.setBackground(Color.BLACK);
        r1Button.setFont(new Font("Candara", Font.BOLD, 20));
        r1Button.setBorderPainted(false);
        r1Button.setBounds(50, 370, 300, 40);

        JButton backButton = new JButton("Back");
        // backButton.setForeground(Color.WHITE);
        // backButton.setBackground(Color.BLACK);
        backButton.setFont(new Font("Candara", Font.BOLD, 15));
        backButton.setBorderPainted(false);
        backButton.setBounds(400, 370, 100, 40);

        r1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = t1.getText();
                String lastName = t2.getText();
                String email = t3.getText();
                String username = t4.getText();
                String password = new String(t5.getPassword());
                String ageText = t6.getText();

                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || ageText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                } else {
                    try {
                        int age = Integer.parseInt(ageText);
                        if (age >= 18) {
                            JSONArray users = new JSONArray();
                            try {
                                String content = new String(Files.readAllBytes(Paths.get("users.json")));
                                users = new JSONArray(content);
                            } catch (Exception ex) {
                                // File may not exist yet, start with empty array
                            }
                            // Check for duplicate username
                            boolean exists = false;
                            for (int i = 0; i < users.length(); i++) {
                                JSONObject user = users.getJSONObject(i);
                                if (user.getString("username").equals(username)) {
                                    exists = true;
                                    break;
                                }
                            }
                            if (exists) {
                                JOptionPane.showMessageDialog(null, "Username already exists!");
                                return;
                            }
                            JSONObject newUser = new JSONObject();
                            newUser.put("firstName", firstName);
                            newUser.put("lastName", lastName);
                            newUser.put("email", email);
                            newUser.put("username", username);
                            newUser.put("password", password);
                            newUser.put("age", age);
                            users.put(newUser);
                            Files.write(Paths.get("users.json"), users.toString(2).getBytes());
                            JOptionPane.showMessageDialog(null, "Your account created successfully!");
                            clearFields();
                        } else {
                            JOptionPane.showMessageDialog(null, "You must be 18 or older to register.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid age.");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error saving user info.");
                    }
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame (UReg)
                // Code to navigate back to the previous page or frame goes here
            }
        });

        panel.add(u1);
        panel.add(t1);
        panel.add(u2);
        panel.add(t2);
        panel.add(u3);
        panel.add(t3);
        panel.add(u4);
        panel.add(t4);
        panel.add(u5);
        panel.add(t5);
        panel.add(r1Button);
        panel.add(backButton); // Add the back button to the panel

        getContentPane().setBackground(new Color(220, 230, 240));
        add(panel);
        setVisible(true);
    }

    private void clearFields() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UReg();
        });
    }
}
