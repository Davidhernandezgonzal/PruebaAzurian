package com.PruebaAzurian.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.PruebaAzurian.model.Empleado;
import com.PruebaAzurian.service.EmpleadoService;

@RestController
@CrossOrigin(origins= {"*"})
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	//CREAR EMPLEADOS
	@PostMapping("/empleados")
	public Empleado guardar(@RequestBody Empleado empleado) {
		return empleadoService.guardar(empleado);
	}
	
	
	//LEER U OBTENER TODOS LOS DATOS DE LOS EMPLEADOS
	@GetMapping("/empleados")
	public List<Empleado> empleados(){
		return empleadoService.mostrarTodo();
		
	}
	
	

	
	@GetMapping("/empleados/{id}")
	public Empleado mostrar(@PathVariable Integer id){
		return empleadoService.buscar(id);
		
	}
	
	
	
	//ACTUALIZAR LOS DATOS
	@PutMapping("/empleados/{id}")
	public Empleado actualizar(@RequestBody Empleado empleado,@PathVariable Integer id) {
		Empleado empleadoActual = empleadoService.buscar(id);
		empleadoActual.setNombre(empleado.getNombre());
		empleadoActual.setApellidoPaterno(empleado.getApellidoPaterno());
		empleadoActual.setApellidoMaterno(empleado.getApellidoMaterno());
		empleadoActual.setPuesto(empleado.getPuesto());
		return empleadoService.guardar(empleadoActual);
		
	}
	
	
	//ELIMINAR DATOS
	@DeleteMapping("/empleados/{id}")
	public void eliminar(@PathVariable Integer id) {
		empleadoService.eliminar(id);
	}
	
}
