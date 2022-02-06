package domaci_04_02_2022;

import java.util.List;

public class Sorted {
	public static boolean sort(List<Double> array) {
		for (int i = 0; i < array.size(); i++) {
			if (i != 0) {
				if (array.get(i) < array.get(i - 1)) {
					return false;
				}
			}
		}
		return true;
	}
}
