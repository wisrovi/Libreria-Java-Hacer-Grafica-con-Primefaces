/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SenInt2.fcv.org.Grafica.linkedin.com.in.wisrovi.rodriguez.grafica;

import SenInt2.fcv.org.Grafica.linkedin.com.in.wisrovi.rodriguez.grafica.DatosGraficaDto;
import java.util.List;

/**
 *
 * @author williamrodriguez
 */
public class GraficaDto {

    private String titulo;
    private List<DatosGraficaDto> grafica;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<DatosGraficaDto> getGrafica() {
        return grafica;
    }

    public void setGrafica(List<DatosGraficaDto> grafica) {
        this.grafica = grafica;
    }

}
