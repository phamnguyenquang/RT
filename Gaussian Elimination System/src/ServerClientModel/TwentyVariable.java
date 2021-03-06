package ServerClientModel;

import testCase.TestCase;

public class TwentyVariable implements TestCase {

	private double[][] A = {
			{ -16.0, -17.0, -6.0, 9.0, 16.0, 9.0, 17.0, -4.0, 6.0, 9.0, -8.0, -5.0, -5.0, 15.0, 20.0, -15.0, 0.0, 15.0,
					10.0, -9.0, },
			{ 16.0, 12.0, 19.0, -18.0, 17.0, 7.0, -15.0, 1.0, 7.0, -9.0, -19.0, 18.0, 17.0, 17.0, -12.0, -10.0, 10.0,
					-14.0, -20.0, 8.0, },
			{ 6.0, 13.0, 1.0, 18.0, 15.0, 17.0, -1.0, -15.0, 11.0, -15.0, 15.0, 17.0, 16.0, -16.0, -14.0, -19.0, -7.0,
					-13.0, 19.0, -4.0, },
			{ -15.0, -20.0, -5.0, 3.0, 8.0, 10.0, 10.0, 7.0, -19.0, 1.0, 4.0, -7.0, -4.0, -1.0, -11.0, 8.0, -17.0, 8.0,
					8.0, 18.0, },
			{ -7.0, 15.0, 8.0, -18.0, 8.0, 11.0, -4.0, -14.0, 5.0, 2.0, 17.0, 18.0, -13.0, -20.0, 19.0, 10.0, -15.0,
					9.0, 16.0, 15.0, },
			{ 11.0, 7.0, -18.0, -11.0, 20.0, 15.0, -11.0, 4.0, 5.0, -3.0, 18.0, 14.0, -19.0, 12.0, -18.0, 6.0, -9.0,
					13.0, -9.0, -7.0, },
			{ 19.0, -17.0, 18.0, -15.0, 3.0, 12.0, 3.0, 2.0, 14.0, -1.0, 19.0, -20.0, 2.0, 19.0, 19.0, 11.0, 13.0, 5.0,
					5.0, 20.0, },
			{ -12.0, 10.0, -3.0, 11.0, -10.0, 16.0, -13.0, 12.0, 7.0, -5.0, 9.0, -20.0, -1.0, 7.0, 14.0, 20.0, 3.0,
					16.0, 17.0, 6.0, },
			{ -1.0, -5.0, -18.0, -18.0, 16.0, -13.0, 6.0, -9.0, 20.0, -8.0, -18.0, 4.0, -9.0, 18.0, -13.0, 11.0, -3.0,
					-6.0, -13.0, 19.0, },
			{ -19.0, 0.0, -14.0, 0.0, 18.0, 18.0, -20.0, 15.0, 4.0, 4.0, -4.0, 15.0, 2.0, 3.0, -7.0, -2.0, -9.0, 5.0,
					20.0, -15.0, },
			{ 5.0, -3.0, -14.0, -8.0, 3.0, -17.0, -13.0, 16.0, 0.0, 3.0, 15.0, -14.0, -11.0, -9.0, 12.0, -19.0, 5.0,
					3.0, 2.0, 20.0, },
			{ -1.0, 17.0, -10.0, 3.0, 20.0, -4.0, 8.0, -15.0, 7.0, 3.0, 19.0, 10.0, 4.0, -20.0, 2.0, 7.0, 18.0, 8.0,
					-2.0, 9.0, },
			{ -16.0, 20.0, 5.0, 14.0, -4.0, -5.0, 2.0, 2.0, 17.0, 17.0, 13.0, -3.0, 19.0, 14.0, -13.0, 8.0, 1.0, -18.0,
					-17.0, -13.0, },
			{ -12.0, -7.0, -10.0, 9.0, 1.0, 6.0, -12.0, 0.0, -15.0, 19.0, 14.0, 19.0, -4.0, -9.0, 9.0, 7.0, 19.0, 0.0,
					12.0, -9.0, },
			{ -6.0, -4.0, -14.0, -12.0, 5.0, -3.0, -8.0, -14.0, 1.0, 11.0, 4.0, 16.0, 6.0, -6.0, -9.0, -5.0, -8.0, 18.0,
					10.0, 19.0, },
			{ 10.0, 13.0, -17.0, -18.0, -3.0, 5.0, 20.0, -4.0, -16.0, 19.0, -6.0, 14.0, 19.0, 9.0, -15.0, 16.0, 6.0,
					-13.0, 18.0, 11.0, },
			{ 9.0, 4.0, 9.0, 9.0, 10.0, -10.0, 16.0, 3.0, -7.0, 12.0, 16.0, 8.0, -19.0, -8.0, 9.0, 7.0, 9.0, 17.0, -6.0,
					8.0, },
			{ 2.0, -5.0, -20.0, -14.0, 14.0, 5.0, 18.0, -5.0, -19.0, 8.0, -6.0, -1.0, 6.0, -2.0, 8.0, 0.0, 11.0, 0.0,
					-9.0, -12.0, },
			{ 6.0, 6.0, -5.0, 4.0, -3.0, -17.0, -19.0, 19.0, 18.0, -13.0, 20.0, -13.0, -16.0, 14.0, 19.0, 18.0, -12.0,
					-20.0, -5.0, -18.0, },
			{ 0.0, -16.0, 14.0, -3.0, 10.0, -9.0, -14.0, -11.0, -11.0, -20.0, 12.0, 6.0, -15.0, 16.0, 11.0, 9.0, -14.0,
					15.0, 11.0, -15.0, }

	};
	private double[] b = { -20.0, -5.0, 19.0, -10.0, -12.0, 2.0, 2.0, -17.0, 1.0, 1.0, -3.0, 16.0, 14.0, -20.0, 16.0,
			-19.0, -11.0, 14.0, -3.0, 11.0, };

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

	public TwentyVariable() {

	}

}
