package Q4.prog1999w;

public class Horse extends Animal implements Comparable<Horse> {
    protected String name;
    protected double riderCost;
    protected int numRiders;

    public Horse(int id, double w, int cc, int hb, int b, int o, String n, double rC, int nR) {
        super(id, w, cc, hb, b, o);
        this.name = n;
        this.riderCost = rC;
        this.numRiders = nR;
    }

    public String getName() {
        return name;
    }
    public double getIncome() {
        return riderCost * numRiders;
    }
    public String toString() {
        return "Horse: " +
                "\nweight=" + weight +
                "\nid=" + id +
                "\ncornCobs=" + cornCobs +
                "\nhayBales=" + hayBales +
                "\nbeans=" + beans +
                "\noats=" + oats +
                "\nname= " + name +
                "\nrider cost= " + riderCost +
                "\nnum riders= " + numRiders;

    }
    public int compareTo(Horse horse) {return Double.compare(this.getIncome(), horse.getIncome());}
}
