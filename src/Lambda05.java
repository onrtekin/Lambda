import java.util.*;
import java.util.stream.Collectors;

public class Lambda05 {
    public static void main(String[] args) {
        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));
        System.out.println(notOrt74BykUnv(unv));
        System.out.println("*************");
        System.out.println(ogrenciSayisi11Azmİ(unv));
        System.out.println("*************");
        System.out.println(matBolumVarMi(unv));
        System.out.println("*************");
        System.out.println(ogrenciSayilariniBykKckSirala(unv));
        System.out.println("*************");
        System.out.println(notortBykKckIlk3(unv));
        System.out.println("*************");
        System.out.println(ogrSayisiEnAz2UniversitePrint(unv));
        System.out.println("*************");
        System.out.println(notOrt63BykUnvOgrSayToplami(unv));


    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv ){
        return  unv.
                stream().
                allMatch(t->t.getNotOrt()>74);
    }
    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.

    public static boolean ogrenciSayisi11Azmİ(List<Universite> unv){
            return  unv.stream().allMatch(t->t.getOgrenciSayisi()>110);
    }
    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matBolumVarMi(List<Universite> unv){
        return unv.stream().anyMatch(t->t.getBolum().equalsIgnoreCase("matematik"));

    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrenciSayilariniBykKckSirala(List<Universite> unv){
            return     unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrenciSayisi).reversed()).
                collect(Collectors.toList());

    }

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List<Universite> notortBykKckIlk3(List<Universite> unv){
     return unv.
             stream().
             sorted(Comparator.comparing(Universite::getNotOrt).reversed()).
             limit(3).
             collect(Collectors.toList());
    }
    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.

    public static List<Universite> ogrSayisiEnAz2UniversitePrint(List<Universite> unv){
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrenciSayisi)).
                limit(2).
                skip(1).
                collect(Collectors.toList());

    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static Optional<Integer> notOrt63BykUnvOgrSayToplami(List<Universite> unv){
        return unv.
                stream().
                filter(t->t.getNotOrt()>63).
                map(t->t.getOgrenciSayisi()).
                reduce(Integer::sum);
                //reduce(Math::addExact);
                //reduce(0,(t,u)->t+u); bunlarda kullanilabilir
    }


    //task 08--> Ogrenci sayisi 130'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    //task 10-->Ogrenci sayilari 130'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    //task 11-->Ogrenci sayilari 150'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
}
