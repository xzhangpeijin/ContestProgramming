package contests.completed.usaco;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Marathon {
  static class Point {
    public final int x, y;
    
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
    
    public int dist(Point p) {
      return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
  }
  

  public class SegmentTree
  {
    private int[] tree;
    private int maxsize;
    private int height;

    private  final int STARTINDEX; 
    private  final int ENDINDEX;
    private  final int ROOT = 0;

    public SegmentTree(int size)
    {
      height = (int)(Math.ceil(Math.log(size) /  Math.log(2)));
      maxsize = 2 * (int) Math.pow(2, height) - 1;
      tree = new int[maxsize];
      STARTINDEX = 0;
      ENDINDEX = size - 1; 
    }

    private int leftchild(int pos)
    {
      return 2 * pos + 1;
    }

    private int rightchild(int pos)
    {
      return 2 * pos + 2;
    }

    private int mid(int start, int end)
    {
      return (start + (end - start) / 2); 
    }

    private int getSumUtil(int startIndex, int endIndex, int queryStart, int queryEnd, int current)
    {
      if (queryStart <= startIndex && queryEnd >= endIndex )
      {
        return tree[current];
      }
      if (endIndex < queryStart || startIndex > queryEnd)
      {
        return 0;
      }
      int mid = mid(startIndex, endIndex);
      return  getSumUtil(startIndex, mid, queryStart, queryEnd, leftchild(current)) 
          + getSumUtil( mid + 1, endIndex, queryStart, queryEnd, rightchild(current));
    }

    public int getSum(int queryStart, int queryEnd)
    {
      if(queryStart < 0 || queryEnd > tree.length)
      {
        return -1;
      }
      return getSumUtil(STARTINDEX, ENDINDEX, queryStart, queryEnd, ROOT);
    }

    private int constructSegmentTreeUtil(int[] elements, int startIndex, int endIndex, int current)
    {
      if (startIndex == endIndex)
      {
        tree[current] = elements[startIndex];
        return tree[current]; 
      }
      int mid = mid(startIndex, endIndex);
      tree[current] = constructSegmentTreeUtil(elements, startIndex, mid, leftchild(current))
          + constructSegmentTreeUtil(elements, mid + 1, endIndex, rightchild(current));
      return tree[current];
    }

    public void constructSegmentTree(int[] elements)
    {
      constructSegmentTreeUtil(elements, STARTINDEX, ENDINDEX, ROOT); 
    }

    private void updateTreeUtil(int startIndex, int endIndex, int updatePos, int update, int current)
    {
      if ( updatePos < startIndex || updatePos > endIndex)
      {
        return;
      }
      tree[current] = tree[current] + update;
      if (startIndex != endIndex)
      {
        int mid = mid(startIndex, endIndex);
        updateTreeUtil(startIndex, mid, updatePos, update, leftchild(current));
        updateTreeUtil(mid+1, endIndex, updatePos, update, rightchild(current));
      }
    }

    public void update(int update, int updatePos, int[] elements)
    {
      int updatediff = update - elements[updatePos]  ;
      elements[updatePos] = update;
      updateTreeUtil(STARTINDEX, ENDINDEX, updatePos, updatediff, ROOT);
    }
  }
  
  public class MaxTree
  {
    private int[] tree;
    private int maxsize;
    private int height;

    private  final int STARTINDEX = 0; 
    private  final int ENDINDEX;
    private  final int ROOT = 0;

    public MaxTree(int size)
    {
      height = (int)(Math.ceil(Math.log(size) /  Math.log(2)));
      maxsize = 2 * (int) Math.pow(2, height) - 1;
      tree = new int[maxsize];
      ENDINDEX = size - 1; 
    }

    private int leftchild(int pos)
    {
      return 2 * pos + 1;
    }

    private int rightchild(int pos)
    {
      return 2 * pos + 2;
    }

    private int mid(int start, int end)
    {
      return (start + (end - start) / 2); 
    }

    private int getSumUtil(int startIndex, int endIndex, int queryStart, int queryEnd, int current)
    {
      if (queryStart <= startIndex && queryEnd >= endIndex )
      {
        return tree[current];
      }
      if (endIndex < queryStart || startIndex > queryEnd)
      {
        return 0;
      }
      int mid = mid(startIndex, endIndex);
      return  Math.max(getSumUtil(startIndex, mid, queryStart, queryEnd, leftchild(current)),
          getSumUtil( mid + 1, endIndex, queryStart, queryEnd, rightchild(current)));
    }

    public int getSum(int queryStart, int queryEnd)
    {
      if(queryStart < 0 || queryEnd > tree.length)
      {
        return 0;
      }
      return getSumUtil(STARTINDEX, ENDINDEX, queryStart, queryEnd, ROOT);
    }

    private int constructSegmentTreeUtil(int[] elements, int startIndex, int endIndex, int current)
    {
      if (startIndex == endIndex)
      {
        tree[current] = elements[startIndex];
        return tree[current]; 
      }
      int mid = mid(startIndex, endIndex);
      tree[current] = Math.max(constructSegmentTreeUtil(elements, startIndex, mid, leftchild(current)),
          constructSegmentTreeUtil(elements, mid + 1, endIndex, rightchild(current)));
      return tree[current];
    }

    public void constructSegmentTree(int[] elements)
    {
      constructSegmentTreeUtil(elements, STARTINDEX, ENDINDEX, ROOT); 
    }

    private void updateTreeUtil(int startIndex, int endIndex, int updatePos, int update, int current)
    {
      if ( updatePos < startIndex || updatePos > endIndex)
      {
        return;
      }
      tree[current] = Math.max(tree[current], update);
      if (startIndex != endIndex)
      {
        int mid = mid(startIndex, endIndex);
        updateTreeUtil(startIndex, mid, updatePos, update, leftchild(current));
        updateTreeUtil(mid+1, endIndex, updatePos, update, rightchild(current));
      }
    }

    public void update(int update, int updatePos, int[] elements)
    {
      int updatediff = update - elements[updatePos]  ;
      elements[updatePos] = update;
      updateTreeUtil(STARTINDEX, ENDINDEX, updatePos, updatediff, ROOT);
    }
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    int q = nextInt();
    
    int[] distmap = new int[n];
    int[] skips = new int[n];

    Point[] points = new Point[n];
    for (int x = 0; x < n; x++) {
      points[x] = new Point(nextInt(), nextInt());
      if (x != 0) {
        distmap[x] = points[x].dist(points[x - 1]);
      }
    }
    for (int x = 1; x < n - 1; x++) {
      skips[x] = distmap[x + 1] + distmap[x] - points[x + 1].dist(points[x - 1]);
    }
    
    SegmentTree distance = new SegmentTree(n);
    distance.constructSegmentTree(distmap);
    MaxTree skip = new MaxTree(n);
    skip.constructSegmentTree(skips);
    
    for (int x = 0; x < q; x++) {
      String type = nextToken();
      if (type.equals("U")) {
        int i = nextInt() - 1;
        points[i] = new Point(nextInt(), nextInt());
        for (int y = Math.max(i, 1); y < i + 2; y++) {
          distance.update(points[y].dist(points[y - 1]), y, distmap);
        }
        
        for (int y = Math.max(i - 1, 1); y < Math.min(i + 2, n - 1); y++) {
          skip.update(distmap[y + 1] - distmap[y - 1] - points[y + 1].dist(points[y - 1]), y, skips);
        }
      } else {
        int i = nextInt() - 1;
        int j = nextInt() - 1;
        out.println(distance.getSum(i, j) - skip.getSum(i, j));
      } 
    }
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
    boolean oj = System.getProperty("ONLINE_JUDGE") == null;
    oj = true;
    br = new BufferedReader(
        new InputStreamReader(oj ? System.in : new FileInputStream("marathon.in")));
    out = new PrintWriter(oj ? System.out : new FileOutputStream("marathon.out"));
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    new Marathon().run();
  }
}
