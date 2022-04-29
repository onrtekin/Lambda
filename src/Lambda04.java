import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

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
        yedidenKckKontrol(menu);
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
        menu.
                stream().
                filter(t -> t.length() % 2 == 0).
                map(t -> t.length() * t.length()).
                sorted(Comparator.comparing(t -> t.toString())).
                distinct().
                forEach(Lambda01::yazdir);
    }
// Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void yedidenKckKontrol(List<String> menu) {
        boolean kontrol=menu.stream().allMatch(t->t.length()<=7);
        if(kontrol){
            System.out.println("7 ve daha az eleman ");
        }else{
            System.out.println("7 harften buyuk ");
        }


        System.out.println(menu.
                stream().
                allMatch(t -> t.length() <= 7) ? "7 ve daha az eleman " : "7 harften buyuk ");
        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    }

    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanPrint(List<String> menu) {
     System.out.println( menu.stream().noneMatch(t->t.startsWith("w"))?"Yoktur":"Vardir");

    }

    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBtnPrint(List<String> menu) {
        System.out.println(menu.stream().anyMatch(t -> t.endsWith("x")) ? "vardir" : "yoktur");

    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void krkSysEnBykPrint(List<String> menu) {

       Stream<String> sonIsim= menu.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(3);
        System.out.println(Arrays.toString(sonIsim.toArray()));
        /*
        sonıisim.toArray()--> meth return dan dolayi stream type olan sonIisim toArray()
        method ile array type convert edildi
         */
/*
  TRİCK : •    Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz. Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
•  Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.

   */
        String enBykKrEl= String.valueOf(menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                findFirst());

        System.out.println(enBykKrEl);
        //limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır.
        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.
        // akıs cıktısını bir veriable assaign edilebilir
    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void sonHarfeGoreSrlIlkElmnHaric(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(t -> t.charAt(t.length()-1))).
                skip(1).//ilk eleman atlandi
                forEach(t-> System.out.print(t+" "));
        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın
        // kalan elemanlarından oluşan bir akış return eder.
        // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür.
        // Bu, durum bilgisi olan bir ara işlemdir.
        //skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.

    }

}
