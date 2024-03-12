import javax.xml.namespace.QName;

public class Inventory {

    /*private  int weaponDamage ;
    private  String weaponName ;
*/
    private Weapon weapon;
    private Armor armor;

    private int waterAward;
    private int foodAward;
    private int firewoodAward;

    public Inventory() {
        this.weapon = new Weapon(-1,"yumruk",0,0);
        this.armor = new Armor(-1,"Gömlek",0,0);
        this.waterAward=0;
        this.foodAward=0;
        this.firewoodAward=0;

    }

    public int getWaterAward() {
        return waterAward;
    }

    public void setWaterAward(int waterAward) {
        this.waterAward = waterAward;
    }

    public int getFoodAward() {
        return foodAward;
    }

    public void setFoodAward(int foodAward) {
        this.foodAward = foodAward;
    }


    public int getFirewoodAward() {
        return firewoodAward;
    }

    public void setFirewoodAward(int firewoodAward) {
        this.firewoodAward = firewoodAward;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
