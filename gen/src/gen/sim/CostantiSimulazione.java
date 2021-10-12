package gen.sim;

public class CostantiSimulazione {

	/**
	 * La {@link Ambiente} in cui si svole la simulazione è un quadrato di queste dimensioni (incluso i bordi)
	 */
	static final public int DIMENSIONE = 30;

	/**
	 * Numero per ogni tipologia
	 */
	static final public int NUMERO_INIZIALE_PER_TIPOLOGIA = 10;

	/**
	 * Probabilita' riproduzione
	 */
	static final public float PROBABILITA_RIPRODUZIONE = 0.3f;

	/**
	 * Probabilita' scontro
	 */
	static final public float PROBABILITA_SCONTRO = 0.3f;

	/**
	 * Probabilita' morte
	 */
	static final public float PROBABILITA_MORTE = 0.05f;

	/**
	 * Minimo eta' riproduzione
	 */
	static final public int MIN_ETA_RIPRODUZIONE = 14;

	/**
	 * Massimo eta' riproduzione
	 */
	static final public int MAX_ETA_RIPRODUZIONE = 40;


	/**
	 * Durata (in passi) totale della simulazione
	 */
	static final public int DURATA_SIMULAZIONE = 500;

	/**
	 * Pausa (in millisecondi) tra due passi consecutivi della simulazione
	 */
	static final public int RITMO  = 100; // millis

}
