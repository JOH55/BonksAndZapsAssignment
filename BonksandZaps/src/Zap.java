import java.util.Random;

/**
 * 
 */

/**
 * @author joshuahodges
 *
 */
public class Zap extends Monster {

	private Boolean hasActed = false;

	/**
	 * 
	 */
	public Zap(int i) {
		// random position for zap
		Random random = new Random();
		int x = random.nextInt(19);
		location.setX(x);
		int y = random.nextInt(19);
		location.setY(y);

		// setting name
		name = 'z' + String.valueOf(i + 1);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Being#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Being#act()
	 */
	@Override
	public void act() throws CannotActException {
		// TODO Auto-generated method stub

		// Being moves
		int newX = 0;
		int oldX = this.location.x;
		int newY = 0;
		int oldY = this.location.y;
		// getting new values
		Random rn = new Random();
		newX = oldX + rn.nextInt(3) - 1;
		newY = oldY + rn.nextInt(3) - 1;
		// setting new values
		if (-1 < newX) {
			if (newX < 20) {
				this.location.setX(newX);
			}
		}
		if (-1 < newY) {
			if (newY < 20) {
				this.location.setY(newY);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Being#getLocation()
	 */
	@Override
	public Position getLocation() {
		// TODO Auto-generated method stub
		return this.currentRoom.getPosition();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Being#setLocation(Position)
	 */
	@Override
	public void setLocation(Position location) {
		// TODO Auto-generated method stub
		this.currentRoom.setPosition(location);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * @return the hasActed
	 */
	public Boolean getHasActed() {
		return hasActed;
	}

	/**
	 * @param hasActed
	 *            the hasActed to set
	 */
	public void setHasActed(Boolean hasActed) {
		this.hasActed = hasActed;
	}

}
