  import java.util.Scanner;

  public class Main {

    public static void main(String[] args) {

      String hisseAdi;
      double alisFiyat;
      double guncelFiyat;
      int adet;
      boolean isRunning = true;
      int devamEtmek;


      Scanner scanner = new Scanner(System.in);

      while (isRunning) {
        System.out.println("Hisse adını girin:");
        hisseAdi = scanner.nextLine();

        System.out.print("Adet giriniz: ");
        adet = scanner.nextInt();

        System.out.println("Hisse alış fiyatını girin:");
        alisFiyat = scanner.nextDouble();

        System.out.println("Hisse güncel fiyatını girin:");
        guncelFiyat = scanner.nextDouble();

        if (girisGecerliMi(adet,alisFiyat, guncelFiyat)) {
          double karZarar = hesapla(adet, alisFiyat, guncelFiyat);
          double maliyetHesabi = maliyet(adet, alisFiyat);
          double guncelDegerHesabi = guncelDeger(adet, guncelFiyat);


          System.out.println("--------------------");
          System.out.println("Hisse adı:" + hisseAdi);
          System.out.println("Adet:" + adet);
          System.out.println("Maliyet: " + maliyetHesabi);
          System.out.println("Güncel Değer: " + guncelDegerHesabi);

          if (karZarar > 0) {
            System.out.println("Kar: " + karZarar);
          } else if (karZarar < 0) {
            System.out.println("Zarar: " + karZarar);
          } else {
            System.out.println("Kar/Zarar yok: " + karZarar);
          }
          System.out.println("--------------------");

        }else {
          System.out.println("--------------------");
          System.out.println("Hatalı giriş! Adet ve fiyatlar 0'dan büyük olmalıdır.");
          System.out.println("--------------------");
        }


          System.out.println("yeni işlem yapmak istemiyorsan 0'a bas");
          System.out.println("yeni işlem yapmak istiyorsan 1'e bas");
          devamEtmek = scanner.nextInt();




        scanner.nextLine();



        if (devamEtmek == 0){
          isRunning = false;
        }

      }

      scanner.close();

    }


      public static double hesapla(int adet, double alisFiyati, double guncelFiyat) {
        return adet * (guncelFiyat - alisFiyati);

      }

      public static double maliyet(int adet,double alisFiyati){
        return adet * alisFiyati;
      }

      public static double guncelDeger(int adet, double guncelFiyat){
        return adet * guncelFiyat;
      }

      public static boolean girisGecerliMi(int adet, double alisFiyati, double guncelFiyat){

        if (adet<=0){
          return false;
        }

        else if (alisFiyati<=0){
          return false;
        }
        else if (guncelFiyat<=0){
          return false;
        }

        return true;
      }

  }