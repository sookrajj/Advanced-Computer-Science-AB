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
                    System.out.println("Wrent a wreck invoice");
                    System.out.println();
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
                                System.out.println("Miles driven " + Math.round(dif * 100.0)/100.0 + " @ " + cosm + " = " + Math.round(dif * cosm * 100.0)/100.0);
                                System.out.println("Days driven " + days + " @ " + cost + " = " + Math.round(days * cost * 100.0)/100.0);
                                var total = (dif*cosm) + (days*cost);
                                System.out.println("Car type Sub Compact");
                                System.out.println("Total = $" + total);
                                car.miles = mileage;
                                que.get(0).add(car);
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
                                System.out.println("Miles driven " + Math.round(dif * 100.0)/100.0 + " @ " + cosm + " = " + Math.round(dif * cosm * 100.0)/100.0);
                                System.out.println("Days driven " + days + " @ " + cost + " = " + Math.round(days * cost * 100.0)/100.0);
                                var total = (dif*cosm) + (days*cost);
                                System.out.println("Car type Compact");
                                System.out.println("Total = $" + total);
                                car.miles = mileage;
                                que.get(1).add(car);
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
                                System.out.println("Miles driven " + Math.round(dif * 100.0)/100.0 + " @ " + cosm + " = " + Math.round(dif * cosm * 100.0)/100.0);
                                System.out.println("Days driven " + days + " @ " + cost + " = " + Math.round(days * cost * 100.0)/100.0);
                                var total = (dif*cosm) + (days*cost);
                                System.out.println("Car type Midsized");
                                System.out.println("Total = $" + total);
                                car.miles = mileage;
                                que.get(2).add(car);
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
                                System.out.println("Miles driven " + Math.round(dif * 100.0)/100.0 + " @ " + cosm + " = " + Math.round(dif * cosm * 100.0)/100.0);
                                System.out.println("Days driven " + days + " @ " + cost + " = " + Math.round(days * cost * 100.0)/100.0);
                                var total = (dif*cosm) + (days*cost);
                                System.out.println("Car type Wagon");
                                System.out.println("Total = $" + total);
                                car.miles = mileage;
                                que.get(3).add(car);
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
                                System.out.println("Miles driven " + Math.round(dif * 100.0)/100.0 + " @ " + cosm + " = " + Math.round(dif * cosm * 100.0)/100.0);
                                System.out.println("Days driven " + days + " @ " + cost + " = " + Math.round(days * cost * 100.0)/100.0);
                                var total = (dif*cosm) + (days*cost);
                                System.out.println("Car type Luxury");
                                System.out.println("Total = $" + total);
                                car.miles = mileage;
                                que.get(4).add(car);
                                break;
                            } else {
                                unrent.add(car);
                            }
                        }

                        while (!unrent.isEmpty()) {
                            rented.add(unrent.remove());
                        }
                    }
                    System.out.println();
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
                    System.out.println();
                }
            }

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//Listing of Subcompact cars:
//Yugo 3456.3
//Sentra 3007.0
//RX7 4002.1
//Chevette 1710.1
//
//Listing of Compact cars:
//Shadow 831.2
//Fiero 1541.4
//Contour 1091.7
//Topaz 412.5
//
//Listing of Midsize cars:
//Cutlass 930.7
//Cougar 1442.2
//LaBaron 831.2
//Mystique 117.4
//
//Listing of Wagon cars:
//Delta88 2417.7
//Bonneville 5100.0
//Caprice 4522.8
//
//Listing of Luxury cars:
//Cadillac 1234.5
//Corvette 10341.7
//Lincoln 8400.2
//
//Rented
//Yugo	3456.3
//LaBaron	831.2
//Cadillac	1234.5
//Delta88	2417.7
//Cougar	1442.2
//Cutlass	930.7
//Topaz	412.5
//Contour	1091.7
//Fiero	1541.4
//Shadow	831.2
//Chevette	1710.1
//RX7	4002.1
//Sentra	3007.0
//
//Wrent a wreck invoice
//
//Car Yugo
//Beginning mileage: 3456.3
//Ending mileage: 3640.0
//Miles driven 183.7 @ 0.22 = 40.41
//Days driven 2 @ 18.0 = 36.0
//Car type Sub Compact
//Total = $76.41399999999996
//
//Wrent a wreck invoice
//
//Car Cadillac
//Beginning mileage: 1234.5
//Ending mileage: 2801.2
//Miles driven 1566.7 @ 0.37 = 579.68
//Days driven 2 @ 34.0 = 68.0
//Car type Luxury
//Total = $647.679
//
//Wrent a wreck invoice
//
//Car Contour
//Beginning mileage: 1091.7
//Ending mileage: 2031.7
//Miles driven 940.0 @ 0.25 = 235.0
//Days driven 3 @ 20.5 = 61.5
//Car type Compact
//Total = $296.5
//
//Listing of Subcompact cars:
//Yugo 3640.0
//
//Listing of Compact cars:
//Contour 2031.7
//
//Listing of Midsize cars:
//Mystique 117.4
//
//Listing of Wagon cars:
//Bonneville 5100.0
//Caprice 4522.8
//
//Listing of Luxury cars:
//Corvette 10341.7
//Cadillac 2801.2
//Lincoln 8400.2
//
//Rented
//Fiero	1541.4
//LaBaron	831.2
//Cougar	1442.2
//Cutlass	930.7
//Topaz	412.5
//Delta88	2417.7
//Shadow	831.2
//Chevette	1710.1
//RX7	4002.1
//Sentra	3007.0