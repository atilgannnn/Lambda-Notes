package LambdaInstruction;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*

    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */


    public static void main(String[] args) {

        University u01 = new University("bogazici","matematik",571,93);
        University u02 = new University("istanbul tk","matematik",600,81);
        University u03 = new University("istanbul","hukuk",1400,71);
        University u04 = new University("marmara","bilgisayar muh",1080,77);
        University u05 = new University("odtu","gemi muh",333,74);

        List<University> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));
        System.out.println(notOrt74BykUnv(unv));
        System.out.println();
        System.out.println(matBolumVarMi(unv));
        System.out.println();
        System.out.println(ogrSayisiBykSirala(unv));
        System.out.println();
        System.out.println("matBolumSayisi(unv) = " + matBolumSayisi(unv));
        System.out.println();
        System.out.println(ogrcSayisi550BykMaxNotOrt(unv));//OptionalInt[93]
        System.out.println();
        System.out.println(ogrcSayisi1050AzMinNotOrt(unv));//OptionalInt[74]



    }

    //task 01--> notOrt'larinin 74' den buyuk oldugunu kontrol eden pr create ediniz.

    public static boolean notOrt74BykUnv(List<University> unv){

        return unv.
                stream().//akış sağladık üniversiteler u01,u02,u03,u04,u05
                allMatch(t->t.getNotOrt()>74);

    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matBolumVarMi(List<University> unv){

        return unv.
                stream().//akış sağlandı
                anyMatch(t->t.getBolum().//objelerin bölüm isimleri alındı
                        toLowerCase().// bölüm isimlerindeki karakterler küçük harfe çevrildi
                        contains("matematik"));// Stream yapısı List yapısına dönüştürüldü

    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<University> ogrSayisiBykSirala(List<University> unv){

        return unv.
                stream().//akış sağlandı
                sorted(Comparator.comparing(University::getOgrenciSayisi).
                        reversed()).//universiteler ogrenci sayisina gore tersten sıralandı
                collect(Collectors.toList());// Stream yapısı List yapısına dönüştürüldü
    }

    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.

    public static int matBolumSayisi(List<University> unv){

        return (int) unv.
                stream().//akış sağladım
                filter(t->t.getBolum().contains("mat")).//matematik bölümü olan üniversiteleri seçtim
                count();//seçilen üniversite sayısını aldım

    }

    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk not Ort'unu bulunuz.

    public static OptionalInt ogrcSayisi550BykMaxNotOrt(List<University>unv){

        return unv.
                stream().//akış sağlandı
                filter(t->t.getOgrenciSayisi()>550).
                mapToInt(t->t.getNotOrt()).
                max();

    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogrcSayisi1050AzMinNotOrt(List<University>unv){

        return unv.
                stream().
                filter(t->t.getOgrenciSayisi()<1050).
                mapToInt(t->t.getNotOrt()).
                min();

    }




}
