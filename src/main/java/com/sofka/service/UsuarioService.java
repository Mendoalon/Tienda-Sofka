package com.sofka.service;

import com.sofka.dao.UsuarioDao;
import com.sofka.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service  //TODO: Se le indica que esto es un servicio.
public class UsuarioService implements IUsuarioService{

    @Autowired   //TODO: Inyectamos la dependencia, para inyectar usuarioDao.
    private UsuarioDao usuarioDao; //TODO: Permite conectar a la base de datos traer la informacion.
    @Override
    @Transactional(readOnly = true)  //TODO: Se le indica que solo es una transacción de solo lectura.
    public List<Usuario> listar() {
        return (List<Usuario>) usuarioDao.findAll(); //TODO: Devuelve un iterable y lo casteamos para optener una lista de usuarios
    }

    @Override
    @Transactional //TODO: Esto le indica al SPA que es una transacción ya que se modificara datos en la base de datos
    public Usuario save(Usuario usuario) {
       return usuarioDao.save(usuario);
    }

    @Override
    @Transactional //TODO: Esto le indica al SPA que es una transacción ya que se modificara datos en la base de datos
    public Usuario update(Long id, Usuario usuario) {
        usuario.setId(id);
        return usuarioDao.save(usuario);
    }

    @Transactional  //TODO: Esto le indica al SPA que es una transacción ya que se modificara datos en la base de datos
    public void updateNombre(Long id, Usuario usuario) {
        usuarioDao.updateNombre(id, usuario.getNombre());
    }

    @Transactional  //TODO: Esto le indica al SPA que es una transacción ya que se modificara datos en la base de datos
    public void updateTipoDocumento(Long id, Usuario usuario) {
        usuarioDao.updateTipoDocumento(id, usuario.getTipoDocumento());
    }

    @Transactional  //TODO: Esto le indica al SPA que es una transacción ya que se modificara datos en la base de datos
    public void updateDocumento(Long id, Usuario usuario) {
        usuarioDao.updateDocumento(id, usuario.getDocumento());
    }

    @Override
    @Transactional //TODO: Esto le indica al SPA que es una transacción ya que se modificara datos en la base de datos
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)  //TODO: Se le indica que solo es una transacción de solo lectura.
    public Optional<Usuario>findUser(Usuario usuario) {
        return usuarioDao.findById(usuario.getId());
    }
}
