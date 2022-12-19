package LambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPractice03 {


    public static void main(String[] args) {

        Apartman daire1=new Apartman("dogu",3,4000);
        Apartman daire2=new Apartman("bati",2,2500);
        Apartman daire3=new Apartman("guney",1,3500);
        Apartman daire4=new Apartman("dogu",5,3000);

        List<Apartman> kiralikDaireler=new ArrayList<>(Arrays.asList(daire1,daire2,daire3,daire4));

        doguKirayaSirala(kiralikDaireler);
        System.out.println();

        System.out.println("kat2denCokKiraList(kiralikDaireler) = " + kat2denCokKiraList(kiralikDaireler));


    }

    //dogu cephesindeki kiralık daireleri kiralarına göre sıralayın
    public static void doguKirayaSirala(List<Apartman>a){

        a.
                stream().
                filter(t->t.getCephe().equalsIgnoreCase("dogu")).//cephesi dogu olan daireleri filtreledim.
                sorted(Comparator.comparing(Apartman::getKira)).forEach(System.out::println);

    }

    //kat sayısı 2den cok olan dairelerin kiralarını listeleyın

    public static List<Integer>kat2denCokKiraList(List<Apartman>a){

        return a.
                stream().
                filter(t->t.getKatSayisi()>2).
                map(t->t.getKira()).
                collect(Collectors.toList());

    }


}
