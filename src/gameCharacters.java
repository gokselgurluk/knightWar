public abstract class gameCharacters {
    private  int ID;
    private String charName;
    private int damege;
    private int healt;
    private int money;


    public gameCharacters(int ID,String charName,int damege, int healt, int money) {
        this.ID = ID;
        this.charName = charName;
        this.damege = damege;
        this.healt = healt;
        this.money = money;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
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
        this.healt = healt;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}


