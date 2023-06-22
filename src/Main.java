interface HavingSuperAbility {
    void applySuperAbility();
}


abstract class Hero implements HavingSuperAbility {
    private int health;
    private int damage;
    private String superAbility;

    public Hero(int health, int damage, String superAbility) {
        this.health = health;
        this.damage = damage;
        this.superAbility = superAbility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getSuperAbility() {
        return superAbility;
    }

    public void setSuperAbility(String superAbility) {
        this.superAbility = superAbility;
    }
}


class Magic extends Hero {
    public Magic(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Magic applied super ability: " + getSuperAbility());
    }
}


class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, String superAbility, int healPoints) {
        super(health, damage, superAbility);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    public void increaseExperience() {
        healPoints += (int) (healPoints * 0.1);
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Medic applied super ability: " + getSuperAbility());
    }
}


class Warrior extends Hero {
    public Warrior(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Warrior applied super ability: " + getSuperAbility());
    }
}


public class Main {
    public static void main(String[] args) {
        Hero[] heroes = new Hero[3];
        heroes[0] = new Magic(100, 20, "Teleportation");
        heroes[1] = new Medic(120, 10, "Healing", 50);
        heroes[2] = new Warrior(150, 30, "Critical Damage");

        for (Hero hero : heroes) {
            hero.applySuperAbility();

            if (hero instanceof Medic) {
                Medic medic = (Medic) hero;
                medic.increaseExperience();
            }
        }
    }
}