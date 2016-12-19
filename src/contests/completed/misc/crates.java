package contests.completed.misc;
// Sample input 3, in Java.
public class crates {
  public crates() {
  }

  public static long GetNumStacks() {
    return 3L;
  }

  public static long GetStackHeight(long i) {
    switch ((int)i) {
      case 1: return 2L;
      case 2: return 2L;
      case 3: return 2L;
      default: throw new IllegalArgumentException("Invalid argument");
    }
  }
}