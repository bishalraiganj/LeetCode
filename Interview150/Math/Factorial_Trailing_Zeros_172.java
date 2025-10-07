package Interview150.Math;

import java.math.BigInteger;

public class Factorial_Trailing_Zeros_172 {



	public static void main(String... args)
	{
		int num = 21;

		System.out.println(trailingZeroes(num));
	}
	public static int trailingZeroes(int n) {

		BigInteger fact = factorial(n);
		int zeroCount = 0;

		while( fact.subtract((fact.divide(BigInteger.valueOf(10)).multiply(BigInteger.valueOf( 10)))).equals(BigInteger.valueOf(0)))
		{
			fact= fact.divide(BigInteger.valueOf(10));
			zeroCount++;
		}
		return zeroCount;
	}

	public static BigInteger factorial(int n)
	{
		BigInteger acc = new BigInteger("1");
		while(n > 0)
		{
			acc = acc.multiply(BigInteger.valueOf(n));
			--n;
		}
		return acc;
	}


	public int trailinZeroes1(int n)
	{
		int count  = 0;
		while(n > 0)
		{
			n/=5;
			count++;
		}
		return count;

	}
}
