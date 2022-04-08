package ray_tracer.rayTracer;

public class PhongMaterial implements Material{

	  private Vector3 color;

	  public PhongMaterial(Vector3 color){
	    this.color = color;
	  } 
	  public Vector3 Shade(Vector3 fromDirection, Vector3 position, Vector3 normal, DirectionalLight directionalLight){
	    var ambient = new Vector3(.1f, .1f, .1f);

	    var diffuseStrength = normal.normalize().dotProduct(directionalLight.directionToLight.normalize());
	    diffuseStrength = Math.max(0, diffuseStrength);

	    var diffuse = this.color.scale(diffuseStrength);



	    //Find the reflection of the light with regards to the normal
	    //compare that to the from direction


	    var reflection = directionalLight.directionToLight.reflect(normal);
	    var specularStrength = Math.max(0, reflection.dotProduct(fromDirection));
	    specularStrength = (float) Math.pow(specularStrength, 1);

	    
	    var specular = new Vector3(1f, 1f, 1f).scale(specularStrength);

	    var finalColor =  ambient.add(diffuse).add(specular);
	    finalColor = finalColor.clamp(0, 1);

	    return finalColor;
	  }
}
