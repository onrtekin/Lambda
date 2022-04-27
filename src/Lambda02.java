import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarePrint(sayi);
        System.out.println("\n       ***");
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n       ***");
        ciftKareKokPrint(sayi);
        System.out.println("\n       ***");
        maxEl(sayi);
        System.out.println("\n       ***");
        ciftElMax(sayi);
        System.out.println("\n       ***");


    }
    // Task : Functional Programming ile listin cift elemanlarinin
    // karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                forEach(Lambda01::yazdir);
        //map()--> Stream içerisindeki elemanları
        // başka tiplere dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.

    }

    // Task : Functional Programming ile listin tek elemanlarinin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edin
    public static void tekKupBirFazlaPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 != 0).
                map(t -> (t * t * t) + 1).
                forEach(Lambda01::yazdir);
    }

    // Task : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    // Task : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKareKokPrint(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t -> System.out.print(t + " "));
    }
    // Task : list'in en buyuk elemanini yazdiriniz

    public static void maxEl(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.stream().reduce(Math::max);
        System.out.print(maxSayi);
    }
// Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftElMax(List<Integer> sayi) {
        System.out.print(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Math::max));
    }

}
