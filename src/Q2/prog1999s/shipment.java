package Q2.prog1999s;

public class shipment {
    private String[] ships;
    private int[] numshi;

    public shipment(String ships) {
        this.ships = ships.split(" ");
        for (int i = 0; i < this.ships.length; i++) {
            numshi[i] = Integer.parseInt(this.ships[i].split(":")[1]);
            this.ships[i] = this.ships[i].split(":")[i]
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
}
