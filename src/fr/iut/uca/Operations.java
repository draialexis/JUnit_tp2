package fr.iut.uca;

public class Operations {
	public long Add(long a, long b, long... others) {

		long res = a + b;
		
		if (others != null) {
			for(long num : others) {
				res += num;
		    }
		}
			
		return res;
	}
	
	public long Multiply(long a, long b, long... others) {

		long res = a * b;

		if (others != null) {
			for(long num : others) {
				res *= num;
		    }
		}
		
		return res;
	}

	public long Divide(long a, long b, long... others) {
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
	
}
