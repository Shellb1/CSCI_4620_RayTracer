package ray_tracer.rayTracer;

public class Plane {

	public Vector3 ABC; // technically the normal
	public double D;
	
	public Plane(Vector3 ABC, double D) {
		this.ABC = ABC;
		this.D = D;
	}
	
}
