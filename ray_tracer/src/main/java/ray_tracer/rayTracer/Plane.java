package ray_tracer.rayTracer;

public class Plane implements Geometry {

	public Vector3 ABC; // technically the normal
	public double D;
	
	public Plane(Vector3 ABC, double D) {
		this.ABC = ABC;
		this.D = D;
	}
	
	@Override
	public TAndNormal intersect(Ray ray) {
		var num = -D - ABC.dotProduct(ray.origin);
		var den = ABC.dotProduct(ray.direction);
		var T = (float) num / den;
		return new TAndNormal(T, ABC);
	}
	
}
