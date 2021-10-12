package battlefield;


/*
 * Da sistemare. Vedi PositionTest.
 * (vedi DOMANDA 1)
 */
public class Position {
	
	private int x, y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
		
	public String toString() {
		return this.x+"-"+this.y;
	}
	
	@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
		Position that = (Position) obj;
			return this.getX() == that.getX() && this.getY()== that.getY();
		}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		
		return this.getX()+ this.getY()*31;
	}

}