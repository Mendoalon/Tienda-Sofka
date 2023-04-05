package com.sofka.dao;

import com.sofka.domain.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//TODO: Capa de persistencias.
//TODO: Se extiende de CrudRepository que nos ayuda a las consultas,
//TODO: Es de typo Usuario Domain o de la tabla representada en Domain
//TODO: Recibe tambien el tipo de dato del Id de la tabla, en este caso es Long
public interface UsuarioDao extends CrudRepository<Usuario, Long> {

    @Modifying  //TODO: Consulta personalizada.
    @Query("update Usuario usu set usu.nombre = :nombre where usu.id = :id")  //Actualizar un usuario solo nombre
    public void updateNombre(
            @Param(value = "id") Long id,
            @Param(value = "nombre") String nombre);


    @Modifying  //TODO: Consulta personalizada.
    @Query("update Usuario usu set usu.tipoDocumento = :tipoDocumento where usu.id = :id") //Actualizar un usuario solo tipo documento
    public void updateTipoDocumento(
            @Param(value = "id") Long id,
            @Param(value = "tipoDocumento") String tipoDocumento);


    @Modifying  //TODO: Consulta personalizada.
    @Query("update Usuario usu set usu.documento = :documento where usu.id = :id") //Actualizar un usuario solo tipo documento
    public void updateDocumento(
            @Param(value = "id") Long id,
            @Param(value = "documento") String documento);


}



