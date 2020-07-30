
package modelos.vo;

public class Cliente {
    
    private int clienteid;
    private String nombre;
    private String apellido;
    private String email;
    private String fono;
    private int edad;
    private int renta;
    private Estado estado;
    private Tipocli tipocli;

    public Cliente() {
    }

    public Cliente(int clienteid, String nombre, String apellido, String email, String fono, int edad, int renta, Estado estado, Tipocli tipocli) {
        this.clienteid = clienteid;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fono = fono;
        this.edad = edad;
        this.renta = renta;
        this.estado = estado;
        this.tipocli = tipocli;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getRenta() {
        return renta;
    }

    public void setRenta(int renta) {
        this.renta = renta;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Tipocli getTipocli() {
        return tipocli;
    }

    public void setTipo(Tipocli tipocli) {
        this.tipocli = tipocli;
    }
    
    
}
