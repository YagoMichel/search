package com.BusquedaAJAX.BusquedaUPIIZ.Models;


public class JobModel {

    private Long id;
    private String nombre;

        public JobModel() {
        }

        public JobModel(Long id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public Long getId() {
            return id;
        }
        public String getNombre() {
            return nombre;
        }
    public void setId(Long id) { this.id = id; }

    public void setNombre(String nombre) { this.nombre = nombre; }


}
