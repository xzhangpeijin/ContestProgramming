package contests.completed.misc;
import java.util.ArrayList;
import java.util.List;


public class rps_sol {
  // true if left wins, false otherwise
  public static boolean winner(char a, char b) {
    if (a == b) {
      return true;
    }
    if (a == 'S' && b == 'P') {
      return true;
    }
    if (a == 'P' && b == 'R') {
      return true;
    }
    if (a == 'R' && b == 'S') {
      return true;
    }
    return false;
  }
  
  static class Player {
    long id;
    char pref;
    public Player(long id, char pref) {
      this.id = id;
      this.pref = pref;
    }
  }
  
  public static void main(String[] args) {
    long N = rps.GetN();
    long nodes = message.NumberOfNodes();
    long id = message.MyNodeId();
    
    long touse = 1;
    long rounds = 0;
    while (2 * touse <= nodes && rounds + 1 <= N) {
      touse *= 2;
      rounds++;
    }
    
    long subrounds = N - rounds;
    long players = (long) Math.pow(2, subrounds);
    
    if (id < touse) {
      long start = id * players;
      long end = (id + 1) * players;
      List<Player> remain = new ArrayList<Player>();
      for (long i = start; i < end; i += 2) {
        char left = rps.GetFavoriteMove(i);
        char right = rps.GetFavoriteMove(i + 1);
        if (winner(left, right)) {
          remain.add(new Player(i, left));
        } else {
          remain.add(new Player(i + 1, right));
        }
      }
      while (remain.size() > 1) {
        List<Player> next = new ArrayList<Player>();
        for (int i = 0; i < remain.size(); i += 2) {
          Player left = remain.get(i);
          Player right = remain.get(i + 1);
          if (winner(left.pref, right.pref)) {
            next.add(left);
          } else {
            next.add(right);
          }
        }
        remain = next;
      }
      Player player = remain.get(0);
      message.PutLL(0, player.id);
      message.PutChar(0, player.pref);
      message.Send(0);
    }
    
    if (id == 0) {
      List<Player> remain = new ArrayList<Player>();
      for (int i = 0; i < touse; i++) {
        message.Receive(i);
        long pid = message.GetLL(i);
        char pref = message.GetChar(i);
        remain.add(new Player(pid, pref));
      }
      while (remain.size() > 1) {
        List<Player> next = new ArrayList<Player>();
        for (int i = 0; i < remain.size(); i += 2) {
          Player left = remain.get(i);
          Player right = remain.get(i + 1);
          if (winner(left.pref, right.pref)) {
            next.add(left);
          } else {
            next.add(right);
          }
        }
        remain = next;
      }
      System.out.println(remain.get(0).id);
    }
  }
}
