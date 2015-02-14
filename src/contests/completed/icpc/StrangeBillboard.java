package contests.completed.icpc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Solves the strange billboard ACM problem.
 * 
 * Problem statement can be found here: 
 *    https://icpcarchive.ecs.baylor.edu/external/39/3953.pdf
 * The problem is essentially the famous "lights out" game on an arbitrary board size.
 * 
 * Solving the board is done by solving the system of linear equations defined by
 * Mx = b where M is the transformation matrix defined by touches in the game, x is the set 
 * of moves to make, and b is the final board state. Solutions are determined using 
 * Gauss-Jordan elimination on the transformation matrix.
 * 
 * @author Peijin Zhang
 */
public class StrangeBillboard
{   
  /**
   * Main solver function.
   */
  private void solve() throws IOException {
    int rows, cols;
    while ((rows = nextInt()) != 0 && (cols = nextInt()) != 0) {
      int[] board = readBoard(rows, cols);
      int tiles = solveBoard(rows, cols, board);
      if (tiles == -1) {
        out.format("Damaged billboard.%n");
      } else {
        out.format("You have to tap %d tiles.%n", tiles);
      }
    }
  }
  
  /**
   * Reads the input board into a single array in row major order.
   *    An ON light is represented with a 1. OFF is 0.
   * Assumes the input is well formatted, meaning that there are a total of 
   * rows lines and each line has cols characters that are either 'X' or '.'.
   */
  private int[] readBoard(int rows, int cols) throws IOException {
    int[] board = new int[rows * cols];
    for (int i = 0; i < rows; i++) {
      String line = nextLine();
      for (int j = 0; j < cols; j++) {
        board[i * cols + j] = (line.charAt(j) == 'X') ? 1 : 0;
      }
    }
    return board;
  }
  
  /**
   * Solves the given board. Return value is -1 if the board is not solvable, or
   * the minimum number of moves required to solve the board.
   */
  private static int solveBoard(int rows, int cols, int[] board) {
    int length = rows * cols;

    // Create the transformation matrix.
    int[][] transform = makeTransformMatrix(rows, cols);
    
    // Perform Gauss-Jordan elimination on transformation matrix.
    gaussJordan(transform, board);
    
    int rank = getRank(transform);
    
    /* Check if our system of equations is solvable.
     * Everything below rank in the row reduced matrix should be 0, so if board is non-zero,
     * that means one of our transformed equations is 0 = 1, which is impossible.
     */
    for (int i = rank; i < length; i++) {
      if (board[i] != 0) {
        return -1;
      }
    }
    
    /* Our board is solvable, so check all solutions and find the least moves needed.
     * Given x free positions, we will have 2^x possible solutions.
     */
    List<Integer> positions = getFreePositions(transform);
    int solutions = (int) Math.pow(2, positions.size());
    int minMoves = Integer.MAX_VALUE;
    for (int x = 0; x < solutions; x++) {
      // Fill a solution with our free variables and solve for the remainder.
      int[] solution = makeSolution(x, length, positions);
      solveSolution(transform, board, solution);
      minMoves = Math.min(minMoves, numMoves(solution));
    }
    return minMoves;
  }

  /**
   * Constructs the transform matrix given the specified dimensions.
   * The transform matrix is in the following format:
   *   
   *        B I 0 0 0          1 1 0 0 0          1 0 0 0 0
   *        I B I 0 0          1 1 1 0 0          0 1 0 0 0
   *   M =  0 I B I 0      B = 0 1 1 1 0      I = 0 0 1 0 0
   *        0 0 I B I          0 0 1 1 1          0 0 0 1 0
   *        0 0 0 I B          0 0 0 1 1          0 0 0 0 1
   *      
   * M is a rows * rows block matrix where each block is a cols * cols matrix.
   * B is a cols * cols matrix with 1 on the diagonal and all cells adjacent to it.
   * I is the cols * cols identity matrix.
   * 
   * The transform matrix M satisfies the property that Mx = b where x is a vector
   * representing the moves to make and b is a vector representing the resulting board.
   */
  private static int[][] makeTransformMatrix(int rows, int cols) {
    int length = rows * cols;
    int[][] transform = new int[length][length];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int diag = cols * i + j;
        transform[diag][diag] = 1;
        if (i > 0) {
          transform[diag][diag - cols] = 1;
        }
        if (i < rows - 1) {
          transform[diag][diag + cols] = 1;
        }
        if (j > 0) {
          transform[diag][diag - 1] = 1;
        }
        if (j < cols - 1) {
          transform[diag][diag + 1] = 1;
        }
      }
    }
    return transform;
  }
  
  /**
   * Performs Gauss-Jordan elimination on the given transformation matrix and board.
   * Both the matrix and board will be transformed by row operations. Matrix is assumed 
   * to be square and consisting of only 1's and 0's.
   */
  private static void gaussJordan(int matrix[][], int[] board) {
    int length = matrix.length;
    
    /* Iteratively constructs the row reduced form for the given matrix.
     * Invariant: The matrix to the top and left of (row, row) is in RREF form.
     */
    for (int row = 0; row < length; row++) {
      // Search for an entry in the matrix with a '1', searching down each column from (row, row).
      int nextrow = row;
      int col = row;
      while (col < length && matrix[nextrow][col] != 1) {
        nextrow++;
        if (nextrow == length) {
          // No entry is this column, check next one.
          col++;
          nextrow = row;
        }
      }
      if (col == length) {
        return;
      }

      // Swap our rows.
      swapRow(matrix, row, nextrow);
      swapElem(board, row, nextrow);

      // Set every element below row in col to be 0.
      for (int i = row + 1; i < length; i++) {
        if (matrix[i][col] != 0) {
          matrix[i][col] = 0;
          for (int j = col + 1; j < length; j++)
            matrix[i][j] = (matrix[i][j] + matrix[row][j]) % 2;
          board[i] = (board[i] + board[row]) % 2;
        }
      }
    }
  }
  
  /**
   * Creates a partial solution given the solution number and the positions of free variables.
   */
  private static int[] makeSolution(int sol, int length, List<Integer> positions) {
    int[] solution = new int[length];
    for (int x = 0; x < positions.size(); x++) {
      // Checks if the xth bit is set.
      if (((sol >> x) & 1) != 0) {
        solution[positions.get(x)] = 1;
      }
    }
    return solution;
  }
  
  /**
   * Given a partially filled solution, solves the remainder of it.
   * We want to fill solution such that transform * solution = board.
   * 
   * To fill the solution, we work upwards from the last row. Each step of the iteration 
   * satisfies the invariant that the solution value for all indices after the pivot is fixed,
   * and we use this to solve for the required value for the solution at the pivot point.
   */
  private static void solveSolution(int[][] transform, int[] board, int[] solution) {
    int length = transform.length;
    
    for (int row = length - 1; row >= 0; row--) {
      int index = -1;
      int sum = 0;
      for (int col = 0; col < length; col++) {
        // Search for the first non-zero element in this row (pivot), then solve for it.
        if (index == -1 && transform[row][col] != 0) {
          index = col;
        } else if (index != -1) {
          // We are after the pivot so start keeping track of the desired sum.
          sum += transform[row][col] * solution[col];
        }
      }
      if (index != -1) {
        // solution[index] must satisfy solution[index] + sum = board[index];
        solution[index] = (sum + board[index]) % 2;
      }
    }
  }
  
  /**
   * Gets the number of moves specified in a move vector.
   */
  private static int numMoves(int[] vector) {
    int moves = 0;
    for (int i : vector) {
      moves += i;
    }
    return moves;
  }
  
  /**
   * Finds the positions of the free variables given a row reduced transformation matrix.
   */
  private static List<Integer> getFreePositions(int[][] transform) {
    List<Integer> free = new ArrayList<Integer>();
    int row = 0;
    for (int col = 0; col < transform[0].length; col++) {
      if (transform[row][col] == 1) {
        row++;
      } else {
        free.add(col);
      }
    }
    return free;
  }
  
  /**
   * Gets the rank of a matrix in row reduced echelon form. 
   */
  private static int getRank(int[][] matrix) {
    int row = 0;
    for (int col = 0; col < matrix[0].length; col++) {
      if (matrix[row][col] == 1) {
        row++;
      }
    }
    return row;
  }
  
  /**
   * Swaps the ith and jth elements of a vector
   */
  private static void swapElem(int[] vector, int i, int j) {
    int temp = vector[i];
    vector[i] = vector[j];
    vector[j] = temp;
  }

  /**
   * Swaps the ith and jth rows of a matrix
   */
  private static void swapRow(int[][] matrix, int i, int j) {
    int temp;
    for (int k = 0; k < matrix[0].length; k++) {
      temp = matrix[i][k];
      matrix[i][k] = matrix[j][k];
      matrix[j][k] = temp;
    }
  }

  // Boilerplate IO and setup code.
  
  private BufferedReader br;
  private StringTokenizer st;
  private PrintWriter out;

  private String nextToken() throws IOException {
    while (st == null || !st.hasMoreTokens()) {
      st = new StringTokenizer(br.readLine());
    }
    return st.nextToken();
  }

  private String nextLine() throws IOException {
    return br.readLine();
  }

  private int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  public void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
    solve();
    out.flush();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    new StrangeBillboard().run();
  }
}
