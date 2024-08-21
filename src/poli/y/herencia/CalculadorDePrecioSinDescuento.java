/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.y.herencia;

/**
 *
 * @author yursd
 */
// CalculadorDePrecioSinDescuento.java
import java.util.List;

public class CalculadorDePrecioSinDescuento implements CalculadorDePrecio {
    @Override
    public double calcularPrecioTotal(List<Producto> productos) {
        return productos.stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();
    }
}
