import java.util.ArrayList;

/**
 * 
 */

/**
 * @author joshuahodges
 *
 */
public class GridWorld {
	private Room[][] world;
	private ArrayList<Bonk> bArray = new ArrayList<>();
	private ArrayList<Zap> zArray = new ArrayList<>();
	private int bonkNumber = 0;

	public GridWorld() {
		world = new Room[20][20];
	}

	public void setup(int y, int z) {
		this.roomCreation();
		this.createBonks(y);
		this.createZaps(z);
	}

	public void cycle(int turns) throws CannotActException {
		// wait between turns
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Zaps kill bonks
		for (Room[] rooms : world) {
			for (Room room : rooms) {
				for (Monster mn : room.getContents()) {
					if (mn.getClass() == Zap.class && ((Zap) mn).getHasActed() == false) {
						for (Monster bonk : room.getContents()) {
							if (bonk.getClass() == Bonk.class && ((Bonk) bonk).getIsRip() == false) {
								((Bonk) bonk).setIsRip(true);
								((Zap) mn).setHasActed(true);
							}
						}
					}
				}
			}
		}

		// bonks mate
		for (Room[] rooms : world) {
			for (Room room : rooms) {
				for (Monster bnMale : room.getContents()) {
					if (bnMale.getClass() == Bonk.class && ((Bonk) bnMale).getGender() == Gender.MALE
							&& ((Bonk) bnMale).getIsBaby() == false && ((Bonk) bnMale).getHasMated() == false) {
						for (Monster bnFemale : room.getContents()) {
							if (bnMale.getClass() == Bonk.class && ((Bonk) bnMale).getGender() == Gender.MALE
									&& ((Bonk) bnMale).getIsBaby() == false && ((Bonk) bnMale).getHasMated() == false) {
								Bonk bonk = new Bonk(bonkNumber);
								bonk.location.setX(bnMale.location.x);
								bonk.location.setY(bnMale.location.y);
								bArray.add(bonk);
								((Bonk) bnMale).setHasMated(true);
								((Bonk) bnFemale).setHasMated(true);
							}
						}
					}
				}
			}
		}

		// move Monsters
		for (Room[] rooms : world) {
			for (Room room : rooms) {
				for (Monster bn : room.getContents()) {
					bn.act();
					if (bn.getClass() == Bonk.class) {
						bArray.add((Bonk) bn);
					}
					if (bn.getClass() == Zap.class) {
						zArray.add((Zap) bn);
					}
				}
			}
		}
		for (Room[] rooms : world) {
			for (Room room : rooms) {
				room.getContents().clear();
			}
		}

		// keeping track of the amount of monsters
		System.out.println();
		int bonk = 0;
		int deadBonk = 0;
		int zap = 0;
		for (Bonk b : bArray) {
			if (b.getIsRip() == false) {
				bonk++;
			} else {
				deadBonk++;
			}
		}
		for (int i = 0; i < zArray.size(); i++) {
			zap++;
		}
		System.out.println(bonk + "bonks " + deadBonk + "deadBonks " + zap + "zaps");

		// putting monsters back in the room
		for (Bonk b : bArray) {
			world[b.location.x][b.location.y].addMonster(b);
		}
		bArray.clear();
		for (Zap z : zArray) {
			world[z.location.x][z.location.y].addMonster(z);
		}
		zArray.clear();

	}

	// Displaying the world
	public void display() {
		String david = "";
		System.out.println();
		for (Room[] rooms : world) {
			for (Room room : rooms) {
				int bonkN = 0;
				int zapN = 0;
				int bonkD = 0;
				for (Being bn : room.getContents()) {
					if (bn.getClass() == Bonk.class) {
						if (((Mortal) bn).getIsRip() == false) {
							bonkN++;
						}
						if (((Mortal) bn).getIsRip() == true) {
							bonkD++;
						}
					}
					if (bn.getClass() == Zap.class) {
						zapN++;
					}
				}
				david += " " + bonkN + "b" + bonkD + "db" + zapN + "z" ;
			}
			System.out.println(david);
			david = "";
		}

	}

	// creating the rooms in the 2d array
	public void roomCreation() {
		int i;
		int j;
		for (i = 0; i < 20; i++) {
			for (j = 0; j < 20; j++) {
				world[i][j] = new Room(i, j);
			}
		}
	}

	// creating the bonks
	public void createBonks(int x) {
		for (int i = 0; i < x; i++) {
			Bonk bonk = new Bonk(bonkNumber);
			world[bonk.location.x][bonk.location.y].addMonster(bonk);
			bonk.setCurrentRoom(world[bonk.location.x][bonk.location.y]);
			bonkNumber = bonkNumber + 1;
		}
	}

	// creating the zaps
	public void createZaps(int x) {
		for (int i = 0; i < x; i++) {
			Zap zap = new Zap(i);
			world[zap.location.x][zap.location.y].addMonster(zap);
		}
	}

}
