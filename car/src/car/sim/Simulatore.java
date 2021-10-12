package car.sim;

import static car.sim.CostantiSimulazione.DURATA_SIMULAZIONE;
import static car.sim.CostantiSimulazione.NUMERO_AUTO_PER_TIPOLOGIA;
import static car.sim.CostantiSimulazione.RITMO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.SwingUtilities;

import car.auto.Auto;
import car.auto.Bianca;
import car.auto.Gialla;
import car.gui.GUI;
import car.stats.Statistiche;

public class Simulatore {

	final private Zona zona;

	final private List<Auto> vetture;

	private int passo;

	private GUI gui;
	
	public Simulatore() {
		this.zona = new Zona();
		this.passo = 0;
		this.vetture = new ArrayList<>();
		creaVetture();
	}

	private void creaVetture() {
		/* DA AGGIORNARE (VEDI DOMANDA 2) */
		for(int i=0; i<NUMERO_AUTO_PER_TIPOLOGIA; i++) {
			this.vetture.add(creaBianca());
			this.vetture.add(creaGialla());
		}
	}
	
	public Auto creaBianca() {
		return new Bianca(this.getZona());
	}

	public Auto creaGialla() {
		return new Gialla(this.getZona());
	}


	public List<Auto> getVetture() {
		return this.vetture;
	}

	public void setGUI(GUI gui) {
		this.gui = gui;
	}

	public Zona getZona() {
		return this.zona;
	}

	public int getPasso() {
		return this.passo;
	}

	public void simula() {

		for(this.passo=0; this.passo<DURATA_SIMULAZIONE; this.passo++) {

			eseguiPassoDellaSimulazione();

			aggiornaStatistiche();

			pausa();
		}
		/**
		 * Termina la simulazione corrente stampando le statistiche finali
		 */
		new Statistiche().stampaFinale(this.getZona());

		terminaSimulazione();
	}

	private void eseguiPassoDellaSimulazione() {
		Collections.shuffle(this.vetture);
		/* DA CAMBIARE ( VEDI DOMANDA 2 )*/
		for(Auto vettura : this.vetture) {
			vettura.simula(this.getPasso());
		}
	}

	private void aggiornaStatistiche() {
		/* stampa passo simulazione */
		this.gui.riportaNelTitolo(this.passo, this.getZona());
	}

	private void pausa() {
		try {
			this.updateGui();
			Thread.sleep(RITMO);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void updateGui() {
		SwingUtilities.invokeLater( new Runnable() {			
			@Override
			public void run() {
				Simulatore.this.gui.repaint();
			}
		});
	}

	/**
	 * Termina la partita corrente
	 */
	public void terminaSimulazione() {
		System.exit(-1);
	}

}
