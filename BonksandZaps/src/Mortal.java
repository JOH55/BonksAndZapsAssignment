/**
 * 
 */

/**
 * @author joshuahodges
 *
 */
public abstract class Mortal extends Monster {

	private Gender gender;
	private Boolean isRip;
	private Boolean hasMated;
	private Boolean isBaby;

	public Mortal() {
		isRip = false;
		hasMated = false;
		isBaby = true;
		gender = Gender.assignGender();
	}

	/**
	 * @return the isRip
	 */
	public Boolean getIsRip() {
		return isRip;
	}

	/**
	 * @param isRip
	 *            the isRip to set
	 */
	public void setIsRip(Boolean isRip) {
		this.isRip = isRip;
	}

	/**
	 * @return the hasMated
	 */
	public Boolean getHasMated() {
		return hasMated;
	}

	/**
	 * @param hasMated
	 *            the hasMated to set
	 */
	public void setHasMated(Boolean hasMated) {
		this.hasMated = hasMated;
	}

	/**
	 * @return the isBaby
	 */
	public Boolean getIsBaby() {
		return isBaby;
	}

	/**
	 * @param isBaby
	 *            the isBaby to set
	 */
	public void setIsBaby(Boolean isBaby) {
		this.isBaby = isBaby;
	}


	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
