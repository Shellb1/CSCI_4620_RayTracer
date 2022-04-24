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
			// add triangles to meshes
			Triangle[] allTriangles = triangles.toArray(new Triangle[0]);
			ArrayList<Mesh> allMeshes = new ArrayList<Mesh>();
			Mesh planeMesh = Meshes.planeMesh1;
			allMeshes.add(planeMesh);
			for (var i = 0; i < allTriangles.length; i++) {
				var mesh = new Mesh(allTriangles[i], Materials.phongRed);
				allMeshes.add(mesh);
			}			


			
			
			

			// camera
			var cameraOrigin = new Vector3(0, 0, -1);
			var cameraLookAt = new Vector3(0, 0, 0);
			var cameraLookUp = new Vector3(0, 1, 0);
			var halfWidth = Math.PI / 4;

			var camera = new Camera(cameraOrigin, cameraLookAt, cameraLookUp, halfWidth);

			var light = new DirectionalLight(new Vector3(2, 2, -2).normalize(), 1);

			Mesh[] meshArray = new Mesh[allMeshes.size()];
			for (int i = 0; i < meshArray.length; i++) {
				meshArray[i] = allMeshes.get(i);
			}
			
			var scene = new Scene(new DirectionalLight[] { light }, camera, meshArray);
			scene.render(outImage);
			ImageIO.write(outImage, "png", new File("./src/main/resources/out.png"));

			Logging.log("Ray tracing complete in: " + (System.currentTimeMillis() - startTime) + " milliseconds");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}