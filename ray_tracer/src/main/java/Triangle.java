public class Triangle {
    public Vector3 one;
    public Vector3 two;
    public Vector3 three;

    public Triangle(Vector3 one, Vector3 two, Vector3 three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public String toString() {
        String point1 = "point 1: (" + this.one.x + ", " + this.one.y + ", " + this.one.z + ")\n";
        String point2 = "point 2: (" + this.two.x + ", " + this.two.y + ", " + this.two.z + ")\n";
        String point3 = "point 3: (" + this.three.x + ", " + this.three.y + ", " + this.three.z + ")\n";
        StringBuilder builder = new StringBuilder();
        return builder.append(point1).append(point2).append(point3).toString();

    }
}
