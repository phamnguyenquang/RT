import java.util.concurrent.ExecutionException;

import ImprovedMulticore.MasterThread;
import MultiCoreRunnable.Core;
import MultiCoreRunnable.Problem;
import MulticoreRREF.MatrixSolverRREF;
import RadomizerForDeveloping.Randomizer;
import ServerClientModel.TwentyVariable;
import SingleCoreModel.GaussianElimination;
import testCase.EightVariable;
import testCase.FiftyVariable;
import testCase.FiveVariable;
import testCase.FourVariable;
import testCase.FourtyFiveVariable;
import testCase.FourtyVariable;
import testCase.NineVariable;
import testCase.SevenVariable;
import testCase.TestCase;
import testCase.TewlveVariable;
import testCase.ThirtyVariable;
import testCase.ThreeVariable;
import testCase.ThreeVariableExtend;

public class Test {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Randomizer test = new Randomizer(1500);
		// test.doRandom();
		// test.doRandomB();

		TestCase test = new FiftyVariable();
		int CoreNo = 3;
		long startTime, stopTime;
		GaussianElimination work = new GaussianElimination(test.getA(), test.getB());
		Problem publisher = new Problem(test.getA(), test.getB(), CoreNo);
		MatrixSolverRREF RREF = new MatrixSolverRREF(test.getA(), test.getB(), CoreNo);
		//

		// int cores = Runtime.getRuntime().availableProcessors();
		// System.out.println(cores);

		// boolean multi = true;
		//
		// if (!multi) {
		//
		// System.err.println("Single core");
		// startTime = System.currentTimeMillis();
//		 work.Substitution();
//		 work.PrintAugmented();
		// stopTime = System.currentTimeMillis();
		// System.out.println(stopTime - startTime + " ms");
		//
		// }
		//
		// else {
		// System.err.println("Multicore");
		// RREF.MulticoreSubstitution();
		// }

		startTime = System.currentTimeMillis();
		Thread[] t = new Thread[CoreNo];
		for (int i = 0; i < CoreNo; ++i) {
			t[i] = new Core(publisher, i + 1);
			// t[i].setPriority(Thread.MAX_PRIORITY);
			t[i].start();
		}
		for (int i = 0; i < CoreNo; ++i) {
			t[i].join();
		}

		publisher.MergeSubMatrix();
		publisher.ComputeSolution();
		System.out.println("");
//		publisher.PrintAugmented();
		publisher.printSolution();
		stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime + " ms");
	}

}
