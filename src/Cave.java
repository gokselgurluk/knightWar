public class Cave extends  BattleLocation{
    private boolean caseLoca;
    public Cave(Player player) {
        super(player, "Magara",new Zombi(), "food",3);

    }

    public boolean isCaseLoca() {
        return caseLoca;
    }

    public void setCaseLoca(boolean caseLoca) {
        this.caseLoca = caseLoca;
    }
}
