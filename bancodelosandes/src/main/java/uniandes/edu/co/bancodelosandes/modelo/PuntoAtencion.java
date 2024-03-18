package uniandes.edu.co.bancodelosandes.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PUNTOSATENCION")
public class PuntoAtencion {
    @Id
    @Column(name = "UBICACIONGEOGRAFICA")
    private String ubicacionGeografica;

    private Integer operacionesRealizadas;

    @Enumerated(EnumType.STRING)
    private TipoPuntoAtencion tipoPuntoAtencion;

    @ManyToOne
    @JoinColumn(name = "oficinaName", referencedColumnName = "nombre")
    private Oficina oficinaName;

    public PuntoAtencion()
    {;}

    public PuntoAtencion(Integer operacionesRealizadas, TipoPuntoAtencion tipoPuntoAtencion, Oficina oficina) {
        this.operacionesRealizadas = operacionesRealizadas;
        this.tipoPuntoAtencion = tipoPuntoAtencion;
        this.oficinaName = oficina;
    }

    public String getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public Integer getOperacionesRealizadas() {
        return operacionesRealizadas;
    }

    public TipoPuntoAtencion getTipoPuntoAtencion() {
        return tipoPuntoAtencion;
    }

    public Oficina getOficina() {
        return oficinaName;
    }

    public void setUbicacionGeografica(String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public void setOperacionesRealizadas(Integer operacionesRealizadas) {
        this.operacionesRealizadas = operacionesRealizadas;
    }

    public void setTipoPuntoAtencion(TipoPuntoAtencion tipoPuntoAtencion) {
        this.tipoPuntoAtencion = tipoPuntoAtencion;
    }

    public void setOficina(Oficina oficina) {
        this.oficinaName = oficina;
    }
}
