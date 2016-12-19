package contests.completed.misc;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class winning_move_sol {
  
  public static void main(String[] args) {
    long players = winning_move.GetNumPlayers();
    long nodes = message.NumberOfNodes();
    long myid = message.MyNodeId();
            
    List<Long> values = new ArrayList<Long>();
    for (long pos = myid; pos < players; pos += nodes) {
      long player = winning_move.GetSubmission(pos);
      values.add(player);
    }
    
    for (long val : values) {
      message.PutLL(0, val);
      message.Send(0);
    }
    
    if (myid == 0) {
      Set<Long> used = new HashSet<Long>();
      Set<Long> duped = new HashSet<Long>();
      for (int i = 0; i < players; i++) {
        int source = message.Receive(-1);
        long player = message.GetLL(source);
        if (used.contains(player)) {
          duped.add(player);
        }
        used.add(player);
      }
      
      long min = Long.MAX_VALUE;
      for (long val : used) {
        if (!duped.contains(val)) {
          min = Math.min(min, val);
        }
      }
      
      if (min == Long.MAX_VALUE) {
        System.out.println(0);
      } else {
        System.out.println(min);
      }
    }
  }
}
