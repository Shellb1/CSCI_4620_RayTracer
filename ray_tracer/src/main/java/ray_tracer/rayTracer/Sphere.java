package ray_tracer.rayTracer;

public class Sphere implements Geometry {

	public Vector3 center;
	public float radius;
	
	public Sphere(Vector3 center, float radius) {
		this.center = center;
		this.radius = radius;
	}
	
	@Override
	public TAndNormal intersect(Ray ray) {
	    float A = ray.direction.dotProduct(ray.direction);
	    float B = 2 * ray.direction.dotProduct(ray.origin.subtract(center));
	    Vector3 oc = ray.origin.subtract(center);
	    float C = oc.dotProduct(oc) - radius * radius;

	    float inSqrt = B * B - 4 * A * C;
	    if (inSqrt < 0)
	      return new TAndNormal(-1, null);

	    float num1 = -1 * B - (float) Math.sqrt(B * B - 4 * A * C);
	    float num2 = -1 * B + (float) Math.sqrt(B * B - 4 * A * C);
	    float den = 2 * A;
	    float t1 = num1 / den;
	    float t2 = num2 / den;
	    float t;

	    
	    if (t1 > 0 && t1 < t2)
	      t = t1;
	    else if (t1 < 0 && t2 > 0)
	      t = t2;
	    else
	      return new TAndNormal(-1, null);

	    var collisionPoint = ray.origin.add(ray.direction.scale(t));
	    var normal = (collisionPoint.subtract(center)).normalize();
	    return new TAndNormal(t, normal);
	}

}
