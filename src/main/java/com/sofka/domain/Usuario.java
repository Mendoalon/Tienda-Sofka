package com.sofka.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import java.io.Serializable;

//Capa de persistencias.
@Data                                                     //TODO: implementa los getter/setter con lombok
@Entity                                                   //TODO: Indica que es una entida de la base de datos
@Table(name = "usuario")                                  //TODO: Indica la tabla se llamara usuario
public class Usuario implements Serializable {            //TODO: se debe impletamneta serailizable => Representacion de una tabla en la base de datos en programacion.

    private static final long serialVersionUID = 1l;     //TODO: se debe implementar
    @Id                                                  //TODO: Le indicamos que es el ID de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //TODO: Estrategia que se genera en el id de la tabla
    @Column(name = "usu_id")                             //TODO: Indicamos el nombre del campo en la base de datos
    private Long id;
    @Column(name = "usu_nombre")                         //TODO: Indicamos el nombre del campo en la base de datos
    private String nombre;
    @Column(name = "usu_tipo_documento")                 //TODO: Indicamos el nombre del campo en la base de datos
    private String tipoDocumento;
    @Column(name = "usu_documento")                      //TODO: Indicamos el nombre del campo en la base de datos
    private String documento;

}
