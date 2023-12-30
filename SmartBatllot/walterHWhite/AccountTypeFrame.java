
package walterHWhite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountTypeFrame extends JFrame {

    public AccountTypeFrame() {
        super("Next Frame Title");
        super.setSize(1366, 768);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(new Color(220, 230, 240));

        JLabel label = new JLabel("Choose Account Type");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Candara", Font.BOLD, 28));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(520, 200, 300, 80);
        add(label);

        JButton userButton = new JButton("User");
        // userButton.setForeground(Color.WHITE);
        // userButton.setBackground(Color.BLACK);
        userButton.setFont(new Font("Candara", Font.BOLD, 18));
        // userButton.setBorderPainted(false);
        userButton.setBounds(500, 300, 150, 40);
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserSU userSUFrames = new UserSU(); // Create an instance of UserSU class
                userSUFrames.setVisible(true); // Show the UserSU frame
            }
        });
        add(userButton);

        JButton adminButton = new JButton("Admin");
        // adminButton.setForeground(Color.WHITE);
        // adminButton.setBackground(Color.BLACK);
        adminButton.setFont(new Font("Candara", Font.BOLD, 18));
        // adminButton.setBorderPainted(false);
        adminButton.setBounds(700, 300, 150, 40);
        adminButton.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    UserSU userSUFrames = new UserSU(); // Create an instance of UserSU class
                    userSUFrames.setVisible(true); // Show the UserSU frame
                }
           
        });
        add(adminButton);

        JLabel rollingText = new JLabel("The change we need.The voice we deserve.");
        rollingText.setForeground(Color.BLACK);
        rollingText.setFont(new Font("Candara", Font.BOLD, 24));
        rollingText.setBounds(480, 400, 600, 50);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(300);
                    String text = rollingText.getText();
                    char firstChar = text.charAt(0);
                    text = text.substring(1) + firstChar;
                    rollingText.setText(text);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        add(rollingText);

        setVisible(true);
    }
}
