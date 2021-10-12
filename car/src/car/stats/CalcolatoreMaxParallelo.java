package car.stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CalcolatoreMaxParallelo implements CalcolatoreMax {

	@Override
	public int max(final int[][] m) {
		int n_thread = Runtime.getRuntime().availableProcessors();

		List<Thread> threads = new ArrayList<>(n_thread);
		final Integer[] maxRelativi = new Integer [n_thread];

		int dimFetta = m.length / n_thread;
		int resto  = m.length % n_thread;

		int inizioFetta =0;

		for (int i=0; i<n_thread; i++) {

			int fineFetta = inizioFetta + dimFetta;
			final int indice = i;
			final int inizio = inizioFetta;
		
			if (i<resto) {
				fineFetta++;
			}
			
			final int fine = fineFetta;
			
			threads.add(new Thread(new Runnable() {

				@Override
				public void run() {
					maxRelativi[indice] = new CalcolatoreMaxSeriale().max(m, inizio, fine);
				}

			}));
			inizioFetta = fineFetta;

		}

		for(int j=0; j<n_thread; j++) {
			try {
				threads.get(j).join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		return Collections.max(Arrays.asList(maxRelativi));

		
	}

}
