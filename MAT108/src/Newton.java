import java.lang.Math;
public class Newton {

	public static void main(String[] args) {
		
		double x = 0;
		double x_;
		do {
			x = -1;
			x_ = x - f(x)/f_(x);
			x = x_;
		} while (f(x) < Math.abs(Math.pow(10, -5)));

	}
	
	public static double f(double x) {
		double y = x + Math.sin(x) + 1;
		return y;
	}
	
	public static double f_(double x) {
		double y = 1 + Math.cos(x);
		return y;
	}

}
