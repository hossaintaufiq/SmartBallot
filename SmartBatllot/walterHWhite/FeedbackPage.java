package walterHWhite;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackPage extends JFrame {

    public FeedbackPage() {
        setTitle("Feedback Page");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this frame

        JLabel feedbackLabel = new JLabel("Feedback Page");
        feedbackLabel.setBounds(220, 20, 200, 30);
        feedbackLabel.setForeground(Color.BLACK);
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel commentLabel = new JLabel("Comments:");
        commentLabel.setBounds(50, 70, 100, 20);
        commentLabel.setForeground(Color.BLACK);

        JTextArea commentTextArea = new JTextArea();
        commentTextArea.setBounds(50, 100, 500, 150);
        commentTextArea.setLineWrap(true);
        commentTextArea.setWrapStyleWord(true);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 280, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Here you can handle the submission of feedback
                // For this example, let's just dispose of the frame
                dispose();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(350, 280, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this frame when the "Back" button is clicked
            }
        });

        add(feedbackLabel);
        add(commentLabel);
        add(commentTextArea);
        add(submitButton);
        add(backButton);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FeedbackPage();
    }
}
