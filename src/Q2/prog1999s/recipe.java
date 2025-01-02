package Q2.prog1999s;

public class recipe implements Comparable<recipe> {

    private String rec;
    private String i1;
    private String i2;
    private String i3;
    private int i1q;
    private int i2q;
    private int i3q;

    public recipe(String rec, String i1, String i2, String i3, int i1q, int i2q, int i3q) {
        this.rec = rec; this.i1 = i1; this.i2 = i2; this.i3 = i3;
        this.i1q = i1q; this.i2q = i2q; this.i3q = i3q;
    }


    @Override
    public int compareTo(recipe o) {
        return rec.compareTo(o.rec);
    }

    public int getI1q() {
        return i1q;
    }

    public int getI2q() {
        return i2q;
    }

    public int getI3q() {
        return i3q;
    }

    public String getI1() {
        return i1;
    }

    public String getI2() {
        return i2;
    }

    public String getI3() {
        return i3;
    }

    public String getRec() {
        return rec;
    }

    public void setI1q(int i1q) {
        this.i1q = i1q;
    }

    public void setI2q(int i2q) {
        this.i2q = i2q;
    }

    public void setI3q(int i3q) {
        this.i3q = i3q;
    }
}
