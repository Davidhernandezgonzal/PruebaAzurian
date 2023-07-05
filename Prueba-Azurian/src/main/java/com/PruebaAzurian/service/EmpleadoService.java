package com.PruebaAzurian.service;

import java.util.List;

import com.PruebaAzurian.model.Empleado;

public interface EmpleadoService {
	
	public Empleado guardar(Empleado empleado);
	public void eliminar(Integer id);
	public Empleado buscar(Integer id);
	public List<Empleado> mostrarTodo();
}
