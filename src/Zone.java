import java.util.Scanner;

public abstract class Zone {

    private Player player ;
    private String name ;
    public static Scanner inputSelect = new Scanner(System.in);

    Zone(Player player,String name){

        this.player=player;
        this.name=name;
    }

  public  abstract boolean onZone();


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
