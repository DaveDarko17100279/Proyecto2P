
package Models;

import java.sql.Date;


public class usuarioEmpresarial  extends usuarioGeneral{
    int Empresa;
    
    public usuarioEmpresarial(int Empresa, String Nombre, String ApellidoPaterno, String ApellidoMaterno, Date FechaNacimiento, String Correo, long telefono, String Contraseña, int Tipo) {
        super(Nombre, ApellidoPaterno, ApellidoMaterno, FechaNacimiento, Correo, telefono, Contraseña, Tipo);
        this.Empresa = Empresa;
    }

    public int getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(int Empresa) {
        this.Empresa = Empresa;
    }
    
    
}
