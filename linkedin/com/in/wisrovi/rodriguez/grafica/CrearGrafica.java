/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SenInt2.fcv.org.Grafica.linkedin.com.in.wisrovi.rodriguez.grafica;

import SenInt2.fcv.org.Grafica.linkedin.com.in.wisrovi.rodriguez.grafica.DatosGraficaDto;
import java.util.Iterator;
import java.util.List;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author williamrodriguez
 */
public class CrearGrafica {

    private LineChartModel model;
    private int valorMaximoGrafica = 0;

    private void CrearModeloGrafica() {
        model = new LineChartModel();
    }

    private void addSerieEnGrafica(ChartSeries serie) {
        model.addSeries(serie);
    }

    private ChartSeries CrearSerie(String tituloLinea, List<DatoCadaPuntoGraficaDto> puntos) {
        ChartSeries serie = new ChartSeries();
        serie.setLabel(tituloLinea);

        for (Iterator<DatoCadaPuntoGraficaDto> iterator = puntos.iterator(); iterator.hasNext();) {
            DatoCadaPuntoGraficaDto next = iterator.next();
            float valor = Float.parseFloat(next.getValorY());
            serie.set((String) next.getValorX(), (float) valor);
            int valorConvertidoInt = Math.round(valor);
            if (valorMaximoGrafica < valorConvertidoInt) {
                valorMaximoGrafica = valorConvertidoInt + 1;
            }
        }

        return serie;
    }

    private void ConfigurarOtrosParametrosTabla(String tituloGrafica) {
        model.setTitle(tituloGrafica);
        model.setAnimate(ParametrosGrafica.graficaAnimada);
        model.setLegendPosition(ParametrosGrafica.posicionLegenda);
                
        model.setShowPointLabels(ParametrosGrafica.puntosLabel);
        model.setZoom(ParametrosGrafica.graficaConZoom);

        model.getAxes().put(AxisType.X, new CategoryAxis(ParametrosGrafica.tituloX));

        model.setStacked(ParametrosGrafica.graficaAplicada);

        model.setMouseoverHighlight(ParametrosGrafica.legendaEnElPuntoAlPasarElMouse);
        
        model.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
        
        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setTickAngle(-25);
                       
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(valorMaximoGrafica + 5);
        yAxis.setLabel(ParametrosGrafica.tituloY);
    }

    public CrearGrafica() {
        CrearModeloGrafica();
    }

    public LineChartModel CargarDatos(GraficaDto datos) {
        model = new LineChartModel();
        String titulo = datos.getTitulo();
        List<DatosGraficaDto> grafica = datos.getGrafica();
        for (Iterator<DatosGraficaDto> iterator = grafica.iterator(); iterator.hasNext();) {
            DatosGraficaDto next = iterator.next();

            ChartSeries SerieCreada = CrearSerie(next.getTitulolinea(), next.getPuntos());
            addSerieEnGrafica(SerieCreada);
        }

        ConfigurarOtrosParametrosTabla(titulo);

        return model;
    }

    public LineChartModel getModel() {
        return model;
    }

}
