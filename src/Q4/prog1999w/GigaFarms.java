package Q4.prog1999w;

import DataStructures.Dictionary;
import DataStructures.LinkedList;

import java.util.Arrays;

public class GigaFarms {
    public static void main(String[] args) {
        var farms = new LinkedList<Farm>();

        for (int i = 0; i < 5; i++) {
            farms.add(new Farm(i));
        }

        //region Profit
        double mostProfit = 0;
        int index = 0;
        for (int i = 0; i < 5; i++) {
            if (mostProfit < farms.get(i).getProfit()) {
                mostProfit = Math.max(farms.get(i).getProfit(), mostProfit);
                index = i + 1;
            }
        }
        System.out.println("Most Profitable Farm is " + index);
        //endregion Profit
        //region milk
        int pounds = 0;
        for (int i = 0; i < farms.size(); i++) {
            var cows = farms.get(i).getCows();
            var keys = cows.keySet();
            for (int h : keys) {
                pounds += cows.get(h).getMilk();
            }
        }
        System.out.println("Total Milk Produced in Pounds " + pounds);
        //endregion milk
        // region turkey weight
        double weigh = 0;
        for (int i = 0; i < farms.size(); i++) {
            var turks = farms.get(i).getTurks();
            for (Turkey h : turks) {
                weigh += h.weight;
            }
        }
        System.out.println("Total Turkey Weight in Pounds " + weigh);
        //endregion turkey weight
        //region Most expensive feed per farm
        for (int i = 0; i < farms.size(); i++) {
            var anis = farms.get(i).getAllAnimals();
            var cor = 0;
            var hay = 0;
            var bean = 0;
            var oat = 0;
            for (Animal l : anis) {
                if (l != null) {
                    cor += l.cornCobs;
                    hay += l.hayBales;
                    bean += l.beans;
                    oat += l.oats;
                }
            }
            var m = Math.max(Math.max(cor, hay), Math.max(bean, oat));
            var t = m == cor ? "Corn" : m == hay ? "Hay" : m == bean ? "Bean" : "Oats";
            System.out.println("The Most Expensive Feed on Farm " + i + " is " + t);
        }
        //endregion Most expensive per farm
        //region costs
        var totcost = 0;
        for (int i = 0; i < farms.size(); i++) {
            var anis = farms.get(i).getAllAnimals();
            var cost = 0;
            for (Animal l : anis) {
                if (l != null) {
                    cost += l.getCost();
                }
            }
            totcost += cost;
            System.out.println("Total Cost of Feed on Farm " + i + " is $" + cost);
        }
        System.out.println("Total Cost of Feed on all Farms Combined is $" + totcost);
        //endregion costs
        //region income
        var totincome = 0;
        for (int i = 0; i < farms.size(); i++) {
            var anis = farms.get(i).getAllAnimals();
            var income = 0;
            for (Animal l : anis) {
                if (l != null) {
                    income += l.getIncome();
                }
            }
            totincome += income;
        }
        System.out.println("Total Income of Feed on all Farms Combined is $" + totincome);
        //endregion income
        //region profit
        var totprofit = 0;
        for (int i = 0; i < farms.size(); i++) {
            var anis = farms.get(i).getAllAnimals();
            var profit = 0;
            for (Animal l : anis) {
                if (l != null) {
                    profit += l.getProfit();
                }
            }
            totprofit += profit;
        }
        System.out.println("Total Profit of Feed on all Farms Combined is $" + totprofit);
        //endregion profit
        //region killCows
        Dictionary<Integer, Cow> onTheChoppingBlock = new Dictionary<Integer, Cow>();
        var bol = new Boolean[] {false, false, false, false, false};
        for (int i = 0; i < 5; i++) {
            var cows = farms.get(i).getCows();
            var id = cows.keySet();
            for (int d : id) {
                if (onTheChoppingBlock.size() < 7) {
                    onTheChoppingBlock.insert(d, cows.get(d));
                } else {
                    var cow = cows.get(d);
                    for (int h : onTheChoppingBlock.keySet()) {
                        if (cow.getIncome() < onTheChoppingBlock.get(h).getIncome()) {
                            var temp = cow;
                            cow = onTheChoppingBlock.get(h);
                            onTheChoppingBlock.remove(h);
                            onTheChoppingBlock.insert(temp.getId(), temp);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < farms.size(); i++) {
            var cows = farms.get(i).getCows();
            for (int n = 0; n < onTheChoppingBlock.size(); n++) {
                var g = onTheChoppingBlock.keySet();
                for (int t : g) {
                    if (cows.contains(t)) cows.remove(t);
                }
            }
        }
        System.out.println("Taken the Cows out back");
        //endregion killCows
        //region killpigs
        var pigpen = farms.get(0).getPigs();
        var tot = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            var pigs = farms.get(i).getPigs();
            var prof = 0;
            for (Pig pig : pigs) {
                if (pig != null) {
                    prof += pig.getProfit();
                }
            }
            if (prof < tot) {
                tot = prof;
                pigpen = pigs;
            }
        }
        for (int i = 0; i < 5; i++) {
            var pigs = farms.get(i).getPigs();
            var prof = 0;
            if (Arrays.equals(pigs, pigpen)) {
                Pig[] p = new Pig[]{pigs[0], pigs[1]};
                for (int l = 2; l < pigs.length; l++) {
                    var pig = pigs[l];
                    if (pig != null) {
                        if (pig.getProfit() > p[0].getProfit()) {
                            var temp = p[0];
                            p[0] = pig;
                            pig = temp;
                        }
                        if (pig.getProfit() > p[1].getProfit()) {
                            var temp = p[0];
                            p[0] = pig;
                            pig = temp;
                        }
                    }
                }
                for (int y = 0; y < pigs.length; y++) {
                    if (pigs[y] != p[0] || pigs[y] != p[1]) {
                        pigs[y] = null;
                    }
                }
            }
        }
        System.out.println("Taken the Pigs out back");
        //endregion killpigs
        //region killTurkeys
        var tu = farms.get(0).getTurks();
        var lowTurkeyProf = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            var tus = farms.get(i).getTurks();
            var low = 0;
            for (Turkey t : tus) {
                low += t.getProfit();
            }
            if (low < lowTurkeyProf) {
                lowTurkeyProf = low;
                tu = tus;
            }
        }
        for (int i = 0; i < farms.size(); i++) {
            var tus = farms.get(i).getTurks();
            if (tu.equals(tus)) {
                var t = new Turkey[tu.size()/2];
                for (Turkey p : tus) {
                    for (int l = 0; l < t.length; l++) {
                        if (t[l] != null) {
                            if (p.getProfit() < t[l].getProfit()) {
                                var temp = p;
                                p = t[l];
                                t[l] = p;
                            }
                        }
                    }
                }

                for (Turkey turkey : t) {
                    tus.remove(turkey);
                }
            }
        }
        System.out.println("Taken the Turkeys out back");
        //endregion killTurkeys
        //region Weight
        var totw = 0;
        for (int i = 0; i < farms.size(); i++) {
            var anis = farms.get(i).getAllAnimals();
            var w = 0;
            for (Animal l : anis) {
                if (l != null) {
                    w += l.getCost();
                }
            }
            totw += w;
        }
        System.out.println("Total Weight of Feed on all Farms Combined is " + totw);
        //endregion weight
        //region killHeavy
        for (int i = 0; i < 5; i++) {
            var farm = farms.get(i);
            var horses = farm.getHorses();
            int he = 0;
            for (int h = 0; h < horses.size(); h++) {
                if (horses.get(h).weight > horses.get(he).weight) he = h;
            }
            farm.removeHorse(horses.get(he));

            var cows = farm.getCows();
            int[] place = new int[] {0, 0};
            for (int l : cows.keySet()) {
                if (place[0] == 0) {
                    place[0] = l;
                } else if (place[1] == 0) {
                    place[1] = l;
                }else {
                    if (cows.get(place[0]).weight < cows.get(l).weight) {
                        var temp = place[0];
                        place[0] = l;
                        l = temp;
                    }
                    if (cows.get(place[1]).weight < cows.get(l).weight) place[1] = l;
                }
            }
            farm.removeCow(cows.get(place[0]));
            farm.removeCow(cows.get(place[1]));

            var turks = farm.getTurks();
            Turkey[] t = new Turkey[3];
            for (Turkey turkey : turks) {
                if (t[0] == null) {
                    t[0] = turkey;
                } else if (t[1] == null) {
                    t[1] = turkey;
                } else if (t[2] == null) {
                    t[2] = turkey;
                } else {
                    if (turkey.weight > t[0].weight) {
                        var temp = t[0];
                        t[0] = turkey;
                        turkey = temp;
                    }
                    if (turkey.weight > t[1].weight) {
                        var temp = t[1];
                        t[1] = turkey;
                        turkey = temp;
                    }
                    if (turkey.weight > t[0].weight) t[2] = turkey;
                }
            }
            farm.removeTurkey(t[0]);
            farm.removeTurkey(t[1]);
            farm.removeTurkey(t[2]);

            var pigs = farm.getPigs();
            int[] indexs = new int[] {0, 1, 2, 3};
            for (int l = 0; l < pigs.length; l++) {
                if (pigs[l] != null) {
                    for (int p = 0; p < indexs.length; p++) {
                        if (pigs[indexs[p]] == null) indexs[p] = l;
                        else {
                            if (pigs[indexs[p]].weight < pigs[l].weight) {
                                var temp = indexs[p];
                                indexs[p] = l;
                                l = temp;
                            }
                        }
                    }
                }
            }
            pigs[indexs[0]] = null;
            pigs[indexs[1]] = null;
            pigs[indexs[2]] = null;
            pigs[indexs[3]] = null;

        }
        System.out.println("Taken the Animals out back.");
        //endregion killHeavy
        //region Weight
        totw = 0;
        for (int i = 0; i < farms.size(); i++) {
            var anis = farms.get(i).getAllAnimals();
            var w = 0;
            for (Animal l : anis) {
                if (l != null) {
                    w += l.getCost();
                }
            }
            totw += w;
        }
        System.out.println("Total Weight of Feed on all Farms Combined is " + totw);
        //endregion weight
        //region reportFood

        //endregion reportFood


    }
}
