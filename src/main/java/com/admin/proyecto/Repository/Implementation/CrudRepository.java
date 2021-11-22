package com.admin.proyecto.Repository.Implementation;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.admin.proyecto.Models.Contratos.ICrudDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class CrudRepository<T, ID extends Serializable> implements ICrudDao<T, ID> {

   @Override
    public T Guardar(T entity) {
        return getDao().save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> BuscarTodos() {
        return getDao().findAll();
    }

    @Override
    public void Eliminar(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public void Editar(T entity) {
        getDao().save(entity);
    }

    @Override
    public T BuscarPorId(ID id) {
        Optional<T> respuesta = getDao().findById(id);
        if (respuesta.isPresent())
            return respuesta.get();
        return null;
    }

    public abstract JpaRepository<T, ID> getDao();
}
