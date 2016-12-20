import java.util.Random;

/**
 * 
 */

/**
 * @author joshuahodges
 *
 */
public class Bonk extends Mortal {
	private int age = 0;

	public Bonk(int i) {
		super();

		// naming bonk
		name = 'b' + String.valueOf(i);

		// setting random position for bonk
		Random random = new Random();
		int x = random.nextInt(19);
		location.setX(x);
		int y = random.nextInt(19);
		location.setY(y);

		// setting alive
		this.setIsRip(false);

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
		if (this.getAge() > 1) {
			this.setIsBaby(false);
		}

		if (this.getIsRip() == false) {
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
		this.setAge(getAge() + 1);

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
		return (name);
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
