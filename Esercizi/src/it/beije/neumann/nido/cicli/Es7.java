/*
 * Scrivere un programma che stampi i
 * primi 100 elementi della successione di Fibonacci.
 */
package it.beije.neumann.nido.cicli;

public class Es7 {

    public static void main(String[] args) {

        long a = 1L;
        long b = 1L;

        System.out.println(a);
        System.out.println(b);

        for (int i = 2; i <= 100; i++) {
            long c = a + b;
            a = b;
            b = c;
            System.out.println(c);
        }
    }

}
