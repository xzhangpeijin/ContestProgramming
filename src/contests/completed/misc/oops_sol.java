package contests.completed.misc;

public class oops_sol {
  public static void main(String[] args) {
    long N = oops.GetN();
    long nodes = message.NumberOfNodes();
    long id = message.MyNodeId();
    
    long max = Long.MIN_VALUE;
    long min = Long.MAX_VALUE;
    
    for (long pos = id; pos < N; pos += nodes) {
      max = Math.max(max, oops.GetNumber(pos));
      min = Math.min(min, oops.GetNumber(pos));
    }
    
    message.PutLL(0, max);
    message.PutLL(0, min);
    message.Send(0);
    
    if (id == 0) {
      long bigmax = Long.MIN_VALUE;
      long bigmin = Long.MAX_VALUE;
      
      for (int i = 0; i < message.NumberOfNodes(); i++) {
        message.Receive(i);
        bigmax = Math.max(bigmax, message.GetLL(i));
        bigmin = Math.min(bigmin, message.GetLL(i));
      }
      System.out.println(bigmax - bigmin);
    }
  }
}
