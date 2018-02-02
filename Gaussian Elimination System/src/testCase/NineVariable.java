package testCase;

public class NineVariable implements TestCase {

	private double[][] A = { 
			{-5.0, 11.0, -20.0, -18.0, -6.0, 7.0, -2.0, -1.0, -8.0, },
			{-12.0, -1.0, 19.0, 11.0, 19.0, -13.0, 8.0, -20.0, -6.0, },
			{-4.0, -9.0, 13.0, -6.0, 17.0, 6.0, -13.0, 4.0, 4.0, },
			{-13.0, 17.0, 17.0, -19.0, -2.0, -2.0, -14.0, 16.0, 1.0, },
			{7.0, -9.0, 10.0, 2.0, 1.0, 4.0, -20.0, 14.0, -11.0, },
			{12.0, 19.0, 0.0, -19.0, 6.0, 17.0, 15.0, -4.0, 16.0, },
			{-6.0, 18.0, -18.0, 13.0, -13.0, 17.0, -5.0, -11.0, -6.0, },
			{1.0, 9.0, -11.0, 2.0, 8.0, -12.0, 10.0, 8.0, 8.0, },
			{-1.0, -1.0, -14.0, 12.0, -18.0, 15.0, 20.0, 19.0, -16.0, }
	};
	private double[] b = {13.0, 20.0, -9.0, 2.0, -16.0, -6.0, 12.0, -16.0, 19.0 };

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
	public NineVariable() {

	}

}
