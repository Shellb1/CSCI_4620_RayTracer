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
					var x = Float.parseFloat(parts[1]);
					var y = Float.parseFloat(parts[2]);
					var z = Float.parseFloat(parts[3]);
					Vector3 vertex = new Vector3(x, y, z);
					vertices.add(vertex);
				} else if (line.startsWith("f")) {
					String[] firstParts = line.split(" ");

					var indexOne = Integer.parseInt(firstParts[1].split("/")[0]);
					var indexTwo = Integer.parseInt(firstParts[2].split("/")[0]);
					var indexThree = Integer.parseInt(firstParts[3].split("/")[0]);
					var one = vertices.get(indexOne - 1);
					var two = vertices.get(indexTwo - 1);
					var three = vertices.get(indexThree - 1);
					var objTriangle = new Triangle(one, two, three);
					triangles.add(objTriangle);
				}
			}
			var phong = new PhongMaterial(new Vector3(0, 0, 1));

			var pointOne = new Vector3(0, 0, 0);
			var pointTwo = new Vector3(1, 0, 0);
			var pointThree = new Vector3(0, 1, 0);
			var triangle = new Triangle(pointOne, pointTwo, pointThree);

			var plane1 = new Plane(new Vector3(0, 0, -1), 1);
			var plane2 = new Plane(new Vector3(0, (float) (-1 / Math.sqrt(2)), (float) (-1 / Math.sqrt(2))), 1);

			var sphere1 = new Sphere(new Vector3(0, 0, 0), 0.5f);
			var material1 = new SolidMaterial(new Vector3(0, 1, 0));
			var material2 = new PhongMaterial(new Vector3(1, 0, 0));
			var material3 = new PhongMaterial(new Vector3(0, 0, 1));

			var planeMesh1 = new Mesh(plane1, material1);
			var planeMesh2 = new Mesh(plane2, material2);
			var sphereMesh1 = new Mesh(sphere1, material3);
			var triangleMesh = new Mesh(triangle, material1);

			Triangle[] allTriangles = triangles.toArray(new Triangle[0]);
			Mesh[] allObjMeshes = new Mesh[allTriangles.length];
			for (var i = 0; i < allTriangles.length; i++) {
				var mesh = new Mesh(allTriangles[i], material1);
				allObjMeshes[i] = mesh;
			}

			// camera
			var cameraOrigin = new Vector3(0, 0, -1);
			var cameraLookAt = new Vector3(0, 0, 0);
			var cameraLookUp = new Vector3(0, 1, 0);
			var halfWidth = Math.PI / 4;

			var camera = new Camera(cameraOrigin, cameraLookAt, cameraLookUp, halfWidth);

			var light = new DirectionalLight(new Vector3(2, 2, -2).normalize(), 1);
//        	var scene = new Scene(new DirectionalLight[] {light}, camera, new Mesh[] {
//        			//planeMesh1,
//        			//planeMesh2,
//        			//sphereMesh1,
//        			triangleMesh,
//        	});
			var scene = new Scene(new DirectionalLight[] { light }, camera, allObjMeshes);
			scene.render(outImage);
			ImageIO.write(outImage, "png", new File("./src/main/resources/out.png"));

			Logging.log("Ray tracing complete in: " + (System.currentTimeMillis() - startTime) + " milliseconds");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}