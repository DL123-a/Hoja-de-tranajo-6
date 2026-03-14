import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Inventario {

    private Map<String, String> inventario;
    private Map<String, Integer> coleccionUsuario;

    public Inventario(Map<String, String> inventario) {
        this.inventario = inventario;
        this.coleccionUsuario = new HashMap<>();
    }

    public void cargarInventario(String archivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            br.readLine(); // saltar encabezado

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split("\\|");

                String categoria = partes[0].trim();
                String producto = partes[1].trim();

                inventario.put(producto, categoria);
            }

        } catch (Exception e) {
            System.out.println("Error leyendo el archivo");
        }
    }

    // OPERACION 1
    public void agregarProducto(String producto) {

        if (!inventario.containsKey(producto)) {
            System.out.println("Producto no existe en el inventario");
            return;
        }

        int cantidad = coleccionUsuario.getOrDefault(producto, 0);
        coleccionUsuario.put(producto, cantidad + 1);

        System.out.println("Producto agregado");
    }

    // OPERACION 2
    public void mostrarCategoria(String producto) {

        String categoria = inventario.get(producto);

        if (categoria == null) {
            System.out.println("Producto no encontrado");
        } else {
            System.out.println("Categoria: " + categoria);
        }
    }

    // OPERACION 3
    public void mostrarColeccion() {

        if (coleccionUsuario.isEmpty()) {
            System.out.println("La colección está vacía");
            return;
        }

        for (Map.Entry<String, Integer> entry : coleccionUsuario.entrySet()) {

            String producto = entry.getKey();
            int cantidad = entry.getValue();
            String categoria = inventario.get(producto);

            System.out.println(producto + " | " + categoria + " | " + cantidad);
        }
    }
}