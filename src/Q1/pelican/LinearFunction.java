package Q1.pelican;

public class LinearFunction {
    double slope;
    double y;

    public LinearFunction(double slo, double b) {
        slope = slo;
        y = b;
    }

    public double getSlope() {
        return slope;
    }

    public double getY() {
        return y;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRoot() {
        var root = 1;
        return root;
    }
}