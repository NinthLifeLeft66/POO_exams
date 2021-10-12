package car.stats;

import java.util.NoSuchElementException;

public class CalcolatoreMaxSeriale implements CalcolatoreMax {

	@Override
	public int max(int[][] m) {
		return max(m,0,m[0].length);
	}
	
	public int max(int[][] m, int colonnaIniziale, int colonnaFinale) {
		if (colonnaIniziale==colonnaFinale) throw new NoSuchElementException();
		int max = m[0][colonnaIniziale];
		for(int c=colonnaIniziale;c<colonnaFinale; c++) {
			for(int r=0;r<m[c].length; r++) {
				if (m[r][c]>max)
					max = m[r][c];
			}
		}
		return max;
	}

}
