public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    public  boolean onZone() {
        System.out.println("Güvenli Bölgedesiniz");
        System.out.println("Canınız Yenilendi");
        System.out.println("Büyük Ödülleri Toplayıp Getir Oyunu KAZAN");
        this.getPlayer().setHealt(this.getPlayer().getBasicHealt());
        if(this.getPlayer().getInventory().getFoodAward()==1 &&
                this.getPlayer().getInventory().getFirewoodAward()==1 &&
                this.getPlayer().getInventory().getWaterAward()==1){
            System.out.println("TEBRİKLER KAZANDINIZ");
            return false;
        }

        return true;


    }
}