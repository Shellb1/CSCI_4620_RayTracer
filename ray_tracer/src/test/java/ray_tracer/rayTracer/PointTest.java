package ray_tracer.rayTracer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PointTest {

	private Point zero;
	private Point one;
	private Point two;
	private Point three;
	
	@Before
	public void setUp() {
		zero = new Point(0, 0, 0);
		one = new Point(1, 1, 1);
		two = new Point(2, 2, 2);
		three = new Point(10, -7, 25);
	}
//	@Test
//	public void testNormalize() {
//		Point normalOne = one.normalize();
//		assertEquals(normalOne.x, (float) 1 / Math.sqrt(3), 0.0000001);
//		assertEquals(normalOne.y, (float) 2 / Math.sqrt(3), 0.0000001);
//		assertEquals(normalOne.z, (float) 3 / Math.sqrt(3), 0.0000001);
//
//	}
	
	@Test
	public void testDot() {
		assertEquals(one.dot(two), 6, 0.00001);
		assertEquals(71, two.dot(three), 0.0001);
	}
	
	@Test
	public void testCross() {
		Point cross = one.cross(two);
		assertEquals(cross.x, 1, 0.00001);
		assertEquals(cross.y, -2, 0.000001);
		assertEquals(cross.z, 1, 0.00001);
	}
}
