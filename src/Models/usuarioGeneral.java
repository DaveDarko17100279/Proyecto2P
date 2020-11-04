
package Models;
import java.sql.*;

public class usuarioGeneral {
    private int id;
    private String Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private Date FechaNacimiento;
    private String Correo;
    private long telefono;
    private String Contraseña;
    private int Tipo;
    public usuarioGeneral() {
    }
    
    public usuarioGeneral(int id, String Nombre, String ApellidoPaterno, String ApellidoMaterno, Date FechaNacimiento, String Correo, long telefono, String Contraseña, int Tipo) {
        this.id = id;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.FechaNacimiento = FechaNacimiento;
        this.Correo = Correo;
        this.telefono = telefono;
        this.Contraseña = Contraseña;
        this.Tipo = Tipo;
    }

    public int getId() {
        return id;
    }
    
    public int getTipo() {
        return Tipo;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public String getCorreo() {
        return Correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }
}
