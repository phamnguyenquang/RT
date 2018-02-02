package testCase;

public class ThreeVariableExtend implements TestCase {
	private double[][] A = { { 1, 2, -3 }, { 6, 3, -9 }, {7,14, -21 },

	};
	private double[] b = { 2, 6, 13 };

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
	public ThreeVariableExtend() {
	}

}
