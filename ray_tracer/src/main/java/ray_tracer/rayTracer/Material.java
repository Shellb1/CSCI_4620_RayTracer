package ray_tracer.rayTracer;

public interface Material {

	Vector3 Shade(Vector3 lookDirection, Vector3 position, Vector3 normal, DirectionalLight directionalLight,
			Scene scene, int remainingBounces);
}
