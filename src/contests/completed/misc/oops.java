package contests.completed.misc;
// Sample input 1, in Java.
public class oops {
  public oops() {
  }

  public static long GetN() {
    return 9L;
  }

  public static long GetNumber(long i) {
    switch ((int)i) {
      case 0: return 12L;
      case 1: return 21L;
      case 2: return 32L;
      case 3: return 24L;
      case 4: return 100L;
      case 5: return 25L;
      case 6: return 49L;
      case 7: return 7L;
      case 8: return 7L;
      default: throw new IllegalArgumentException("Invalid argument");
    }
  }
}