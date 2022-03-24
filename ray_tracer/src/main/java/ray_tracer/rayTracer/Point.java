package ray_tracer.rayTracer;

public class Point {

	double x;
	double y;
	double z;
	
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point normalize() {
		 if (length() != 0) {
	            return new Point(this.x / length(), this.y / length(), this.z / length());
	        } else {
	            return this;
	        }
	}
	
	
	public double length() { 
		return Math.sqrt(this.lengthSquared());
	}
	
	public double lengthSquared() {
		return x * x + y * y + z * z;
	}
	
	public double dot(Point other) {
		return this.x * other.x + this.y * other.y + this.z * other.z;
	}
	
	public Point cross(Point other) {
		 return new Point(this.y * other.z - this.z * other.y, 
			        this.z * other.x - this.x * other.z, this.x * other.y - this.y * other.x);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}
}
