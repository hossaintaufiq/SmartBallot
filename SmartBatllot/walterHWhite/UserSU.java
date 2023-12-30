
package walterHWhite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserSU extends JFrame {

    private JTextField t1;
    private JPasswordField p1;

    public UserSU() {
        setTitle("Sign Up.");
        setSize(500, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(220, 230, 240));

        JLabel uL = new JLabel("Username:");
        uL.setBounds(50, 30, 100, 30);
        panel.add(uL);

        t1 = new JTextField();
        t1.setBounds(150, 30, 150, 30);
        panel.add(t1);

        JLabel pL = new JLabel("Password:");
        pL.setBounds(50, 80, 100, 30);
        panel.add(pL);

        p1 = new JPasswordField();
        p1.setBounds(150, 80, 150, 30);
        panel.add(p1);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 130, 100, 30);
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(200, 130, 100, 30);
        panel.add(registerButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(390, 200, 80, 30);
        panel.add(backButton);

        add(panel);

        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = t1.getText();
                String enteredPassword = new String(p1.getPassword());
        
                if (authenticateUser(enteredUsername, enteredPassword)) {
                    // JOptionPane.showMessageDialog(null);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UReg();
                
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


    private boolean authenticateUser(String username, String password) {
        String filePath = "user_info.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String storedUsername = parts[0].trim();
                    String storedPassword = parts[1].trim();
    
                    // Check if the entered credentials match admin credentials
                    if (username.equals("admin") && password.equals("admin")) {
                         new AdDsh(); // Redirect to admin dashboard
                        return true;
                    }
    
                    // Check if the entered credentials match stored credentials
                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        new UsDsh(); // Redirect to user dashboard
                        return true;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UserSU();
        });
    }
}

