package Code;

public class KnightTester {
    public static void main(String[] args) {
        LinkedGrid board = new LinkedGrid(5); // Create a 5x5 board
        board.display(); // Display the initial board
        board.createPaths(); // Create movement paths for the knight
        board.startTour(); // Start the knight's tour algorithm
    }
}
