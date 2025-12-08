import java.util.Scanner;

public class Main{
    public static void main(String args[]){
    System.out.println("Kredīta kalkulātors");

    Scanner myObj = new Scanner(System.in);

    System.out.println("Kredīta summa: ");
        String KreditSumma = myObj.nextLine();
        int KreditSum = Integer.parseInt(KreditSumma);
        do{
            System.out.println("Laukam jābūt 1000 - 1000000");
        }
        while (1000 <= KreditSumma <= 1000000)

    System.out.println("Gada procentu likme: ");
        float ProcentuLikme = myObj.nextFloat();
        myObj.nextLine();

    System.out.println("Atmaksas termiņs gados: ");
        String TerminsGad = myObj.nextLine();
        int Termins = Integer.parseInt(TerminsGad);
        myObj.close();

        int Percent = 100;
        int MonthInYear = 12;
        int months = Termins * MonthInYear;
        float rate = ProcentuLikme / Percent / MonthInYear;
        double P = KreditSum * (rate * Math.pow((1 + rate), months)) / (Math.pow((1 + rate), months) - 1);
        System.out.println("Kredīts: " + P);

}}