package Dao;

import java.util.List;

import Entidad.Movimiento;

public interface IDaoMovimiento {
	public boolean insert(Movimiento movimiento);
	public boolean delete(Movimiento ovimiento_a_eliminar);
	public boolean update(Movimiento movimiento_a_modificar);
	public List<Movimiento> readAll();
}
