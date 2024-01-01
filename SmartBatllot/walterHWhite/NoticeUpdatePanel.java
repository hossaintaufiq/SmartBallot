

package walterHWhite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeUpdatePanel extends JFrame {

    public NoticeUpdatePanel() {
        setTitle("Notice & Update Page");
        setSize(800, 600); // Enlarged size
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this frame

        JLabel mainLabel = new JLabel("Latest Election Updates");
        mainLabel.setBounds(250, 20, 500, 30);
        mainLabel.setForeground(Color.BLACK);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel newsPanel = new JPanel();
        newsPanel.setLayout(new BoxLayout(newsPanel, BoxLayout.Y_AXIS));
        newsPanel.setBounds(50, 70, 700, 450);

        // Headline 1
        JLabel headline1 = new JLabel("High Voter Turnout");
        headline1.setForeground(Color.BLACK);
        headline1.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel description1 = new JLabel("<html><br>The ongoing elections are witnessing high voter turnout across the nation. "
                + "Candidates from various parties are engaging in intense campaigning.</html>");
        description1.setFont(new Font("Arial", Font.PLAIN, 14));
        description1.setVerticalAlignment(SwingConstants.TOP);

        // Headline 2
        JLabel headline2 = new JLabel("Political Campaigning");
        headline2.setForeground(Color.BLACK);
        headline2.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel description2 = new JLabel("<html><br>Political candidates are focusing on key issues and strategies for "
                + "the upcoming election day. Public debates and rallies are gaining momentum.</html>");
        description2.setFont(new Font("Arial", Font.PLAIN, 14));
        description2.setVerticalAlignment(SwingConstants.TOP);

        // Headline 3
        JLabel headline3 = new JLabel("Election Impact on Education");
        headline3.setForeground(Color.BLACK);
        headline3.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel description3 = new JLabel("<html><br>The election results are anticipated to have an impact on education policies, "
                + "funding, and reforms. Education stakeholders are closely observing the electoral outcomes.</html>");
        description3.setFont(new Font("Arial", Font.PLAIN, 14));
        description3.setVerticalAlignment(SwingConstants.TOP);

        newsPanel.add(headline1);
        newsPanel.add(description1);
        newsPanel.add(Box.createVerticalStrut(20)); // Adds spacing between headlines and descriptions
        newsPanel.add(headline2);
        newsPanel.add(description2);
        newsPanel.add(Box.createVerticalStrut(20)); // Adds spacing between headlines and descriptions
        newsPanel.add(headline3);
        newsPanel.add(description3);

        JButton backButton = new JButton("Back");
        backButton.setBounds(350, 530, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this frame when the "Back" button is clicked
            }
        });

        add(mainLabel);
        add(newsPanel);
        add(backButton);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NoticeUpdatePanel();
    }
}
