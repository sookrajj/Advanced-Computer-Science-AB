package Q3;

import DataStructures.UnionFind;

public class UnionFindLab { // Island connectivity finder
    private final UnionFind uf;
    public         UnionFindLab(int n)          {uf = new UnionFind(n);}
    public void    addBridge(int i1, int i2)    {uf.union(i1, i2);}
    public boolean areConnected(int i1, int i2) {return uf.connected(i1, i2);}
    public int     numberOfIslandGroups()       {return uf.count();}
    public static void main(String[] args) {
        //Test Case  1
        var icf = new UnionFindLab(5);
        System.out.println(icf.numberOfIslandGroups());

        //Test Case 2
                           icf.addBridge       (0, 1);
        System.out.println(icf.areConnected    (0, 1));
        System.out.println(icf.numberOfIslandGroups());

        //Test Case 3
        icf.addBridge(2, 3);icf.addBridge       (1, 2);
        System.out.println( icf.areConnected    (0, 3));
        System.out.println( icf.numberOfIslandGroups());

        //Test Case 4
                           icf.addBridge        (0, 3);
        System.out.println(icf.numberOfIslandGroups());
    }
}
