package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SpaceTurtle {
  static class Turtle {
    private enum Direction {
      POSX, NEGX, POSY, NEGY, POSZ, NEGZ;
    }
    
    private int x, y, z;
    private double minDist;
    private Planet target;
    private Direction dir;
    private Map<Character, Direction> dirMap;
    
    public Turtle(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.dirMap = new HashMap<Character, Direction>();
      
      this.dir = Direction.POSX;
      dirMap.put('L', Direction.POSY);
      dirMap.put('R', Direction.NEGY);
      dirMap.put('U', Direction.POSZ);
      dirMap.put('D', Direction.NEGZ);
    }
    
    public void move(int units) {
      switch (dir) {
      case POSX:
        for (int i = 0; i < units; i++) {
          this.x++;
          minDist = Math.min(minDist, target.distance(x, y, z));
        }
        break;
      case NEGX:
        for (int i = 0; i < units; i++) {
          this.x--;
          minDist = Math.min(minDist, target.distance(x, y, z));
        }
        break;
      case POSY:
        for (int i = 0; i < units; i++) {
          this.y++;
          minDist = Math.min(minDist, target.distance(x, y, z));
        }
        break;
      case NEGY:
        for (int i = 0; i < units; i++) {
          this.y--;
          minDist = Math.min(minDist, target.distance(x, y, z));
        }
        break;
      case POSZ:
        for (int i = 0; i < units; i++) {
          this.z++;
          minDist = Math.min(minDist, target.distance(x, y, z));
        }
        break;
      case NEGZ:
        for (int i = 0; i < units; i++) {
          this.z--;
          minDist = Math.min(minDist, target.distance(x, y, z));
        }
        break;
      }
    }
    
    public void turn(char turn) {
      switch (turn) {
      case 'L':
        dirMap.put('R', dir);
        this.dir = dirMap.get('L');
        dirMap.put('L', flip(dirMap.get('R')));
        break;
      case 'R': 
        dirMap.put('L', dir);
        this.dir = dirMap.get('R');
        dirMap.put('R', flip(dirMap.get('L')));
        break;
      case 'U':
        dirMap.put('D', dir);
        this.dir = dirMap.get('U');
        dirMap.put('U', flip(dirMap.get('D')));
        break;
      case 'D':
        dirMap.put('U', dir);
        this.dir = dirMap.get('D');
        dirMap.put('D', flip(dirMap.get('U')));
        break;
      }
    }
    
    public double getDist() {
      return minDist;
    }
    
    public Direction flip(Direction d) {
      switch (d) {
      case POSX: return Direction.NEGX;
      case NEGX: return Direction.POSX; 
      case POSY: return Direction.NEGY;
      case NEGY: return Direction.POSY; 
      case POSZ: return Direction.NEGZ;
      case NEGZ: return Direction.POSZ;       
      }
      return null;
    }
    
    public void targetPlanet(Planet target) {
      this.target = target;
      this.minDist = target.distance(x, y, z);
    }
  }
  
  static class Planet {
    private int x, y, z;
    
    public Planet(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
    
    public double distance(int xco, int yco, int zco) {
      return Math.sqrt(Math.pow(x - xco, 2) + Math.pow(y - yco, 2) + Math.pow(z - zco, 2));
    }
  }
  
  public void solve() throws IOException {
    Turtle turtle = new Turtle(nextInt(), nextInt(), nextInt());
    turtle.targetPlanet(new Planet(nextInt(), nextInt(), nextInt()));
    
    boolean end = false;
    while (!end) {
      int moves = nextInt();
      char turn = nextToken().charAt(0);
      
      turtle.move(moves);
      if (turn == 'E') {
        end = true;
      } else {
        turtle.turn(turn);
      }
    }
    
    System.out.format("%.2f%n", turtle.getDist());
  }

  public BufferedReader br;
  public StringTokenizer st;
  public PrintWriter out;

  public String nextToken() throws IOException {
    while (st == null || !st.hasMoreTokens()) {
      st = new StringTokenizer(br.readLine());
    }

    return st.nextToken();
  }

  public String nextLine() throws IOException {
    return br.readLine();
  }

  public int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  public long nextLong() throws IOException {
    return Long.parseLong(nextToken());
  }

  public double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  public void run() throws IOException {
    boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    oj = true;
    br = new BufferedReader(
        new InputStreamReader(oj ? System.in : new FileInputStream("input.txt")));
    out = new PrintWriter(oj ? System.out : new FileOutputStream("output.txt"));
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    new SpaceTurtle().run();
  }
}
