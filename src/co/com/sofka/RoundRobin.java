package co.com.sofka;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoundRobin {
    private static final Scanner sc = new Scanner(System.in);
    private static int numProcesos;
    private static int quantum;
    private final String archivo;
    private final Proceso[] procesos;
    private final List<String> buffer;

    public RoundRobin(int numProcesos, int quantum, String archivo) {
        this.numProcesos = numProcesos;
        this.quantum = quantum;
        this.archivo = archivo;
        this.procesos = new Proceso[numProcesos];
        this.buffer = new ArrayList<>();
        Proceso p;
        for (int i = 0; i < this.numProcesos; i++) {
            p = new Proceso();
            p.setPcb("P" + (i + 1));
            p.setId("0" + (i + 1));
            System.out.println("Tiempo de procesamiento para el proceso P"+ (i + 1) + ": ");
            p.setNCpu(sc.nextInt());
            p.setEstado("N");
            p.setPosicCola(i+1);
            procesos[i] = p;
        }
        tituloBuffer();
        colaListo();
        procesarCola();
        System.out.println(this.archivo + " guardado correctamente");
    }

    private void tituloBuffer(){
        this.buffer.add("Algoritmo de planificación Round Robin\n");
        this.buffer.add("N(Nuevo) L(Listo) E(Ejecución) T(Terminado)\n");
        this.buffer.add("Cantidad de procesos: " + this.numProcesos + "\n");
        this.buffer.add("Quantum: " + this.quantum + "\n");
        guardarBuffer();
    }

    private void guardarBuffer() {
        this.buffer.add("\nProceso");
        for(Proceso p : procesos) {
            this.buffer.add("\t" + p.pcb());
        }
        this.buffer.add("\nID");
        for(Proceso p : procesos) {
            this.buffer.add("\t" + p.id());
        }
        this.buffer.add("\nInstruc");
        for(Proceso p : procesos) {
            this.buffer.add("\t" + p.nCpu());
        }
        this.buffer.add("\nEstado");
        for(Proceso p : procesos) {
            this.buffer.add("\t" + p.estado());
        }
        this.buffer.add("\nPosic");
        for(Proceso p : procesos) {
            this.buffer.add("\t" + p.posicCola());
        }
        this.buffer.add("\n");
        guardarArchivo();
    }

    private void colaListo() {
        for (int i = 0; i < this.numProcesos; i++) {
            this.procesos[i].setEstado("L");
        }
        guardarBuffer();
    }

    private void procesarCola() {
        while (procesosNoTerminados()) {
            for (Proceso p : procesos) {
                trabajarProceso(p);
            }
        }
        reposicionarCola();
        guardarBuffer();
    }

    private void reposicionarCola() {
        int posicion = 0;
        for (Proceso p : procesos) {
            if (p.estado().equals("T")) {
                p.setPosicCola(0);
            } else {
                posicion += 1;
                p.setPosicCola(posicion);
            }
        }
    }

    private boolean procesosNoTerminados() {
        for (Proceso p : procesos) {
            if (!"T".equals(p.estado())) {
                return true;
            }
        }
        return false;
    }

    private void trabajarProceso(Proceso p) {
        if (p.nCpu() > quantum) {
            p.setNCpu(p.nCpu() - quantum);
            p.setEstado("E");
            guardarBuffer();
            p.setEstado((p.nCpu() == 0) ? "T" : "L");
        } else if (!"T".equals(p.estado())) {
            p.setNCpu(0);
            p.setEstado("E");
            reposicionarCola();
            guardarBuffer();
            p.setEstado("T");
        }
    }

    private void guardarArchivo() {
        try {
            String buf = String.join("", this.buffer);
            FileWriter fw = new FileWriter(this.archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(buf);
            pw.close();
            this.buffer.clear();
        } catch (Exception e) {
            System.out.println("Error al guardar " + this.archivo);
        }
    }
}
