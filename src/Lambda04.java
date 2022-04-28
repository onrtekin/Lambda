import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda04 {
    public static void main(String[] args) {
        List<String> menu=new ArrayList<String>(Arrays.asList("kusleme","adana","trilece","HavucDilim"
        ,"buryan","yaglama","kokorec","arabasi","guvec","trilece","trilece"));
        alfabetikBykTekrrsz(menu);
        System.out.println("\n    *******      ");
        karakterSysTersTkrrsPrint(menu);
        System.out.println("\n    *******      ");
        krkSysKckByPrint(menu);
        System.out.println("\n    *******      ");
        sonHarfeTersSrPrint(menu);
        System.out.println("\n    *******      ");




    }
    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikBykTekrrsz(List<String> menu){
        menu.
                stream().
                //map(t->t.toUpperCase()).
                map(String::toUpperCase).// bu sekildede olabilir String classindan alir
                sorted().
                distinct().//tekrarsiz hale getiren method
                forEach(t-> System.out.print(t+" "));
        //distinct() => Bu method tekrarlı elemanları sadece bir kere yazdırır.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir (yinelenen öğeler için,
        // karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder
    }


// Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void karakterSysTersTkrrsPrint(List<String> menu){
        menu.
                stream().
                map(t->t.length()).//map(String::length()) kullanilabilir
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(t-> System.out.print(t+" "));
    }
// Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void krkSysKckByPrint(List<String> menu){
        menu.
                stream().
                sorted(Comparator.comparing(String::length)).
                distinct().
                forEach(t->System.out.print(t + " "));
    }

// Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfeTersSrPrint(List<String> menu){
        menu.
                stream().
                sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1)).reversed()).

                forEach(t->System.out.print(t + " "));

    }

// Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini
// tekrarsiz buyukten kucuge sirali  print ediniz..

    public static void ciftSyChrKarTkrrbyKcPrint(List<String> menu){



    }
// Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
// Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
// Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
// Task : Karakter sayisi en buyuk elemani yazdiriniz.
// Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
}
