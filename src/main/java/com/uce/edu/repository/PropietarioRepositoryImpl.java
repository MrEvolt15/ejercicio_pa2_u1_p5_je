package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Propietario;

@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository{
	
	private static List<Propietario> base = new ArrayList<>();
	
	@Override
	public Propietario seleccionar(String cedula) {
		for(Propietario p: base) {
			if(p.getCedula().equals(cedula)) {
				Propietario prop = new Propietario();
				prop.setApellido(p.getApellido());
				prop.setCedula(p.getCedula());
				prop.setGenero(p.getGenero());
				prop.setNombre(p.getNombre());
				return prop;
			}
		}
		return null;
	}
	public Propietario seleccionarEliminar(String cedula) {
		for (Propietario p: base) {
			if(p.getCedula().equals(cedula)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		base.add(propietario);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Propietario pe= this.seleccionarEliminar(cedula);
		base.remove(pe);
		
	}
	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.eliminar(propietario.getCedula());
		this.insertar(propietario);
		System.out.println(propietario);
		
	}

}
