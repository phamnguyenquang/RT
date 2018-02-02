package ImprovedMulticore;

import java.util.concurrent.Callable;

public class EliminationThread implements Callable<double[][]> {
	private double[][] temp;
	private double[][] result;
	private double ratio = 0;
	private int pivot;
	private int lowerlim;
	private int upperlim;

	public EliminationThread(double[][] t, int pivot, int lower, int upper) {
		temp = t;
		lowerlim = lower;
		upperlim = upper;
		this.pivot = pivot;
	}

	@Override
	public double[][] call() throws Exception {
		// TODO Auto-generated method stub
		int workload = upperlim - lowerlim + 1;
//		System.out.println(workload);
		result = new double[workload][temp.length];
		int track = 0;
		for (int i = lowerlim; i <= upperlim; ++i) {
			if (temp[i][pivot] != 0) {
				ratio = temp[pivot][pivot] / temp[i][pivot];
				for (int j = 0; j < temp.length; ++j) {
					result[track][j] = temp[i][j] * ratio - temp[pivot][j];
				}
			} else {
				result[track] = temp[i];
			}
			track++;
		}
		return result;
	}

}