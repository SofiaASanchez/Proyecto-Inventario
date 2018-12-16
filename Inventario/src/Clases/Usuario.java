package Clases;

public class Usuario extends Persona{
    
   private String tipo_usuario;
   private String contra;

    public Usuario(String tipo_usuario, String contra, String id_persona,
            String nombre, String apellido, String fecha_nacimiento, String telefono, String direccion) {
        super(id_persona, nombre, apellido, fecha_nacimiento, telefono, direccion);
        this.tipo_usuario = tipo_usuario;
        this.contra = contra;
    }

    public Usuario(String tipo_usuario, String contra) {
        this.tipo_usuario = tipo_usuario;
        this.contra = contra;
    }
   
    public Usuario(){}
    
    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public String getContrasena() {
        return contra;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public void setContrasena(String contra) {
        this.contra = contra;
    }
   
   
}
