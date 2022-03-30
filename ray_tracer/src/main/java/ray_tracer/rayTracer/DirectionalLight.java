package ray_tracer.rayTracer;
public class DirectionalLight {
    public Vector3 direction;
    public double intensity;

    public DirectionalLight(Vector3 direction, double intensity) {
        this.direction = direction;
        this.intensity = intensity;
    }
    
    public DirectionalLight normalize() {
    	direction = direction.normalize();
    	return this;
    }
}
