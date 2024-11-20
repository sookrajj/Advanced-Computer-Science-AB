package Q2;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.*;

public class prog1060h {

    public static class carcomp implements Comparable<carcomp> {
        private String car;
        private double miles;

        public carcomp(String car, double cost) {
            this.car = car;
            this.miles = cost;
        }

        public String getcar() {
            return car;
        }

        public double getmiles() {
            return miles;
        }

        @Override
        public int compareTo(carcomp o) {
            return 0;
        }
    }
    public static class carcost implements Comparable<carcost> {
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

        @Override
        public int compareTo(carcost o) {
            return 0;
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
            ArrayList<carcost> quee = new ArrayList<>();
            carcost scc = null;
            carcost ccc = null;
            carcost mcc = null;
            carcost wcc = null;
            carcost lcc = null;
            while (f2.hasNext()) {
                var str = f2.next();
                var cpd = Double.parseDouble(str.substring(1));
                var costpmile = f2.nextDouble();
                var type = str.substring(0, 1);
                str = str.substring(1);
                if (type.equalsIgnoreCase("S")) {
                    scc = new carcost(cpd, costpmile);
                } else if (type.equalsIgnoreCase("C")) {
                    ccc = new carcost(cpd, costpmile);
                } else if (type.equalsIgnoreCase("M")) {
                    mcc = new carcost(cpd, costpmile);
                } else if (type.equalsIgnoreCase("W")) {
                    wcc = new carcost(cpd, costpmile);
                } else if (type.equalsIgnoreCase("L")) {
                    lcc = new carcost(cpd, costpmile);
                }
            }
            quee.add(scc); quee.add(ccc); quee.add(mcc); quee.add(wcc); quee.add(lcc);
            var rented = new PriorityQueue<carcomp>();
            while (f3.hasNext()) {
                var str = f3.next();
                var type = "";
                var cpd = 0.0;
                var days = 0;
                if (str.length() > 1) {

                    type = str.substring(1, 2);
                }
                if (str.length() > 2) {
                    days = Integer.parseInt(str.substring(2));
                }
//                if (str.length() > 3) {
//                    cpd = Double.parseDouble(f3.next());
//                }
                str = str.substring(0, 1);
                if (str.equalsIgnoreCase("L")) {
                    if (type.equalsIgnoreCase("S")) {
                        var q = que.get(0);
                        var qe = new PriorityQueue<carcomp>();
                        System.out.println("Listing of Subcompact cars: ");
                        while (!q.isEmpty()) {
                            var temp = q.remove();
                            System.out.println(temp.car.substring(1) + " " + temp.miles);
                            qe.add(temp);
                        }
                        while (!qe.isEmpty()) {
                            var temp = qe.remove();
                            q.add(temp);
                        }
                    } else if (type.equalsIgnoreCase("C")) {
                        var q = que.get(1);
                        var qe = new PriorityQueue<carcomp>();
                        System.out.println("Listing of Compact cars: ");
                        while (!q.isEmpty()) {
                            var temp = q.remove();
                            System.out.println(temp.car.substring(1) + " " + temp.miles);
                            qe.add(temp);
                        }
                        while (!qe.isEmpty()) {
                            var temp = qe.remove();
                            q.add(temp);
                        }
                    } else if (type.equalsIgnoreCase("M")) {
                        var q = que.get(2);
                        var qe = new PriorityQueue<carcomp>();
                        System.out.println("Listing of Midsize cars: ");
                        while (!q.isEmpty()) {
                            var temp = q.remove();
                            System.out.println(temp.car.substring(1) + " " + temp.miles);
                            qe.add(temp);
                        }
                        while (!qe.isEmpty()) {
                            var temp = qe.remove();
                            q.add(temp);
                        }
                    } else if (type.equalsIgnoreCase("W")) {
                        var q = que.get(3);
                        var qe = new PriorityQueue<carcomp>();
                        System.out.println("Listing of Wagon cars: ");
                        while (!q.isEmpty()) {
                            var temp = q.remove();
                            System.out.println(temp.car.substring(1) + " " + temp.miles);
                            qe.add(temp);
                        }
                        while (!qe.isEmpty()) {
                            var temp = qe.remove();
                            q.add(temp);
                        }
                    } else if (type.equalsIgnoreCase("L")) {
                        var q = que.get(4);
                        var qe = new PriorityQueue<carcomp>();
                        System.out.println("Listing of Luxury cars: ");
                        while (!q.isEmpty()) {
                            var temp = q.remove();
                            System.out.println(temp.car.substring(1) + " " + temp.miles);
                            qe.add(temp);
                        }
                        while (!qe.isEmpty()) {
                            var temp = qe.remove();
                            q.add(temp);
                        }
                    }
                    System.out.println();
                    System.out.println();
                } else if (str.equalsIgnoreCase("R")) {
                    if (type.equalsIgnoreCase("S")) {
                        var q = que.get(0);
                        if (!q.isEmpty()) rented.add(q.remove());
                        else if (!que.get(1).isEmpty()) rented.add(que.get(1).remove());
                        else if (!que.get(2).isEmpty()) rented.add(que.get(2).remove());
                        else if (!que.get(3).isEmpty()) rented.add(que.get(3).remove());
                        else if (!que.get(4).isEmpty()) rented.add(que.get(4).remove());
                        else {
                            System.out.println("Sorry we are out of cars");
                        }
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

                    var mileage = f3.nextDouble();
                    var carname = f3.next();
                    var unrent = new PriorityQueue<carcomp>();
                    if (type.equalsIgnoreCase("S")) {
                        while (!rented.isEmpty()) {
                            var car = rented.remove();
                            if (car.getcar().substring(1).equals(carname)) {
                                System.out.println("Car " + car.getcar().substring(1));
                                System.out.println("Beginning mileage: " + car.getmiles());
                                System.out.println("Ending mileage: " + mileage);
                                var dif = mileage- car.getmiles();
                                var cost = quee.get(0).day;
                                var cosm = quee.get(0).mile;
                                System.out.println("Miles driven " + dif + " @ " + cosm + " = " + (dif*cosm));
                                System.out.println("Days driven " + days + " @ " + cost + " = " + (days*cost));
                                var total = (dif*cosm) + (days*cost);
                                System.out.println("Car type Sub Compact");
                                System.out.println("Total = $" + total);
                                car.miles = mileage;
                                break;
                            } else {
                                unrent.add(car);
                            }
                        }

                        while (!unrent.isEmpty()) {
                            rented.add(unrent.remove());
                        }

                    } else if (type.equalsIgnoreCase("C")) {
                        while (!rented.isEmpty()) {
                            var car = rented.remove();
                            if (car.getcar().substring(1).equals(carname)) {
                                System.out.println("Car " + car.getcar().substring(1));
                                System.out.println("Beginning mileage: " + car.getmiles());
                                System.out.println("Ending mileage: " + mileage);
                                var dif = mileage- car.getmiles();
                                var cost = quee.get(1).day;
                                var cosm = quee.get(1).mile;
                                System.out.println("Miles driven " + dif + " @ " + cosm + " = " + (dif*cosm));
                                System.out.println("Days driven " + days + " @ " + cost + " = " + (days*cost));
                                var total = (dif*cosm) + (days*cost);
                                System.out.println("Car type Compact");
                                System.out.println("Total = $" + total);
                                car.miles = mileage;
                                break;
                            } else {
                                unrent.add(car);
                            }
                        }

                        while (!unrent.isEmpty()) {
                            rented.add(unrent.remove());
                        }

                    } else if (type.equalsIgnoreCase("M")) {
                        while (rented.isEmpty()) {
                            var car = rented.remove();
                            if (car.getcar().substring(1).equals(carname)) {
                                System.out.println("Car " + car.getcar().substring(1));
                                System.out.println("Beginning mileage: " + car.getmiles());
                                System.out.println("Ending mileage: " + mileage);
                                var dif = mileage- car.getmiles();
                                var cost = quee.get(2).day;
                                var cosm = quee.get(2).mile;
                                System.out.println("Miles driven " + dif + " @ " + cosm + " = " + (dif*cosm));
                                System.out.println("Days driven " + days + " @ " + cost + " = " + (days*cost));
                                var total = (dif*cosm) + (days*cost);
                                System.out.println("Car type Midsized");
                                System.out.println("Total = $" + total);
                                car.miles = mileage;
                                break;
                            } else {
                                unrent.add(car);
                            }
                        }

                        while (unrent.isEmpty()) {
                            rented.add(unrent.remove());
                        }

                    } else if (type.equalsIgnoreCase("W")) {
                        while (rented.isEmpty()) {
                            var car = rented.remove();
                            if (car.getcar().substring(1).equals(carname)) {
                                System.out.println("Car " + car.getcar().substring(1));
                                System.out.println("Beginning mileage: " + car.getmiles());
                                System.out.println("Ending mileage: " + mileage);
                                var dif = mileage- car.getmiles();
                                var cost = quee.get(3).day;
                                var cosm = quee.get(3).mile;
                                System.out.println("Miles driven " + dif + " @ " + cosm + " = " + (dif*cosm));
                                System.out.println("Days driven " + days + " @ " + cost + " = " + (days*cost));
                                var total = (dif*cosm) + (days*cost);
                                System.out.println("Car type Wagon");
                                System.out.println("Total = $" + total);
                                car.miles = mileage;
                                break;
                            } else {
                                unrent.add(car);
                            }
                        }

                        while (unrent.isEmpty()) {
                            rented.add(unrent.remove());
                        }

                    } else if (type.equalsIgnoreCase("L")) {
                        while (!rented.isEmpty()) {
                            var car = rented.remove();
                            if (car.getcar().substring(1).equals(carname)) {
                                System.out.println("Car " + car.getcar().substring(1));
                                System.out.println("Beginning mileage: " + car.getmiles());
                                System.out.println("Ending mileage: " + mileage);
                                var dif = mileage- car.getmiles();
                                var cost = quee.get(4).day;
                                var cosm = quee.get(4).mile;
                                System.out.println("Miles driven " + dif + " @ " + cosm + " = " + (dif*cosm));
                                System.out.println("Days driven " + days + " @ " + cost + " = " + (days*cost));
                                var total = (dif*cosm) + (days*cost);
                                System.out.println("Car type Luxury");
                                System.out.println("Total = $" + total);
                                car.miles = mileage;
                                break;
                            } else {
                                unrent.add(car);
                            }
                        }

                        while (!unrent.isEmpty()) {
                            rented.add(unrent.remove());
                        }
                    }
                } else {
                    var unrent = new PriorityQueue<carcomp>();
                    System.out.println("Rented");
                    while (!rented.isEmpty()) {
//                        System.out.println("the boushwazi was the middle class of russia that revolted against the rulers for increasing prices that they did not like, they were able to kill the king and queen at the time and became the soviet union");
                        var temp = rented.remove();
                        System.out.println("" + temp.car.substring(1) + "\t" + temp.miles);
                        unrent.add(temp);

                    }
                    while (!unrent.isEmpty()) {
                        rented.add(unrent.remove());
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
