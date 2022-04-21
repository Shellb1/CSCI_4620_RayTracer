package ray_tracer.rayTracer;

public class PureReflective implements Material {

	 public PureReflective(){
		    
	  }
	  public Vector3 Shade(Vector3 fromDirection, Vector3 position, Vector3 normal, DirectionalLight directionalLight, Scene scene, int remainingBounces){
	   
	    if (remainingBounces == 0)
	      return new Vector3(0, 0, 0);

	    Vector3 bounceDirection = fromDirection.reflect(normal);
	    
	    var jx = Math.random() * 2 - 1;
			var jy = Math.random() * 2 - 1;
			var jz = Math.random() * 2 - 1;

			var jitter = new Vector3((float) jx, (float) jy, (float) jz).scale(.1f);
		bounceDirection = bounceDirection.add(jitter).normalize();
	    var intersection = scene.shootRay(
	        new Ray(
	            position.add(bounceDirection.scale(.1f)),
	            bounceDirection));
	    if (intersection == null)
	      return new Vector3(0, 0, 0);

	    var collisionPosition = position.add(bounceDirection.scale(intersection.t));
	    var closestColor = intersection.mesh.material.Shade(
	        fromDirection,
	        collisionPosition,
	        intersection.normal,
	        directionalLight,
	        scene,
	        remainingBounces - 1);

	    closestColor = closestColor.scale(.9f);

	    return closestColor;
	  }
}
