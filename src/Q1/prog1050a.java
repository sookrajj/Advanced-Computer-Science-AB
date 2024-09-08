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

    public class calculationStuff {
        private ArrayList<keep> stuff;
        private int salesteurope;
        private int cerealtcam;
        private double meatpro;
        private double highprio;
        private double fruitloss2012;
        private int numpriolate;
        private String highpro;
        private String regmostsnacks;

        public calculationStuff(ArrayList<keep> all) {
            stuff = all;
            calc();
        }

        private void calc() {
            int numssales = 0;
            int certcam = 0;
            double meatprofit = 0;
            int low = 0;
            int med = 0;
            double high = 0;
            double fruloss = 0;
            for (int lcv = 0; lcv < stuff.size(); lcv++) {
                if (stuff.get(lcv).getRegion().equals("Europe")) {
                    numssales += stuff.get(lcv).getUnitsSold();
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
            }
            salesteurope = numssales;
            cerealtcam = certcam;
            meatpro = meatprofit;
            highprio = high/(high+med+low);
            fruitloss2012 = fruloss;
        }

        private int numdays(int point) {
            int num = 0;
            fdate orddate = stuff.get(point).getOrderDate();
            fdate shidate = stuff.get(point).getShipDate();
            if (orddate.getYear() == shidate.getYear()) {
                if (orddate.getMonth() == shidate.getMonth()) {
                    num = shidate.getDay()-orddate.getDay();
                } else if (shidate.getMonth()-orddate.getMonth() == 1) {
                    num = (30+shidate.getDay()) - orddate.getDay();
                }
            } else if (shidate.getYear()-orddate.getYear() == 1) {

            }
            return num;
        }

        public int salesteuro() {
            int numssales = 0;
            for (int lcv = 0; lcv < stuff.size(); lcv++) {
                if (stuff.get(lcv).getRegion().equals("Europe")) {
                    numssales += stuff.get(lcv).getUnitsSold();
                }
            }
            return numssales;
        }

        public int cerealbyCam() {
            int numscer = 0;
            for (int lcv = 0; lcv < stuff.size(); lcv++) {
                if (stuff.get(lcv).getCountry().equals("Cambodia")) {
                    if (stuff.get(lcv).getItemType().equals("Cereal")) {
                        numscer += stuff.get(lcv).getUnitsSold();
                    }

                }
            }
            return numscer;
        }

        public double meatmoney() {
            int numeat = 0;
            for (int lcv = 0; lcv < stuff.size(); lcv++) {
                if (stuff.get(lcv).getItemType().equals("Meat")) {
                    numeat += stuff.get(lcv).getUnitsSold();
                }
            }
            return numeat;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new File("Langdat/lang1050.csv"));
            String[] strs = new String[14];
            ArrayList<keep> all =  new ArrayList<>();
            while (s.hasNext()) {
                strs = s.nextLine().split(",");

                all.add(new keep(strs[0], strs[1], strs[2], strs[3], strs[4],
                        strs[5], strs[6], strs[7], Integer.parseInt(strs[8]),
                        Double.parseDouble(strs[9]), Double.parseDouble(strs[10]),
                        Double.parseDouble(strs[11]), Double.parseDouble(strs[12]),
                        Double.parseDouble(strs[13])));
            }




        } catch (
                IOException e) {
            System.out.println("Can't find data file.");
        }
    }
}
