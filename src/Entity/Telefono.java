package Entity;

public class Telefono extends Productos {
    private String descripcion; ///Una descpripcion del sistema Operativo
    private int almacenamiento; ///En GB
    private String tamanioDePantalla; ///en cm

    public Telefono(String nombre, String marca, float precio, int stock, String descripcion, int almacenamiento, String tamanioDePantalla) {
        super(nombre, marca, precio, stock);
        this.descripcion = descripcion;
        this.almacenamiento = almacenamiento;
        this.tamanioDePantalla = tamanioDePantalla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getTamanioDePantalla() {
        return tamanioDePantalla;
    }

    public void setTamanioDePantalla(String tamanioDePantalla) {
        this.tamanioDePantalla = tamanioDePantalla;
    }


    @Override
    public String toString() {
        return "Telefono{" +
                "descripcion='" + descripcion + '\'' +
                ", almacenamiento=" + almacenamiento +
                ", tamanioDePantalla='" + tamanioDePantalla + '\'' +
                '}';
    }



}
