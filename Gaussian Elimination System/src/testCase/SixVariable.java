package testCase;

public class SixVariable implements TestCase {
	private double[][] A = { 
			{ 1,1,-2,1,3,-1 }, 
			{ 2,-1,1,2,1,-3 }, 
			{ 1,3,-3,-1,2,1 },
			{ 5,2,-1,-1,2,1 },
			{ -3,-1,2,3,1,3 },
			{ 4,3,1,-6,-3,-2 }

	};
	private double[] b = { 4,20,-15,-3,16,-27 };

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
	public SixVariable() {
	}

}
