// Vibu Ramineni
// GameBoard.java

public class GameBoard
{
    private Board shipsBoard;
    private Board guessesBoard;
    private Ship[] ships;

    public GameBoard()
    {
        shipsBoard = new Board();
        guessesBoard = new Board();
        ships = new Ship[5];
    }

    public Board getShipsBoard()
    {
        return shipsBoard;
    }

    public Board getGuessesBoard()
    {
        return guessesBoard;
    }

    public Ship getShip(int index)
    {
        return ships[index];
    }

    public boolean addShip(Ship ship, int index)
    {
        if (ship == null || index < 0 || index >= ships.length || ships[index] != null)
        {
            return false;
        }
        if (shipsBoard.addShip(ship.getRowPos(), ship.getColPos(), ship.getLen(), ship.getHoriz()))
        {
            ships[index] = ship;
            return true;
        }
        return false;
    }
}
