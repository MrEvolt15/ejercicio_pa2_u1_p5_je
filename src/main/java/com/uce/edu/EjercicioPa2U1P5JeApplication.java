package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.IPropietarioService;
import com.uce.edu.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPa2U1P5JeApplication implements CommandLineRunner{
	@Autowired
	private IVehiculoService iVehiculoService;
	@Autowired
	private IPropietarioService iPropietarioService;
	@Autowired
	private IMatriculaService iMatriculaService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioPa2U1P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Propietario p1 = new Propietario();
		p1.setApellido("Espinosa");
		p1.setCedula("1726333196");
		p1.setGenero("masculino");
		p1.setNombre("Joel");
		
		this.iPropietarioService.guardar(p1);
		
		
		Vehiculo v1 = new Vehiculo();
		v1.setMarca("Chevrolet");
		v1.setPrecio(BigDecimal.valueOf(1000));
		v1.setPlaca("PFD0452");
		v1.setTipo("liviano");
		
		this.iVehiculoService.guardar(v1);
		
		Propietario p2 = this.iPropietarioService.buscar("1726333196");
		p2.setApellido("Perez");
		p2.setNombre("Juan");
		this.iPropietarioService.actualizar(p2);
		Propietario p3 = this.iPropietarioService.buscar("1726333196");
		System.out.println(p3);
		this.iMatriculaService.matricular("1726333196", "PFD0452");	
	}

}
