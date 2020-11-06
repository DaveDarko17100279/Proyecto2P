package Models;

public class conferencia_participante {
     private int ID_CP;
     private int ID_Usuario;
     private int ID_Conferencia;
     private int Codigo_Participante;
    
    public conferencia_participante(){
    }
    
    public conferencia_participante(int ID_Usuario, int ID_Conferencia, int Codigo_Participante ){
        this.ID_Usuario = ID_Usuario;
        this.ID_Conferencia = ID_Conferencia;
        this.Codigo_Participante = Codigo_Participante;
    }
     
    public int getID_CP() {
        return ID_CP;
    }

    public void setID_CP(int ID_CP) {
        this.ID_CP = ID_CP;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public int getID_Conferencia() {
        return ID_Conferencia;
    }

    public void setID_Conferencia(int ID_Conferencia) {
        this.ID_Conferencia = ID_Conferencia;
    }

    public int getCodigo_Participante() {
        return Codigo_Participante;
    }

    public void setCodigo_Participante(int Codigo_Participante) {
        this.Codigo_Participante = Codigo_Participante;
    }
}