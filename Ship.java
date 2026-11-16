// Vibu Ramineni
// Ship.java

public class Ship
{
    private int lenShip;
    private String name;
    private int posRow;
    private int posCol;
    private boolean horiz;
    private boolean[] isHit;

    // set up ship
    public Ship(int l, String n, int r, int c, boolean h)
    {
        lenShip = l;
        name = n;
        posRow = r;
        posCol = c;
        horiz = h;
        isHit = new boolean[lenShip];
    }

    // get ship length
    public int getLen()
    {
        return lenShip;
    }

    // get ship name
    public String getName()
    {
        return name;
    }

    // get starting row
    public int getRowPos()
    {
        return posRow;
    }

    // get starting column
    public int getColPos()
    {
        return posCol;
    }

    // get ship direction
    public boolean getHoriz()
    {
        return horiz;
    }

    // check if part was hit
    public boolean getHealth(int index)
    {
        return isHit[index];
    }

    // show ship information
    public String toString()
    {
        return ("Name: " + name + "\n Length: " + lenShip + "\n Coordinates: (" + posCol + ", " + posRow + ")\n Is horizontal: " + horiz);
    }
}
