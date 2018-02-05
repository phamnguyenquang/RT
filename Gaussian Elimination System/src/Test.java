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
		/*
		 * This sector can be used to make the matrices for simltaneous equation with
		 * the problem size greater than 50
		 */
		// Randomizer test = new Randomizer(1500);
		// test.doRandom();
		// test.doRandomB();

		/*-----------------------------------------------------------*/

		/*
		 * Define the problem size There are hard coded instances of the problem found
		 * in testCases package change the name accordingly coreNo defines number of
		 * core used
		 */
		TestCase test = new FiftyVariable();
		int CoreNo = 3;
		long startTime, stopTime;
		GaussianElimination work = new GaussianElimination(test.getA(), test.getB());
		Problem problem = new Problem(test.getA(), test.getB(), CoreNo);
		MatrixSolverRREF RREF = new MatrixSolverRREF(test.getA(), test.getB(), CoreNo);
		
		/*-----------------------------------------------------------*/
		
		/*
		 * Single core means sequential processing Uncomment the section below to use
		 * comment the other secion(s) for a healthier cpu
		 */
		// System.err.println("Single core");
		// startTime = System.currentTimeMillis();
		// work.Substitution();
		// work.PrintAugmented();
		// stopTime = System.currentTimeMillis();
		// System.out.println(stopTime - startTime + " ms");

		/*-----------------------------------------------------------*/
		
		/*Multicore synchronization using thread calling
		 * uncomment the section to use
		 * Time pringing function is coded in MulticoreSubstitution()
		 * Function to print augmented matrix is not yet implemented
		 * This implementation can be found in MulticoreRREF package*/
		
		// System.err.println("Multicore");
		// RREF.MulticoreSubstitution();

		/*-----------------------------------------------------------*/
		
		/*Multicore synchronization using semaphore
		 * uncomment the section to use
		 * This implementation can be found in MulticoreRunnable package
		 * PrintAugmented() can be used to print the initial/final augmented matrix
		 * depends on where the function call is placed*/
		startTime = System.currentTimeMillis();
		Thread[] t = new Thread[CoreNo];
		for (int i = 0; i < CoreNo; ++i) {
			t[i] = new Core(problem, i + 1);
			t[i].setPriority(Thread.MAX_PRIORITY);
			t[i].start();
		}
		for (int i = 0; i < CoreNo; ++i) {
			t[i].join();
		}

		problem.MergeSubMatrix();
		problem.ComputeSolution();
		System.out.println("");
		// publisher.PrintAugmented();
		problem.printSolution();
		stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime + " ms");
		
		/*-----------------------------------------------------------*/
	}

}
