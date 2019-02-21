/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SenInt2.fcv.org.Grafica.linkedin.com.in.wisrovi.rodriguez.grafica;

import java.util.List;

/**
 *
 * @author williamrodriguez
 */
public class DatosGraficaDto {

    private String titulolinea;
    private List<DatoCadaPuntoGraficaDto> puntos;

    public String getTitulolinea() {
        return titulolinea;
    }

    public void setTitulolinea(String titulolinea) {
        this.titulolinea = titulolinea;
    }

    public List<DatoCadaPuntoGraficaDto> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<DatoCadaPuntoGraficaDto> puntos) {
        this.puntos = puntos;
    }

}
