package Class;

public class Estudiante {
    private String documento;
    private String nombre;
    private  String correo;

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento){
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String DatoEstudiante(){
        String datoEstudiante="";
        datoEstudiante = "Estudiante: "+getDocumento()+" "+this.getNombre()+" "+this.getCorreo();
        return datoEstudiante;
    }
}
