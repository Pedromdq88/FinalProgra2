
import Entity.*;

public class Main {
    public static void main(String[] args) {

        Telefono telefono1 = new Telefono("A31", "Samsung", 1220, 3, "confiable", 32, "12x10 cm");

        Computadora compu1 = new Computadora("mac 62", "apple", 3499, 4, "ryzen 5 5600g", 32, 34);

        Accesorio accesorio1 = new Accesorio("webcam", "logitech", 200.2f, 1, "cable", "computadoras");
        Accesorio accesorio2 = new Accesorio("microfono", "logitech", 200.2f, 0, "cable", "computadoras/celulares");

        GestionTienda gestion = new GestionTienda();

        gestion.addProducto(telefono1);

        gestion.addProducto(compu1);

        gestion.addProducto(accesorio1);
        gestion.addProducto(accesorio2);
        gestion.mostrarInventario();

        gestion.deleteProducto(2);
        gestion.mostrarInventario();

        gestion.comprar(1);

       // gestion.buscarClientePorNombre("microfono");
   //     gestion.comprar(3);  si hacemos esto no sera posible ya que el stock no puede ser menor que 0

 gestion.guardarInventarioAJSON("inventario.json");


    }
}
