package physics;

/**
 * {@code Vector2D} is a physic class that implement the vector mathematics
 * caracteristics in 2 dimensions.
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since   2021-04-12
 */
public class Vector2D {

    public final static Vector2D LEFT = new Vector2D(-1, 0);
    public final static Vector2D RIGHT = new Vector2D(1, 0);
    public final static Vector2D UP = new Vector2D(0, 1);
    public final static Vector2D DOWN = new Vector2D(1, -1);

    public double x;
    public double y;

    public Vector2D() {}

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double magnitude() {
        return (x * x + y * y);
    }

    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public Vector2D normalize() {
        return new Vector2D((x / (Math.pow(x, 2) + Math.pow(y, 2))), (y / (Math.pow(x, 2) + Math.pow(y, 2))));
    }

    @Override
    public boolean equals(Object o) {

        if(!(o instanceof Vector2D)) {
            return false;
        }

        Vector2D vector2D = (Vector2D)o;
        return this.x == vector2D.x && this.y == vector2D.y;
    }


    @Override
    public String toString() {
        return "{" +
            " x='" + x + "'" +
            ", y='" + y + "'" +
            "}";
    }

    
}
