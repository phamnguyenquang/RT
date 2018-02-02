package RadomizerForDeveloping;

import java.util.Random;

public class Randomizer {
	private double[][]A;
	private double [] B;
	private int dim;
	private int max = 100;
	private int min = 1;
	Random rand = new Random();
	
	public Randomizer(int i)
	{
		dim = i;
	}
	public double[] doRandomB()
	{
		B = new double[dim];
		for(int i = 0; i < dim; ++i)
		{
			B[i]= rand.nextInt(max - min + 1) + min;
		}
		return B;
	}
	public double[][]doRandom()
	{
		A = new double[dim][dim];
		for(int i = 0; i < dim; ++i)
		{
			for(int j = 0; j < dim; ++j)
			{
				A[i][j]= rand.nextInt(max - min + 1) + min;
			}
		}
		return A;
	}
	
	public double[][] getA()
	{
		return A;
	}
	
	public double[] getB()
	{
		return B;
	}
	
	public void print()
	{
		for(int i = 0; i < dim; ++i)
		{
			System.out.print("{");
			for(int j = 0; j < dim; ++j)
			{
				System.out.print(A[i][j] + ", ");
			}
			System.out.print("},");
			System.out.println("");
		}
	}
	
}
