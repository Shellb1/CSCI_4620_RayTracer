package ray_tracer.rayTracer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
class Main {

    public static void main(String[] args) {
        // NOTE: When debugging, can make image smaller to test
        try {
        	Logging.log("Beginning ray tracing");
        	long startTime = System.currentTimeMillis();
        	
        	var width = 128;
        	var height = 128;

        	BufferedImage outImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        	
        	var pointOne = new Vector3(0, 0, 0);
        	var pointTwo = new Vector3(1, 0, 0);
        	var pointThree = new Vector3(0, 1, 0);
        	var triangle = new Triangle(pointOne, pointTwo, pointThree);
        	
        	var plane1 = new Plane(new Vector3(0, 0, -1), 1);
        	var plane2 = new Plane(new Vector3(0, (float) (-1 / Math.sqrt(2)), (float) (-1 / Math.sqrt(2))), 1);
        	
        	var sphere1 = new Sphere(new Vector3(0, 0, 0), 0.5f);
        	var material1 = new Material(new Vector3(0, 1, 0));
        	var material2 = new Material(new Vector3(1, 0, 0));
        	var material3 = new Material(new Vector3(0, 0, 1));
        	
        	var planeMesh1 = new Mesh(plane1, material1);
        	var planeMesh2 = new Mesh(plane2, material2);
        	
        	// camera
        	var cameraOrigin = new Vector3(0, 0, -1);
        	var cameraLookAt = new Vector3(0, 0, 0);
        	var cameraLookUp = new Vector3(0, 1, 0);
        	var halfWidth = Math.PI / 4;
        	
        	var camera = new Camera(cameraOrigin, cameraLookAt, cameraLookUp, halfWidth);
        	
        	var light = new DirectionalLight(new Vector3(1, 1, 1).normalize(), 1);
        	var scene = new Scene(new DirectionalLight[] {light}, camera, new Mesh[] {
        			planeMesh1,
        			planeMesh2,
        	});
        	scene.render(outImage);
        	ImageIO.write(outImage, "png", new File("./src/main/resources/out.png"));
     
        	
            Logging.log("Ray tracing complete in: " + (System.currentTimeMillis() - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}