public class Player {
    private String name;
    private int health;
    private Weapon weapon;

    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health <= 0) {
            System.out.println("У игрока: " + name + " кончилось ХП");
        }
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " нападает на " + enemy.getName() + " с оружием " + weapon.getName());
        enemy.takeDamage(weapon.getDamage());
    }
}

class Enemy {
    private String name;
    private int health;
    private int damage;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("У врага: " + name + " закончилось ХП");
        }
    }

    public void attack(Player player) {
        System.out.println(name + " нападает на " + player.getName());
        player.takeDamage(damage);
    }
}

class Weapon {
    private String name;
    private int damage;

    Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}

class Main14 {
    public static void main(String[] args) {
        Player player = new Player("Убивец", 100, new Weapon("Пистолет", 30));
        Enemy enemy = new Enemy("Чудо-юдо", 50, 10);

        System.out.println("Игрок " + player.getName() + " с кол-вом ХП: " + player.getHealth());
        System.out.println("Враг " + enemy.getName() + " с кол-вом ХП: " + enemy.getHealth());

        while (player.getHealth() >= 0 || enemy.getHealth() >= 0) {
            player.attack(enemy);
            if (enemy.getHealth() <= 0) {
                System.out.println("Игрок " + player.getName() + " победил!");
                break;
            }
            else if (player.getHealth() <= 0) {
                System.out.println("Враг " + enemy.getName() + " победил!");
            }
            enemy.attack(player);
        }
    }
}