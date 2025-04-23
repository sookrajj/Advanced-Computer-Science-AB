package Q4.prog1999w;

public abstract class Animal implements IFarm{
    protected double weight;
    protected int id;
    protected int cornCobs;
    protected int hayBales;
    protected int beans;
    protected int oats;

    public Animal(int id, double w, int cc, int hb, int b, int o) {
        this.id = id;
        weight = w;
        cornCobs = cc;
        hayBales = hb;
        beans = b;
        oats = o;
    }

    public int getId() {return id;}
    public double getWeight() {return weight;}
    public int getCornCobs() {return cornCobs;}
    public int getHayBales() {return hayBales;}
    public int getBeans() {return beans;}
    public int getOats() {return oats;}
    public double getCost() {return cornCobs + hayBales + beans + oats;}
    public abstract double getIncome();
    public double getProfit() {return getIncome() - getCost();}

    @Override
    public String toString() {
        return "Animal" +
                "\nweight=" + weight +
                "\nid=" + id +
                "\ncornCobs=" + cornCobs +
                "\nhayBales=" + hayBales +
                "\nbeans=" + beans +
                "\noats=" + oats;
    }


}
