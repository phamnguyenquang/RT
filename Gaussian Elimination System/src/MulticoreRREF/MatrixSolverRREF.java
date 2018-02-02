package MulticoreRREF;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ImprovedMulticore.EliminationThread;

public class MatrixSolverRREF {
	private double[][] A;
	private double[][] AB;
	private double[] sol;
	private double[] B;
	private int Resindex = 0;
	private int[] upperbound;;
	private int threadNo;
	private long startTime, stopTime;
	private List<EliminationThreadRREF> taskForThread;
	private ArrayList<Callable<double[][]>> task = new ArrayList<Callable<double[][]>>();
	private List<Future<double[][]>> result;

	private void Solve() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(threadNo);
		Resindex = 0;
		int rowTrack = 0;
		for (int pivot = 0; pivot < A.length; ++pivot) {
			if (pivot == 0) {
				rowTrack = 1;
				for (int j = 0; j < taskForThread.size(); ++j) {
					taskForThread.get(j).setPiv(AB[0]);
					taskForThread.get(j).setPivotPos(pivot);
					task.add(taskForThread.get(j));
				}
			} else {
				if (pivot > upperbound[Resindex]) {
					Resindex++;
					rowTrack = 0;
				}
				double[] pivotCopy = result.get(Resindex).get()[rowTrack];
				result.clear();
				for (int j = 0; j < taskForThread.size(); ++j) {
					taskForThread.get(j).setPivotPos(pivot);
					taskForThread.get(j).setPiv(pivotCopy);
					task.add(taskForThread.get(j));
				}
				++rowTrack;
			}
			result = executor.invokeAll(task);
			task.clear();
			int index = 0;
			for (int r = 0; r < result.size(); ++r) {
				for (int jj = 0; jj < result.get(r).get().length; ++jj) {
					AB[index] = result.get(r).get()[jj];
					index += 1;
				}

			}
		}

		executor.shutdown();
		sol = new double[B.length];
		for (int i1 = 0; i1 < sol.length; ++i1) {
			sol[i1] = AB[i1][B.length] / AB[i1][i1];
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
			System.out.println("\n");
		}
	}

	public void printAB() {
		for (int i = 0; i < B.length; ++i) {
			for (int j = 0; j < B.length + 1; ++j) {
				System.out.print(AB[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

	private void setup() {
		taskForThread = new ArrayList<EliminationThreadRREF>();
		int[] workload = new int[threadNo];
		upperbound = new int[threadNo];
		int upperlim = 0;
		int lowerlim = 0;

		int Ratio = A.length / threadNo;
		int remainder = A.length % threadNo;
		if (Ratio >= 1) {
			for (int i = 0; i < workload.length; ++i) {
				workload[i] = Ratio;
			}
			if (remainder != 0) {
				for (int i = 0; i < remainder; ++i) {
					workload[i] = Ratio + 1;
				}
			}
		} else if (Ratio < 1) {
			for (int i1 = 0; i1 < A.length; ++i1) {
				workload[i1] = 1;
			}
		}
		int lowerbound = 0;
		for (int k = 0; k < upperbound.length; ++k) {
			upperbound[k] = workload[k] + lowerbound - 1;
			lowerbound += workload[k];
		}
		for (int j = 0; j < threadNo; ++j) {
			upperlim = lowerlim + workload[j] - 1;
			if (upperlim >= lowerlim) {
				taskForThread.add(new EliminationThreadRREF(AB, lowerlim, upperlim));
			}
			lowerlim += workload[j];
		}
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

	public MatrixSolverRREF(double[][] a, double[] b, int coreNo)

	{
		A = a;
		B = b;
		threadNo = coreNo;
		swap();
		AB = new double[A.length][B.length + 1];
		for (int i = 0; i < A.length; ++i) {
			for (int j = 0; j < B.length + 1; ++j) {
				if (j == B.length) {
					AB[i][j] = B[i];
				} else {
					AB[i][j] = A[i][j];
				}
			}
		}
		setup();
	}

	public void MulticoreSubstitution() throws InterruptedException, ExecutionException {
		startTime = System.currentTimeMillis();
		Solve();
		printSolution();
		stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime + " ms");
	}
}
