package DTO;

import Entity.Productos;

import java.util.Locale;

public class InventarioDto {


        public int id;
        public String nombre;
        public float precio;
        public int stock;
        public String marca;


        public InventarioDto(Productos p) {
            this.id = p.getId();
            this.nombre = p.getNombre();
            this.precio = p.getPrecio();
            this.stock = p.getStock();
            this.marca = p.getMarca();


        }

        public String toJsonObjectString(String indent) {
            StringBuilder sb = new StringBuilder();

            sb.append("  {\n");
            sb.append("    \"id\": ").append(id).append(",\n");
            sb.append(indent).append("  \"nombre\": \"").append(escaparComillas(nombre)).append("\",\n");
            sb.append(indent).append("  \"precio\": ").append(String.format(Locale.ROOT, "%.2f", precio)).append(",\n");
            sb.append(indent).append("  \"stock\": ").append(stock).append(",\n");
            sb.append(indent).append("  \"marca\": ").append(escaparComillas(marca)).append("\",\n");


            sb.append("\n").append(indent).append("}");
            return sb.toString();

        }

        private String escaparComillas(String texto) {
            if (texto == null) {
                return "";
            }
            return texto.replace("\"", "\\\"");
        }
    }





