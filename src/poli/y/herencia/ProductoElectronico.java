/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.y.herencia;

/**
 *
 * @author yursd
 */
// ProductoElectrónico.java

public class ProductoElectronico extends Producto {
    private int garantia;

    public ProductoElectronico(String nombre, double precio, int cantidad, Proveedor proveedor, Categoria categoria, int garantia) {
        super(nombre, precio, cantidad, proveedor, categoria);
        this.garantia = garantia;
    }

    @Override
    public String getDetalles() {
        return String.format("Electrónico: %s, Precio: %.2f, Cantidad: %d, Garantía: %d años, Categoría: %s",
                getNombre(), getPrecio(), getCantidad(), garantia, getCategoria().getNombre());
    }
}