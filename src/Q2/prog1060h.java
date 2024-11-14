package Q2;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.*;

public class prog1060h {

    public static class carcomp {
        private String car;
        private double cost;

        public carcomp(String car, double cost) {
            this.car = car;
            this.cost = cost;
        }

        public String getcar() {
            return car;
        }

        public double getcost() {
            return cost;
        }
    }
    public static class carcost {
        private double day;
        private double mile;

        public carcost(double day, double mile) {
            this.day = day;
            this.mile = mile;
        }

        public double getday() {
            return day;
        }

        public double getmile() {
            return mile;
        }
    }
    public static void main(String[] args) {
        try {
            var f1 = new Scanner(new File("Langdat/invntory.dat"));
            var f2 = new Scanner(new File("Langdat/rates.dat"));
            var f3 = new Scanner(new File("Langdat/transact.dat"));
            ArrayList<Queue<carcomp>> que = new ArrayList<>();
            Queue<carcomp> sc = new PriorityQueue<>();
            Queue<carcomp> cc = new PriorityQueue<>();
            Queue<carcomp> mc = new PriorityQueue<>();
            Queue<carcomp> wc = new PriorityQueue<>();
            Queue<carcomp> lc = new PriorityQueue<>();
            while (f1.hasNext()) {
                var str = f1.next();
                var cost = f1.nextDouble();
                var type = str.substring(0, 1);
                str = str.substring(1);
                if (type.equalsIgnoreCase("S")) {
                    sc.add(new carcomp(str, cost));
                } else if (type.equalsIgnoreCase("C")) {
                    cc.add(new carcomp(str, cost));
                } else if (type.equalsIgnoreCase("M")) {
                    mc.add(new carcomp(str, cost));
                } else if (type.equalsIgnoreCase("W")) {
                    wc.add(new carcomp(str, cost));
                } else if (type.equalsIgnoreCase("L")) {
                    lc.add(new carcomp(str, cost));
                }
            }
            f1.close();
            que.add(sc); que.add(cc); que.add(mc); que.add(wc); que.add(lc);
            ArrayList<Queue<carcost>> quee = new ArrayList<>();
            Queue<carcost> scc = new PriorityQueue<>();
            Queue<carcost> ccc = new PriorityQueue<>();
            Queue<carcost> mcc = new PriorityQueue<>();
            Queue<carcost> wcc = new PriorityQueue<>();
            Queue<carcost> lcc = new PriorityQueue<>();
            while (f2.hasNext()) {
                var str = f2.next();
                var cpd = Double.parseDouble(str.substring(1));
                var costpmile = f2.nextDouble();
                var type = str.substring(0, 1);
                str = str.substring(1);
                if (type.equalsIgnoreCase("S")) {
                    scc.add(new carcost(cpd, costpmile));
                } else if (type.equalsIgnoreCase("C")) {
                    ccc.add(new carcost(cpd, costpmile));
                } else if (type.equalsIgnoreCase("M")) {
                    mcc.add(new carcost(cpd, costpmile));
                } else if (type.equalsIgnoreCase("W")) {
                    wcc.add(new carcost(cpd, costpmile));
                } else if (type.equalsIgnoreCase("L")) {
                    lcc.add(new carcost(cpd, costpmile));
                }
            }
            quee.add(scc); quee.add(ccc); quee.add(mcc); quee.add(wcc); quee.add(lcc);
            var rented = new PriorityQueue<carcomp>();
            while (f3.hasNext()) {
                var str = f3.next();
                var type = "";
                var cpd = 0.0;
                if (str.length() > 1) {
                    cpd = Double.parseDouble(str.substring(1));
                    type = str.substring(1);
                }
                str = str.substring(0, 1);
                if (str.equalsIgnoreCase("L")) {
                    if (type.equalsIgnoreCase("S")) {
                        var q = que.get(0);
                        var qe = new PriorityQueue<carcomp>();
                        while (!q.isEmpty()) {
                            var temp = q.remove();
                            System.out.println(temp.car);
                            qe.add(temp);
                        }
                        while (!qe.isEmpty()) {
                            var temp = qe.remove();
                            q.add(temp);
                        }
                    } else if (type.equalsIgnoreCase("C")) {
                        var q = que.get(1);
                        var qe = new PriorityQueue<carcomp>();
                        while (!q.isEmpty()) {
                            var temp = q.remove();
                            System.out.println(temp.car);
                            qe.add(temp);
                        }
                        while (!qe.isEmpty()) {
                            var temp = qe.remove();
                            q.add(temp);
                        }
                    } else if (type.equalsIgnoreCase("M")) {
                        var q = que.get(2);
                        var qe = new PriorityQueue<carcomp>();
                        while (!q.isEmpty()) {
                            var temp = q.remove();
                            System.out.println(temp.car);
                            qe.add(temp);
                        }
                        while (!qe.isEmpty()) {
                            var temp = qe.remove();
                            q.add(temp);
                        }
                    } else if (type.equalsIgnoreCase("W")) {
                        var q = que.get(3);
                        var qe = new PriorityQueue<carcomp>();
                        while (!q.isEmpty()) {
                            var temp = q.remove();
                            System.out.println(temp.car);
                            qe.add(temp);
                        }
                        while (!qe.isEmpty()) {
                            var temp = qe.remove();
                            q.add(temp);
                        }
                    } else if (type.equalsIgnoreCase("L")) {
                        var q = que.get(4);
                        var qe = new PriorityQueue<carcomp>();
                        while (!q.isEmpty()) {
                            var temp = q.remove();
                            System.out.println(temp.car);
                            qe.add(temp);
                        }
                        while (!qe.isEmpty()) {
                            var temp = qe.remove();
                            q.add(temp);
                        }
                    }
                } else if (str.equalsIgnoreCase("R")) {
                    if (type.equalsIgnoreCase("S")) {
                        var q = que.get(0);
                        rented.add(q.remove());
                    } else if (type.equalsIgnoreCase("C")) {
                        var q = que.get(1);
                        rented.add(q.remove());
                    } else if (type.equalsIgnoreCase("M")) {
                        var q = que.get(2);
                        rented.add(q.remove());
                    } else if (type.equalsIgnoreCase("W")) {
                        var q = que.get(3);
                        rented.add(q.remove());
                    } else if (type.equalsIgnoreCase("L")) {
                        var q = que.get(4);
                        rented.add(q.remove());
                    }
                } else if (str.equalsIgnoreCase("A")) {
                    var days = f3.nextInt();
                    var mileage = f3.nextDouble();
                    if (type.equalsIgnoreCase("S")) {

                    } else if (type.equalsIgnoreCase("C")) {
                        var q = que.get(1);
                        rented.add(q.remove());
                    } else if (type.equalsIgnoreCase("M")) {
                        var q = que.get(2);
                        rented.add(q.remove());
                    } else if (type.equalsIgnoreCase("W")) {
                        var q = que.get(3);
                        rented.add(q.remove());
                    } else if (type.equalsIgnoreCase("L")) {
                        var q = que.get(4);
                        rented.add(q.remove());
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
