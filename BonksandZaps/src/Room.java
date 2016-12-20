import java.util.ArrayList;

/**
 * 
 */

/**
 * @author joshuahodges
 *
 */
public class Room {

	protected ArrayList<Monster> contents;
	private Position position;
	private String name;

	/**
	 * @param contents
	 * @param position
	 */
	public Room(int i, int j) {
		this.contents = new ArrayList<Monster>();
		position = new Position();
		this.position.setX(i);
		this.position.setY(j);
		name = "Room " + String.valueOf(i) + String.valueOf(j);
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * add being to array
	 */
	public void addMonster(Monster being) {
		getContents().add(being);
	}

	/*
	 * remove being from array
	 */
	public void removeMonster(Monster being) {
		getContents().remove(being);
	}

	/**
	 * @return the contents
	 */
	public ArrayList<Monster> getContents() {
		return contents;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hasZap
	 */

}
