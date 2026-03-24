import java.util.Objects;

public class Plane {
    private int planeId;
    private String type;

    public Plane(int planeId, String type) {
        this.planeId = planeId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "planeId=" + planeId +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return planeId == plane.planeId && Objects.equals(type, plane.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeId, type);
    }

}
