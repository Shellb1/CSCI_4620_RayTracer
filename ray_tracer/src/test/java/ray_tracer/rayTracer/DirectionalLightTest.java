package ray_tracer.rayTracer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DirectionalLightTest {

	@Test
	public void testNormalize() {
		Vector3 vector = new Vector3(1, 1, 1);
		Vector3 normalized = vector.normalize();
		DirectionalLight light = new DirectionalLight(vector, 1);
		light = light.normalize();
		assertTrue(light.directionToLight.x == normalized.x);
		assertTrue(light.directionToLight.y == normalized.y);
		assertTrue(light.directionToLight.z == normalized.z);
		assertTrue(light.intensity == 1);
	}
}
