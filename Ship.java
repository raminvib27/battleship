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

    public Ship(int l, String n, int r, int c, boolean h)
    {
        lenShip = l;
        name = n;
        posRow = r;
        posCol = c;
        horiz = h;
        isHit = new boolean[lenShip];
    }

    public int getLen()
    {
        return lenShip;
    }

    public String getName()
    {
        return name;
    }

    public int getRowPos()
    {
        return posRow;
    }

    public int getColPos()
    {
        return posCol;
    }

    public boolean getHoriz()
    {
        return horiz;
    }

    public boolean getHealth(int index)
    {
        return isHit[index];
    }

    public String toString()
    {
        return ("Name: " + name + "\n Length: " + lenShip + "\n Coordinates: (" + posCol + ", " + posRow + ")\n Is horizontal: " + horiz);
    }
}
