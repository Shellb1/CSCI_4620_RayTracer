package ray_tracer.rayTracer;
// combinaton of triangles and shader
public class Mesh {
    public SolidMaterial material;
    public Geometry geometry;

    public Mesh(Geometry geometry, SolidMaterial material) {
        this.material = material;
        this.geometry = geometry;
    }
}
