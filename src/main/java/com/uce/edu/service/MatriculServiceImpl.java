package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.IPropietarioRepository;
import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;

@Service
public class MatriculServiceImpl implements IMatriculaService{
	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	
	@Override
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.insertar(matricula);
	}

	@Override
	public void matricular(String cedulaPropietario, String placaVehiculo) {
		// TODO Auto-generated method stub
		Propietario prop = this.iPropietarioRepository.seleccionar(cedulaPropietario);
		Vehiculo vec = this.iVehiculoRepository.seleccionar(placaVehiculo);
		Matricula mat = new Matricula();
		mat.setPropietario(prop);
		mat.setVehiculo(vec);
		mat.setFecha(LocalDateTime.now());
		mat.setValor(BigDecimal.valueOf(0));
		if(vec.getTipo().equals("pesado")) {
			BigDecimal valor =vec.getPrecio().multiply(BigDecimal.valueOf(0.25));
			mat.setValor(valor);
			if(valor.compareTo(BigDecimal.valueOf(2200))>=0) {
				mat.setValor(valor.multiply(BigDecimal.valueOf(0.95)));
			}
		}else if( vec.getTipo().equals("liviano")) {
			BigDecimal valor = vec.getPrecio().multiply(BigDecimal.valueOf(0.20));
			mat.setValor(valor);
			if(valor.compareTo(BigDecimal.valueOf(2200))>=0) {
				mat.setValor(valor.multiply(BigDecimal.valueOf(0.95)));
			}
		}
		
		this.iMatriculaRepository.insertar(mat);
		System.out.println("Se inserto la siguiente matricula: ");
		System.out.println(mat);
		
	}

}
