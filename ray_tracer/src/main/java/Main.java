import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
class Main {

    public static void main(String[] args) {
        System.out.println("test");
        // NOTE: When debugging, can make image smaller to test
        try {
            Vector3 vector = new Vector3(200f, 200f, 200f);

            RayTracer rt = new RayTracer(null, new Camera(vector, vector, vector), null);
            var image = rt.render(512, 512);
            ImageIO.write(image, "PNG", new File("./out.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}