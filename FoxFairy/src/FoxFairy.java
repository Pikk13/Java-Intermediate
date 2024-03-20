import java.util.Random;

public class FoxFairy implements Human {

    Random random = new Random();
    int randomLoveCode = random.nextInt(1, 5);

    private int loveCode = randomLoveCode;
    private int victim;
    private boolean disappointing;

    public void increaseVictim() {
        victim++;
        System.out.println("Áldozatok száma: " + getVictim());
        if (victim > 5) {
            disappointing = true;
            System.out.println("A rókatündér nagyon szomorú, csalódott, keres egy másik biomot!");
        }
    }

    public FoxFairy() {
    }

    public int getLoveCode() {
        return loveCode;
    }

    public int getVictim() {
        return victim;
    }

    public boolean isDisappointing() {
        return disappointing;
    }

    @Override
    public boolean trueLove(Human human) {
        if (human instanceof Man) {
            Man man = (Man) human;
            return this.loveCode == man.getLoveCode();
        }
        return false;
    }

    @Override
    public String toString() {
        return "FoxFairy{" +
                "loveCode=" + loveCode +
                ", victim=" + victim +
                ", disappointing=" + disappointing +
                '}';
    }
}

