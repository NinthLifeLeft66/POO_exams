package battlefield;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Battlefield {

	static final private Class<?>[] TIPOLOGIE = { Walker.class, Chaser.class } ;

	static final private int NUMERO_TIPOLOGIE = TIPOLOGIE.length;

	static final private double OCCUPAZIONE_INIZIALE = 0.01d; // 1%

	private int dim;

	private Random random;
	
	private Map<Position, Robot> posizione2robot;

	public Battlefield(int dimensione) {
		this.dim = dimensione;
		this.posizione2robot = new HashMap<>();
		this.random = new Random();
	}

	public void addRobot(Robot r) {
		this.posizione2robot.put(r.getPosizione(), r);
	}

	public Robot getRobot(Position p) {
		return posizione2robot.get(p);
	}


	public Collection<Robot> getAllRobots() {
		return this.posizione2robot.values();
	}



	@SuppressWarnings("rawtypes")
	public Map<Class, Set<Robot>> raggruppaRobotPerTipo() {
		Map<Class, Set<Robot>> c2r = new HashMap<>();
		
		for (Robot r : this.getAllRobots()) {
			if ( c2r.containsKey(r.getClass()) ) {
				c2r.get( r.getClass() ).add(r);
			}else {
				c2r.put(r.getClass(), new HashSet<Robot>());
				c2r.get( r.getClass() ).add(r);
			}
		}
		
		return c2r;
	}
	
	public List<Robot> getRobotOrdinatiPerPosizione() {
		// (vedi DOMANDA 4)
		List<Robot> rOrd = new ArrayList<Robot>() ;
			
		ComparatoreRperPos comp = new ComparatoreRperPos();
		rOrd.addAll(this.getAllRobots());
		
		Collections.sort(rOrd, comp);
		
		
		return rOrd;
	}
	
	public SortedSet<Robot> getRobotOrdinatiPerLongevita() {
		// (vedi DOMANDA 6)
		SortedSet<Robot> robOrdLong= new TreeSet<Robot>(new Comparator<Robot>() {

			@Override
			public int compare(Robot r1, Robot r2) {
				int res = r1.getLongevita()-r2.getLongevita();
				if ( res==0)
					res= 1;
				return res;
			}
			
		});
		robOrdLong.addAll(getAllRobots());
		
		return robOrdLong;
	}
	
	public List<Position> adiacenti(Position perno) {
		final List<Position> adiacenti = new LinkedList<>();
		int x = perno.getX();
		int y = perno.getY();

		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				Position adiacente = new Position(x+i, y+j);
				if (inCampo(adiacente))
					adiacenti.add(adiacente);
			}
		}
		adiacenti.remove(perno);  // coincidono: quindi non sono adiacenti
		
		Collections.shuffle(adiacenti); /* ordine casuale */
		return adiacenti;
	}

	private boolean inCampo(Position p) {
		return  p.getX()>=0 && p.getX()<this.dim && 
				p.getY()>=0 && p.getY()<this.dim  ;
				
	} 

	public Position posizioneLiberaVicino(Position posizione) {
		for(Position p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}

	public boolean isLibera(Position posizione) {
		return ( this.getRobot(posizione)==null);
	}

	public int getDimensione() {
		return this.dim;
	}

	public void riempi() {
		long numeroIniziale = Math.round(OCCUPAZIONE_INIZIALE * dim * dim);
		for(int i=0 ; i<numeroIniziale; i++) {
			int x = this.random.nextInt(this.dim);
			int y = this.random.nextInt(this.dim);
			Position posizione = new Position(x, y);
			if (this.isLibera(posizione)) {
				switch (this.random.nextInt(NUMERO_TIPOLOGIE)) {
				case 0: Robot robot = new Chaser(posizione);
						this.addRobot(robot);
				break;
				case 1: Robot robot2 = new Walker(posizione);
						this.addRobot(robot2);
				break;
				//case: NUMERO_TIPOLOGIE-1...
				default: throw new IllegalStateException();
				} 
			}
		}
	}

}
