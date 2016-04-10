package contests.completed.misc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * Assumes that mapping is bijective, IE no two characters map to same symbol
 * Doesn't pass last test case but not sure what's wrong. Thinking validator doesn't check
 * for multiple valid solutions
 */

public class BrokeMath {
  static final List<Character> symbols = Arrays.asList('+', '-', '%', '/', '^', '*');
  static final int INVALID = 0xDEADBEEF;
  
  static class Equation {
    String input;
    Set<Character> unmapped;
    Set<Character> openparen;
    Set<Character> closeparen;
    boolean hasParen = false;
    public Equation(String input) {
      this.input = input;
      this.unmapped = new HashSet<Character>();
      this.openparen = new HashSet<Character>();
      this.closeparen = new HashSet<Character>();
      this.hasParen = false;
      
      boolean digit = false;
      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) == ' ') {
          continue;
        }
        if (Character.isDigit(input.charAt(i))) {
          digit = true;
        } else {
          if (!digit) {
            hasParen = true;
            if (i != 0) {
              int j = i;
              while (j > 0) {
                if (Character.isDigit(input.charAt(j))) {
                  break;
                }
                if (input.charAt(j) != ' ') {
                  openparen.add(input.charAt(j));
                  closeparen.add(input.charAt(j));
                }
                j--;
              }
            } else {
              openparen.add(input.charAt(i));
            }
          }
          unmapped.add(input.charAt(i));
          digit = false;
        }
      }
      if (!digit) {
        closeparen.add(input.charAt(input.length() - 1));
      }
    }
  }
  
  static int settleOps(int value, int lastnum, char lastop) {
    switch (lastop) {
    case '%':
      if (lastnum == 0) {
        return INVALID;
      }
      return value % lastnum;
    case '+':
      return value + lastnum;
    case '-':
      return value - lastnum;
    case '/':
      if (lastnum == 0) {
        return INVALID;
      }
      return value / lastnum;
    case '*':
      return value * lastnum;
    case '^':
      return (int) Math.pow(value, lastnum);
    default:
      return lastnum;
    }
  }
  
  static int evaluateString(String a) {
    List<Integer> values = new ArrayList<Integer>();
    List<Character> ops = new ArrayList<Character>();
    int lastnum = -1;
    boolean digit = false;
    boolean neg = false;
    boolean cantdigit = false;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == ' ') {
        continue;
      } else if (Character.isDigit(a.charAt(i))) {
        if (cantdigit) {
          return INVALID;
        }
        int val = (a.charAt(i) - '0');
        if (digit) {
          lastnum = lastnum * 10 + val;
        } else {
          lastnum = val;
        }
        digit = true;
      } else {
        if (a.charAt(i) != ')' && a.charAt(i) != '(') {
          if (!digit) {
            if (a.charAt(i) == '-') {
              neg = !neg;
            } else {
              return INVALID;
            }
          } else {
            if (neg) {
              lastnum = lastnum * -1;
            }
            digit = false;
            values.add(lastnum);
            ops.add(a.charAt(i));
            cantdigit = false;
            neg = false;
          }
        } else if (a.charAt(i) == '(') {
          int j = a.indexOf(')', i);
          lastnum = evaluateString(a.substring(i + 1, j));
          cantdigit = true;
          digit = true;
          i = j;
        }
      }
    }
    if (neg) {
      lastnum = lastnum * -1;
    }
    values.add(lastnum);
        
    for (int i = 0; i < ops.size(); i++) {
      switch (ops.get(i)) {
      case '^':
        int val = settleOps(values.get(i), values.get(i + 1), ops.get(i));
        values.remove(i + 1);
        values.remove(i);
        values.add(i, val);
        ops.remove(i--);
      default:
        break;
      }      
    }
    
    for (int i = 0; i < ops.size(); i++) {
      switch (ops.get(i)) {
      case '%':
      case '/':
      case '*':
        int val = settleOps(values.get(i), values.get(i + 1), ops.get(i));
        if (val == INVALID) {
          return INVALID;
        }
        values.remove(i + 1);
        values.remove(i);
        values.add(i, val);
        ops.remove(i--);
      default:
        break;
      }      
    }
    for (int i = 0; i < ops.size(); i++) {
      switch (ops.get(i)) {
      case '+':
      case '-':
        int val = settleOps(values.get(i), values.get(i + 1), ops.get(i));
        values.remove(i + 1);
        values.remove(i);
        values.add(i, val);
        ops.remove(i--);
      default:
        break;
      }      
    }
    return values.get(0);
  }
    
  static String mapEquation(Equation e, Map<Character, Character> map) {
    char[] arr = e.input.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        arr[i] = map.get(arr[i]);
      }
    }
    return new String(arr);
  }
  
  static boolean equalEquation(Equation e, Map<Character, Character> map) {
    String eq = mapEquation(e, map);
    String[] data = eq.split("=");
    int left = evaluateString(data[0]);
    int right = evaluateString(data[1]);
//    if (map.get('y') == '-' && map.get('f') == '+' && map.get('S') == '=' && 
//        map.get('m') == '(' && map.get('Z') == ')' && map.get('i') == '/' && 
//        map.get('*') == '^') {
//      System.out.println(eq + "\n" + left + " " + right);
//    }
//    if (map.get('s') == '+' && map.get('l') == '*' && map.get('^') == '^' &&
//        map.get('G') == '=' && map.get('+') == '-') {
//      System.out.println(eq + "\n" + left + " " + right);
//    }
    return left != INVALID && right != INVALID && left == right;
  }
  
  static boolean validString(String a, char open, char close) {
    boolean digit = false;
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == ' ') {
        continue;
      }
      if (Character.isDigit(a.charAt(i))) {
        digit = true;
      } else if (a.charAt(i) == open) {
        if (digit) {
          return false;
        }
        count++;
      } else if (a.charAt(i) == close) {
        if (!digit) {
          return false;
        }
        count--;
        if (count < 0) {
          return false;
        }
      } else {
        digit = false;
      }
    }
    return count == 0 && digit;
  }
  
  static boolean validEquation(Equation e, char equal, char open, char close) {
    String[] data = e.input.split(String.valueOf(equal));
    if (data.length != 2) {
      return false;
    }
    return validString(data[0], open, close) &&
           validString(data[1], open, close);
  }
  
  public void solve() throws IOException {
    String input = "";
    List<Equation> equations = new ArrayList<Equation>();
    Set<Character> unmapped = new HashSet<Character>();
    Set<Character> equalsCandidates = new HashSet<Character>();
    Set<Character> openCandidates = new HashSet<Character>();
    Set<Character> closeCandidates = new HashSet<Character>();
    
    boolean hasParen = false;
    while ((input = nextLine()) != null && input.length() > 0) {
      Equation e = new Equation(input);
      equations.add(e);
      unmapped.addAll(e.unmapped);
      if (equalsCandidates.size() == 0) {
        equalsCandidates.addAll(e.unmapped);
      } else {
        equalsCandidates.retainAll(e.unmapped);
      }
      if (e.hasParen) {
        if (openCandidates.size() == 0) {
          openCandidates.addAll(e.openparen);
          closeCandidates.addAll(e.closeparen);
        } else {
          openCandidates.retainAll(e.openparen);
          closeCandidates.retainAll(e.closeparen);
        }
      }
      hasParen = hasParen || e.hasParen;
    }
            
    if (hasParen) {
      for (char a : equalsCandidates) {
        for (char b : openCandidates) {
          if (b == a) continue;
          for (char c : closeCandidates) {
            if (c == a || c == b) continue;
            boolean valid = true;
            for (Equation e : equations) {
              if (!validEquation(e, a, b, c)) {
                valid = false;
                break;
              }
            }            
            if (!valid) continue;

            Map<Character, Character> map = new HashMap<Character, Character>();
            map.put(a, '=');
            map.put(b, '(');
            map.put(c, ')');
            
            List<Map<Character, Character>> queue = new ArrayList<Map<Character, Character>>();
            queue.add(map);
            
            for (char s : symbols) {
              int size = queue.size();
              for (int i = 0; i < size; i++) {
                Map<Character, Character> partial = queue.get(i);
                for (char u : unmapped) {
                  if (u == a || u == b || u == c || partial.containsKey(u)) continue;
                  Map<Character, Character> next = new HashMap<Character, Character>(partial);
                  next.put(u, s);
                  queue.add(next);
                }
              }
            }
                        
            for (Map<Character, Character> full : queue) {
              if (full.size() != unmapped.size()) continue;
              boolean equals = true;
              for (Equation e : equations) {
                if (!equalEquation(e, full)) {
                  equals = false;
                }
              }
              if (equals) {
                for (Equation e : equations) {
                  System.out.println(mapEquation(e, full));
                }
                return;
              }
            }
          }
        }
      }
    }
        
//    for (char a : equalsCandidates) {
//      boolean valid = true;
//      for (Equation e : equations) {
//        if (!validEquation(e, a, '(', ')')) {
//          valid = false;
//          break;
//        }
//      }
//      if (!valid) continue;
//
//      Map<Character, Character> map = new HashMap<Character, Character>();
//      map.put(a, '=');
//
//      List<Map<Character, Character>> queue = new ArrayList<Map<Character, Character>>();
//      queue.add(map);
//
//      for (char s : symbols) {
//        int size = queue.size();
//        for (int i = 0; i < size; i++) {
//          Map<Character, Character> partial = queue.get(i);
//          for (char u : unmapped) {
//            if (u == a || partial.containsKey(u)) continue;
//            Map<Character, Character> next = new HashMap<Character, Character>(partial);
//            next.put(u, s);
//            queue.add(next);
//          }
//        }
//      }
//
//      for (Map<Character, Character> full : queue) {
//        if (full.size() != unmapped.size()) continue;
//        boolean equals = true;
//        for (Equation e : equations) {
//          if (!equalEquation(e, full)) {
//            equals = false;
//          }
//        }
//        if (equals) {
//          for (Equation e : equations) {
//            System.out.println(mapEquation(e, full));
//          }
//          return;
//        }
//      }
//    }
    
    throw new RuntimeException();
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
    new BrokeMath().run();
  }
}
