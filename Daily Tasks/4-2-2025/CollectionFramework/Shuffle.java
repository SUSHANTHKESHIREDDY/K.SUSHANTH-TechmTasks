package Collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Shuffle {
	public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Orange");

        Collections.shuffle(colors);

        System.out.println("Shuffled ArrayList: " + colors);
	}
}
