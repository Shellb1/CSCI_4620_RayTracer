package ray_tracer.rayTracer;
import java.awt.image.*;
import java.awt.*;

public class RayTracer {

    public Light[] lights;
    public Camera camera;
    public Mesh mesh;

    public RayTracer(Light[] lights, Camera camera, Mesh mesh) {
        this.lights = lights;
        this.camera = camera;
        this.mesh = mesh;
    }

    public BufferedImage render(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        // trace image
        for (var y = 0; y < height; y++) {
            for (var x = 0; x < width; x++) {
                image.setRGB(x, y, new Color(x / (float) width, y / (float) height, 0.8f).getRGB());
            }
        }
        return image;
    }
}
