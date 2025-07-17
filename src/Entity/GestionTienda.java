package Entity;

import DTO.InventarioDto;
import Exceptions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GestionTienda {

    private Map<Integer, Productos> inventario;
    private ArrayList<Productos> cesta;

    public GestionTienda() {
        this.inventario = new TreeMap<>();
        this.cesta=new ArrayList<>();
    }

    public Map<Integer, Productos> getInventario() {
        return inventario;
    }

    public void setInventario(Map<Integer, Productos> inventario) {
        this.inventario = inventario;
    }

    public void addProducto(Productos producto) {
        this.inventario.put(producto.getId(), producto);
        System.out.println("Producto '" + producto.getNombre() + "' (ID: " + producto.getId() + ") agregado al inventario.");

    }

    public void deleteProducto(int idproducto) {
        if (this.inventario.containsKey(idproducto)) {
            Productos productoEliminado = this.inventario.remove(idproducto);
            System.out.println("Producto '" + productoEliminado.getNombre() + "' (ID: " + idproducto + ") eliminado del inventario.");
        } else {
            System.out.println("Error: No se encontró ningún producto con ID " + idproducto + " en el inventario para eliminar.");
        }
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("el inventario esta vacio");
            return;
        }
        System.out.println("\n--- INVENTARIO DE PRODUCTOS ---");
        for (Map.Entry<Integer, Productos> entry : inventario.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
        System.out.println("-------------------------------\n");

    }


    public Productos buscarClientePorNombre(String nombreProducto) {
        Productos P_agregar = inventario.get(nombreProducto);
        return P_agregar;
    }


    public void agregarProductoACesta(Productos producto) throws FaltaStockException {
        if (producto.getStock() == 0) {
            throw new FaltaStockException("No se puede agregar producto, ya que el stock =0");
        }
        this.cesta.add(producto);
        System.out.println(producto + "Fue comprado con exito!!");

    }

    public void comprar(int idProducto) {

        if (inventario.isEmpty()) {
            System.out.println("el inventario esta vacio");
            return;
        }
        System.out.println("Ingrese el id que deseas agregar: ");


        Productos P_agregar = inventario.get(idProducto);
        P_agregar.actualizarStock(-1);
        if (P_agregar != null) {
            try {
                agregarProductoACesta(P_agregar);
            } catch (FaltaStockException e) {
                System.out.println("Error al comprar el producto de la cesta");
            }

        }

    }





    public void  guardarInventarioAJSON(String nombreArchivo) {
        Collection<Productos> productosOriginales = inventario.values();
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");

        boolean primerElemento = true;
        for (Productos p : productosOriginales) {
            if (!primerElemento) {
                jsonBuilder.append(",\n");
            }
            InventarioDto dtoProducto = new InventarioDto(p);
            jsonBuilder.append(dtoProducto.toJsonObjectString("  "));
            primerElemento = false;
        }
        jsonBuilder.append("\n]");
        String jsonString = jsonBuilder.toString();

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(jsonString);
            System.out.println("\nInventario guardado exitosamente en '" + nombreArchivo + "'.");
        } catch (IOException e) {
            System.err.println("Error al guardar el inventario en JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }



}