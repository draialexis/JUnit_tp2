package fr.iut.uca;

public class PGCD {
	public int pgcd(int a, int b) {
		if (a < 0) a = -a;
		if (b < 0) b = -b;
		
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		if (b == 0) return a;

		int q = a % b;
		if(q == 0) {
			return b;
		} else {
			return pgcd(b, q);
		}
		
	}
}
