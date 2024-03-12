import java.beans.beancontext.BeanContextMembershipEvent;

public class Store extends NormalLoc {
    public Store(Player player) {
        super(player, "Magza");

    }

    @Override
    public boolean onZone() {
        System.out.println("<<Magzaya Hoşgeldiniz>>");
        boolean flag = true;
        while (flag) {
            System.out.println("1-Silahlar");
            System.out.println("2-Zırhlar");
            System.out.println("3-Çıkış");
            System.out.print("Seçiminiz: ");
            int selectCase = Zone.inputSelect.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Geçersiz Degergirdiniz");
                inputSelect.nextInt();
            }
            switch (selectCase) {

                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Güle Güle");
                    flag = false;
                    break;


            }
        }

        return true;
    }

    public void printWeapon() {

        System.out.println("Silahlar");

        for (Weapon w : Weapon.weapons()) {
            System.out.println("ID: " + w.getId() + "   İsim : " + w.getName() + "  Hasar: " + w.getDamege() + "    Para: " + w.getPrice());
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyWeapon() {

        System.out.println("Bir Silah Seçin");
        System.out.print("Seçiminiz: ");
        int selectWeaponID = inputSelect.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Geçersiz deger");
            selectWeaponID = inputSelect.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if (selectWeapon != null) {
                if (selectWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yetersiz Bakiye");

                } else {
                    System.out.println(selectWeapon.getName() + " Silahını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());

                    this.getPlayer().getInventory().setWeapon(selectWeapon);
                    System.out.println("Aktif Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void printArmor() {

        System.out.println("Zırhlar");

        for (Armor a : Armor.armors()) {
            System.out.println("ID: " + a.getID() + "   İsim: " + a.getName() + "   Zırh: " + a.getBlok() + "   Para: " + a.getPrice());
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyArmor() {
        System.out.println("Bir Zırh Seçin");
        System.out.print("Seçiminiz: ");
        int selectZırhID = inputSelect.nextInt();
        while (selectZırhID < 0 || selectZırhID > Weapon.weapons().length) {
            System.out.println("Geçersiz deger");
            selectZırhID = inputSelect.nextInt();
        }

        if (selectZırhID != 0) {
            Armor selectArmor = Armor.getArmorObjByID(selectZırhID);
            if (selectArmor != null) {
                if (selectArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yetersiz Bakiye");
                } else {
                    System.out.println(selectArmor.getName() + " Zırhı satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki Zırhınız: " + this.getPlayer().getInventory().getWeapon().getName());

                    this.getPlayer().getInventory().setArmor(selectArmor);
                    System.out.println("Aktif Zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }

        }
    }
}

