package LambdaInstruction;

import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {

        System.out.println(topla(5));//15
        System.out.println(toplaCincix(5));//15
        System.out.println(toplaCift(5));
        System.out.println(toplaIlkXCift(4));
        System.out.println(toplaIlkXTek(5));
        ikininIlkXKUvvetPrint(3);
        System.out.println();
        istenenSayiIlkKuvvetPrint(3,2);
        System.out.println();
        System.out.println(istenenSayiFactorial(5));


    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
    // tamsayilari toplayan bir program create ediniz.

    //Structured

    public static int topla(int x){

        int toplam = 0;

        for (int i = 0; i <= x ; i++){

            toplam = toplam + i;

        }
        return toplam;

    }

    //Functional

    public static int toplaCincix(int x){//List<Integer> x ---> x.stream().

        return IntStream.//int degerlerde bir akış sağlar
                range(1,x+1).//range(a,b) --> a dan b ye kadar int değerler akışa alındı
                sum();//akıştan gelen degerler toplandı

    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCift(int x){

        return IntStream.
                rangeClosed(1,x).filter(t->t%2==0).sum();

    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int toplaIlkXCift(int x){

        return IntStream.
                iterate(2,t->t+2).//2 den sonsuza kadar elemanlari 2 arttirarak akışa alır -->2,4,6,8,...
                limit(x).// x ile sınırlıyorum
                sum();//akıştan gelen bütün değerleri topluyorum



    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int toplaIlkXTek(int x){

        return IntStream.
                iterate(1,t->t+2).//1,3,5,7,9,...
                limit(x).//ilk x tek tamsayı ile sınırlandırıldı
                sum();//akistan gelen int degerler toplandi


    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi create ediniz.

    public static void ikininIlkXKUvvetPrint(int x){//2,4,8,16,32,...

        IntStream.
                iterate(2,t->t*2).//iterasyon ici sartimizi yazdik
                limit(x).// x degeri ile sinirladik
                forEach(Lambda01::yazdir);//lambda01 classindaki yazdir methodunu cagirarak ekrana yazdik

    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi create ediniz.

    public static void istenenSayiIlkKuvvetPrint(int istenenSayi,int x){//method içinde yazıran bir fonksiyon oldugu icin void verdik son iki soruda

        IntStream.
                iterate(istenenSayi, t->t*istenenSayi).
                limit(x).
                forEach(Lambda01::yazdir);


    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi create ediniz.
    // 5!--->5*4*3*2*1      3!---> 3*2*1

    public static int istenenSayiFactorial(int x){//5

       return IntStream.// int akis basladi
               rangeClosed(1,x).//rangeClosed(1,5) ---> 1,2,3,4,5
               reduce(1,(t,u)->t*u);//


    }

}
