import java.util.*;

public class Lambda03 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.

        minBul(sayi);
        ciftKareKbPrinr(sayi);
        System.out.println();
        tekKareBkPrint(sayi);






        

    }
    //1. yontem Method Reference --> Integer class
    public static void minBul(List<Integer> sayi){
        Optional<Integer> minSayiInteger = sayi.stream().reduce(Integer::min);
        System.out.println(minSayiInteger);
        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        System.out.println(minSayiMath );
        //3. yontem Lambda Expression
          int minSayiLambda = (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        System.out.println(minSayiLambda);
        //4. yontem Method Reference --> Haluk class
        Optional<Integer> minSayiHaluk = sayi.stream().reduce(Lambda03::byHalukMin);
        System.out.println(minSayiHaluk);
    }


    public static int byHalukMin(int a,int b){// iki int degerin en kucugunu return eder
        return a<b?a:b;
    }
    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBuyukTekEnKucuk(List<Integer> sayi){
        System.out.println(sayi.stream().filter(t->t>5&&t%2==1).reduce(Lambda03::byHalukMin));
    }
    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKbPrinr(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                sorted().//siraya sokuldu
                forEach(Lambda01::yazdir);
    }
    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
    public static void tekKareBkPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t%2!=0).
                map(t->t*t).
                sorted(Comparator.reverseOrder()). //tersten siralama methodu
                forEach(Lambda01::yazdir);
    }

    
}
