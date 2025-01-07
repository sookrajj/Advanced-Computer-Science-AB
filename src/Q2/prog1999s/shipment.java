package Q2.prog1999s;

public class shipment implements Comparable<shipment> {
    private String[] ships = new String[3];
    private int[] numshi = new int[3];

    public shipment(String ships) {
        this.ships = ships.split(" ");
        for (int i = 0; i < this.ships.length; i++) {
            this.numshi[i] = Integer.parseInt(this.ships[i].split(":")[1]);
            this.ships[i] = this.ships[i].split(":")[0];
        }
    }

    public String getShip(int num) {
        return ships[num];
    }
    public int getnum(int num) {
        return numshi[num];
    }

    public String[] getShips() {
        return ships;
    }

    public int[] getNumshi() {
        return numshi;
    }

    @Override
    public int compareTo(shipment o) {
        return 0;
    }
}
