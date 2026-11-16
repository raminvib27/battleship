// Vibu Ramineni
// GameBoard.java

public class GameBoard
{
    private Board shipsBoard;
    private Board guessesBoard;
    private Ship[] ships;

    // set up boards and ships
    public GameBoard()
    {
        shipsBoard = new Board();
        guessesBoard = new Board();
        ships = new Ship[5];
    }

    // get ships board
    public Board getShipsBoard()
    {
        return shipsBoard;
    }

    // get guesses board
    public Board getGuessesBoard()
    {
        return guessesBoard;
    }

    // get ship by index
    public Ship getShip(int index)
    {
        return ships[index];
    }

    // add ship to board
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
