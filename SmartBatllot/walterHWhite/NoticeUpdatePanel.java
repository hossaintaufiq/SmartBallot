package walterHWhite;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class NoticeUpdatePanel extends JFrame {

    public NoticeUpdatePanel() {
        setTitle("Notice & Update Page");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this frame

        JLabel noticeLabel = new JLabel("This is the Notice & Update Page");
        noticeLabel.setBounds(50, 50, 500, 30);
        noticeLabel.setForeground(Color.BLACK);
        noticeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        add(noticeLabel);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NoticeUpdatePanel();
    }
}