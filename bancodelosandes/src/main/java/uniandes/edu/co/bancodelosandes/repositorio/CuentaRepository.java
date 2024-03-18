package uniandes.edu.co.bancodelosandes.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.bancodelosandes.modelo.Cliente;
import uniandes.edu.co.bancodelosandes.modelo.Cuenta;
import uniandes.edu.co.bancodelosandes.modelo.EstadoCuenta;
import uniandes.edu.co.bancodelosandes.modelo.TipoCuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
    @Query(value = "SELECT * FROM cuentas", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM cuentas WHERE numCuenta = :numCuenta", nativeQuery = true)
    Cuenta darCuenta(@Param("numCuenta") Long numCuenta);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (numCuenta, tipoCuenta, estadoCuenta, saldo, fechaUtimaTransaccion, fechaCreacion, numIdentificacion) VALUES (:numCuenta, :tipoCuenta, :estadoCuenta, :saldo, :fechaUtimaTransaccion, :fechaCreacion, :numIdentificacion)", nativeQuery = true)
    void insertarCuenta(@Param("numCuenta") Long numCuenta, @Param("tipoCuenta") TipoCuenta tipoCuenta, @Param("estadoCuenta") EstadoCuenta estadoCuenta, @Param("saldo") Float saldo, @Param("fechaUtimaTransaccion") java.sql.Date fechaUtimaTransaccion, @Param("fechaCreacion") java.sql.Date fechaCreacion, @Param("numIdentificacion") Cliente numIdentificacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentas SET tipoCuenta = :tipoCuenta, estadoCuenta = :estadoCuenta, saldo = :saldo, fechaUtimaTransaccion = :fechaUtimaTransaccion, fechaCreacion = :fechaCreacion, numIdentificacion = :numIdentificacion WHERE numCuenta = :numCuenta", nativeQuery = true)
    void actualizarCuenta(@Param("tipoCuenta") TipoCuenta tipoCuenta, @Param("estadoCuenta") EstadoCuenta estadoCuenta, @Param("saldo") Float saldo, @Param("fechaUtimaTransaccion") java.sql.Date fechaUtimaTransaccion, @Param("fechaCreacion") java.sql.Date fechaCreacion, @Param("numIdentificacion") Cliente numIdentificacion, @Param("numCuenta") Long numCuenta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas WHERE numCuenta = :numCuenta", nativeQuery = true)
    void eliminarCuenta(@Param("numCuenta") Long numCuenta);
}
