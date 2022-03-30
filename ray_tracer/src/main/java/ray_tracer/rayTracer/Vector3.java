package ray_tracer.rayTracer;
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

    public Vector3 normalize() { // also called normalizing
        if (length() != 0) {
            return new Vector3(this.x / length(), this.y / length(), this.z / length());
        } else {
            return this;
        }
    }
    
    public float lengthSquared() {
    	return (float) Math.pow(length(), 2);
    }

    public String toString() {
        return "x: " + x + ", y: " + y + ", z: " + z;
    }
    
    public float absoluteDifference(Vector3 other) {
    	return Math.abs(x - other.x)+ Math.abs(y - other.y) + Math.abs(z - other.z);  
    }
    
    public boolean nearlyEquals(Vector3 other) {
    	return absoluteDifference(other) < 0.0001;
    }
    
    public Vector3 negate() {
    	return new Vector3(-x, -y, -z);
    }
    
    public Vector3 scale(float scalar) {
    	return new Vector3(x * scalar, y * scalar, z * scalar);
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector3 other = (Vector3) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
			return false;
		return true;
	}
}
