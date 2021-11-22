package com.admin.proyecto.Services;

import java.io.Serializable;
import java.util.List;

import com.admin.proyecto.Models.Contratos.ICrudDao;

public abstract class CrudService<T, ID extends Serializable> {
  

  public abstract ICrudDao<T, ID> getDao();

  public T Guardar(T empleado){
    return getDao().Guardar(empleado);
  }

  public T Buscar(ID id){
    return getDao().BuscarPorId(id);
  }

  public List<T> Buscar(){
    return getDao().BuscarTodos();
  }

  public void Editar(T empleado){
    getDao().Editar(empleado);
  }

  public void Eliminar(ID id){
    getDao().Eliminar(id);
  }

}
