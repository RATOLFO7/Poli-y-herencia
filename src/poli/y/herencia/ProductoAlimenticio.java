/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.y.herencia;

/**
 *
 * @author yursd
 */
// ProductoAlimenticio.java

public class ProductoAlimenticio extends Producto {
    private String fechaDeCaducidad;

    public ProductoAlimenticio(String nombre, double precio, int cantidad, Proveedor proveedor, Categoria categoria, String fechaDeCaducidad) {
        super(nombre, precio, cantidad, proveedor, categoria);
        this.fechaDeCaducidad = fechaDeCaducidad;
    }

    @Override
    public String getDetalles() {
        return String.format("Alimenticio: %s, Precio: %.2f, Cantidad: %d, Fecha de Caducidad: %s, Categoría: %s",
                getNombre(), getPrecio(), getCantidad(), fechaDeCaducidad, getCategoria().getNombre());
    }
}
