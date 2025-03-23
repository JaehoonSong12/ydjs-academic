package jayden.app;

import jayden.app.login_controller.LoginController;
import jayden.app.login_view.LoginView;
import javax.swing.SwingUtilities;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;


public class Gui {
    public static void main(String[] args) {
       // SwingUtilities.invokeLater(() -> {
       //      LoginModel model = new LoginModel();
       //      LoginView view = new LoginView();
       //      new LoginController(model, view);
       //     view.setVisible(true);
       //  });
    //    TicTacToe tictactoe = new TicTacToe();




        // jaydenTemplate();
        // SwingTemplateApp.main(args);
        SwingUtilities.invokeLater(() -> new MainFrame());
        // jaydenTemp_2();

    }

    public static void jaydenTemplate() {
        
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1)); // 1 row, 2 columns
        northPanel.add(bluePanel);
        northPanel.add(redPanel);

        //// 2x2
        //// 
        //// o  o 
        //// o  o

        
        //// 1x2
        //// 
        //// o(blue)  o(red) 
        //// 


        
        //// 2x1
        //// 
        //// o(blue)   
        //// o(red)


        JPanel middlePanel = new JPanel();
        middlePanel.setBackground(Color.yellow);

        JPanel middlePanel_1 = new JPanel();
        middlePanel_1.setBackground(Color.blue);
        // Yellow Panel (full height below)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2)); // 1 row, 2 columns
        centerPanel.add(middlePanel);
        centerPanel.add(middlePanel_1);
        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(Color.black);
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.black);
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.gray);



        // Root Panel (uses BorderLayout)
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        rootPanel.add(northPanel, BorderLayout.NORTH); // Blue & Red at top
        rootPanel.add(centerPanel, BorderLayout.CENTER); // Yellow takes remaining space
        rootPanel.add(eastPanel, BorderLayout.EAST);
        rootPanel.add(westPanel, BorderLayout.WEST);
        rootPanel.add(southPanel, BorderLayout.SOUTH);


        // Frame Setup
        JFrame frame = new JFrame("Swing Window");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rootPanel);
        frame.setVisible(true);
    }





    
    public static void jaydenTemp_2() {
        ImageIcon image = new ImageIcon("src/main/java/jayden/app/Png.png");
        ImageIcon image2 = new ImageIcon("src/main/java/jayden/app/Png.png");
        Border border = BorderFactory.createLineBorder(Color.green,10);
    
    
        JLabel label = new JLabel();
        label.setText("Wsg bro!");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MV Boli",Font.PLAIN,20));
        label.setIconTextGap(-30);
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setBorder(border);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(0,0,500,500);
    
    
        JLabel label_two = new JLabel();
        label_two.setText("Good, U?");
        label_two.setIcon(image2);
        label_two.setHorizontalTextPosition(JLabel.CENTER);
        label_two.setVerticalTextPosition(JLabel.BOTTOM);
        label_two.setForeground(new Color(0x00FF00));
        label_two.setFont(new Font("MV Boli",Font.PLAIN,20));
        label_two.setIconTextGap(-30);
        label_two.setBackground(Color.white);
        label_two.setOpaque(true);
        label_two.setBorder(border);
        label_two.setHorizontalAlignment(JLabel.CENTER);
        label_two.setVerticalAlignment(JLabel.CENTER);
        label_two.setBounds(500,0,500,500);
    
    
    
    
       
       
    
    
        JFrame frame = new JFrame("Swing Window");
        //frame.setTitle("HI");
        frame.setSize(1020, 540); //size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //yeah
        //frame.setLayout(null);
        frame.setVisible(true); //make frame visible
        frame.add(label);
        frame.add(label_two);
        //frame.pack();
    
    
    
    
    }
}