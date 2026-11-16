// Vibu Ramineni
// Battleship.java

import java.util.Scanner;

public class Battleship
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Board board = new Board();
        boolean playing = false;
        System.out.println("Welcome to Battleship!");

        while (true)
        {
            if (playing)
            {
                System.out.println("Press \"s\" to shoot at a square, \"b\" to see the board, \"q\" to quit");
            }
            else
            {
                System.out.println("Type \"a\" to add new ship, \"b\" to see the board, \"p\" to play or \"q\" to quit.");
            }
            if (!input.hasNext())
            {
                break;
            }
            String choice = input.next();
            if (choice.equals("q"))
            {
                break;
            }
            else if (choice.equals("b"))
            {
                System.out.println(board);
            }
            else if (!playing && choice.equals("a"))
            {
                System.out.println("Starting in which row?");
                int row = readNumber(input);
                System.out.println("Starting in which column?");
                int col = readNumber(input);
                System.out.println("How long?");
                int len = readNumber(input);
                System.out.println("Horizontal (h) or vertical (v)?");
                if (!input.hasNext())
                {
                    break;
                }
                String direction = input.next();
                boolean horizontal = direction.equals("h");
                if ((horizontal || direction.equals("v")) && board.addShip(row, col, len, horizontal))
                {
                    System.out.println("New ship added!");
                }
                else
                {
                    System.out.println("Could not add ship. Try again.");
                }
            }
            else if (!playing && choice.equals("p"))
            {
                if (board.foundShip(3) && board.foundShip(4))
                {
                    playing = true;
                    System.out.println("Ok, let's play!");
                }
                else
                {
                    System.out.println("You need ships of length 3 and 4 to play!");
                }
            }
            else if (playing && choice.equals("s"))
            {
                System.out.println("Input row");
                int row = readNumber(input);
                System.out.println("Input column");
                int col = readNumber(input);
                int result = board.shoot(row, col);
                if (result == -1)
                {
                    System.out.println("That square is outside the board.");
                }
                else if (result == 0)
                {
                    System.out.println("Miss!");
                }
                else if (result == 1)
                {
                    System.out.println("Hit!");
                    if (board.gameOver())
                    {
                        System.out.println("Game over!");
                        break;
                    }
                }
                else
                {
                    System.out.println("You already tried that");
                }
            }
            else
            {
                System.out.println("Please choose one of the listed options.");
            }
        }
        input.close();
    }

    public static int readNumber(Scanner input)
    {
        while (input.hasNext() && !input.hasNextInt())
        {
            System.out.println("Please enter a number.");
            input.next();
        }
        if (!input.hasNextInt())
        {
            return -1;
        }
        return input.nextInt();
    }
}
