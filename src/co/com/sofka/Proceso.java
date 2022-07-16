package co.com.sofka;

public final class Proceso {
    private String pcb;
    private String id;
    private int nCpu;
    private String estado;
    private int posicCola;
    private int tiempoLlegada;
    private int tiempoEntradaSalida;
    private int tiempoSalida;
    private int tiempoEspera;
    private int tiempoAsignacion = -1;
    private int tiempoVuelta;
    private boolean llego = false;

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

    public int tiempoSalida() {
        return tiempoSalida;
    }

    public void setTiempoSalida(int tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
    }

    public boolean isLlego() {
        return llego;
    }

    public void setLlego(boolean llego) {
        this.llego = llego;
    }

    public int tiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public int tiempoAsignacion() {
        return tiempoAsignacion;
    }

    public void setTiempoAsignacion(int tiempoAsignacion) {
        this.tiempoAsignacion = tiempoAsignacion;
    }

    public int tiempoVuelta() {
        return tiempoVuelta;
    }

    public void setTiempoVuelta(int tiempoVuelta) {
        this.tiempoVuelta = tiempoVuelta;
    }
}
