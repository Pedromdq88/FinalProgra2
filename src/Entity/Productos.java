package Entity;

public abstract class Productos {

    private int id; ///sera autoincremental
    private String nombre;
    private String marca;
    private float precio;
    private int stock;

    private static int nextInt =0;
    public Productos(String nombre, String marca, float precio, int stock) {
        this.id = nextInt++;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void actualizarStock(int cantidad) {

        if (cantidad < 0) {
            if (this.stock + cantidad < 0) {
                throw new RuntimeException("Cantidad negativa");
            }else{
                this.stock += cantidad;
            }
        }else {
            this.stock += cantidad;
        }
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
