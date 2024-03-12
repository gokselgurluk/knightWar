import java.time.ZoneId;
import  java.util.Scanner;
import java.util.logging.SocketHandler;

public class Player {
    private  int ID;
    private int damege;
    private int healt;
    private int basicHealt;
    private int money;
    private String charName;
    private String name;
    private  Inventory inventory;
    private Scanner inputSelect = new Scanner(System.in);

    Player(String name) {
        this.name = name;
        this.inventory = new Inventory();

    }
    public void printInfo(){

        System.out.println("Silah: "+this.getInventory().getWeapon().getName()
                +"\t Zırh: "+this.getInventory().getArmor().getName()
                +"\t Blok: "+this.getInventory().getArmor().getBlok()
                +"\tKarater Gücü: "+this.getDamege()
                +"\tKarater Canı: "+this.getHealt()
                +"\tKarater Para: "+this.getMoney()
                +"\tFood Ödül: "+this.getInventory().getFoodAward()
                +"\tFireWood Ödül: "+this.getInventory().getFirewoodAward()
                +"\tWater Ödül: "+this.getInventory().getWaterAward());

    }

    public int getTotalDamage(){
        return damege+getInventory().getWeapon().getDamege();
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamege() {
        return damege;
    }
    public void setDamege(int damege) {
        this.damege = damege;
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

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    private String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectZone () {

    }

    public int getBasicHealt() {
        return basicHealt;
    }

    public void setBasicHealt(int basicHealt) {
        this.basicHealt = basicHealt;
    }

    public void selectChar(){

        gameCharacters[] charactersList = {new Warrior(),new Rogue(),new Mage()};
        System.out.println("--------------Karakter Listesi-----------");
        for (gameCharacters gC:charactersList){
            System.out.println(//"Karakter ismi: "+this.getName()
                    "Karater ID  : "+gC.getID()
                    +"\tKarater Türü : "+gC.getCharName()
                    +"\tKarater Gücü : "+gC.getDamege()
                    +"\tKarater Canı : "+gC.getHealt()
                    +"\tKarater Para : "+gC.getMoney());
            System.out.println("--------------------------------------");

        }
        System.out.println("------------Karater Seçiniz-----------");
        System.out.print("Seçiminiz: ");
        int select= inputSelect.nextInt();

        switch (select){
            case 1:
                playerSelect(new Warrior());
                break;
           case 2:
               playerSelect(new Rogue());
                break;
            case 3:
                playerSelect(new Mage());

        }
       /* System.out.println("\tKarater ID  : "+this.getID()
                +"Seçilen Karakter: "+this.getCharName()
                +"\tKarater Türü: "+this.getCharName()
                +"\tKarater Gücü: "+this.getDamege()
                +"\tKarater Canı: "+this.getHealt()
                +"\tKarater Para: "+this.getMoney());*/

    }

    public void playerSelect(gameCharacters name){
        this.setID(name.getID());
        this.setCharName(name.getCharName());
        this.setDamege(name.getDamege());
        this.setHealt(name.getHealt());
        this.setBasicHealt(name.getHealt());
        this.setMoney(name.getMoney());

    }
}
