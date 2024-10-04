package com.curso.inventarios.servicio;

import com.curso.inventarios.modelo.Producto;
import com.curso.inventarios.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServicio implements IProductoServicio{

    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Override
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        return productoRepositorio.findById(idProducto).orElse(null);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        productoRepositorio.save(producto);
        return producto;
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        productoRepositorio.deleteById(idProducto);
    }
}
