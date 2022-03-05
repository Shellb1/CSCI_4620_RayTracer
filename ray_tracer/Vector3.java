

public class Vector3 {

    public float x;
    public float y;
    public float z;

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float dotProduct(Vector3 other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public Vector3 crossProduct(Vector3 other) {
        Vector3 vector = new Vector3(0, 0, 0);
        vector.x = this.y * other.z - this.z * other.y;
        vector.y = this.z * other.x - this.x * other.z;
        vector.z = this.x * other.y - this.y * other.x;
        return vector;
    }
}
