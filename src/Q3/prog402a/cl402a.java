package Q3.prog402a;

public class cl402a {
    private int myid;
    private int myscore;

    public cl402a(int score, int id) {
        myscore = score;
        myid = id;
    }
    public int getMyid() {return myid;}
    public String toString() { return myscore + "\t\t" + myid; }
}
