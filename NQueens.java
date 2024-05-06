public class NQueens {


    public static void solveNQueens(int n) {
       
        int[] queens = new int[n];
     
        solve(queens, 0, n);
    }

    private static void solve(int[] queens, int row, int n) {
   
        if (row == n) {
  
            printQueens(queens);
            return;
        }
      
        for (int col = 0; col < n; col++) {
            boolean isValid = true;
           
            for (int i = 0; i < row; i++) {
               
                if (queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i])) {
                    isValid = false;
                    break;
                }
            }
  
            if (isValid) {
             
                queens[row] = col;
                
                solve(queens, row + 1, n);
            }
        }
    }

   
    private static void printQueens(int[] queens) {
        int n = queens.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                System.out.print(queens[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
        
        System.out.println();
    }

    
    public static void main(String[] args) {
        int n = 4; 
        solveNQueens(n);
    }
}
