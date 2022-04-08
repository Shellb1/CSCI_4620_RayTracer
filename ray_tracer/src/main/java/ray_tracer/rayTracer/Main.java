package ray_tracer.rayTracer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
class Main {

    public static void main(String[] args) {
        // NOTE: When debugging, can make image smaller to test
        try {	
        	Logging.log("Beginning ray tracing");
        	long startTime = System.currentTimeMillis();
        	
        	var width = 512;
        	var height = 512;

        	BufferedImage outImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        	
        	File f = new File("./src/main/resources/triangles.obj");
        	Scanner scanner = new Scanner(f);
        	ArrayList<Vector3> vertices = new ArrayList<Vector3>();
        	ArrayList<Triangle> triangles = new ArrayList<Triangle>();
        	while (scanner.hasNextLine()) {
        		String line = scanner.nextLine();
        		if (line.startsWith("v ")) {
        			String[] parts = line.split(" ");
        			vertices.add(new Vector3(Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Float.parseFloat(parts[3])));
        		}
        		if (line.startsWith("f")) {
        			String[] parts = line.split(" ");
        			String[] splitBySlashes = parts[1].split("/");
        			int index = Integer.parseInt(splitBySlashes[1]) - 1;
        			Vector3 vertice1 = vertices.get(index);
        			splitBySlashes = parts[2].split("/");
        			index = Integer.parseInt(splitBySlashes[1]) - 1;
        			Vector3 vertice2 = vertices.get(index);
        			splitBySlashes = parts[3].split("/");
        			index = Integer.parseInt(splitBySlashes[1]) - 1;
        			Vector3 vertice3 = vertices.get(index);
        			
        			Triangle triangle = new Triangle(vertice1, vertice2, vertice3);
        			triangles.add(triangle);
        		}
        	}
        	
        	var pointOne = new Vector3(0, 0, 0); 
        	var pointTwo = new Vector3(1, 0, 0);
        	var pointThree = new Vector3(0, 1, 0);
        	var triangle = new Triangle(pointOne, pointTwo, pointThree);
        	
        	var plane1 = new Plane(new Vector3(0, 0, -1), 1);
        	var plane2 = new Plane(new Vector3(0, (float) (-1 / Math.sqrt(2)), (float) (-1 / Math.sqrt(2))), 1);
        	
        	var sphere1 = new Sphere(new Vector3(0, 0, 0), 0.5f);
        	var material1 = new PhongMaterial(new Vector3(1, 0, 0));
        	var material2 = new PhongMaterial(new Vector3(1, 0, 0));
        	var material3 = new PhongMaterial(new Vector3(0, 0, 1));
        	
        	var planeMesh1 = new Mesh(plane1, material1);
        	var planeMesh2 = new Mesh(plane2, material2);
            var sphereMesh1 = new Mesh(sphere1, material3);
        	
        	// camera
        	var cameraOrigin = new Vector3(0, 0, -1);
        	var cameraLookAt = new Vector3(0, 0, 0);
        	var cameraLookUp = new Vector3(0, 1, 0);
        	var halfWidth = Math.PI / 4;
        	
        	var camera = new Camera(cameraOrigin, cameraLookAt, cameraLookUp, halfWidth);
        	
        	var light = new DirectionalLight(new Vector3(2, 2, -2).normalize(), 1);
        	var scene = new Scene(new DirectionalLight[] {light}, camera, new Mesh[] {
        			planeMesh1,
        			//planeMesh2,
        			sphereMesh1,
        	});
        	scene.render(outImage);
        	ImageIO.write(outImage, "png", new File("./src/main/resources/out.png"));
     
            Logging.log("Ray tracing complete in: " + (System.currentTimeMillis() - startTime) + " milliseconds");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}