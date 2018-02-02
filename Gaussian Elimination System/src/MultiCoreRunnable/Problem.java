package MultiCoreRunnable;

import java.util.ArrayList;
import java.util.List;

public class Problem {
	// A must have
	// -------------------------
	private double[][] A; // original A
	private double[][] AB; // for the Augmented matrix
	private double[] sol; // for solution
	private double[] B; // original B
	private double[] pivot; // things to pass around and keep track
	private List<double[][]> submatrix; // for the thread
	private int CurrentpivotPos = 0; // to track the pivot.
	private int threadNo; // the thread number
	private boolean[] threadCanReadPivot;
	private boolean[] calculated;
	private int[] count; // semaphore
	private boolean prematureStop = false;
	// --------------------------

	private int pivotWrite = 1;
	int[] workload;

	private int[] lowerbound;

	// For testing purpose

	public Problem(double[][] a, double[] b, int coreNo)

	{
		A = a;
		B = b;
		threadNo = coreNo;
		Setup();
	}

	public void Setup() {
		swap();
		MakeAugmentedMatrix();
		calculateWorkload();
		makeSubMatrix();
		pivot = AB[0];
		threadCanReadPivot = new boolean[threadNo];
		for (int i = 0; i < threadNo; ++i) {
			threadCanReadPivot[i] = true;
		}
		calculated = new boolean[threadNo];
		for (int i = 0; i < threadNo; ++i) {
			calculated[i] = false;
		}
		int lower = 0;
		lowerbound = new int[threadNo];
		count = new int[threadNo];
		for (int j = 0; j < lowerbound.length; ++j) {
			lowerbound[j] = lower;
			lower += workload[j];
		}

	}

	public double[] getPivotRow() {
		return pivot;
	}

	public int getPivotPos() {
		return CurrentpivotPos;
	}

	public int getPivotWrite() {
		return pivotWrite;
	}

	public int getLowerBoundat(int index) {
		return lowerbound[index];
	}

	public void setThreadPivotWrite(int i) {
		pivotWrite = i;
	}

	public void writePivotRow(double[] p) {
		pivot = p;
		++CurrentpivotPos;
		tokenLease();
	}

	private void tokenLease() {
		for (int i = 0; i < threadCanReadPivot.length; ++i) {
			threadCanReadPivot[i] = true;
			calculated[i] = false;
		}
	}

	public void setThreadRead(int index, boolean b) {
		threadCanReadPivot[index - 1] = b;
	}

	public void setCalculated(int index, boolean b) {
		calculated[index - 1] = b;
	}

	public boolean getCalculatedStatus() {
		int res = 0;
		for (int j = 0; j < count.length; ++j) {
			count[j] = 0;
		}
		for (int i = 0; i < calculated.length; ++i) {
			if (calculated[i] == true) {
				count[i] = 1;
			} else {
				count[i] = 0;
			}
			res += count[i];
		}
		if (res == threadNo) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getWriteReadyStatus() {
		int res = 0;
		for (int j = 0; j < count.length; ++j) {
			count[j] = 0;
		}
		for (int i = 0; i < threadCanReadPivot.length; ++i) {
			if (threadCanReadPivot[i] == false) {
				count[i] = 1;
			} else {
				count[i] = 0;
			}
			res += count[i];
		}
		if (res == threadNo) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getTheadReadPivot(int threadNo) {
		return threadCanReadPivot[threadNo - 1];
	}

	public boolean PivotIsLast() {
		if (CurrentpivotPos == AB.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getPrematureStop() {
		return prematureStop;
	}

	public void setPrematureStop(boolean b) {
		prematureStop = b;
	}

	public void ComputeSolution() {
		sol = new double[B.length];
		for (int i = 0; i < sol.length; ++i) {
			sol[i] = AB[i][AB.length] / AB[i][i];
		}

	}

	public void printSolution() {
		for (int i = 0; i < sol.length; ++i) {
			System.out.println(sol[i]);
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

	private void MakeAugmentedMatrix() {
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
	}

	private void calculateWorkload() {
		workload = new int[threadNo];
		int Ratio = AB.length / threadNo;
		int remainder = AB.length % threadNo;
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
			for (int i1 = 0; i1 < AB.length; ++i1) {
				workload[i1] = 1;
			}
		}
	}

	private void makeSubMatrix() {
		submatrix = new ArrayList<double[][]>();
		int track = 0;
		for (int i = 0; i < threadNo; ++i) {
			submatrix.add(new double[workload[i]][A.length + 1]);

		}
		for (int j = 0; j < submatrix.size(); ++j) {
			for (int k = 0; k < workload[j]; ++k) {
				for (int l = 0; l < A.length + 1; ++l) {
					submatrix.get(j)[k][l] = AB[track][l];
				}
				++track;
			}
		}

	}

	public double[][] getSubMatrixAt(int index) {
		return submatrix.get(index);
	}

	public void OverwriteSubMatrix(double[][] sub, int index) {
		for (int i = 0; i < submatrix.get(index - 1).length; ++i) {
			submatrix.get(index - 1)[i] = sub[i];
		}
	}

	public void MergeSubMatrix() {
		int track = 0;
		for (int i = 0; i < submatrix.size(); ++i) {
			for (int j = 0; j < submatrix.get(i).length; ++j) {
				AB[track] = submatrix.get(i)[j];
				++track;
			}
		}
	}

	public void PrintAugmented() {
		for (int i = 0; i < AB.length; ++i) {
			for (int j = 0; j < AB[0].length; ++j) {
				System.out.print(AB[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

}
