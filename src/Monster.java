public class Monster {

    private int ID;
    private String name;
    private int damage;
    private int healt;
    private int award ;
    private int basicHealt;

    public Monster(int ID, String name,int damage, int healt,int award) {
        this.ID = ID;
        this .name=name;
        this.damage = damage;
        this.healt = healt;
        this.award=award;
        this.basicHealt=healt;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealt() {

        return healt;
    }

    public void setHealt(int healt) {
        if(healt<0){
            healt=0;
        }
        this.healt = healt;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getBasicHealt() {
        return basicHealt;
    }

    public void setBasicHealt(int basicHealt) {
        this.basicHealt = basicHealt;
    }
}
