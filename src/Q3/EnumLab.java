package Q3;

public class EnumLab {
    enum Level {
        Low,
        Medium,
        High
    }

    public static void main(String[] args) {
        Level mylvl = Level.Medium;
        switch(mylvl) {
            case Low -> System.out.println("Low level");
            case Medium -> System.out.println("Medium Level");
            case High -> System.out.println("High Level");
        }

        for (Level option : Level.values()) {
            System.out.println(option);
        }
        // enums can have classes with methods and attributions and interfaces
        // but enum constants are final
    }
}
