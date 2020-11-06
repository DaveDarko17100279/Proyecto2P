
package Models;
import java.sql.*;
public class conferencia {
    private int idConferencia;
    private int idUsuario;
    private String NombreConferencia;
    private int CupoTotal;
    private int Precio;
    private boolean Costo;
    private Date FechaPresentacion;
    private Time HoraInicial;
    private Time HoraFinalizacion;
    private long CodigoParticipante;

    public conferencia() {
    }
    
    public conferencia(int idUsuario, String NombreConferencia, int CupoTotal, int Precio, boolean Costo, Date FechaPresentacion, Time HoraInicial, Time HoraFinalizacion) {
        this.idUsuario = idUsuario;
        this.NombreConferencia = NombreConferencia;
        this.CupoTotal = CupoTotal;
        this.Precio = Precio;
        this.Costo = Costo;
        this.FechaPresentacion = FechaPresentacion;
        this.HoraInicial = HoraInicial;
        this.HoraFinalizacion = HoraFinalizacion;
    }

    public conferencia(int idConferencia, String NombreConferencia, int CupoTotal, int Precio, boolean Costo) {
        this.idConferencia = idConferencia;
        this.NombreConferencia = NombreConferencia;
        this.CupoTotal = CupoTotal;
        this.Precio = Precio;
        this.Costo = Costo;
    }

    public conferencia(int idConferencia, int idUsuario) {
        this.idConferencia = idConferencia;
        this.idUsuario = idUsuario;
    }

    public conferencia(int idConferencia, int idUsuario, long CodigoParticipante) {
        this.idConferencia = idConferencia;
        this.idUsuario = idUsuario;
        this.CodigoParticipante = CodigoParticipante;
    }

    public conferencia(int idConferencia, Date FechaPresentacion, Time HoraInicial, Time HoraFinalizacion) {
        this.idConferencia = idConferencia;
        this.FechaPresentacion = FechaPresentacion;
        this.HoraInicial = HoraInicial;
        this.HoraFinalizacion = HoraFinalizacion;
    }

    public conferencia(int idConferencia, String NombreConferencia, int CupoTotal, int Precio, Date FechaPresentacion, Time HoraInicial, Time HoraFinalizacion) {
        this.idConferencia = idConferencia;
        this.NombreConferencia = NombreConferencia;
        this.CupoTotal = CupoTotal;
        this.Precio = Precio;
        this.FechaPresentacion = FechaPresentacion;
        this.HoraInicial = HoraInicial;
        this.HoraFinalizacion = HoraFinalizacion;
    }
    
    public int getIdConferencia() {
        return idConferencia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreConferencia() {
        return NombreConferencia;
    }

    public int getCupoTotal() {
        return CupoTotal;
    }

    public int getPrecio() {
        return Precio;
    }

    public boolean isCosto() {
        return Costo;
    }

    public Date getFechaPresentacion() {
        return FechaPresentacion;
    }

    public Time getHoraInicial() {
        return HoraInicial;
    }

    public Time getHoraFinalizacion() {
        return HoraFinalizacion;
    }

    public long getCodigoParticipante() {
        return CodigoParticipante;
    }

    public void setIdConferencia(int idConferencia) {
        this.idConferencia = idConferencia;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreConferencia(String NombreConferencia) {
        this.NombreConferencia = NombreConferencia;
    }

    public void setCupoTotal(int CupoTotal) {
        this.CupoTotal = CupoTotal;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public void setCosto(boolean Costo) {
        this.Costo = Costo;
    }

    public void setFechaPresentacion(Date FechaPresentacion) {
        this.FechaPresentacion = FechaPresentacion;
    }

    public void setHoraInicial(Time HoraInicial) {
        this.HoraInicial = HoraInicial;
    }

    public void setHoraFinalizacion(Time HoraFinalizacion) {
        this.HoraFinalizacion = HoraFinalizacion;
    }

    public void setCodigoParticipante(long CodigoParticipante) {
        this.CodigoParticipante = CodigoParticipante;
    }
    
}
