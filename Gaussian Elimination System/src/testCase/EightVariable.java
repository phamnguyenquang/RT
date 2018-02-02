package testCase;

public class EightVariable implements TestCase {

	private double[][] A = { 
			{6.0, -7.0, 11.0, 4.0, 12.0, -8.0, -14.0, 13.0, },
			{-18.0, 6.0, 19.0, 1.0, 1.0, -13.0, -1.0, 13.0, },
			{-10.0, 11.0, 14.0, 15.0, -17.0, 10.0, 20.0, -6.0, },
			{-14.0, -14.0, 9.0, -9.0, -15.0, -11.0, -13.0, -5.0, },
			{6.0, 5.0, -5.0, -6.0, -17.0, 19.0, 15.0, -18.0, },
			{20.0, -6.0, -8.0, 14.0, 1.0, 7.0, 17.0, -12.0, },
			{-8.0, 4.0, 10.0, -2.0, 7.0, 19.0, -15.0, -15.0, },
			{3.0, -12.0, -5.0, -13.0, -7.0, 19.0, -4.0, -18.0, }
	};
	private double[] b = {0.0, -18.0, -10.0, 15.0, 14.0, -10.0, -3.0, -3.0};

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

	public EightVariable() {

	}

}
