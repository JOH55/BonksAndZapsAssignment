/**
 * 
 */

/**
 * @author joshuahodges
 *
 */
public abstract class Monster implements Being {
	protected Room currentRoom;
	protected String name;
	protected Position location;

	/**
	 * @return the location
	 */
	@Override
	public Position getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	@Override
	public void setLocation(Position location) {
		this.location = location;
	}

	/**
	 * @param currentRoom
	 * @param name
	 * @param location
	 */
	public Monster() {
		super();
		// this.currentRoom = currentRoom;
		// this.name = name;
		this.location = new Position();
	}

	/**
	 * @return the currentRoom
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * @param currentRoom
	 *            the currentRoom to set
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public void setName(String nm) {
		this.name = nm;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
