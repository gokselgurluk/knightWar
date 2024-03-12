

import java.util.Scanner;
public class Game {


    public  void startGame() {
        Scanner input = new Scanner(System.in);

        System.out.println("Karakter İsmini Giriniz");
        String charName = input.nextLine();
        Player player =new Player(charName);
        player.selectChar();

while (true){
    player.printInfo();
    Zone zone=null;
    System.out.println("<<<<<<<<Bölgeler>>>>>>>>");
    System.out.println("1 Güvenli Alan");
    System.out.println("2 Demirci");
    System.out.println("3 Magara (Savaş Alanı) Canavar:Zombi  Ödül:Yemek");
    System.out.println("4 Orman  (Savaş Alanı) Canavar:Vampir Ödül:Odun");
    System.out.println("5 Nehir  (Savaş Alanı) Canavar:Ayı    Ödül:Su");
    //6. bolumu lısteledık
    System.out.println("6 Maden  (Savaş Alanı) Canavar:Yılan  Ödül: Para, Silah veya Zırh");
    System.out.println("0 Çıkış Yap");
    System.out.println("Lütfen Gitmek istediginiz bölgeyi seçiniz");
    System.out.print("Seçiminiz: ");

    int selecZone = input.nextInt();
    switch (selecZone){
        case 0:
            zone=null;
            break;
        case 1:
            zone=new SafeHouse(player);
            break;
        case 2:
            zone=new Store(player) ;
            break;
        case 3:

            zone=new Cave(player) ;
            break;
        case 4:
            zone=new Forest(player) ;
            break;
        case 5:
            zone=new River(player) ;
            break;
        case 6:
            zone=new Mine(player) ;//6. bolumu ekledık
            break;
        default:
            zone=new SafeHouse(player) ;
            break;
    }

    if(zone==null){
        System.out.println("Oyun sonlandı");
        break;
    }
    if(!zone.onZone()){

        break;
    }


}

    }

}
