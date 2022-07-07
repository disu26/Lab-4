package co.com.sofka;

import java.util.Scanner;

public final class Robin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cantidad de procesos: ");
        int numProcesos = sc.nextInt();

        System.out.println("Tamaño del quantum: ");
        int quantum = sc.nextInt();

        new RoundRobin(numProcesos,
                quantum,
                "jatest.txt");
    }
}
