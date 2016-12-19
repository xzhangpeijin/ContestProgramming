package contests.completed.misc;
// Sample input 1, in Java.
public class winning_move {
  public winning_move() {
  }

  public static long GetNumPlayers() {
    return 6L;
  }

  public static long GetSubmission(long playernum) {
    switch ((int)playernum) {
      case 0: return 4L;
      case 1: return 8L;
      case 2: return 15L;
      case 3: return 16L;
      case 4: return 23L;
      case 5: return 42L;
      default: throw new IllegalArgumentException("Invalid argument");
    }
  }
}