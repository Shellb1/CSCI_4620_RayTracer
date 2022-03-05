
// combinaton of triangles and shader
public class Mesh {
    public Material material;
    public Triangle[] triangles;

    public Mesh(Material material, Triangle[] triangles) {
        this.material = material;
        this.triangles = triangles;
    }
}
