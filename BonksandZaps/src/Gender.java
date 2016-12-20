import java.util.*;

/**
 * 
 */

/**
 * @author joshuahodges
 *
 */
public enum Gender {
 MALE , FEMALE;
 
 private static final List<Gender> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
 private static final int SIZE = VALUES.size();
 private static final Random RANDOM = new Random();

 public static Gender assignGender()  {
	 return VALUES.get(RANDOM.nextInt(SIZE));
 }

}
