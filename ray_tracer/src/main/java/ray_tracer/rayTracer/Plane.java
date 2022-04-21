package ray_tracer.rayTracer;

public class Plane implements Geometry {

	  public Vector3 ABC; // technically normal 
	  public float D;

	  public Plane(Vector3 ABC, float D) {
	    this.ABC = ABC;
	    this.D = D;
	  }

	  public Plane(Vector3[] points){
	    Vector3 ab = points[0].subtract(points[1]);
	    Vector3 cb = points[2].subtract(points[1]);
	    Vector3 crossProduct = ab.crossProduct(cb);
	    this.ABC = crossProduct.normalize();
	    
	    this.D = -this.ABC.dotProduct(points[0]);
	  }

	  public Plane(Vector3 one, Vector3 two, Vector3 three){
	    this(new Vector3[]{one, two, three});
	  }

	  @Override
	  public Intersection intersect(Ray ray) {

	    var num = -D-ABC.dotProduct(ray.origin);
	    var den = ABC.dotProduct(ray.direction);
	    var T = num/den;
	    return new Intersection(T, ABC, null);
	  }

	  public float offset(Vector3 collision) {
	    return this.ABC.dotProduct(collision)+this.D;
	  }

}
