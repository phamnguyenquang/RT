package MultiCoreRunnable;

public class Core extends Thread {

	// Things that are needed
	// -------------------------------
	private Problem problem;
	private int threadIndex; // according to the thread number set, used to keep track and setup work
	private double[][] submatrix;
	private double[] pivotRow;
	// -------------------------------
	private int pivotGlobalPosition = 0;
	private int localPivot = 0;
	private int lowerbound = 0;
	private boolean finished = false;

	@Override
	public void run() {
		try {
			Thread.sleep((long) (0.00001 * threadIndex));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (!finished) {
			if (problem.getPrematureStop() == true) {
				finished = true;
				problem.OverwriteSubMatrix(submatrix, threadIndex);
			} else if (checkRead() == false && problem.getCalculatedStatus()) {
				// System.out.println("thread " + threadIndex + " waiting for token lease");
				if (checkWrite() == true) {
					if (getWritePermission() == true) {
						PassPivot();
					}
				}
			} else if (checkRead() == true) {
				ReadPivot();
				Calculate();
				checkIfDone();
			} else {
			}
			try {
				Thread.sleep((long) (0.000002));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Core(Problem pp, int no) {
		problem = pp;
		threadIndex = no;
		submatrix = pp.getSubMatrixAt(no - 1);
		lowerbound = problem.getLowerBoundat(no - 1);
		pivotRow = problem.getPivotRow();
		pivotGlobalPosition = problem.getPivotPos();
		if (no == 1) {
			if (submatrix.length > 1) {
				localPivot = 1;
			}

		}

	}

	private synchronized void ReadPivot() {
		pivotRow = problem.getPivotRow();
		pivotGlobalPosition = problem.getPivotPos();
		setReadDone();
	}

	private void Calculate() {
		for (int i = 0; i < submatrix.length; ++i) {
			if (pivotGlobalPosition == lowerbound + i) {
				submatrix[i] = submatrix[i];
			} else if (submatrix[i][pivotGlobalPosition] == 0) {
				submatrix[i] = submatrix[i];
			} else if (submatrix[i][pivotGlobalPosition] != 0) {
				double ratio = pivotRow[pivotGlobalPosition] / submatrix[i][pivotGlobalPosition];
				for (int j = 0; j < pivotRow.length; ++j) {
					submatrix[i][j] = submatrix[i][j] * ratio - pivotRow[j];
				}
			}
			if (allZero(submatrix[i])) {
				finished = true;
				problem.OverwriteSubMatrix(submatrix, threadIndex - 1);
				problem.setPrematureStop(true);
			}
		}
		problem.setCalculated(threadIndex, true);
	}

	private synchronized void checkIfDone() {
		if (problem.PivotIsLast() && checkRead() == false) {
			problem.OverwriteSubMatrix(submatrix, threadIndex);
			finished = true;
		}
	}

	private void PassPivot() {
		if (threadIndex == 1 && localPivot == 0) {
			problem.setThreadPivotWrite(threadIndex + 1);
			++localPivot;
		} else {
			problem.writePivotRow(submatrix[localPivot]);
			if (localPivot == submatrix.length - 1) {
				problem.setThreadPivotWrite(threadIndex + 1);
			}
			++localPivot;
		}
	}

	private boolean allZero(double[] ss) {
		int k = 0;
		for (int i = 0; i < ss.length - 1; ++i) {
			if (ss[i] != 0) {
				++k;
			}

		}
		if (k == 0) {
			return true;
		} else {
			return false;
		}
	}

	private synchronized boolean checkRead() {
		return problem.getTheadReadPivot(threadIndex);
	}

	private synchronized boolean checkWrite() {
		return problem.getWriteReadyStatus();
	}

	private void setReadDone() {
		problem.setThreadRead(threadIndex, false);
	}

	private synchronized boolean getWritePermission() {
		if (problem.getPivotWrite() == threadIndex) {
			return true;
		} else {
			return false;
		}
	}
}
