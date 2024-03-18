package uniandes.edu.co.bancodelosandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.bancodelosandes.modelo.TipoIdentificacion;
import uniandes.edu.co.bancodelosandes.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE numIdentificacion = :numIdentificacion", nativeQuery = true)
    Usuario darUsuario(@Param("numIdentificacion") Integer numIdentificacion);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (tipoIdentificacion, numIdentificacion, contrasena, nombre, apellido, nacionalidad, direccion, email, telefono, ciudad, departamento, codigoPostal) VALUES ( :tipoIdentificacion, :numIdentificacion, :contrasena, :nombre, :apellido, :nacionalidad, :direccion, :email, :telefono, :ciudad, :departamento, :codigoPostal)", nativeQuery = true)
    void insertarUsuario(@Param("tipoIdentificacion") TipoIdentificacion tipoIdentificacion, @Param("numIdentificacion") Integer numIdentificacion, @Param("contrasena") String contrasena, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("nacionalidad") String nacionalidad, @Param("direccion") String direccion, @Param("email") String email, @Param("telefono") Integer telefono, @Param("ciudad") String ciudad, @Param("departamento") String departamento, @Param("codigoPostal") Integer codigoPostal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET contrasena = :contrasena, nombre = :nombre, apellido = :apellido, nacionalidad = :nacionalidad, direccion = :direccion, email = :email, telefono = :telefono, ciudad = :ciudad, departamento = :departamento, codigoPostal = :codigoPostal WHERE numIdentificacion = :numIdentificacion", nativeQuery = true)
    void actualizarUsuario(@Param("contrasena") String contrasena, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("nacionalidad") String nacionalidad, @Param("direccion") String direccion, @Param("email") String email, @Param("telefono") Integer telefono, @Param("ciudad") String ciudad, @Param("departamento") String departamento, @Param("codigoPostal") Integer codigoPostal, @Param("numIdentificacion") Integer numIdentificacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE numIdentificacion = :numIdentificacion", nativeQuery = true)
    void eliminarUsuario(@Param("numIdentificacion") Integer numIdentificacion);
}
