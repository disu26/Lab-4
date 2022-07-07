package co.com.sofka;

public final class Proceso {
    private String pcb;
    private String id;
    private int nCpu;
    private String estado;
    private int posicCola;
    private int tiempoLlegada;
    private int tiempoEntradaSalida;

    public Proceso() {
    }

    public String pcb() {
        return pcb;
    }

    public void setPcb(String pcb) {
        this.pcb = pcb;
    }

    public String id() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int nCpu() {
        return nCpu;
    }

    public void setNCpu(int nCpu) {
        this.nCpu = nCpu;
    }

    public String estado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int posicCola() {
        return posicCola;
    }

    public void setPosicCola(int posicCola) {
        this.posicCola = posicCola;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getTiempoEntradaSalida() {
        return tiempoEntradaSalida;
    }

    public void setTiempoEntradaSalida(int tiempoEntradaSalida) {
        this.tiempoEntradaSalida = tiempoEntradaSalida;
    }
}
