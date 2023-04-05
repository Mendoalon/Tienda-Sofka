package com.sofka.service;

import com.sofka.domain.Usuario;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

   public List<Usuario> listar(); //Optener todos los usuarios

   public Usuario save(Usuario usuario); //Guardar un usuario

    public Usuario update(Long id, Usuario usuario); //Actualizar un usuario

    public void delete(Usuario usuario);   //Eliminar un usuario

    public Optional<Usuario> findUser(Usuario usuario); //Buscar un usuario

}
