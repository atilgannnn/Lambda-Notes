package LambdaInstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havuçDilim","güveç","kokoreç","küşleme","arabAşı","waffle","künefe","güveç"));

        alfBykTekrsz(menu);
        System.out.println();
        chrSayisiTerSiraliUnique(menu);
        System.out.println();
        chrSayisiBykSirali(menu);
        System.out.println();
        harfSayisi7denAzKontrol(menu);
        System.out.println();
        wIleBaslayanElKontrol(menu);
        System.out.println();
        xIleBitenElKontrol(menu);
        System.out.println();
        charSayisiEnBykElPrint(menu);
        System.out.println();
        ilkElHrcSonHrfSiraliPrint(menu);



    }

    // Task -1 : List elemanlarini alfabetik buyuk harf ve tekrarsiz print ediniz.

    public static void alfBykTekrsz(List<String> yemek){

        yemek.
                stream().//akış başladı
                map(String::toUpperCase).//buyuk harf
                sorted().//doğal sıralandı(alfabetik)
                distinct().//elemanlar tekrarsız oldu
                forEach(t-> System.out.print(t + " "));//print

    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void chrSayisiTerSiraliUnique(List<String> ikram){

        ikram.
                stream().//akış alındı
                map(String::length).//akışı güncelledim,kelimelerin uzunluğu olarak
                sorted(Comparator.reverseOrder()).//ters sıralı
                distinct().//tekrarsiz
                forEach(Lambda01::yazdir);//print

    }

    // Task-3 : List elemanlarini character sayisina gore kucukten buyuge gore print ediniz..

    public static void chrSayisiBykSirali(List<String> ikram){

        ikram.
                stream().//akış sağlandı
                sorted(Comparator.comparing(String::length)).//String ifadeleri karakter sayısına gore kucukten buyuge sıraladım
                forEach(t-> System.out.print(t + " "));//print

    }

    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> en az bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elelmmalarinin hepsinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontrol(List<String>ikram){

        System.out.println(ikram.
                stream().
                allMatch(t->t.length()<=7) ?
                "list elemanlari 7 ve daha az harften olusuyor" :
                "list elemanlari 7 harften buyuk");


    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.

    public static void wIleBaslayanElKontrol(List<String>ikram){

        System.out.println(ikram.
                stream().
                noneMatch(t -> t.startsWith("w")) ?
                "w ile yemek ismi mi olur" :
                "w ile yemek icat ettik");

    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.

    public static void xIleBitenElKontrol(List<String> ikram){

        System.out.println(ikram.
                stream().
                anyMatch(t -> t.endsWith("x")) ?
                "maşallah":
                "x ile yemek ismi biter mi hiç" );

    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void charSayisiEnBykElPrint(List<String>ikram) {

        Stream<String> sonIsim = ikram.
                stream().//akış sağlandı
                        sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).//karakter sayisina gore tersten siralandi
                        limit(1);//limit methodu kullanilarak sadece ilk eleman cagirildi
        //limit() methodunun donen degeri Steam<String> yapidadir

        System.out.println(Arrays.toString(sonIsim.toArray())); // sonIsim.toArray() --> Stream olan akış Array'e cevirildi.
        // Arrays.toString(sonIsim.toArray()) --> Array'i String yapıya çeviriyor.

    }

        // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

        public static void ilkElHrcSonHrfSiraliPrint(List<String> ikram){
            ikram.
                    stream().//akış saglandi
                    sorted(Comparator.comparing(t->t.charAt(t.length()-1))).//son harfine gore alfabetik sıralandı
                    skip(1).//akıştaki ilk eleman haric tutuldu
                    forEach(Lambda01::yazdir);//print

        }








}
