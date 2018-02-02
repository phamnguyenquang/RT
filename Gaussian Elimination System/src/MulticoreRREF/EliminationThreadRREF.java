package MulticoreRREF;

import java.util.concurrent.Callable;

public class EliminationThreadRREF implements Callable<double[][]> {
	private double[][] temp;
	private double[][] result;
	private double[] pRow;
	private double ratio = 0;
	private int pivot;
	private int lowerlim;
	private int upperlim;
	private long startTime, stopTime;

	public EliminationThreadRREF(double[][] t, int lower, int upper) {
		temp = t;
		lowerlim = lower;
		upperlim = upper;
		// this.pivot = pivot;
	}

	public void setPiv(double[] p) {
		pRow = p;
	}

	public void setPivotPos(int p) {
		pivot = p;
	}

	@Override
	public double[][] call() throws Exception {
		// TODO Auto-generated method stub
		// startTime = System.currentTimeMillis();
		int workload = upperlim - lowerlim + 1;
		result = new double[workload][temp.length + 1];
		int track = 0;
		for (int i = lowerlim; i <= upperlim; ++i) {
			if (i == pivot) {
				result[track] = temp[i];
			} else if (temp[i][pivot] != 0) {
				ratio = pRow[pivot] / temp[i][pivot];
				for (int j = 0; j < temp.length + 1; ++j) {
					result[track][j] = temp[i][j] * ratio - pRow[j];
				}

			} else {
				result[track] = temp[i];
			}
			track++;
		}
		return result;
	}

}