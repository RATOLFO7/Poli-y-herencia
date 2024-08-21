/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.y.herencia;

/**
 *
 * @author yursd
 */
// CalculadorDePrecioPorCategoría.java

import java.util.List;

public class CalculadorDePrecioPorCategoria implements CalculadorDePrecio {
    private Categoria categoria;

    public CalculadorDePrecioPorCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public double calcularPrecioTotal(List<Producto> productos) {
        return productos.stream()
                .filter(p -> p.getCategoria().equals(categoria))
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();
    }
}