import java.util.Scanner;
import java.lang.Math;

public class MyClass {

public static void main(String args[]){

System.out.println("Loan calculator");

int kreditSum = 0;
float procentuLikme = 0.0f;
int termins = 0;

procentuLikme = readInput("Loan amount: ", 1000, 1000000);
procentuLikme = readInput("Yearly rate: ", 0, 20);
termins = readInput("How many years: ", 1, 30);

double monthlyPayment = calculateMortgage(termins, procentuLikme, kreditSum);
System.out.println("Monthly pay: " + monthlyPayment + " EUR");
}

public static float readInput(String prompt, int loverLimit, int upperLimit){
var scanner = new Scanner(System.in);
float input = -1;
while (true){
System.out.println(prompt);
input = scanner.nextFloat();

if ( input >= 1000 && input <= 1000000){
break;
}

System.out.println("The summ should be within the rules");
}
}

public static double calculateMortgage(int termins, float procentuLikme, int kreditSum) {

final int Percent = 100;
final int MonthInYear = 12;

int months = termins * MonthInYear;
float rate = procentuLikme / Percent / MonthInYear;

double izt1 = rate * Math.pow((1 + rate), months);
double izt2 = Math.pow((1 + rate), months) - 1;
double P = kreditSum * (izt1 / izt2);
return P;
}

}
