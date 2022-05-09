package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5,-8,-2,-12,0,1,12,5,6,9,15,8));
        hepsiniYaz(list);
        System.out.println();
        negatifYazdir(list);
        System.out.println();
        System.out.println(pozitifList(list));
        System.out.println();
        System.out.println(kareleriList(list));
        System.out.println();
        System.out.println(kareleriTekrarsizList(list));
        System.out.println();
        sirala(list);
        System.out.println();
        tersSirala(list);
        System.out.println();
        System.out.println(pozitifKupBirlerBas5YeniList(list));
        System.out.println();
        System.out.println(karelerinBirler5YeniList(list));
        System.out.println();
        topla(list);
        System.out.println();
        System.out.println(negatiflerinKarelerindenYeniList(list));
        System.out.println();
        System.out.println(VarMi5buyuk(list));
        System.out.println();
        System.out.println(hepsiSifirdanKucukMu(list));
        System.out.println();
        System.out.println(yuzeEsitElYokMu(list));
    }
    // S1:listi aralarinda bosluk birakarak yazdiriniz //
    public static void hepsiniYaz(List<Integer> list){
        list.stream().forEach(t-> System.out.print(t+" "));

    }



    //S2: sadece negatif olanlari yazdir
    public static void negatifYazdir(List<Integer> list){
        list.stream().filter(t->t<0).forEach(t-> System.out.print(t+" "));
    }



    //S3: pozitif olanlardan yeni bir liste olustur
    public static List<Integer> pozitifList(List<Integer> list){
       return list.stream().filter(t->t>0).collect(Collectors.toList());

    }



    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static List<Integer> kareleriList(List<Integer> list){
        return list.stream().map(t->t*t).collect(Collectors.toList());

    }




    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static List<Integer> kareleriTekrarsizList(List<Integer> list){
        return list.stream().map(t->t*t).distinct().collect(Collectors.toList());

    }



    //S6: listin elemanlarini kucukten buyuge siralayalim
    public static void sirala(List<Integer> list){
        list.stream().sorted().forEach(t-> System.out.print(t+" "));

    }




    //S7: listin elemanlarini buyukten kucuge siralayalim
    public static void tersSirala(List<Integer> list){
        list.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));

    }



    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> pozitifKupBirlerBas5YeniList(List<Integer> list){
    return    list.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());

    }



    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> karelerinBirler5YeniList(List<Integer> list){
        return    list.stream().map(t->t*t).filter(t->t%10!=5).collect(Collectors.toList());

    }



    // S10 :list elemanlarini toplamini bulalim
    public static void topla(List<Integer> list){
        System.out.println(list.stream().reduce(0,(x, y) -> x + y));

    }



    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static List<Integer> negatiflerinKarelerindenYeniList(List<Integer> list){
        return    list.stream().
                filter(t->t<0).
                peek(t-> System.out.println("negatifler"+t)).
                map(t->t*t).peek(t-> System.out.println("kareleri : "+t)).
                collect(Collectors.toList());

    }



    // S12 : listeden 5 den buyuk  sayi var mi?
    public static boolean VarMi5buyuk(List<Integer> list){
    return list.stream().anyMatch(t->t>5);

    }




    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static boolean hepsiSifirdanKucukMu(List<Integer> list){
        return list.stream().allMatch(t->t<0);
    }




    // S14: listenin 100 e esit elemani yok mu ?
    public static boolean yuzeEsitElYokMu(List<Integer> list){
        return list.stream().noneMatch(t->t==100);
    }




    // S15: listenin sifira esit elemani yok mu?



    // S16:  listenin ilk 5 elemanini topla?



    //S17: listenin son bes elemaninin  listele


}