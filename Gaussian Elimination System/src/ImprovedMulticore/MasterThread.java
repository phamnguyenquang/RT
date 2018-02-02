package ImprovedMulticore;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class MasterThread {
	private double[][] A;
	private double[] sol;
	private double[] B;
	private int threadNo;
	private ArrayList<Callable<double[][]>> task = new ArrayList<Callable<double[][]>>();
	private List<Future<double[][]>> result;

	public MasterThread(double[][] a, double[] b, int thread_no)

	{
		A = a;
		B = b;
		threadNo = thread_no;
	}

	private void swap() {
		int n = B.length;

		for (int p = 0; p < n; p++) {

			// find pivot row and swap
			int max = p;
			for (int i = p + 1; i < n; i++) {
				if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
					max = i;
				}
			}
			double[] temp = A[p];
			A[p] = A[max];
			A[max] = temp;
			double t = B[p];
			B[p] = B[max];
			B[max] = t;

		}
	}

	private void ForwardElimination() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(threadNo);
		int Ratio = 0;
		int remainder = 0;
		int upperlim = 0;
		int lowerlim = 0;
		int index = 0;
		int gap = 0;
		int[] workload = new int[threadNo];
		for (int pivot = 0; pivot < B.length - 1; ++pivot) {
			// solve for B
			index = pivot + 1;
			for (int m = pivot + 1; m < B.length; ++m) {
				if (A[m][pivot] != 0) {
					double ratio = A[pivot][pivot] / A[m][pivot];
					B[m] = B[m] * ratio - B[pivot];
				}
			}
			// ----------------------------------------------
			for (int i = 0; i < workload.length; ++i) {
				workload[i] = 0;
			}
			gap = B.length - 1 - pivot;
			Ratio = gap / threadNo;

			if (Ratio >= 1) {
				for (int i = 0; i < workload.length; ++i) {
					workload[i] = Ratio;
				}
				remainder = (gap) % threadNo;
				if (remainder != 0) {
					for (int i = 0; i < remainder; ++i) {
						workload[i] = Ratio + 1;
					}
				}
			} else if (Ratio < 1) {
				for (int i1 = 0; i1 < gap; ++i1) {
					workload[i1] = 1;
				}
			}
			lowerlim = pivot + 1;
			for (int j = 0; j < threadNo; ++j) {
				upperlim = lowerlim + workload[j] - 1;
				if (upperlim >= lowerlim) {
					task.add(new EliminationThread(A, pivot, lowerlim, upperlim));
				}
				lowerlim += workload[j];
			}
			result = executor.invokeAll(task);
			for (int r = 0; r < result.size(); ++r) {
				for (int jj = 0; jj < result.get(r).get().length; ++jj) {
					A[index] = result.get(r).get()[jj];
					index += 1;
				}
			}
			task.clear();
			result.clear();
		}
		executor.shutdown();
	}

	private void BackwardSubstitution() {
		int n = B.length;
		sol = new double[n];
		// PrintSolution();
		for (int i = n - 1; i >= 0; i--) {
			double sum = 0.0;
			// PrintSolution();
			for (int j = i + 1; j < n; j++) {
				sum += A[i][j] * sol[j];
			}
			sol[i] = (B[i] - sum) / A[i][i];
		}
	}

	private void printSolution() {
		for (int i = 0; i < sol.length; ++i) {
			System.out.println(sol[i] + " ");
		}
		System.out.println("\n");
	}

	public void printA() {
		for (int i = 0; i < B.length; ++i) {
			for (int j = 0; j < B.length; ++j) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public void MulticoreSubstitution() throws InterruptedException, ExecutionException {
		swap();
		ForwardElimination();
		BackwardSubstitution();
		printSolution();
	}
}