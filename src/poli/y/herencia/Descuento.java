/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.y.herencia;

/**
 *
 * @author yursd
 */
// Descuento.java

import java.util.List;

public class Descuento {
    private CalculadorDePrecio calculadorDePrecio;

    public Descuento(CalculadorDePrecio calculadorDePrecio) {
        this.calculadorDePrecio = calculadorDePrecio;
    }

    public double aplicarDescuento(List<Producto> productos) {
        return calculadorDePrecio.calcularPrecioTotal(productos);
    }
}
