package testCase;

public class FiveVariable implements TestCase {
	private double[][] A = { 
			{ 1,0,-3,2,4}, 
			{ 5,6,7,8,-9 }, 
			{ 1,1,1,1,1 },
			{ 0,0,0,1,0 },
			{ 2,-3,2,-3,4 },

	};
	private double[] b = { 10,35,5,1,14 };

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

	public FiveVariable() {
	}

}
