package uniandes.edu.co.bancodelosandes.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.bancodelosandes.modelo.Cuenta;
import uniandes.edu.co.bancodelosandes.modelo.OperacionBancaria;
import uniandes.edu.co.bancodelosandes.modelo.OperacionCuenta;
import uniandes.edu.co.bancodelosandes.modelo.TipoOperacionCuenta;

public interface OperacionCuentaRepository extends JpaRepository<OperacionCuenta, Long> {
    @Query(value = "SELECT * FROM operacionesCuenta", nativeQuery = true)
    Collection<OperacionCuenta> darOperacionesCuenta();

    @Query(value = "SELECT * FROM operacionesCuenta WHERE id = :id", nativeQuery = true)
    OperacionCuenta darOperacionCuenta(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operacionesCuenta (id, tipoOperacionCuenta, numCuenta, operacionBancaria) VALUES (:id, :tipoOperacionCuenta, :numCuenta, :operacionBancaria)", nativeQuery = true)
    void insertarOperacionCuenta(@Param("id") Long id, @Param("tipoOperacionCuenta") TipoOperacionCuenta tipoOperacionCuenta, @Param("numCuenta") Cuenta numCuenta, @Param("operacionBancaria") OperacionBancaria operacionBancaria);

    @Modifying
    @Transactional
    @Query(value = "UPDATE operacionesCuenta SET tipoOperacionCuenta = :tipoOperacionCuenta, numCuenta = :numCuenta, operacionBancaria = :operacionBancaria WHERE id = :id", nativeQuery = true)
    void actualizarOperacionCuenta(@Param("tipoOperacionCuenta") TipoOperacionCuenta tipoOperacionCuenta, @Param("numCuenta") Cuenta numCuenta, @Param("operacionBancaria") OperacionBancaria operacionBancaria, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operacionesCuenta WHERE id = :id", nativeQuery = true)
    void eliminarOperacionCuenta(@Param("id") Long id);
}
