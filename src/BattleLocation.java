import javax.xml.stream.Location;
import java.util.Random;

public abstract class BattleLocation extends Zone {
    private Monster monster;
    private String award;
    private int maxMonster;

    private boolean caseLocation;

    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;


    }

    @Override
    public boolean onZone() {

        if (getPlayer().getInventory().getFoodAward() == 1 && this.getName().equals("Magara")) {
            System.out.println("########## Magara bölümünü bitirdiniz");
            return true;
        }
        if(getPlayer().getInventory().getFirewoodAward() == 1 && this.getName().equals("Orman")) {
            System.out.println("########## Orman bölümünü bitirdiniz");
            return true;
        }
        if(getPlayer().getInventory().getWaterAward() == 1 && this.getName().equals("Nehir")) {
                System.out.println("########## Nehir bölümünü bitirdiniz");
                return true;
 ////
            } else {
            int monsterNum=this.randomMonster();
            if(this.getName().equals("Maden")){
                monsterNum =randomSnake();
            }

            System.out.println("Şuan buradasınız " + this.getName());
            System.out.println("Dikaktli Ol Burada   " + monsterNum + " tane " + this.getMonster().getName() + "  Yaşıyor");
            System.out.println("<S>avaş" + "veya" + "<K>aç");
            String palyerSelect = inputSelect.nextLine();
            // palyerSelect=palyerSelect.toUpperCase();
            System.out.println("Savaş Başladı");

            if (palyerSelect.equalsIgnoreCase("S") ) {
                combat(monsterNum);
            }

            if (this.getName().equals("Magara")) {
                getPlayer().getInventory().setFoodAward(1);

            }
            if (this.getName().equals("Orman")) {
                getPlayer().getInventory().setFirewoodAward(1);

            }
            if (this.getName().equals("Nehir")) {
                getPlayer().getInventory().setWaterAward(1);

            }


            if (this.getPlayer().getHealt() <= 0) {
                System.out.println("Öldünüz");
                return false;
            }
            return true;
        }
    }


    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setHealt(this.getMonster().getBasicHealt());
            if(this.getMonster().getName().equals("Yilan")){
                this.getMonster().setDamage(randomDamage());
            }
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealt() > 0 && this.getMonster().getHealt() > 0) {
                System.out.println("<V>ur veya <K>aç");
                String selectCombat = inputSelect.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    int rand = (int) (Math.random() * 100);
                    if (rand >= 50) {
                        System.out.println("Siz Vurdunuz");
                        monster.setHealt(this.monster.getHealt() - this.getPlayer().getTotalDamage());
                        afterHit();

                    } else {
                        if (this.getMonster().getHealt() > 0) {
                            System.out.println();
                            System.out.println("Canavar Vurdu");

                            int monsterDamage = (this.getMonster().getDamage()) - (getPlayer().getInventory().getArmor().getBlok());
                            if (monsterDamage < 0)
                            {
                                monsterDamage = 0;
                            }
                            this.getPlayer().setHealt(this.getPlayer().getHealt() - monsterDamage);
                            afterHit();
                        } else {
                            return false;
                        }
                    }
                }
                if (this.getMonster().getHealt() < this.getPlayer().getHealt()) {
                    System.out.println("Düşmanı yendiniz");

                    if(this.getMonster().getName().equals("Yilan")){
                        randomItem();

                    }else {
                        System.out.println("ÖDÜL: " + getMonster().getAward() + " Para");
                        System.out.println("Bölüm Ödülü: " + this.award);
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                        System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
                    }

                }
            }
        }



        return false;
    }

    public int randomDamage(){
        Random random= new Random();
        int randomDamege;
        randomDamege=random.nextInt(3,this.monster.getDamage());
       /* if ( randomDamege<3){
           return 3;
        }*/
        return randomDamege;
    }
    public void randomItem(){
        int number= (int) (Math.random() * 100);
        //Silah Kazanma İhtimali : 15%
        if(number<=15){
            int randomNumber= (int) (Math.random() * 100);

            if(randomNumber<=20)
            {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
                System.out.println("Ödül Silah : "+Weapon.getWeaponObjByID(1).getName());
                //Tüfek Kazanma İhtimali : 20%
            }
            if((randomNumber >15) && (randomNumber <50 ))
            {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
                System.out.println("Ödül Silah: "+Weapon.getWeaponObjByID(2).getName());
                // Kılıç Kazanma İhtimali : 30%
            }
            if(randomNumber >= 50)
            {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
                System.out.println("Ödül Silah: "+Weapon.getWeaponObjByID(3).getName());
                // Tabanca Kazanma İhtimali : 50%
            }

        }
        //Zırh Kazanma İhtimali : 15%
        if((number >15) && (number <=30 )){
            int randomNumber= (int) (Math.random() * 100);

            if(randomNumber<=20)
            {
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
                System.out.println("Ödül Zırh: "+Armor.getArmorObjByID(1).getName());
                //Tüfek Kazanma İhtimali : 20%
            }
            if((randomNumber >21) && (randomNumber <50 ))
            {
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
                System.out.println("Ödül Zırh: "+Armor.getArmorObjByID(2).getName());
                // Kılıç Kazanma İhtimali : 30%
            }
            if(randomNumber>=50)
            {
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
                System.out.println("Ödül Zırh: "+Armor.getArmorObjByID(3).getName());
                // Tabanca Kazanma İhtimali : 50%
            }

        }
       // Para Kazanma İhtimali : 25%
        if((number >30) && (number <=55 )){
            int randomNumber= (int) (Math.random() * 100);

            if(randomNumber<=20)
            {
                this.getPlayer().setMoney(getPlayer().getMoney()+10);
                System.out.println("Ödül para: "+10);
                //
                //10 Para Kazanma İhtimali: 20%
            }
            if((randomNumber >20) && (randomNumber <50 ))
            {
                this.getPlayer().setMoney(getPlayer().getMoney()+5);
                System.out.println("Ödül para: "+5);
                // 5 Para Kazanma İhtimali: 30%
            }
            if(randomNumber>=50)
            {
                this.getPlayer().setMoney(getPlayer().getMoney()+1);
                System.out.println("Ödül para: "+1);
                //
                //1 Para Kazanma İhtimali: 50%
            }

        }
        if((number > 55)) {
            System.out.println("Ödül Kazanamadınız");
        }

    }

    public void playerStats() {
        System.out.println("Oyuncu Degerleri");
        System.out.println("-----------------");
        System.out.println("Saglık: " + this.getPlayer().getHealt());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blok: " + this.getPlayer().getInventory().getArmor().getBlok());
        System.out.println("Para: " + this.getPlayer().getMoney());
        System.out.println();


    }

    public void monsterStats(int i) {

        System.out.println(i + ". " + this.getMonster().getName() + " Canavar Statları");
        System.out.println("--------------------------");
        System.out.println("Saglık " + this.getMonster().getHealt());
        System.out.println("Hasar  " + this.getMonster().getDamage());
        System.out.println("Ödül  " + this.getMonster().getAward());
        System.out.println();


    }
    public int randomSnake() {
        int monsterNumber=0;
        Random random = new Random();
        while (monsterNumber < 1 ){
            monsterNumber = random.nextInt(getMaxMonster());
        }
       return monsterNumber;
    }
    public int randomMonster() {

        Random random = new Random();
        return random.nextInt(this.getMaxMonster()) + 1;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealt());
        System.out.println(this.getMonster().getName() + " Canı " + this.getMonster().getHealt());
        System.out.println("--------------------");
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
