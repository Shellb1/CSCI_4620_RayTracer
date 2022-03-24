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
        return new Vector3(this.y * other.z - this.z * other.y, 
        this.z * other.x - this.x * other.z, this.x * other.y - this.y * other.x);
    }

    public Vector3 add(Vector3 other) {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3 subtract(Vector3 other) {
        return new Vector3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public Vector3 multiply(Vector3 other) {
        return new Vector3(this.x * other.x, this.y * other.y, this.z * other.z);
    }

    public float length() { // also called magnitude
        return (float) Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
    }

    public Vector3 unit() { // also called normalizing
        if (length() != 0) {
            return new Vector3(this.x / length(), this.y / length(), this.z / length());
        } else {
            return this;
        }
    }

    public String toString() {
        return "x: " + x + ", y: " + y + ", z: " + z;
    }
}
