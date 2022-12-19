package LambdaInstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi);
        System.out.println("\n*******************************");
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n*******************************");
        maxElBul(sayi);
        System.out.println("\n*******************************");
        structuredMaxElBul(sayi);
        System.out.println("\n*******************************");
        ciftKareMaxPrint(sayi);
        System.out.println("\n*******************************");
        elTopla(sayi);
        System.out.println("\n*******************************");
        ciftCarp(sayi);
        System.out.println("\n*******************************");
        minBul(sayi);
        System.out.println("\n*******************************");
        bestenBykTekKck(sayi);
        System.out.println("\n*******************************");
        ciftKareKbSortPrint(sayi);





    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer>sayi){

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t*t).//16,4,36 -- Stream içerisindeki elemanları başka değerlere dönüştürür.
                forEach(Lambda01::yazdir);

    }

    // Task-2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edin

    public static void tekKupBirFazlaPrint(List<Integer>sayi){

        sayi.
                stream(). //(4,2,6,11,-5,7,3,15)
                filter(t->t%2 != 0). //(11,-5,7,3,15)
                map(t->(t*t*t)+1). //(1332,-124,344,28,3376)
                forEach(Lambda01::yazdir);

    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKarekokPrint(List<Integer>sayi){

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt). //double
                forEach(t-> System.out.println(t+" "));

    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void maxElBul(List<Integer>sayi){

        Optional<Integer> maxSayi = sayi.
                                    stream().
                                    reduce(Math::max); //eğer benim resultım tek bir deger ise o zaman reduce terminal operatoru kullanılır

        System.out.println(maxSayi);

    }

    //Structured yapi ile çözelim

    public static void structuredMaxElBul(List<Integer>sayi){

        int max = Integer.MIN_VALUE;
        System.out.println("max = " + max);
        for (int i = 0; i<sayi.size(); i++){

            if (sayi.get(i)>max){

                max = sayi.get(i);

            }


        }

        System.out.println("en buyuk sayi : " + max);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftKareMaxPrint(List<Integer>sayi){

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(a -> a * a).
                reduce(Integer::max)); // "Integer::max" methodu "Math::max" e gore daha hızlı calisir

    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void elTopla(List<Integer>sayi){

        int toplam = sayi.
                stream().
                reduce(0,(a,b)->a+b);
        System.out.println("toplam = " + toplam);

        /*
        * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
            bu örnekte 0 oluyor
        * b degerini her zamana  stream()'dan akısdan alır
        * a ilk degerinden sonraki her değeri action(işlem)'dan alır

        */

    }

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftCarp(List<Integer>sayi){

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));//method reference

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b))); //lambda expression

    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.

    public static void minBul(List<Integer>sayi){

        System.out.println(sayi.
                stream().
                reduce(Integer::min)); //Math::min ile de yapılabilir

        sayi.stream().reduce(Lambda02::byMiracMin);

    }

    public static int byMiracMin(int a,int b){

        return (a<b) ? a : b; //byMiracMin(4,9)

    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void bestenBykTekKck(List<Integer>sayi){

        System.out.println(sayi.
                stream().
                filter(a -> (a > 5) && (a % 2 == 1)).
                reduce(Lambda02::byMiracMin));

    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.

    public static void ciftKareKbSortPrint(List<Integer>sayi){

        sayi.
                stream().
                filter(Lambda01::ciftBul).//akış içindeki çift sayilari aldim
                map(t->t*t).//sayilarin karesi ile yeni bir akis olusturdum
                sorted().//akıs icindeki sayilari natural-order olarak sıraladım. Sorted otomatikte natural order(kucukten buyuge) sıralama yapar
                forEach(Lambda01::yazdir);//akıştaki sayilari ekrana yazdirdim

    }





}
