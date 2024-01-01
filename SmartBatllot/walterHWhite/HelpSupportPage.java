package walterHWhite;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpSupportPage extends JFrame {

    public HelpSupportPage() {
        setTitle("Help & Support Page");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the frame on close

        JPanel panel = new JPanel();
        panel.setLayout(null); // Using null layout for demonstration

        JLabel titleLabel = new JLabel("Help & Support");
        titleLabel.setBounds(320, 50, 200, 30);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Candara", Font.BOLD, 24));
        panel.add(titleLabel);

        JLabel supportLabel = new JLabel("<html>Contact our support team for assistance.<br>Software Developed by Hossain Ahmmed Taufiq<br>Email: hossainahmmedtaufiq22@gmail.com<br>Phone: 01773983904</html>");
        supportLabel.setBounds(50, 100, 700, 150);
        supportLabel.setForeground(Color.BLACK);
        supportLabel.setFont(new Font("Candara", Font.PLAIN, 16));
        panel.add(supportLabel);

        // Additional help and support information can be added here...

        JButton backButton = new JButton("Back");
        backButton.setBounds(330, 500, 120, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this frame when back button is clicked
            }
        });
        panel.add(backButton);

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HelpSupportPage();
    }
}
