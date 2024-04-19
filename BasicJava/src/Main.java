import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        System.out.println("Hello World!");

        int sayi= 5;

        System.out.println(sayi);

        double sayi2=3.14;

        System.out.println(sayi2);
        float sayi3=3.14F;
        System.out.println(sayi3);

        char karakter='K';

        System.out.println(karakter);

        String metin= "Merhaba,nasılsınız?";
        System.out.println(metin);

        Scanner scanner= new Scanner(System.in);

        System.out.println("Adinizi giriniz!");
        String ad= scanner.nextLine();

        System.out.println(metin+ " "+ ad);
        System.out.println("Bir sayi giriniz?");
        int sayi4 = scanner.nextInt();

        System.out.println(sayi4);

        if(sayi4>0){
            System.out.println("Sayi Pozitiif");
        } else if (sayi4==0) {
            System.out.println("Sayı sıfıra eşittir.");

        } else {
            System.out.println("Sayi Negatif");
        }

        System.out.println("Haftanın günü sayi olarak giriniz");

        int gun= scanner.nextInt();
        switch (gun) {
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("Çarşamba");
                break;
            case 4:
                System.out.println("Pazartesi");
                break;
            case 5:
                System.out.println("Salı");
                break;
            case 6:
                System.out.println("Çarşamba");
                break;
            case 7:
                System.out.println("Çarşamba");
                break;
            default:
                System.out.println("Geçersiz gün");
                break;
        }
*/
/*
        System.out.println("While Döngüsü");
        int i = 1;
        while (i>=0)
        {
            System.out.println(i);
            i++;
        if (i>10)
            return;
        }

        System.out.println("Do while");

        int j = 1;
        do {
            System.out.println(j);
            j++;
        }while (j<=10);

        System.out.println("For Döngüsü");
        for (int k = 0; k <= 10; k++) {
            System.out.println(k);
        }
        */

        //int h= 5;
/*
        int [] dizi={1,3,5,7};
        for(int i=0;i<dizi.length;i++){
            System.out.println(dizi[i]);
        }

        for (int eleman : dizi) {
            System.out.println(eleman);
        }
    */
        /*
        int birincisayi=6;
        int ikincisayi=7;

        System.out.println(toplama(birincisayi,ikincisayi));
        System.out.println(toplama(9,13));


        System.out.println(faktoriyel(5));

        System.out.println(Gunler.valueOf("PAZARTESI"));
     }

     public static int toplama(int sayi1,int sayi2) {
        return sayi1+sayi2;
     }
    public static int faktoriyel(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * faktoriyel(n - 1);
        }*/

        Ogrenci ogrenci1= new Ogrenci();
        ogrenci1.setNo(1);
        ogrenci1.setAd("John");
        ogrenci1.setSoyad("Doe");
        System.out.println(ogrenci1.giveFullName());

        Ogrenci ogrenci2= new Ogrenci(2,"Jane","Doe");
        System.out.println(ogrenci2.giveFullName());

        ogrenci2.setAd("Janet");
        System.out.println(ogrenci2.giveFullName());

    }

    public enum Gunler {
        PAZARTESI,
        SALI,
        CARSAMBA,
        PERSEMBE,
        CUMA,
        CUMARTESI,
        PAZAR
    }
}
