

public class Test {
  public Test() {
    StringBuilder buf = new StringBuilder("asdf");
    buf.deleteCharAt(1);
    System.out.println(buf.toString());
    buf.insert(1, 's');
    System.out.println(buf.toString());
  }

  public static void main(String[] args) {
    new Test();
  }
}
