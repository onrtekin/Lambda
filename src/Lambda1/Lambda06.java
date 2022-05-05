package Lambda1;

import java.math.BigInteger;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Lambda06 {
    public static void main(String[] args) {
        System.out.println("TASK 01 Str-->" + toplaStr(10));
        System.out.println("TASK 01 Func.-->" + topla(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->"+ciftSayilariTopla(10));
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->"+ilkXCiftSayilariTopla(10));
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->"+ilkXTekSayilariTopla(3));
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ikininIlkXKuvvetPrint(7);
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 07 -->"+istenenSayiFaktoryel(5));
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->"+istenenSayininXKuvveti(2,4));
        System.out.println("   ***   ");

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming
    public static int toplaStr(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional(cincix Programming
    public static int topla(int x) {
        return IntStream.
                range(1, x + 1).// 1 den x e kadar akisa alindi
                        sum();
    }


    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftSayilariTopla(int x) {
        return IntStream.
                rangeClosed(1, x).// 1 den x e kadar akisa alindi
                filter(Lambda01::ciftBul).
                sum();

    }


    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int ilkXCiftSayilariTopla(int x) {
        return IntStream.
                iterate(2,t->t+2).//2,4,6,8,10.......
                limit(x).//akistaki ilk x int degeri akisa alir
                sum();// akistaki degerler toplami

    }
    //iterate(seed, repeat action) -->
    // seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy


    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkXTekSayilariTopla(int x) {
        return IntStream.
                iterate(1,t->t+2).
                        limit(x).//akistaki ilk x int degeri akisa alir
                        sum();// akistaki degerler toplami

    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void ikininIlkXKuvvetPrint(int x) {
        IntStream.
                iterate(2, t -> t * 2).//2 den sonsuza  kadar elemanları 2 ile carparak akısa alır -->2,4,8,16,32...
                limit(x).//akısdaki ilk x int degeri akısa alır
                forEach(Lambda01::yazdir);//akısdaki int degerler toplandı

        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa kıyar
    }


    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void IstenenSayiIlkXKuvvetPrint(int istenenSayi,int x){
        IntStream.iterate(istenenSayi,t->t*istenenSayi).limit(x).forEach(Lambda01::yazdir);
    }



    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
public static int istenenSayiFaktoryel(int x){
      return  IntStream.rangeClosed(1,x).//reduce(Math::multiplyExact).
                                    reduce(1,(t,u)->t*u);

    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int istenenSayininXKuvveti(int istenenSayi,int x){
        return IntStream.iterate(istenenSayi,t->t*istenenSayi).limit(x).reduce(0,(t,u)->u);




    }


}
