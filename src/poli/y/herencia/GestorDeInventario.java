/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.y.herencia;

/**
 *
 * @author yursd
 */
// GestorDeInventario.java

import java.util.List;

public class GestorDeInventario {
    private CalculadorDePrecio calculadorDePrecio;

    public GestorDeInventario(CalculadorDePrecio calculadorDePrecio) {
        this.calculadorDePrecio = calculadorDePrecio;
    }

    public double calcularPrecioTotalInventario(List<Producto> productos) {
        return calculadorDePrecio.calcularPrecioTotal(productos);
    }
}
