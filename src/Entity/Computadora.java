package Entity;

public class Computadora extends  Productos{
    private String procesador;
    private int MemoriaRam;///En GB
    private int tamanioDisco;

    public Computadora(String nombre, String marca, float precio, int stock, String procesador, int memoriaRam, int tamanioDisco) {
        super(nombre, marca, precio, stock);
        this.procesador = procesador;
        MemoriaRam = memoriaRam;
        this.tamanioDisco = tamanioDisco;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getMemoriaRam() {
        return MemoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) {
        MemoriaRam = memoriaRam;
    }

    public int getTamanioDisco() {
        return tamanioDisco;
    }

    public void setTamanioDisco(int tamanioDisco) {
        this.tamanioDisco = tamanioDisco;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "procesador='" + procesador + '\'' +
                ", MemoriaRam=" + MemoriaRam +
                ", tamanioDisco=" + tamanioDisco +
                '}';
    }
}
