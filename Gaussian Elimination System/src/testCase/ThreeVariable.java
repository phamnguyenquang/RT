package testCase;

public class ThreeVariable implements TestCase {
	private double[][] A = { { 2, 1, 1 }, { 0, -8, -2 }, { 0, 0, 1 },

	};
	private double[] b = { 5, -12, 2 };

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
	public ThreeVariable() {
	}

}
