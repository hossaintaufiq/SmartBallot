package walterHWhite;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsDsh extends JFrame {

        private String[] col = { "Name", "Start Date", "End Date", "Status" };
        private String[][] row = {

                        { "Presidential Election", "March 20, 2024", "March 21, 2024", "Voted" },
                        { "Parliamentary Election", "January 7, 2024", "January 8, 2024", "Voted" },
                        { "Class Captain Election", "January 1, 2024", "January 5, 2024", "Voted" }

        };

        public UsDsh() {

                JFrame f1 = new JFrame("User Dashboard.");

                JLabel d1 = new JLabel(" Smart - Ballot ");
                d1.setBounds(78, 30, 250, 40);
                d1.setForeground(Color.BLACK); // Set font color
                d1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 28)); // Set font size

                JPanel leftHalf = new JPanel();
                leftHalf.setBounds(0, 0, 350, 768); // Adjust the bounds as needed
                leftHalf.setBackground(Color.ORANGE);
                leftHalf.setLayout(null);

                JPanel rightHalf = new JPanel();
                rightHalf.setBounds(351, 0, 1016, 768); // Adjust the bounds as needed
                rightHalf.setBackground(Color.WHITE);
                rightHalf.setLayout(null);

                JButton ud1 = new JButton("Election Info");
                ud1.setForeground(Color.BLACK);
                ud1.setBackground(Color.ORANGE);
                ud1.setFont(new Font("Candara", Font.BOLD, 20));
                ud1.setBorderPainted(false);
                ud1.setBounds(67, 90, 150, 40);

                JButton ud2 = new JButton("Notice & Updates");
                ud2.setForeground(Color.BLACK);
                ud2.setBackground(Color.ORANGE);
                ud2.setFont(new Font("Candara", Font.BOLD, 20));
                ud2.setBorderPainted(false);
                ud2.setBounds(58, 130, 210, 40);

                JButton ud3 = new JButton("Help & Support");
                ud3.setForeground(Color.BLACK);
                ud3.setBackground(Color.ORANGE);
                ud3.setFont(new Font("Candara", Font.BOLD, 20));
                ud3.setBorderPainted(false);
                ud3.setBounds(50, 170, 210, 40);

                JButton ud4 = new JButton("Feedback");
                ud4.setForeground(Color.BLACK);
                ud4.setBackground(Color.ORANGE);
                ud4.setFont(new Font("Candara", Font.BOLD, 20));
                ud4.setBorderPainted(false);
                ud4.setBounds(57, 210, 150, 40);

                JButton ud5 = new JButton("My Profile");
                ud5.setForeground(Color.BLACK);
                ud5.setBackground(Color.ORANGE);
                ud5.setFont(new Font("Candara", Font.BOLD, 20));
                ud5.setBorderPainted(false);
                ud5.setBounds(62, 300, 150, 40);

                JButton ud6 = new JButton("LogOut");
                ud6.setForeground(Color.BLACK);
                ud6.setBackground(Color.ORANGE);
                ud6.setFont(new Font("Candara", Font.BOLD, 20));
                ud6.setBorderPainted(false);
                ud6.setBounds(51, 340, 150, 40);
    
                ud6.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                // Create an instance of GetSt class and dispose of the current JFrame
                                new GetSt();
                                dispose(); // Dispose of the current UsDsh JFrame
                        }
                });

                JLabel d2 = new JLabel("Running Elections");
                d2.setBounds(10, 180, 230, 40);
                d2.setForeground(Color.BLACK); // Set font color
                d2.setFont(new Font("Candara", Font.BOLD, 22));

                JLabel d3 = new JLabel("Presidential Election");
                d3.setBounds(10, 435, 230, 40);
                d3.setForeground(Color.BLACK); // Set font color
                d3.setFont(new Font("Candara", Font.BOLD, 22));

                JButton ud9 = new JButton("Go for Vote");
                ud9.setForeground(Color.BLACK);
                ud9.setBackground(Color.ORANGE);
                ud9.setFont(new Font("Candara", Font.BOLD, 20));
                ud9.setBorderPainted(false);
                ud9.setBounds(240, 435, 150, 40);

                JLabel d4 = new JLabel("Parliamentary Election");
                d4.setBounds(10, 495, 230, 40);
                d4.setForeground(Color.BLACK); // Set font color
                d4.setFont(new Font("Candara", Font.BOLD, 22));

                JButton ud10 = new JButton("Go for Vote");
                ud10.setForeground(Color.BLACK);
                ud10.setBackground(Color.ORANGE);
                ud10.setFont(new Font("Candara", Font.BOLD, 20));
                ud10.setBorderPainted(false);
                ud10.setBounds(240, 495, 150, 40);

                JLabel d5 = new JLabel("Class Captain Election");
                d5.setBounds(10, 555, 230, 40);
                d5.setForeground(Color.BLACK); // Set font color
                d5.setFont(new Font("Candara", Font.BOLD, 22));

                JButton ud11 = new JButton("Go for Vote");
                ud11.setForeground(Color.BLACK);
                ud11.setBackground(Color.ORANGE);
                ud11.setFont(new Font("Candara", Font.BOLD, 20));
                ud11.setBorderPainted(false);
                ud11.setBounds(240, 555, 150, 40);

                // JButton ud12 = new JButton("Back");
                // ud12.setForeground(Color.WHITE);
                // ud12.setBackground(Color.BLACK);
                // ud12.setFont(new Font("Candara", Font.BOLD, 20));
                // ud12.setBorderPainted(false);
                // ud12.setBounds(800, 650, 150, 40);

                JTable jT = new JTable(row, col);
                JScrollPane sp1 = new JScrollPane(jT);
                sp1.setBounds(10, 220, 980, 180);

                Font tableFont = new Font("Candara", Font.BOLD, 18); // Change the font size as needed
                jT.setFont(tableFont);

                // Increase cell size
                int rowHeight = 50; // Set the row height as needed
                jT.setRowHeight(rowHeight);

                // Remove table background
                jT.setOpaque(false);
                jT.setBackground(new Color(0, 0, 0, 0)); // Transparent background

                // Remove JScrollPane background
                sp1.setOpaque(false);
                sp1.getViewport().setOpaque(false);

                // Set text color to black
                jT.setForeground(Color.BLACK);

                Border blackBorder = new LineBorder(Color.WHITE);

                // Set the header color and font
                JTableHeader header = jT.getTableHeader();
                header.setBackground(Color.BLUE);
                header.setForeground(Color.WHITE); // Set text color to white
                header.setFont(new Font("Candara", Font.BOLD, 18));

                // Remove cell borders
                jT.setShowGrid(false);
                jT.setIntercellSpacing(new Dimension(0, 0));

                sp1.setBorder(null);

                leftHalf.add(d1);
                leftHalf.add(ud1);
                leftHalf.add(ud2);
                leftHalf.add(ud3);
                leftHalf.add(ud4);
                leftHalf.add(ud5);
                leftHalf.add(ud6);

                rightHalf.add(d2);
                rightHalf.add(sp1);
                rightHalf.add(d3);
                rightHalf.add(ud9);
                rightHalf.add(ud10);
                rightHalf.add(d4);
                rightHalf.add(ud11);
                rightHalf.add(d5);
                // rightHalf.add(ud12);

                f1.add(leftHalf);
                f1.add(rightHalf);

                f1.setSize(1366, 768);
                f1.setResizable(false);
                f1.setLocationRelativeTo(null);
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f1.setLayout(null); // Set layout to null for absolute positioning
                f1.setVisible(true);

        }

}
