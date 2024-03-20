public class Man implements Human {

    private String name;
    private int loveCode;

    public Man(String name, int loveCode) {
        this.name = name;
        this.loveCode = loveCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoveCode() {
        return loveCode;
    }

    public void setLoveCode(int loveCode) {
        this.loveCode = loveCode;
    }

    @Override
    public boolean trueLove(Human human) {
        if (human instanceof FoxFairy){
            FoxFairy foxFairy = (FoxFairy) human;
            return this.loveCode == foxFairy.getLoveCode();
        }  return false;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", loveCode=" + loveCode +
                '}';
    }
}
