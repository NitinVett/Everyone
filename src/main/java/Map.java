import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;

public class Map extends JPanel {
        int [][] Area = new int[40][65]; //row , coloum
public void setMap(){
    for(int i=0; i <40; i++){
        for(int j=0; j<65; j++){
            if (i==38||i==0||j==63||j==0){
                Area[i][j]=1;

            }
            else {
                Area [i][j]=0;
            }

        }
    }

}
public int[][] getMap(){
return Area;
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon Grass1 = new ImageIcon("src\\New Piskel.png");
        ImageIcon GrassFloor = new ImageIcon("src\\New Piskel (2).png");
        super.paint(g);
        setMap();
        this.setBackground(Color.BLACK);
        for(int i = 0; i < 40;i++)
        {
            for (int j = 0; j < 65;j++)
            {
                if(Area[i][j]==0) {
                    g.drawImage(GrassFloor.getImage(),j*20,i*20,this);

                }
                else if(Area[i][j]==1) {
                    g.drawImage(Grass1.getImage(),j*20,i*20,this);

                }
            }

        }
    }
}

