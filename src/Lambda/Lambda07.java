package Lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda07 {

    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        Path haluk = Path.of("src/Lambda/haluk.txt");
        Stream<String> akis = Files.lines(haluk);//haluk txt datalari akis stream e atandi
        //1. yol
        Files.lines(Paths.get("src/Lambda/haluk.txt")).
                forEach(System.out::println);
        //2.yol
        akis.forEach(System.out::println);


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.lines(Paths.get("src/Lambda/haluk.txt")).map(String::toUpperCase).forEach(System.out::println);


        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        //1.yol
        Files.lines(Paths.get("src/Lambda/haluk.txt")).map(String::toLowerCase).limit(1).forEach(System.out::println);
        //2.yol
        System.out.println(Files.lines(Paths.get("src/Lambda/haluk.txt")).map(String::toLowerCase).findFirst());


        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.lines(Paths.get("src/Lambda/haluk.txt")).map(String::toLowerCase).filter(t -> t.contains("basari")).count());


        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        /*
Stream.flatMap, ad??yla tahmin edilebilece??i gibi, bir map ve flat i??leminin birle??imidir.
Bu, ilk ??nce elemanlar??n??za bir
 fonksiyon uygulad??????n??z ve daha sonra d??zle??tirdi??iniz anlam??na gelir.
  Stream.map yaln??zca ak?????? d??zle??tirmeden bir i??levi uygular.

   Bir ak??????n d??zle??tirme'in neyi i??erdi??ini anlamak i??in,
   "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yap?? d??????n??n.
   Bunun d??zle??tirilmesi, "bir seviye" yap??s??nda d??n????t??r??lmesi anlam??na gelir: [ 1,2,3,4,5,6,7,8,9 ].
   flatMap y??ntemi, bir ak??????n her bir de??erini ba??ka bir ak????la de??i??tirmenizi sa??lar
   ve ard??ndan olu??turulan t??m ak????lar?? tek bir ak????a birle??tirir.

 */
        //1,yol
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                distinct().
                collect(Collectors.toList()));
        //2.yol
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).collect(Collectors.toSet()));


        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.lines(haluk).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                sorted().forEach(System.out::println);


        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bag??ms??z yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.equals("basari")).
                count());

        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
                count());

        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
                collect(Collectors.toList()));


        //TASK 10 --> haluk.txt dosyasinda kac /farkl?? harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farkl?? harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.split("")).
                flatMap(Arrays::stream).
                distinct().count());



        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                distinct().count());

        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
        System.out.println("\nTASK 12 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        Files.lines(haluk).
                map(t -> t.split(" ")).//kelime ak??s?? saglan??r
                flatMap(Arrays::stream).
                distinct().forEach(System.out::println);


    }
}
