package Q2.prog1999s;

public class inventory {
    private String item;
    private int num;

    public inventory(String item, int num) {
        this.item = item;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public String getItem() {
        return item;
    }

    public void setNum(int num) {
        this.num = num;
    }
}