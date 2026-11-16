// Vibu Ramineni
// Board.java

public class Board
{
    private String[][] squares;

    public Board()
    {
        squares = new String[10][10];
        for (int row = 0; row < 10; row++)
        {
            for (int col = 0; col < 10; col++)
            {
                squares[row][col] = "-";
            }
        }
    }

    public String toString()
    {
        String board = "";
        for (int row = 0; row < 10; row++)
        {
            for (int col = 0; col < 10; col++)
            {
                board += squares[row][col];
                if (col < 9)
                {
                    board += " ";
                }
            }
            if (row < 9)
            {
                board += "\n";
            }
        }
        return board;
    }

    public boolean addShip(int row, int col, int len, boolean horizontal)
    {
        if (row < 0 || row >= 10 || col < 0 || col >= 10 || len <= 0 || len > 10)
        {
            return false;
        }
        if ((horizontal && col + len > 10) || (!horizontal && row + len > 10))
        {
            return false;
        }
        for (int i = 0; i < len; i++)
        {
            int r = row;
            int c = col;
            if (horizontal)
            {
                c += i;
            }
            else
            {
                r += i;
            }
            if (!squares[r][c].equals("-"))
            {
                return false;
            }
        }
        for (int i = 0; i < len; i++)
        {
            if (horizontal)
            {
                squares[row][col + i] = "b";
            }
            else
            {
                squares[row + i][col] = "b";
            }
        }
        return true;
    }

    public boolean foundShip(int len)
    {
        if (len <= 0 || len > 10)
        {
            return false;
        }
        for (int row = 0; row < 10; row++)
        {
            int count = 0;
            for (int col = 0; col < 10; col++)
            {
                if (squares[row][col].equals("b"))
                {
                    count++;
                }
                else
                {
                    if (count == len)
                    {
                        return true;
                    }
                    count = 0;
                }
            }
            if (count == len)
            {
                return true;
            }
        }
        for (int col = 0; col < 10; col++)
        {
            int count = 0;
            for (int row = 0; row < 10; row++)
            {
                if (squares[row][col].equals("b"))
                {
                    count++;
                }
                else
                {
                    if (count == len)
                    {
                        return true;
                    }
                    count = 0;
                }
            }
            if (count == len)
            {
                return true;
            }
        }
        return false;
    }

    public int shoot(int row, int col)
    {
        if (row < 0 || row >= 10 || col < 0 || col >= 10)
        {
            return -1;
        }
        if (squares[row][col].equals("-"))
        {
            squares[row][col] = "m";
            return 0;
        }
        if (squares[row][col].equals("b"))
        {
            squares[row][col] = "x";
            return 1;
        }
        return 2;
    }

    public boolean gameOver()
    {
        for (int row = 0; row < 10; row++)
        {
            for (int col = 0; col < 10; col++)
            {
                if (squares[row][col].equals("b"))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
