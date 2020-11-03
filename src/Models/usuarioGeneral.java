
package Models;
import java.sql.*;

public class usuarioGeneral {
    String Nombre;
    String ApellidoPaterno;
    String ApellidoMaterno;
    Date FechaNacimiento;
    String Correo;
    long telefono;
    String Contraseña;

    public usuarioGeneral(String Nombre, String ApellidoPaterno, String ApellidoMaterno, Date FechaNacimiento, String Correo, long telefono, String Contraseña) {
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.FechaNacimiento = FechaNacimiento;
        this.Correo = Correo;
        this.telefono = telefono;
        this.Contraseña = Contraseña;
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
    
    
}
