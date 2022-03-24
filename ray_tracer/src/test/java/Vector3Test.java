import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Vector3Test {

    @Test
    public void testDotProduct() {
        Vector3 vector = new Vector3(1, 2, 3);
        Vector3 vector1 = new Vector3(4, 5, 6);
        assertTrue(vector.dotProduct(vector1) == 32);
    }
}