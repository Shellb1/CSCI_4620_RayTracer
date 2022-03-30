package ray_tracer.rayTracer;
// combinaton of triangles and shader
public class Mesh {
    public Material material;
    public Geometry geometry;

    public Mesh(Geometry geometry, Material material) {
        this.material = material;
        this.geometry = geometry;
    }
}
