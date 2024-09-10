package Q1;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class prog1050a {
    public static class fdate {
        private int month;
        private int day;
        private int year;

        public fdate(String date) {
            String[] s = new String[3];
            s = date.split("/");
            month = Integer.parseInt(s[0]);
            day = Integer.parseInt(s[1]);
            year = Integer.parseInt(s[2]);
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        public int getYear() {
            return year;
        }
    }
    public static class keep {
        private String region;
        private String country;
        private String itemType;
        private String salesChannel;
        private String orderPriority;
        private fdate orderDate;
        private String orderID;
        private fdate shipDate;
        private int unitsSold;
        private double unitPrice;
        private double unitCost;
        private double totalRevenue;
        private double totalCost;
        private double totalProfit;

        public keep(String reg, String coun, String item, String sach, String Opro,
                    String Odate, String OID, String Sdate, int Usold, double Uprice,
                    double Ucost, double totr, double totc, double totp) {
            region = reg; country = coun; itemType = item; salesChannel = sach;
            orderPriority = Opro; orderDate = new fdate(Odate); orderID = OID;
            shipDate = new fdate(Sdate); unitsSold = Usold; unitPrice = Uprice;
            unitCost = Ucost; totalRevenue = totr; totalCost = totc; totalProfit = totp;
        }

        public String getRegion() {
            return region;
        }

        public String getCountry() {
            return country;
        }

        public String getItemType() {
            return itemType;
        }

        public String getSalesChannel() {
            return salesChannel;
        }
        public String getOrderPriority() {
            return orderPriority;
        }

        public fdate getOrderDate() {
            return orderDate;
        }

        public String getOrderID() {
            return orderID;
        }

        public fdate getShipDate() {
            return shipDate;
        }

        public int getUnitsSold() {
            return unitsSold;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public double getUnitCost() {
            return unitCost;
        }

        public double getTotalRevenue() {
            return totalRevenue;
        }

        public double getTotalCost() {
            return totalCost;
        }

        public double getTotalProfit() {
            return totalProfit;
        }
    }

    public static class calculationStuff {
        private ArrayList<keep> stuff;
        private int salesteurope;
        private int cerealtcam;
        private double meatpro;
        private double highprio;
        private double fruitloss2012;
        private int numpriolate = 0;
        private String highpro;
        private String regmostsnacks;

        public calculationStuff(ArrayList<keep> all) {
            stuff = all;
            calc();
        }

        private void calc() {
            ArrayList<counpro> pros = new ArrayList<>();
            ArrayList<mosna> mo = new ArrayList<>();
            int numssales = 0;
            int certcam = 0;
            double meatprofit = 0;
            int low = 0;
            int med = 0;
            double high = 0;
            double fruloss = 0;
            for (int lcv = 0; lcv < stuff.size(); lcv++) {
                if (stuff.get(lcv).getRegion().equals("Europe")) {
                    numssales ++;
                }
                if (stuff.get(lcv).getCountry().equals("Cambodia") &&
                        stuff.get(lcv).getItemType().equals("Cereal")) {
                    certcam += stuff.get(lcv).getUnitsSold();
                }
                if (stuff.get(lcv).getItemType().equals("Meat")) {
                    meatprofit += stuff.get(lcv).getTotalProfit();
                }
                if (stuff.get(lcv).getOrderPriority().equals("H")) {
                    high++;
                    if (numdays(lcv)) {
                        numpriolate += stuff.get(lcv).getUnitsSold();
                    }
                } else if (stuff.get(lcv).getOrderPriority().equals("M")) {
                    med++;
                } else {
                    low++;
                }
                fdate od = stuff.get(lcv).getOrderDate();
                if (stuff.get(lcv).getItemType().equals("Fruit")) {
                    if (od.getYear() == 2012) {
                        fruloss += stuff.get(lcv).getTotalProfit();
                    }
                }
                if (stuff.get(lcv).getItemType().equals("Personal Care")) {
                    if (pros.isEmpty()) {
                        pros.add(new counpro(stuff.get(lcv).getCountry(),
                                stuff.get(lcv).getTotalProfit()));
                    }
                    boolean yes = false;
                    for (int lv = 0; lv < pros.size(); lv++) {
                        if (pros.get(lv).getCoun().equals(stuff.get(lcv).getCountry())) {
                            pros.get(lv).setPro(stuff.get(lcv).getTotalProfit());
                            yes = true;
                        }
                    }
                    if (!yes) {
                        pros.add(new counpro(stuff.get(lcv).getCountry(),
                                stuff.get(lcv).getTotalProfit()));
                    }
                }
                if (stuff.get(lcv).getItemType().equals("Snacks")) {
                    if (mo.isEmpty()) {
                        mo.add(new mosna(stuff.get(lcv).getRegion(),
                                stuff.get(lcv).getUnitsSold()));
                    }
                    boolean yes = false;
                    for (int lv = 0; lv < mo.size(); lv++) {
                        if (mo.get(lv).getReg().equals(stuff.get(lcv).getRegion())) {
                            mo.get(lv).setSnun(stuff.get(lcv).getUnitsSold());
                            yes = true;
                        }
                    }
                    if (!yes) {
                        mo.add(new mosna(stuff.get(lcv).getRegion(),
                                stuff.get(lcv).getUnitsSold()));
                    }
                }
            }
            salesteurope = numssales;
            cerealtcam = certcam;
            meatpro = meatprofit;
            highprio = Math.round(((double) high)/(double)(high+med+low)) * 100.0;
            fruitloss2012 = fruloss;
            int prohi = 0;
            for (int lcv = 1; lcv < pros.size(); lcv++) {
                if (pros.get(lcv).getPro() > pros.get(prohi).getPro()) {
                    prohi = lcv;
                }
            }
            highpro = pros.get(prohi).getCoun();
            int hisna = 0;
            for (int lcv = 1; lcv < mo.size(); lcv++) {
                if (mo.get(lcv).getSnun() > mo.get(hisna).getSnun()) {
                    hisna = lcv;
                }
            }
            regmostsnacks = mo.get(hisna).getReg();
        }

        private boolean numdays(int point) {
            int num = 0;
            fdate orddate = stuff.get(point).getOrderDate();
            fdate shidate = stuff.get(point).getShipDate();
            if (orddate.getYear() == shidate.getYear()) {
                if (orddate.getMonth() == shidate.getMonth()) {
                    num = shidate.getDay()-orddate.getDay();
                    if (num < 4) {return true;}
                    return false;
                } else if (shidate.getMonth()-orddate.getMonth() == 1) {
                    num = (30+shidate.getDay()) - orddate.getDay();
                    if (num < 4) {return true;}
                    return false;
                }
            } else if (shidate.getYear()-orddate.getYear() == 1) {
                if (orddate.getMonth() == 12 && shidate.getMonth() == 1) {
                    if ((30+shidate.getDay())-orddate.getDay() <= 3) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int getSalesteurope() {
            return salesteurope;
        }

        public int getCerealtcam() {
            return cerealtcam;
        }

        public double getMeatpro() {
            return meatpro;
        }

        public double getHighprio() {
            return highprio;
        }

        public double getFruitloss2012() {
            return fruitloss2012;
        }

        public int getNumpriolate() {
            return numpriolate;
        }

        public String getHighpro() {
            return highpro;
        }

        public String getRegmostsnacks() {
            return regmostsnacks;
        }
    }
    public static class mosna {
        private String reg;
        private int snun;

        public mosna(String region, int snackunit) {
            reg = region;
            snun = snackunit;
        }

        public void setSnun(int snun) {
            this.snun = this.snun + snun;
        }

        public String getReg() {
            return reg;
        }

        public int getSnun() {
            return snun;
        }
    }
    public static class counpro {
        private String coun;
        private double pro;

        public counpro(String coun, double pro) {
            this.coun = coun;
            this.pro = pro;
        }

        public String getCoun() {
            return coun;
        }

        public double getPro() {
            return pro;
        }

        public void setPro(double pro) {
            this.pro = this.pro+ pro;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new File("Langdat/lang1050.csv"));
            String[] strs = new String[14];
            ArrayList<keep> all =  new ArrayList<>();
            String place = s.nextLine();
            while (s.hasNext()) {
                strs = s.nextLine().split(",");

                all.add(new keep(strs[0], strs[1], strs[2], strs[3], strs[4],
                        strs[5], strs[6], strs[7], Integer.parseInt(strs[8]),
                        Double.parseDouble(strs[9]), Double.parseDouble(strs[10]),
                        Double.parseDouble(strs[11]), Double.parseDouble(strs[12]),
                        Double.parseDouble(strs[13])));
            }
            calculationStuff calcs = new calculationStuff(all);
            System.out.println("Sales to Europe: " + calcs.getSalesteurope());
            System.out.println("Cereal bought by Cambodia: " + calcs.getCerealtcam());
            System.out.println("Total profit on Meat: " + calcs.getMeatpro());
            System.out.printf("High priority sales percentage: %.2f %%", calcs.getHighprio());
            System.out.printf("\nFruits profit lost in 2012: %.2f %%", calcs.getFruitloss2012());
            System.out.println("\nHigh priority sales shipped more than 3 days late: " + calcs.getNumpriolate());
            System.out.println("Country with highest profit on Personal Care: " + calcs.getHighpro());
            System.out.println("Region that bought the most Snacks: " + calcs.getRegmostsnacks());



        } catch (
                IOException e) {
            System.out.println("Can't find data file.");
        }
    }
}
