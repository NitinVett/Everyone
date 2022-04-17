import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Screen extends JFrame{
    //creating map object and panel object
    Map map = new Map();
    JPanel panel = new JPanel();
    //starting screen
    public void setScreen()
    {
        //set frame size and location
        this.setBounds(0,0,1300,800);
        //set screen to center
        this.setLocationRelativeTo(null);
        //set contentpanes dimensions (gets rid of having to account for frame's border)
        this.getContentPane().setPreferredSize(new Dimension(1300, 800));
        //adjusts the frame to fit the content pane
        this.pack();
        //frame set to visible
        this.setVisible(true);
        //set title of frame 28
        this.setTitle("28");
        //allows you to close out of jframe
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //doesn't allow you to adjust the size of frame
        this.setResizable(false);
        //sets panel(menu) background to gray
        panel.setBackground(Color.GRAY);
        //sets panel layout to null
        panel.setLayout(null);
        //adds panel to jframe
        this.add(panel);



    }

    public void Menu()
    {
        //creates new button for menu
        JButton play = new JButton();
        //set location and size of button
        play.setBounds(450,300,400,200);
        //changes font of text on button
        play.setFont(new Font("Courier", Font.BOLD, 50));
        //sets button text to "Play"
        play.setText("Play");
        //sets button to visisble
        play.setVisible(true);
        //adding button to menu
        panel.add(play);
        //play button action listener
        play.addActionListener(e -> {
            //removes everything
            this.getContentPane().removeAll();
            //draws map
            drawMap();
            //refreshes screen
            validate();
        });
    }




    public void drawMap()
    {
        //calls on set map function from Map class to set the tile numbers in the 2d array
        map.setMap();
        //Map extends JPanel so we directly add it to our frame
        this.add(map);

    }
}