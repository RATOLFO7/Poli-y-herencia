/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.y.herencia;

/**
 *
 * @author yursd
 */
// CalculadorDePrecioConDescuento.java

import java.util.List;

public class CalculadorDePrecioConDescuento implements CalculadorDePrecio {
    private double descuento;

    public CalculadorDePrecioConDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double calcularPrecioTotal(List<Producto> productos) {
        double total = productos.stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();
        return total - (total * descuento / 100);
    }
}
