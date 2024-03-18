package uniandes.edu.co.bancodelosandes.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="USUARIOS")
public class Usuario {
    private TipoIdentificacion tipoIdentificacion;
    @Id
    @Column(name = "NUMIDENTIFICACION")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numIdentificacion;
    
    private String contrasena;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private String direccion;
    private String email;
    private Integer telefono;
    private String ciudad;
    private String departamento;
    private Integer codigoPostal;

    public Usuario(TipoIdentificacion tipoIdentificacion, String contrasena, String nombre, String apellido, String nacionalidad, String direccion, String email, Integer telefono, String ciudad, String departamento, Integer codigoPostal) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
    }

    public Usuario() 
    {;}


    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public Integer getNumIdentificacion() {
        return numIdentificacion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public void setNumIdentificacion(Integer numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    






}