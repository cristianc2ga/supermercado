package model;

public class Model {
    private String nombre;
    private int identificacion;
    private String cargo;
    

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getIdentificacion() {
            return identificacion;
        }

        public void setIdentificacion(int identificacion) {
            this.identificacion = identificacion;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }
}
