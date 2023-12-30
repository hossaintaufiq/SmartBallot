
package walterHWhite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.*;
import javax.swing.border.*;

public class GetSt extends JFrame {

    public GetSt() {
        initializeUI();
    }

    private void initializeUI() {
        JFrame f1 = new JFrame("Smart Ballot");
        f1.setSize(1366, 768);
        f1.setResizable(false);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(new BorderLayout()); // Use BorderLayout

        // Panel for the central content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // Set layout to null for absolute positioning
        contentPanel.setBackground(new Color(220, 230, 240)); // Mixed light color background
        f1.add(contentPanel, BorderLayout.CENTER);

        // Label for title
        JLabel labelText = new JLabel("Smart Ballot : Revolutionizing The Voting Experience.");
        labelText.setForeground(Color.BLACK);
        labelText.setFont(new Font("Candara", Font.BOLD, 28));
        labelText.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
        labelText.setBounds(300, 300, 800, 80); // Positioned in the vertical center
        contentPanel.add(labelText);

        // Create "Get Started" button with rounded design
        JButton getStartedButton = new JButton("Get Started");
        getStartedButton.setForeground(Color.WHITE);
        getStartedButton.setBackground(Color.BLACK);
        getStartedButton.setFont(new Font("Candara", Font.BOLD, 20));
        getStartedButton.setFocusPainted(false); // Remove button border focus
        getStartedButton.setBounds(600, 400, 160, 50); // Positioned below the headline
        getStartedButton.setBorder(new RoundBorder(20)); // Custom rounded border
        getStartedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the UserSU signup page when the "Get Started" button is clicked
                new AccountTypeFrame(); // Create an instance of UserSU class
                f1.dispose(); // Close the current JFrame (GetSt page)
            }
        });
        contentPanel.add(getStartedButton);

        f1.setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        javax.swing.SwingUtilities.invokeLater(() -> {
            new GetSt(); // Create and display the JFrame
        });
    }
}



class RoundBorder implements Border {
    private int radius;

    RoundBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.BLACK);
        ((Graphics2D) g).draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, this.radius, this.radius));
    }
}


