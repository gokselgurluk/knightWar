public  class NormalLoc extends Zone{

    public NormalLoc(Player player, String name) {
        super(player,name);
    }

    @Override
  public  boolean onZone() {
        System.out.println("Güvenli Bölgedesiniz");
        System.out.println("Canınız Yenilendi");
        return true;
    }
}
