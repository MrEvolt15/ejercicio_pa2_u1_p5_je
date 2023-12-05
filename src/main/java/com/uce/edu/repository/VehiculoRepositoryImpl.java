package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository{
	private static List<Vehiculo> base =new ArrayList<>();
	@Override
	public Vehiculo seleccionar(String placa) {
		for(Vehiculo v: base) {
			if(v.getPlaca().equals(placa)) {
				Vehiculo vec1 = new Vehiculo();
				vec1.setMarca(v.getMarca());
				vec1.setPlaca(v.getPlaca());
				vec1.setPrecio(v.getPrecio());
				vec1.setTipo(v.getTipo());
				return vec1;
			}
		}
		return null;
	}
	public Vehiculo seleccionarEliminar(String placa) {
		for (Vehiculo v: base) {
			if(v.getPlaca().equals(placa)) {
				return v;
			}
		}
		return null;
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		base.add(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.eliminar(vehiculo.getPlaca());
		this.insertar(vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo ve = this.seleccionarEliminar(placa);
		base.remove(ve);
	}

}
