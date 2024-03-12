public class Weapon {
    int id;
    String name;
    int damege;
    int price;

    public Weapon(int id, String name, int damege, int price) {
        this.id = id;
        this.name = name;
        this.damege = damege;
        this.price = price;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponsList =new Weapon[3];
        weaponsList[0]=new Weapon(1,"Sword",2,25);
        weaponsList[1]=new Weapon(2,"Bow",3,35);
        weaponsList[2]=new Weapon(3,"Staf",7,45);

        return weaponsList;
    }

    public static  Weapon getWeaponObjByID(int id ){

        for(Weapon w : Weapon.weapons()){
            if (w.getId()==id){
                return w;
            }

        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamege() {
        return damege;
    }

    public void setDamege(int damege) {
        this.damege = damege;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
