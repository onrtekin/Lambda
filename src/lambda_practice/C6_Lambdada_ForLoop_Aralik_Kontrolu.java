package lambda_practice;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {
        ilkOtuz(30);
        System.out.println();
        ilkDahilOtuz(30);
        System.out.println();
        System.out.println(topla(1, 10));
        System.out.println();
        System.out.println(ort(20, 30));
        System.out.println();
        System.out.println(sekizeBolunen(325, 468));
        System.out.println();
        sekizeBolunenYaz(325,468);
        System.out.println();
        System.out.println(sekizeBolunenToplami(352, 468));
        System.out.println();
        System.out.println(tekSayilarinCarpimi(7, 15));
        System.out.println();
        tekleriYazdir(5);
        System.out.println();
        yedininKatlariYazdir(10);
        System.out.println();
        yedininKatlariTopla(20);


    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
    public static void ilkOtuz(int a){
        IntStream.range(1,a).forEach(t-> System.out.print(t+" "));
    }


    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
    public static void ilkDahilOtuz(int a){
        IntStream.rangeClosed(1,a).forEach(t-> System.out.print(t+" "));
    }

    //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim
    public static int topla(int a,int b){
        return IntStream.rangeClosed(a,b).sum();
    }


    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim
    public static OptionalDouble ort(int a, int b){
        return IntStream.rangeClosed(a,b).average();
    }


    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
    public static int sekizeBolunen(int a,int b){
        return (int) IntStream.rangeClosed(a,b).filter(t->t%8==0).count();
    }

    //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim
    public static void sekizeBolunenYaz(int a,int b){
         IntStream.rangeClosed(a,b).filter(t->t%8==0).forEach(t-> System.out.print(t+" "));
    }


    // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim
    public static int sekizeBolunenToplami(int a,int b){
        return  IntStream.rangeClosed(a,b).filter(t->t%8==0).sum();
    }


    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim
    public static OptionalInt tekSayilarinCarpimi(int a, int b){
        return  IntStream.rangeClosed(a,b).filter(Methods::tekMi).reduce(Math::multiplyExact);
    }



    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
    public static void tekleriYazdir(int a){
       // IntStream.rangeClosed(1,a).limit(10).filter(Methods::tekMi).forEach(t-> System.out.print(t+" "));
        IntStream.iterate(1,t->t+2).limit(a).forEach(Methods::yazInteger);
    }


    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
    public static void yedininKatlariYazdir(int a){
IntStream.iterate(21,t->t+7).filter(Methods::tekMi).limit(a).forEach(Methods::yazInteger);

    }



    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim
    public static void yedininKatlariTopla(int a){
        System.out.println(IntStream.iterate(21, t -> t + 7).limit(a).sum());

    }


}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belilioruz