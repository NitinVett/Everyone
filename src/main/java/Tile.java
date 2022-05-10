import java.awt.*;
import java.awt.image.ImageObserver;


public class Tile {
    private Image tileImage;
    private boolean playerTile;
    private boolean barrier;
    private boolean visited;
    private final int x;
    private final int y;
    private int midx;
    private int midy;
    Rectangle r = new Rectangle();

    public Tile(Image n,int x,int y)
    {
        this.x=x;
        this.y=y;
        tileImage = n;
        barrier = false;
        playerTile = false;
        r.setBounds(x*20,y*20,20,20);
        midx = (x*20)+10;
        midy = (y*20)+10;
    }

    public void drawTile(Graphics g, int x, int y, ImageObserver s)
    {
        if(playerTile)
        {
            g.setColor(Color.BLUE);
            g.fillRect(x,y,20,20);
        }
        else
        {
            g.drawImage(tileImage, x, y, s);
        }

    }

    public Rectangle getRectangle()
    {
        return r;
    }

    public int getmidx()
    {
        return midx;
    }
    public int getmidy()
    {
        return midy;
    }

    public int getX()
    {
        return x*20;
    }

    public int getY()
    {
        return y*20;
    }

    public void setPlayerTile(boolean a)
    {
        playerTile = a;
    }

    public boolean getPlayerTile()
    {
        return playerTile;
    }

    public void setBarrier(boolean a)
    {
        barrier = a;
    }

    public boolean getBarrier()
    {
        return barrier;
    }

    public boolean getVisited()
    {
        return visited;
    }

    public void setVisited(boolean a)
    {
        visited = a;
    }

    public void clearCube(Tile[][] t)
    {
        for(int j = x-2;j<x+3;j++)
        {
            for(int i = y-2;i<y+3;i++)
            {
                if(i==y-2||i==y+2||j==x-2||j==x+2) {
                    t[j][i] = new Tile(Map.Stone.getImage(), j, i);
                    t[j][i].visited = true;
                }
                else {
                    t[j][i] = new Tile(Map.FlowerFloor.getImage(), j, i);
                    t[j][i].visited = true;
                }
            }
        }
    }

    public void clearCubeWalls(Tile[][] t, String direction)
    {
        switch (direction)
        {
            case "left":
                for (int i=0;i<5;i++)
                {
                    t[x-2][y-2+i] = new Tile(Map.FlowerFloor.getImage(),x-2,y-2+i);
                }
                break;
            case "right":
                for (int i=0;i<5;i++)
                {
                    t[x+2][y-2+i] = new Tile(Map.FlowerFloor.getImage(),x+2,y-2+i);
                }
                break;
            case "up":
                for (int i=0;i<5;i++)
                {
                    t[x-2+i][y-2] = new Tile(Map.FlowerFloor.getImage(),x-2+i,y-2);
                }
                break;
            case "down":
                for (int i=0;i<5;i++)
                {
                    t[x-2+i][y+2] = new Tile(Map.FlowerFloor.getImage(),x-2+i,y+2);
                }
                break;
        }
    }
}
