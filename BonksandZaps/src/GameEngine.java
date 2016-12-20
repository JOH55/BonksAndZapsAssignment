import java.util.Scanner;

/**
 * 
 */

/**
 * @author joshuahodges
 *
 */
public class GameEngine {
	/**
	 * @param args
	 * @throws CannotActException
	 */
	public static void main(String[] args) throws CannotActException {
		// TODO Auto-generated method stub
		GameEngine app = new GameEngine();
		System.out.println("/////////////////////////////////////////////");
		System.out.println("Welcome to bonks and zaps");
		System.out.println("How many turns would you like the game to run");
		System.out.println("/////////////////////////////////////////////");
		Scanner in = new Scanner(System.in);
		int turns = in.nextInt();
		System.out.println("/////////////////////////////////////////////");
		System.out.println("How many starting bonks would you like");
		System.out.println("/////////////////////////////////////////////");
		Scanner bonk = new Scanner(System.in);
		int bonks = in.nextInt();
		System.out.println("/////////////////////////////////////////////");
		System.out.println("How many starting zaps would you like");
		System.out.println("/////////////////////////////////////////////");
		Scanner zap = new Scanner(System.in);
		int zaps = in.nextInt();
		in.close();
		bonk.close();
		zap.close();
		app.run(turns, bonks, zaps);

	}

	public void run(int x, int y, int z) throws CannotActException {
		// setting up the world
		GridWorld world = new GridWorld();
		world.setup(y,z);

		// printing off the world
		int turn = x;
		for (int i = 0; i < turn; i++) {
			world.cycle(turn);
			System.out.println();
			System.out.println("Cycle" + (i + 1));
			world.display();
		}

	}

}
