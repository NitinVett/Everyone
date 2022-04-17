import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Screen extends JFrame{
    Map map = new Map();//object

    //starting screen
    public void setScreen()
    {
        JPanel panel = new JPanel();

        this.setBounds(0,0,1300,820);
        this.setVisible(true);
        this.setTitle("28");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.GRAY);
       // this.getContentPane().setLayout(null);
        this.add(panel);


    }

    public void Menu()
    {
        JButton button = new JButton();
        button.setBounds(450,300,400,200);
        JLabel background = new JLabel();
        background.setBounds(200,200,1300,820);
        button.setFont(new Font("Courier", Font.BOLD, 50));
        this.setLocationRelativeTo(null);
        button.setText("Play");
        background.setVisible(true);
        button.setVisible(true);
        this.add(button);
        this.add(background);
        button.addActionListener(e -> {
        this.getContentPane().removeAll();//removes everything
        button.setVisible(false);
        this.repaint();//refresh
            drawMap();
            validate();//gives the hint
        });
    }




    public void drawMap()
    {
        System.out.println("lol");
       // this.remove(panel);
        this.add(map);
        this.repaint();
    }
}