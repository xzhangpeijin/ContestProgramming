package contests.current;

public class Test
{
	public Test()
	{
		double val = 0.2354;
		val = (double)Math.round(val * 1000) / 1000;
		System.out.println(val);
		System.out.println(String.format("%.3f", val));
	}
	
	public static void main(String[] args)
	{
		new Test();
	}
}
