package lambda_practice;
//multi arrayleri cevirirken flapMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc","Erik"}
        };
        System.out.println();
        System.out.println(liste(arr));
        System.out.println();
        doubleYaz(arr);
        System.out.println();
        System.out.println(eBaslayanliste(arr));
        System.out.println();
        kIleBitenSonYildiz(arr);

    }
    // S1 : tum elemanlari list yapayim
    public static List<String>liste(String[][]str){
        return Arrays.stream(str).flatMap(t->Arrays.stream(t)).collect(Collectors.toList());
    }



    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim
    public static void  doubleYaz(String[][]str){
        Arrays.stream(str).
                flatMap(t->Arrays.stream(t)).filter(t->t.startsWith("E")).
                map(t->t+t).
                forEach(t-> System.out.print(t+" "));
    }



    // S3: E ile baslayan elemanlari liste olarak yazdiralim
    public static List<String>eBaslayanliste(String[][]str){
        return Arrays.stream(str).
                flatMap(t->Arrays.stream(t)).filter(t->t.startsWith("E")).
                collect(Collectors.toList());
    }



    //S4 : k ile bitenlerin sonuna '*' ekleyelim
    public static void  kIleBitenSonYildiz(String[][]str){
        Arrays.stream(str).
                flatMap(t->Arrays.stream(t)).filter(t->t.endsWith("k")).

                forEach(t-> System.out.print(t+"*"+" "));
    }


}
