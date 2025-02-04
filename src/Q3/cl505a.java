package Q3;

public class cl505a implements Comparable<cl505a> {
    private String myName;
    private int myBooks;
    private int myPoints;

    public cl505a(String name, int books) {
        myName = name;
        myBooks = books;
        myPoints = 0;
    }

    public void calc() {
        if (myBooks <= 3) myPoints = myBooks * 10;
        else if (myBooks <= 6) myPoints = 3 * 10 + (myBooks-3) * 15;
        else myPoints = 3 * 10 + 3 * 15 + (myBooks-6) * 20;
    }

    public String getName() {return myName;}
    public int getBooks() {return myBooks;}
    public int getPoints() {return myPoints;}

    public String toString() {return myName + "\t" + myBooks + "\t" + myPoints;}

    @Override
    public int compareTo(cl505a o) {
        return 0;
    }
}
