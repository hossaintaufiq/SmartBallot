package walterHWhite;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FeedbackDisplayPage extends JFrame {

    private JTextArea displayTextArea;

    public FeedbackDisplayPage() {
        setTitle("Feedback Display");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        displayTextArea = new JTextArea();
        displayTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayTextArea);
        scrollPane.setBounds(50, 50, 500, 300);

        add(scrollPane);
        displayFeedback(); // Display feedback in the text area
        setVisible(true);
    }

    private void displayFeedback() {
        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                displayTextArea.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FeedbackDisplayPage();
    }
}

