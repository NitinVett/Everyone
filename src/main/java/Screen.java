import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Screen extends JFrame{
    Map map = new Map();//object
    JPanel panel = new JPanel();
    //starting screen
    public void setScreen()
    {

        this.setBounds(0,0,1300,820);
        this.setVisible(true);
        this.setTitle("28");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
       // this.getContentPane().setLayout(null);
        this.add(panel);


    }

    public void Menu()
    {
        JButton button = new JButton();
        button.setBounds(450,300,400,200);
        button.setFont(new Font("Courier", Font.BOLD, 50));
        button.setText("Play");
        button.setVisible(true);
        panel.add(button);
        button.addActionListener(e -> {
            this.getContentPane().removeAll();//removes everything
            button.setVisible(false);
            drawMap();
            validate();
        });
    }




    public void drawMap()
    {
        this.add(map);

    }
}