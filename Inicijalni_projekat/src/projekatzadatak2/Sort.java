package projekatzadatak2;

import java.util.Comparator;

import geometry.Circle;

public class Sort implements Comparator<Circle> {

	@Override
	public int compare(Circle o1, Circle o2) {
			return (int)(o1.area()-(o2.area()));
	}

}
