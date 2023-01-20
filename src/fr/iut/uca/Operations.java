package fr.iut.uca;

public class Operations {
	public long add(long a, long b, long... others) {

		long res = a + b;
		
		if (others != null) {
			for(long num : others) {
				res += num;
		    }
		}
			
		return res;
	}
	
	public long multiply(long a, long b, long... others) {

		long res = a * b;

		if (others != null) {
			for(long num : others) {
				res *= num;
		    }
		}
		System.out.println(res);
		return res;
	}

	public long divide(long a, long b, long... others) {
		if(b == 0) {
			throw new ArithmeticException("attempted to divide by zero");
		}
		
		long res = a / b;
		
		if(others != null) {
			for(long num : others) {
		        if(num == 0) {
		        	throw new ArithmeticException("attempted to divide by zero");
		        }
		        res *= num;
		    }
		}
		    
		return res;
	}
	
	public boolean pythagoras(long a, long b, long c) {
		if(a <= 0 || b <= 0 || c <= 0) {
			throw new ArithmeticException("there is no such thing as a negative length for a triangle's side");
		}
		
		return (
				(a * a) + (b * b) == c * c
				|| (c * c) + (b * b) == a * a
				|| (a * a) + (c * c) == b * b
				);
	}
	
}
