package model;

/**
 *
 * @author CristianGarcia
 */
public class Model {
    public class Cliente {
    private String nombre;
    private Integer identificacion;
    private String cargo;
    
    public Cliente(String nombre, Integer identificacion, String cargo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.cargo = cargo;
    }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Integer getIdentificacion() {
            return identificacion;
        }

        public void setIdentificacion(Integer identificacion) {
            this.identificacion = identificacion;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        
    
    
}
}
