import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Entity implements KeyListener {
    int velL,velR,velU,velD;
    int preX, preY;


    public Player(int x, int y)
    {
        super(x,y);

    }

    public void draw(Graphics g,int x,int y)
    {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,20,20);
    }

    public void update()
    {
        preX=x;
        preY=y;
        x += velR;
        x += velL;
//        if(velR!=0||velL!=0) {      no diaganol moving test #2
//            x += velR;
//            x += velL;
//        }
        y+=velU;
        y+=velD;
    }



    //we not using this just an implemented method
    public void keyTyped(KeyEvent e){}


    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode())
        {
            case 65:
                velL = -1;
//                velR = 0;     no diagonal moving test#1
//                velD = 0;
//                velU = 0;
                break;
            case 68:
                velR = 1;
//                velL = 0;     no diagonal moving test#1
//                velD = 0;
//                velU = 0;

                break;
            case 83:
                velU = 1;
//                velR = 0;     no diagonal moving test#1
//                velD = 0;
//                velL = 0;
                break;
            case 87:
                velD = -1;
//                velR = 0;     no diagonal moving test#1
//                velL = 0;
//                velU = 0;
                break;

        }

    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case 65:
                velL = 0;
                break;
            case 68:
                velR = 0;
                break;
            case 83:
                velU = 0;
                break;
            case 87:
                velD = 0;
                break;

        }
    }
}
