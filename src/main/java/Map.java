import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    //sets size of the map
    int[][] Area = new int[40][65];
    //loading images
    ImageIcon Grass1 = new ImageIcon(Map.class.getClassLoader().getResource("New Piskel.png"));
    ImageIcon GrassFloor = new ImageIcon(Map.class.getClassLoader().getResource("New Piskel (2).png"));

    //sets tile numbers of our 2d array
    public void setMap() {
        //cycles through each row
        for (int i = 0; i < 40; i++) {
            //cycles through each column
            for (int j = 0; j < 65; j++) {

                //sets to 1 or 0 based on location (1 = stone, 0 = grass)
                if (i == 39 || i == 0 || j == 64 || j == 0) {
                    Area[i][j] = 1;
                } else {
                    Area[i][j] = 0;
                }


            }

        }

    }

    //returns map
    public int[][] getMap() { return Area; }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //sets background to black (its drawn over usually)
        this.setBackground(Color.BLACK);

        //same for loop as setMap()
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 65; j++) {

                //prints different tile depending on number at index at 2d array
                if (Area[i][j] == 0) {
                    g.drawImage(GrassFloor.getImage(), j * 20, i * 20, this);

                }
                else if (Area[i][j] == 1) {
                    g.drawImage(Grass1.getImage(), j * 20, i * 20, this);

                }

            }

        }
    }
}

