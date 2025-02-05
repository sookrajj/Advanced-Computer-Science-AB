package Q3;

public class msoe20139 {
    public static void main(String[] args) {


    }

    static class helper {
        public double x;
        public double y;

        public helper(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double dist(int ox, int oy) {
            return Math.abs(x-ox) / Math.abs(y-oy);
        }
    }
}
