import contests.completed.misc.crates;
import contests.completed.misc.message;


public class Main {
  static final long MOD = 1000000007L;

  public static void main(String[] args) {
    long stacks = crates.GetNumStacks();
    int nodes = message.NumberOfNodes();
    int myid = message.MyNodeId();

    long handle = 1 + (stacks - 1) / nodes;
    long start = myid * handle;
    long end = Math.min((myid + 1) * handle, stacks);

    long[] heights = new long[(int)handle];
    long total = 0;
    for (long i = start; i < end; i++) {
      heights[(int)(i - start)] = crates.GetStackHeight(i + 1);
      total += heights[(int)(i - start)];
    }
    message.PutLL(0, total);
    message.Send(0);

    if (myid == 0) {
      long bigtot = 0;
      for (int i = 0; i < nodes; i++) {
        message.Receive(i);
        bigtot += message.GetLL(i);
      }
      for (int i = 0; i < nodes; i++) {
        message.PutLL(i, bigtot);
        message.Send(i);
      }
    }

    message.Receive(0);
    long bigtot = message.GetLL(0);
    long target = bigtot / stacks;
    long extras = bigtot % stacks;

    long diff = 0;
    long moves = 0;
    if (myid != 0) {
      int source = (int)(myid - 1);
      message.Receive(source);
      diff = message.GetLL(source);
      moves = message.GetLL(source);
    }

    for (long i = start; i < end; i++) {
      long needed = target;
      if (i < extras) {
        needed = target + 1;
      }

      moves += Math.abs(diff);
      moves %= MOD;

      long height = heights[(int)(i - start)];
      diff += height - needed;
    }
    
    if (myid != message.NumberOfNodes() - 1) {
      int tar = (int)(myid + 1);
      message.PutLL(tar, diff);
      message.PutLL(tar, moves);
      message.Send(tar);
    } else {
      if (diff != 0) {
        throw new RuntimeException("Incorrect difference");
      }
      System.out.println(moves % MOD);
    }
  }
}
