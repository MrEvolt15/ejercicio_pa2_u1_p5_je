package com.uce.edu.service;

import com.uce.edu.repository.modelo.Matricula;

public interface IMatriculaService {
	public void guardar(Matricula matricula);
	public void matricular(String cedulaPropietario, String placaVehiculo);
}
