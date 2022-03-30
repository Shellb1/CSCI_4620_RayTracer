package ray_tracer.rayTracer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ray_tracer.rayTracer.Logging;
import ray_tracer.rayTracer.Vector3;;

public class Vector3Test {

    @Test
    public void testDotProduct() {
        Vector3 vector = getInitialVector();
        Vector3 vector1 = getSecondVector();
        assertTrue(vector.dotProduct(vector1) == 32);
    }
    
    @Test
    public void testCrossProduct() {
    	Vector3 vector = getInitialVector();
    	Vector3 vector1 = getSecondVector();
    	Vector3 result = vector.crossProduct(vector1);
    	assertTrue(result.x == -3);
    	assertTrue(result.y == 6);
    	assertTrue(result.z == -3);
    }
    
    @Test
    public void testAdd() {
    	Vector3 vector = getInitialVector();
    	Vector3 vector1 = getSecondVector();
    	Vector3 result = vector.add(vector1);
    	assertTrue(result.x == 5);
    	assertTrue(result.y == 7);
    	assertTrue(result.z == 9);
    }
    
    @Test
    public void testSubtract() {
    	Vector3 vector = getInitialVector();
    	Vector3 vector1 = getSecondVector();
    	Vector3 result = vector.subtract(vector1);
    	assertTrue(result.x == -3);
    	assertTrue(result.y == -3);
    	assertTrue(result.z == -3);
    }
    
    @Test
    public void testMultiply() {
    	Vector3 vector = getInitialVector();
    	Vector3 vector1 = getSecondVector();
    	Vector3 result = vector.multiply(vector1);
    	assertTrue(result.x == 4);
    	assertTrue(result.y == 10);
    	assertTrue(result.z == 18);
    }
    
    @Test
    public void testLength() {
    	Vector3 vector = getInitialVector();
    	assertTrue(vector.length() == (float) Math.sqrt(14));
    }
    
    @Test
    public void testUnit() {
    	Vector3 vector = getInitialVector();
    	Vector3 result = vector.normalize();
    	Logging.log(result.toString());
    	assertEquals(result.x, 0.26726124, 0.00001);
    	assertEquals(result.y, 0.53452248382, 0.00001);
    	assertEquals(result.z, 0.80178372573, 0.00001);
    }
    
    @Test
    public void testUnit_lengthZero() {
    	Vector3 vector = new Vector3(0, 0, 0);
    	Vector3 result = vector.normalize();
    	assertTrue(result.x == 0);
    	assertTrue(result.y == 0);
    	assertTrue(result.z == 0);
    }
    
    private Vector3 getInitialVector() {
    	return new Vector3(1, 2, 3);
    }
    
    private Vector3 getSecondVector() {
    	return new Vector3(4, 5, 6);
    }
}