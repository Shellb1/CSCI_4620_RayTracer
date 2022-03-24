package ray_tracer.rayTracer;

import org.junit.Test;

public class TriangleTest {

	
	@Test
	public void triangleTest() {
		Vector3 vector1 = new Vector3(1, 2, 3);
		Vector3 vector2 = new Vector3(4, 5, 6);
		Vector3 vector3 = new Vector3(7, 8, 9);
		Triangle triangle = new Triangle(vector1, vector2, vector3);
		Logging.log(triangle.toString());
	}
}
