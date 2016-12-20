/**
 * 
 */

/**
 * @author joshuahodges
 *
 */
public class Position {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return x + "," + y;
	}

	public int x = 0;
	public int y = 0;

	public Position() {
		x = 0;
		y = 0;

	}

	/**
	 * @param x2
	 */
	public void setX(int x2) {
		// TODO Auto-generated method stub
		this.x = x2;
	}

	/**
	 * @param y2
	 */
	public void setY(int y2) {
		// TODO Auto-generated method stub
		this.y = y2;
	}

}
