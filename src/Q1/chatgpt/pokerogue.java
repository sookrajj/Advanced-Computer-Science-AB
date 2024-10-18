package Q1.chatgpt;

import java.util.Random;
import java.util.Scanner;

class Creature {
    String name;
    int health;
    int attackPower;

    Creature(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    boolean isAlive() {
        return health > 0;
    }

    void attack(Creature opponent) {
        opponent.health -= attackPower;
        System.out.println(name + " attacks " + opponent.name + " for " + attackPower + " damage!");
    }
}

class Player extends Creature {
    Player(String name) {
        super(name, 100, 10);
    }

    void heal() {
        health += 20;
        System.out.println(name + " heals for 20 health!");
    }
}

class Enemy extends Creature {
    Enemy(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
}

public class pokerogue {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to PokeRogue!");

        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        Enemy[] enemies = {
                new Enemy("Goblin", 30, 5),
                new Enemy("Troll", 50, 7),
                new Enemy("Dragon", 80, 10)
        };

        for (Enemy enemy : enemies) {
            System.out.println("A wild " + enemy.name + " appears!");
            while (player.isAlive() && enemy.isAlive()) {
                System.out.println("Your Health: " + player.health + " | " + enemy.name + " Health: " + enemy.health);
                System.out.println("1. Attack\n2. Heal");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    player.attack(enemy);
                } else if (choice == 2) {
                    player.heal();
                } else {
                    System.out.println("Invalid choice! You lose your turn.");
                }

                if (enemy.isAlive()) {
                    enemy.attack(player);
                }
            }

            if (!player.isAlive()) {
                System.out.println("You have been defeated by " + enemy.name + "!");
                break;
            } else {
                System.out.println("You have defeated " + enemy.name + "!");
            }
        }

        if (player.isAlive()) {
            System.out.println("Congratulations, " + player.name + "! You have defeated all enemies!");
        }

        scanner.close();
    }
}

