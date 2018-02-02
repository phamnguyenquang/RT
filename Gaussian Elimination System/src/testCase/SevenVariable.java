package testCase;

public class SevenVariable implements TestCase {

	private double[][] A = { 
			{-18.0, 19.0, -2.0, 2.0, -9.0, 1.0, -2.0, },
			{5.0, 9.0, -16.0, -2.0, 3.0, 8.0, 18.0, },
			{15.0, -10.0, 15.0, 0.0, 13.0, 7.0, -6.0, },
			{12.0, 10.0, -13.0, 6.0, -1.0, 13.0, -15.0, },
			{9.0, -14.0, -15.0, 13.0, 10.0, 13.0, -14.0, },
			{18.0, 1.0, 3.0, -11.0, -5.0, -11.0, 8.0, },
			{-7.0, 15.0, -18.0, 1.0, 2.0, -9.0, 2.0, }


	};
	private double[] b = {20.0, 7.0, -11.0, -4.0, -6.0, -11.0, -14.0, };

	@Override
	public double[][] getA() {
		// TODO Auto-generated method stub
		return A;
	}

	@Override
	public double[] getB() {
		// TODO Auto-generated method stub
		return b;
	}
	public void ThousandTime(int n) {
		for (int i = 0; i < b.length; ++i) {
			b[i] *= (1000 * n);
			for (int j = 0; j < b.length; ++j) {
				A[i][j] *= (1000 * n);
			}
		}
	}
	public SevenVariable() {

	}

}
