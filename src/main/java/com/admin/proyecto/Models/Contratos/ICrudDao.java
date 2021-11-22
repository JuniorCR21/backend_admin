package com.admin.proyecto.Models.Contratos;

import java.io.Serializable;
import java.util.List;

public interface ICrudDao<T, ID extends Serializable> {
    public T Guardar(T entity);

    public List<T> BuscarTodos();

    public void Eliminar(ID id);

    public T BuscarPorId(ID id);

    public void Editar(T entity);
}
