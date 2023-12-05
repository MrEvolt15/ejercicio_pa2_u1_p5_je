package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IPropietarioRepository;
import com.uce.edu.repository.modelo.Propietario;

@Service
public class PropietarioServiceImp implements IPropietarioService{
	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	
	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.iPropietarioRepository.seleccionar(cedula);
	}

	@Override
	public void guardar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.insertar(propietario);
		System.out.println("Se inserto el siguiente propietario: ");
		System.out.println(propietario);
	}

	@Override
	public void borrar(String cedula) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.eliminar(cedula);
	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.actualizar(propietario);
	}

}
