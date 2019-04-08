/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.media.jfxmedia.events.NewFrameEvent;
import java.awt.BorderLayout;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Conexion;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Juan1
 */
public class ControllerReport {

    Conexion conexion;

    public ControllerReport() {
        conexion = new Conexion();
    }

    public void executeReport() {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReport.class.getResource("/report/MyReportOne.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp);
            jv.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex.getMessage());
        }
    }

    public void executeReportWithParameters(String title) {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReport.class.getResource("/report/MyReportOne.jasper"));
            Map parameters = new HashMap<String, Object>();
            parameters.put("title", title);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "ERROR JRException " + ex.getMessage());
        }
    }

    public void executeReportWithSql() {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReport.class.getResource("/report/MyReportWithSql.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conexion.getConnection());
            //se crea el visor con el reporte
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void executeReportWithSqlWithParameters(String dni) {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReport.class.getResource("/report/MyReportWithSql.jasper"));
            Map parameters = new HashMap<String, Object>();
            parameters.put("dni", dni);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conexion.getConnection());
            //se crea el visor con el reporte
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    public void executeReportWithSqlWithParametersF(String startDate, String endDate) {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReport.class.getResource("/report/report1.jasper"));
            Map parameters = new HashMap<String, Object>();
            parameters.put("startDate", startDate);
            parameters.put("endDate", endDate);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conexion.getConnection());
            //se crea el visor con el reporte
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    public void excuteBarChartReport() {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReport.class.getResource("/report/BarCharReport.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conexion.getConnection());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    
    ////////////////////////////////REPORTES DE PRUUEBA////////////////////////////////////////////7
    
}
