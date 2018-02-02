package testCase;

public class TewlveVariable implements TestCase {

	private double[][] A = { 
			{-1.0, 1.0, -16.0, -20.0, 13.0, -18.0, 10.0, 7.0, -4.0, -11.0, 2.0, -3.0, },
			{1.0, 4.0, 14.0, 17.0, 15.0, -20.0, -18.0, 16.0, 5.0, -16.0, 7.0, 12.0, },
			{0.0, 10.0, 15.0, 17.0, 2.0, 5.0, -13.0, -5.0, -16.0, -9.0, 14.0, -20.0, },
			{-18.0, 13.0, -5.0, 3.0, 10.0, -3.0, 5.0, -19.0, -19.0, 3.0, -2.0, 11.0, },
			{16.0, 3.0, 16.0, -15.0, 19.0, 1.0, 20.0, 5.0, 12.0, -19.0, 20.0, -4.0, },
			{1.0, -20.0, -20.0, 16.0, -18.0, -9.0, -13.0, 1.0, 15.0, 12.0, -6.0, 3.0, },
			{-4.0, 11.0, 7.0, -4.0, -2.0, 0.0, 18.0, 1.0, -2.0, -3.0, 4.0, 14.0, },
			{-10.0, -3.0, 20.0, 8.0, 1.0, 8.0, -14.0, -12.0, 11.0, 20.0, -14.0, 2.0, },
			{-17.0, 14.0, -19.0, 1.0, 6.0, 10.0, 14.0, -12.0, -16.0, 0.0, -10.0, -17.0, }
	};
	private double[] b = {10.0, -4.0, 7.0, -2.0, 0.0, 15.0, 2.0, 11.0, 3.0, 9.0, -4.0, -18.0, };

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
	public TewlveVariable() {

	}
}