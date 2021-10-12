package battlefield;

import java.util.Comparator;

public class ComparatoreRperPos implements Comparator<Robot>{

	

	@Override
	public int compare(Robot o1, Robot o2) {
		int res = o1.getPosizione().getX() -  o2.getPosizione().getX();
		 if ( res==0)
			res = o1.getPosizione().getY() -  o2.getPosizione().getY();
			 
		
		return res;
	}

}
