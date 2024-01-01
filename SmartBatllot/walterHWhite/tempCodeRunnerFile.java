
package walterHWhite;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class tempCodeRunnerFile extends JFrame {

    public tempCodeRunnerFile() {
        setTitle("Feedback Page");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this frame

        JLabel feedbackLabel = new JLabel("Feedback Page");
        feedbackLabel.setBounds(220, 20, 200, 30);
        feedbackLabel.setForeground(Color.BLACK);
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 100, 20);
        nameLabel.setForeground(Color.BLACK);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 70, 200, 20);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 100, 100, 20);
        emailLabel.setForeground(Color.BLACK);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 100, 200, 20);

        JLabel commentLabel = new JLabel("Comments:");
        commentLabel.setBounds(50, 130, 100, 20);
        commentLabel.setForeground(Color.BLACK);

        JTextArea commentTextArea = new JTextArea();
        commentTextArea.setBounds(50, 160, 500, 100);
        commentTextArea.setLineWrap(true);
        commentTextArea.setWrapStyleWord(true);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 280, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String comment = commentTextArea.getText();

                saveFeedback(name, email, comment); // Save feedback to a file
                dispose(); // Close the frame
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(350, 280, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the frame
            }
        });

        add(feedbackLabel);
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(commentLabel);
        add(commentTextArea);
        add(submitButton);
        add(backButton);
        setLayout(null);
        setVisible(true);
    }

    private void saveFeedback(String name, String email, String comment) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt", true))) {
            writer.write("Name: " + name + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Comment: " + comment + "\n");
            writer.write("--------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FeedbackPage();
    }
}
