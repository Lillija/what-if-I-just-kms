import java.util.Scanner;


public class Main{
public static void main(String[] args){

    final byte months = 12;
    final byte percent = 100;
    int creditSum = -1;
    float yearlyPercent = -1;
    int paybackTime = -1;

    System.out.println("Kredīta kalkulātors");
    var scanner = new Scanner(System.in);
        while(true){
        System.out.println("Ievadat kredīta summu : ");
        creditSum = scanner.nextInt();
        if (creditSum >= 1000 && creditSum <= 1000000)
        break;
        }
        while(true){
        System.out.println("Ievadat gada procentu likmi : ");
        yearlyPercent = scanner.nextFloat();
        if (yearlyPercent > 0 && yearlyPercent < 20)
        break;
        }
        while(true){
        System.out.println("Ievadat atmaksas termiņu gados : ");
        paybackTime = scanner.nextInt();
        if (paybackTime >= 0 && paybackTime < 30)
        break;
        }
        float c = yearlyPercent / percent / months;
        int n = paybackTime * months;

        double P = creditSum * (c * Math.pow((1 + c), n)) / (Math.pow((1 + c), n) - 1);
        System.out.println("Lietotāja info : " + "Kredīta summa " + creditSum + " ;==; Procentu likme " + c + " ;==; Atmaksas termiņš " + n);
        System.out.println("Ikmēneša maksājums : " + Math.round(P));
}
}
