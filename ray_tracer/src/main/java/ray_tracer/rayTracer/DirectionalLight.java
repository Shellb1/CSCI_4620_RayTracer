package ray_tracer.rayTracer;
public class DirectionalLight {
    public Vector3 directionToLight;
    public double intensity;

    public DirectionalLight(Vector3 direction, double intensity) {
        this.directionToLight = direction;
        this.intensity = intensity;
    }
    
    public DirectionalLight normalize() {
    	directionToLight = directionToLight.normalize();
    	return this;
    }
}
