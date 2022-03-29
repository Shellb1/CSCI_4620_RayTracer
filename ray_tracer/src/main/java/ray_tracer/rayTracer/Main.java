package ray_tracer.rayTracer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
class Main {

    public static void main(String[] args) {
        System.out.println("test");
        // NOTE: When debugging, can make image smaller to test
        try {
        	Logging.log("Beginning ray tracing");
        	long startTime = System.currentTimeMillis();
            Vector3 vector = new Vector3(200f, 200f, 200f);

            
            // create geometry
            var pointOne = new Vector3(0, 0, 0);
            
            
            
            RayTracer rt = new RayTracer(null, new Camera(vector, vector, vector), null);
            var image = rt.render(512, 512);
            ImageIO.write(image, "PNG", new File("./src/main/resources/out.png"));
            Logging.log("Ray tracing complete in: " + (System.currentTimeMillis() - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}