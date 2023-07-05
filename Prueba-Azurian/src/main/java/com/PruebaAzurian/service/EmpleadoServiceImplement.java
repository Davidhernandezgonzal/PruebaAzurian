package com.PruebaAzurian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PruebaAzurian.dao.EmpleadoDao;
import com.PruebaAzurian.model.Empleado;


@Service
public class EmpleadoServiceImplement implements EmpleadoService {

	@Autowired
	private EmpleadoDao empleadoDao;
	
	
	@Override
	@Transactional(readOnly = false)
	public Empleado guardar(Empleado empleado) {
		return empleadoDao.save(empleado);
	}

	@Override
	@Transactional(readOnly = false)
	public void eliminar(Integer id) {
		empleadoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado buscar(Integer id) {
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> mostrarTodo() {
		return (List<Empleado>) empleadoDao.findAll();
	}

}
