import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Map extends JPanel implements ActionListener {
    //sets size of the map
    Tile[][] Area = new Tile[1100][1100];
    Tile[][] ogMap=new Tile[1100][1100];
    //loading images
    static ImageIcon Stone = new ImageIcon(Map.class.getClassLoader().getResource("New Piskel.png"));
    static ImageIcon GrassFloor = new ImageIcon(Map.class.getClassLoader().getResource("New Piskel (2).png"));
    static ImageIcon FlowerFloor= new ImageIcon(Map.class.getClassLoader().getResource("New Piskel-3.png.png"));
    static Image grass[] = {GrassFloor.getImage(),FlowerFloor.getImage()};
    Timer mainTimer;
    Player p;
    public Map(Player p)
    {
        setFocusable(true);
        this.p=p;
        addKeyListener(this.p);
        mainTimer = new Timer(20,this);

    }

    //entrance to maze
    public void setEntrance(boolean a) {
        if (a) {
            //left slit
            for (int i = 0; i < 5; i++) {
                for (int j=0;j<25;j++)
                {

                    if(i==0||i==4)
                    {
                        Area[400-j][948 + i] = new Tile(Stone.getImage(),400-j,948+i);
                        Area[400-j][948 + i].setBarrier(true);
                    }
                    else
                    {
                        Area[400-j][948 + i] = new Tile(GrassFloor.getImage(),400-j,948+i);
                    }
                }


            }
            //right slit
            for (int i = 0; i < 5; i++) {
                for (int j=0;j<25;j++)
                {
                    Area[600+j][948 + i] = new Tile(Stone.getImage(),600+j,948+i);
                }
            }

            //top slit
            for (int i = 0; i < 5; i++) {
                for (int j=0;j<25;j++)
                {
                    Area[498 + i][850-j] = new Tile(Stone.getImage(),498+i,850-j);

                }
            }

        } else {
            //left slit
            for (int i = 0; i < 5; i++) {
                Area[400][948 + i] = new Tile(Stone.getImage(),400,948+i);
                Area[400][948 + i].setBarrier(true);
            }
            //right slit
            for (int i = 0; i < 5; i++) {
                Area[599][948 + i] = new Tile(Stone.getImage(),599,948+i);
                Area[599][948 + i].setBarrier(true);
            }
            //top slit
            for (int i = 0; i < 5; i++) {
                Area[498 + i][850] = new Tile(Stone.getImage(),498+i,850);
                Area[498 + i][850].setBarrier(true);
            }

        }
    }
    //sets walls up for home area
    public void setBorder(boolean a)
    {
        if(a) {
            for (int i = 850; i <= 1050; i++) {
                Area[400][i] = new Tile(Stone.getImage(),400,i);
                Area[400][i].setBarrier(true);
                Area[600][i] = new Tile(Stone.getImage(),600,i);
                Area[600][i].setBarrier(true);

            }
            for (int i = 400; i < 600; i++) {
                Area[i][850] = new Tile(Stone.getImage(),i,850);
                Area[i][850].setBarrier(true);

            }
        }
        else
        {
            for (int i = 800; i < 1000; i++) {
                Area[400][i] = new Tile(grass[ThreadLocalRandom.current().nextInt(0, grass.length)],400,i);
                Area[599][i] = new Tile(grass[ThreadLocalRandom.current().nextInt(0, grass.length)],599,i);

            }
            for (int i = 400; i < 600; i++) {
                Area[i][800] = new Tile(grass[ThreadLocalRandom.current().nextInt(0, grass.length)],i,800);
                Area[i][999] = new Tile(grass[ThreadLocalRandom.current().nextInt(0, grass.length)],i,999);
            }
        }
    }

    //sets tile numbers of our 2d array
    public void setMap() {
        //cycles through each row
        for (int i = 0; i < 1100; i++) {
            //cycles through each column
            for (int j = 0; j < 1100; j++) {
                if(i<50||i>1049||j<50||j>1049)
                {
                    Area[j][i] = new Tile(Stone.getImage(),j,i);
                    Area[j][i].setBarrier(true);
                }
                else
                {
                    Area[j][i] = new Tile(grass[ThreadLocalRandom.current().nextInt(0, grass.length)],j,i);
                    Area[j][i].setVisited(true);
                }

            }

        }
        setBorder(true);
        setEntrance(true);
        mainTimer.start();

    }


    //returns map
    public Tile[][] getMap() {
        return Area;
    }

    //paints the map onto the players screen
    public void paintMap(Graphics g)
    {
        int countX=0;
        int countY=0;
        //following camera
        ArrayList<Tile> screenBorder = new ArrayList<>();
        for (int i = p.y-20; i < p.y+20; i++) {
            for (int j = p.x-32; j < p.x+33; j++) {
                if(Area[j][i].getBarrier())
                {
                    screenBorder.add(Area[j][i]);
                }
            }
        }
        for (int i = p.y-20; i < p.y+20; i++) {
            for (int j = p.x-32; j < p.x+33; j++) {
                boolean found = false;
                Line2D s = new Line2D.Float(Area[p.x][p.y].getmidx(),Area[p.x][p.y].getmidy(),Area[j][i].getmidx(),Area[j][i].getmidy());
                if(!screenBorder.contains(Area[j][i])) {
                    for (int k = 0; k < screenBorder.size(); k++) {
                        if (s.intersects(screenBorder.get(k).getRectangle())) {
                            g.setColor(Color.BLACK);
                            g.fillRect(countX * 20, countY * 20, 20, 20);
                            found = true;

                            break;
                        }

                    }
                    if (!found) {
                        Area[j][i].drawTile(g, countX * 20, countY * 20, this);
                    }
                }
                else {
                    Area[j][i].drawTile(g, countX * 20, countY * 20, this);
                }
                g.setColor(Color.black);

                countX++;
            }
            countX=0;
            countY++;
        }

    }


    @Override
    //paint method for jpanel
    public void paint(Graphics g) {
        super.paint(g);
        //sets background to black (its drawn over usually)
        paintMap(g);

    }

    @Override
    //timer method
    public void actionPerformed(ActionEvent e) {
        //Area is map with player, ogMap is map without player, ogMap keep track of all tiles
        Area[p.x][p.y].setPlayerTile(false);
        p.update();
        System.out.println(p.x + " " + p.y);

        if(Area[p.x][p.y].getBarrier()){
            p.x=p.preX;
            p.y=p.preY;
        }
        //get player cord and set == to 2 on array
        Area[p.x][p.y].setPlayerTile(true);

        repaint();
    }
}

