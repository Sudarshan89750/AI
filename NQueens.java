public class NQueens {

    // Main function to solve the N Queens problem
    public static void solveNQueens(int n) {
        // Array to store column positions of queens in each row
        int[] queens = new int[n];
        // Call the solve function to find solutions recursively
        solve(queens, 0, n);
    }

    // Recursive function to place queens and solve the N Queens problem
    private static void solve(int[] queens, int row, int n) {
        // Base case: If all queens are placed (reached the last row)
        if (row == n) {
            // Print the current arrangement of queens
            printQueens(queens);
            return;
        }
        // Loop through each column in the current row
        for (int col = 0; col < n; col++) {
            boolean isValid = true;
            // Check if placing a queen at this position is valid
            for (int i = 0; i < row; i++) {
                // Check if the queen is threatened by another queen in the same column or diagonals
                if (queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i])) {
                    isValid = false;
                    break;
                }
            }
            // If placing a queen at this position is valid
            if (isValid) {
                // Place the queen at this position
                queens[row] = col;
                // Move to the next row recursively
                solve(queens, row + 1, n);
            }
        }
    }

    // Function to print the arrangement of queens on the chessboard
    private static void printQueens(int[] queens) {
        int n = queens.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Print 'Q' if there is a queen at this position, otherwise print '.'
                System.out.print(queens[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
        // Print a new line to separate different solutions
        System.out.println();
    }

    // Main method to start the program
    public static void main(String[] args) {
        int n = 4; // Change n to desired board size
        solveNQueens(n); // Call the function to solve the N Queens problem
    }
}