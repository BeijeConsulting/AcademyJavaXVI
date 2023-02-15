package it.beije.neumann.elassl.feb1;


/*
-Scrivere un programma che stampi a video i primi dieci numeri interi
Scrivere un programma che stampi a video i primi dieci interi pari compresi fra 20 e 0, partendo da 20.
Scrivere un programma che stampi le tabellina del numero dato come argomento
Stampare a video la seguente figura:
******
*****
****
***
**
*
Stampare a video la seguente figura:
#
##
###
####
#####
######
Stampare a video la seguente figura:
1      654321
12      54321
123      4321
1234      321
12345      21
123456      1
Scrivere un programma che stampi i primi 100 elementi della successione di Fibonacci.
Scrivere un programma che stampi le n righe della successione di Fibonacci in questo modo:
1
1, 1
1, 1, 2
1, 1, 2, 3
1, 1, 2, 3, 5
1, 1, 2, 3, 5, 8
1, 1, 2, 3, 5, 8, 13
....

class Stampa {

public static void primo() {
  System.out.println("Hello World");
}
	public static void main(String[] args) {
	int a = 15;
	int b = 10;
	System.out.println(a);
	}
}
*/
class Cicli {
  public static void es1() {
      for (int i=1;i<=10;i++)
        System.out.println(i);
    }
  public static void es2() {
      for (int i=20;i>0;i=i-2)
        System.out.println(i);
    }
  public static void es3(int num) {
      for (int i=0;i<=10;i++)
        System.out.println(num+"*"+i+"="+num*i);
    }
  public static void es4() {
      for (int i=6;i>0;i--){
        for (int j=0; j<i; j++)
          System.out.print("*");
        System.out.print("\n");
      }
    }
  public static void es5() {
      for (int i=1;i<=6;i++){
        for (int j=0; j<i; j++)
          System.out.print("#");
        System.out.print("\n");
      }
    }
  public static void es6() {
      for (int i=1;i<=6;i++){
        for (int j=0; j<i; j++)
          System.out.print(j);
        
        System.out.print(" ");
        
        for (int j=7-i; j>0; j--)
          System.out.print(j);
        System.out.print("\n");
      }
    }
  public static void es7(){
    long f1=1;
    long f2=1;
    System.out.println(f1);
    System.out.println(f2);
    for(int i=3; i<100; i++){
      long fibo=f1+f2;
      System.out.println(fibo);
      f2=f1;
      f1=fibo;
    }
  }
  public static void es8_fibo(int n){
    long f1=1;
    long f2=1;
    System.out.print("\n"+f1);
    System.out.print(", "+f2);
    for(int i=3; i<=n; i++){
      long fibo=f1+f2;
      System.out.print(", "+fibo);
      f2=f1;
      f1=fibo;
    }
  }
  public static void es8(int n){
    if(n>=1){
      System.out.print("\n1");
    }
    if(n>=2){
      System.out.print("\n1, 1");
    }
    for(int i=3; i<=n; i++)
      es8_fibo(i);
  }
    
  public static void main(String[] args) {
        System.out.print("\n\nEsercizio 1:\n");
        Cicli.es1();
        System.out.print("\n\nEsercizio 2:\n");
        Cicli.es2();
        System.out.print("\n\nEsercizio 3:\n");
        Cicli.es3(11);
        System.out.print("\n\nEsercizio 4:\n");
        Cicli.es4();
        System.out.print("\n\nEsercizio 5:\n");
        Cicli.es5();
        System.out.print("\n\nEsercizio 6:\n");
        Cicli.es6();
        System.out.print("\n\nEsercizio 7:\n");
        Cicli.es7();
        System.out.print("\n\nEsercizio 8:\n");
        Cicli.es8(9);
        
    }
}