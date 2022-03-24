


public class Camera {
    public Vector3 origin;
    public Vector3 lookAt;
    public Vector3 lookUp;

    public Camera(Vector3 origin, Vector3 lookAt, Vector3 lookUp) {
        this.origin = origin;
        this.lookAt = lookAt;
        this.lookUp = lookUp;
    }
}
