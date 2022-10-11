import java.util.Scanner;

class RomanNumberCalculater{

int value(char r){
if (r == 'I')
return 1;
if (r == 'V')
return 5;
if (r == 'X')
return 10;
if (r == 'L')
return 50;
if (r == 'C')
return 100;
if (r == 'D')
return 500;
if (r == 'M')
return 1000;
return -1;
}


public int romanToDecimal(String str) {
int res = 0;

for (int i = 0; i < str.length(); i++) {
int s1 = value(str.charAt(i));    
if (i + 1 < str.length())
{
int s2 = value(str.charAt(i + 1));
if (s1 >= s2) 
{

res = res + s1;
}
else{

res = res + s2 - s1;
i++;
}
}
else {
res = res + s1;
}
}

return res;
}
public String integerToRoman(int num) {
int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

StringBuilder roman = new StringBuilder();

for(int i=0;i<values.length;i++) {
while(num >= values[i]) {
num -= values[i];
roman.append(romanLiterals[i]);
}
}
return roman.toString();
}

public void additionRoamnNumber(String roman1,String roman2){
String result = "" ;
int num1 = romanToDecimal(roman1);
int num2 = romanToDecimal(roman2);
int res = num1+num2;
result = integerToRoman(res); 
System.out.println("Addition : - ");
System.out.println( num1 + " + " + num2 + " = " + res );
System.out.println( roman1 + " + " + roman2 + " = " + result );
}

public void subtractionRoamnNumber(String roman1,String roman2){
String result = "" ;
int num1 = romanToDecimal(roman1);
int num2 = romanToDecimal(roman2);
int res = num1-num2;
result = integerToRoman(res);
System.out.println("Subtraction : - ");
System.out.println( num1 + " - " + num2 + " = " + res );
System.out.println( roman1 + " - " + roman2 + " = " + result );
}

public void multilicationRoamnNumber(String roman1,String roman2){
String result = "" ;
int num1 = romanToDecimal(roman1);
int num2 = romanToDecimal(roman2);
int res = num1*num2;
result = integerToRoman(res);
System.out.println("Multilication : - ");
System.out.println( num1 + " * " + num2 + " = " + res );
System.out.println( roman1 + " * " + roman2 + " = " + result );
  
}

public void divisionRoamnNumber(String roman1,String roman2){
String result = "" ;
int num1 = romanToDecimal(roman1);
int num2 = romanToDecimal(roman2);
int res = num1/num2;
result = integerToRoman(res); 
System.out.println("Division : - ");
System.out.println( num1 + " / " + num2 + " = " + res );
System.out.println( roman1 + " / " + roman2 + " = " + result );
}
}

public class TestRomanNumberCalculater{
public static void main(String args[]){
String romanNum1, romanNum2;
RomanNumberCalculater romanCalculator = new RomanNumberCalculater();
int choice;
Scanner sc = new Scanner(System.in);
do{
menuForCalculater();
System.out.print("Choice : ");
choice = sc.nextInt();
if(choice>=1 && choice<=4){
System.out.print("Enter first roman number : ");
romanNum1 = sc.next();
System.out.print("Enter secound roman number : ");
romanNum2 = sc.next();

switch(choice){
case 1:
romanCalculator.additionRoamnNumber(romanNum1,romanNum2);
break;
case 2:
romanCalculator.subtractionRoamnNumber(romanNum1, romanNum2);
break;
case 3:
romanCalculator.multilicationRoamnNumber(romanNum1, romanNum2);
break;
case 4:
romanCalculator.divisionRoamnNumber(romanNum1, romanNum2);
break;
}
}else{
if(choice!=5){
System.out.println("Worng choice");
}
}   
}while(choice!=5);   
}
public static void menuForCalculater(){
System.out.println("\nOperation on Roman Numeral ");
System.out.println("1-> Addition");
System.out.println("2-> Subtraction");
System.out.println("3-> Multiplication");
System.out.println("4-> Division");
System.out.println("5-> Exit");
}
}