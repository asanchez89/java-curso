package com.curso.cuentas.servicio;

import com.curso.cuentas.modelo.Cuenta;
import com.curso.cuentas.repositorio.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CuentaServicio implements ICuentaServicio{
    @Autowired
    CuentaRepositorio cuentaRepositorio;
    @Override
    public List<Cuenta> listarCuentas() {
        return cuentaRepositorio.findAll();
    }

    @Override
    public Cuenta buscarCuentaPorId(Integer idCuenta) {
        return cuentaRepositorio.findById(idCuenta).orElse(null);
    }

    @Override
    public void guardarCuenta(Cuenta cuenta) {
        cuentaRepositorio.save(cuenta);
    }

    @Override
    public void eliminarCuenta(Cuenta cuenta) {
        cuentaRepositorio.delete(cuenta);
    }
}
