package dist.sim;

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
	 * Probabilita' di creazione in ciascun passo
	 */
	static final public float PROBABILITA_CREAZIONE = 0.001f;
	
	/**
	 * Probabilita' di un infetto di essere consapevole della propria infezione
	 */
	static final public float PROBABILITA_CONSAPEVOLEZZA = 0.75f;

	/**
	 * Durata (in passi) totale della simulazione
	 */
	static final public int DURATA_SIMULAZIONE = 200;

	/**
	 * Pausa (in millisecondi) tra due passi consecutivi della simulazione
	 */
	static final public int RITMO  = 100; // millis

}
