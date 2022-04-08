package ray_tracer.rayTracer;

public class SolidMaterial implements Material {
	public Vector3 color;

	public SolidMaterial(Vector3 color) {
		this.color = color;
	}

	@Override
	public Vector3 Shade(Vector3 lookDirection, Vector3 position, Vector3 normal, DirectionalLight directionalLight) {
		return this.color;
	}
}
