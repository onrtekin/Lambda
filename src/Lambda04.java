import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda04 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<String>(Arrays.asList("kusleme", "adana", "trilece", "HavucDilim"
                , "buryan", "yaglama", "kokorex", "arabasi", "guvec", "trilece", "wrilece"));
        alfabetikBykTekrrsz(menu);
        System.out.println("\n    *******      ");
        karakterSysTersTkrrsPrint(menu);
        System.out.println("\n    *******      ");
        krkSysKckByPrint(menu);
        System.out.println("\n    *******      ");
        sonHarfeTersSrPrint(menu);
        System.out.println("\n    *******      ");
        ciftSyChrKarTkrrbyKcPrint(menu);
        System.out.println("\n    *******      ");
        yedidenKckPrint(menu);
        System.out.println("\n    *******      ");
        wIleBaslayanPrint(menu);
        System.out.println("\n    *******      ");
        xIleBtnPrint(menu);
        System.out.println("\n    *******      ");
        krkSysEnBykPrint(menu);
        System.out.println("\n    *******      ");
        sonHarfeGoreSrlIlkElmnHaric(menu);
        System.out.println("\n    *******      ");


    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikBykTekrrsz(List<String> menu) {
        menu.
                stream().
                //map(t->t.toUpperCase()).
                        map(String::toUpperCase).// bu sekildede olabilir String classindan alir
                sorted().
                distinct().//tekrarsiz hale getiren method
                forEach(t -> System.out.print(t + " "));
        //distinct() => Bu method tekrarlı elemanları sadece bir kere yazdırır.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir (yinelenen öğeler için,
        // karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder
    }


    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void karakterSysTersTkrrsPrint(List<String> menu) {
        menu.
                stream().
                map(t -> t.length()).//map(String::length()) kullanilabilir
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(t -> System.out.print(t + " "));
    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void krkSysKckByPrint(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(String::length)).
                distinct().
                forEach(t -> System.out.print(t + " "));
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfeTersSrPrint(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1)).reversed()).

                forEach(t -> System.out.print(t + " "));

    }

// Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini
// tekrarsiz buyukten kucuge sirali  print ediniz..

    public static void ciftSyChrKarTkrrbyKcPrint(List<String> menu) {
        menu.stream().filter(t -> t.length() % 2 == 0).map(t -> t.length() * t.length()).
                sorted(Comparator.comparing(t -> t.toString())).
                distinct().forEach(Lambda01::yazdir);
    }
// Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void yedidenKckPrint(List<String> menu) {
        menu.stream().filter(t -> t.length() <= 7).forEach(t -> System.out.print(t + " "));


    }

    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanPrint(List<String> menu) {
        menu.stream().filter(t -> t.startsWith("W") || t.startsWith("w")).forEach(t -> System.out.println(t + " "));

    }

    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBtnPrint(List<String> menu) {
        menu.stream().filter(t -> t.endsWith("x")).forEach(t -> System.out.println(t + " "));

    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void krkSysEnBykPrint(List<String> menu) {
        String enBuyuk = menu.stream().max(Comparator.comparing(String::length)).get();
        System.out.println(enBuyuk);
    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void sonHarfeGoreSrlIlkElmnHaric(List<String> menu) {
        menu.stream().sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1))).
                forEach(t -> System.out.print(t.substring(1) + " "));

    }

}
