/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.controlador;

import inf.pucp.edu.pe.CargaDatos.LeeArchHist;
import inf.pucp.edu.pe.modelo.ConnectionDB;
import inf.pucp.edu.pe.modelo.DiaMes;
import inf.pucp.edu.pe.modelo.InfoCuad;
import inf.pucp.edu.pe.modelo.Patron;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author fatima
 */
public class ControladorPatron {
    
    public ArrayList<DiaMes> infoGps;
    public ArrayList<InfoCuad> listaCua;
    
    public ControladorPatron(ArrayList<DiaMes> infoGps){
        this.infoGps=infoGps;
    }
    

   // public ArrayList<InfoCuad> listaCuadrantesPat() {
    public void listaCuadrantesPat(){
System.out.println("entro al metodo listaCuadrantesPat ");
        //ArrayList<DiaMes> infoGps = null;//LeeArchHist.datosCargados();

        ArrayList<InfoCuad> listaCuadrantes = new ArrayList<InfoCuad>();

        for (int i = 0; i < infoGps.size(); i++) {
            for (int j = 0; j < infoGps.get(i).getHoras().size(); j++) {
                for (int k = 0; k < infoGps.get(i).getHoras().get(j).getMin().size(); k++) {

                    //seteo el arreglo de posiciones en 0
                    ArrayList<Integer> arrPos = new ArrayList<Integer>();
                    for (int p = 0; p < 160; p++) {
                        int x = 0;
                        arrPos.add(x);
                    }

                    //se carga el arreglo con los puntos en esa hora
                    for (int l = 0; l < infoGps.get(i).getHoras().get(j).getMin().get(k).getSeg().size(); l++) {
                        int r = 0;
                        while (r < infoGps.get(i).getHoras().get(j).getMin().get(k).getSeg().get(l).getCoordenadas().size()) {
                            int x = infoGps.get(i).getHoras().get(j).getMin().get(k).getSeg().get(l).getCoordenadas().get(r);
                            r++;
                            int y = infoGps.get(i).getHoras().get(j).getMin().get(k).getSeg().get(l).getCoordenadas().get(r);

                            int cuadX = x / 6000;
                            int cuadY = y / 4000;
                            int posArr = cuadX + (cuadY * 40);
                            int elm = arrPos.get(posArr);
                            elm++;
                            arrPos.set(posArr, elm);
                            r++;
                        }
                    }

                    //cargara en el arreglo de cuadrantes las zonas mas congestionadas
                    for (int w = 0; w < arrPos.size(); w++) {
                        if (arrPos.get(w) >= 5000) {
                            int ejeX = w % 40;
                            int ejeY = w / 40;
                            ArrayList<Integer> pos = new ArrayList<Integer>();
                            pos.add(ejeX);
                            pos.add(ejeY);
                            ejeX = ejeX + 6000;
                            ejeY = ejeY + 4000;
                            pos.add(ejeX);
                            pos.add(ejeY);
                            int dia = infoGps.get(i).getDia();
                            int mes = infoGps.get(i).getMes();
                            int hora = infoGps.get(i).getHoras().get(j).getHora();

                            InfoCuad infoP = new InfoCuad(dia,mes, hora, pos);
                            listaCuadrantes.add(infoP);
                        }
                    }
                }
            }
        }
        System.out.println("-----------YA SALIOOOOO----------");
        System.out.println(listaCuadrantes.size());
        this.listaCua= listaCuadrantes;
    }
    
    Patron obtenerPatron(String diaSemana, int mes, int hora) {

        Patron p = new Patron();

        int result = 0;
        ConnectionDB objConn = new ConnectionDB();
        Connection conn = null;

        try {
            conn = objConn.open();
        } catch (SQLException ex) {
        }

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String SqlString = null;

            SqlString = "SELECT p.idPatron,p.Dia, p.Anho FROM patron p WHERE p.DiaSemana='" + diaSemana + "' AND p.Mes='" + mes + "' AND p.Hora='" + hora + "'";
            pstmt = conn.prepareStatement(SqlString);
            rs = pstmt.executeQuery();

            int id = 0;
            int anho = 0;
            int dia = 0;

            while (rs.next()) {
                id = rs.getInt("idPatron");
                dia = rs.getInt("Dia");
                anho = rs.getInt("Anho");
            }
            rs = null;
            SqlString = null;
            SqlString = "SELECT s.TiempoV, s.TiempoR, s.PosX, s.PosY FROM semXPatron s WHERE s.IdPatron='" + id + "'";

            pstmt = conn.prepareStatement(SqlString);
            rs = pstmt.executeQuery();
            int verde = 0;
            int rojo = 0;
            int posX=0;
            int posY=0;

            ArrayList<Integer> tiempos = new ArrayList<Integer>();
            ArrayList<Integer> sems = new ArrayList<Integer>();

            while (rs.next()) {
                verde = rs.getInt("TiempoV");
                rojo = rs.getInt("TiempoR");
                posX= rs.getInt("PosX");
                posY=rs.getInt("PosY");
                tiempos.add(verde);
                tiempos.add(rojo);
                sems.add(posX);
                sems.add(posY);
            }

            p.setAnho(anho);
            p.setDia(dia);
            p.setDiaSemana(diaSemana);
            p.setHora(hora);
            p.setMes(mes);
            p.setConfSemaf(tiempos);


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return p;

    }

    int guardarPatron(Patron p) {
        int result = 0;

        ConnectionDB objConn = new ConnectionDB();
        Connection conn = null;

        try {
            conn = objConn.open();
        } catch (SQLException ex) {
            //  Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null,ex);
        }

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String SqlString = null;
            SqlString = "INSERT INTO patron(Dia, Mes, Anho, DiaSemana, Hora) "
                    + "VALUES(?,?,?,?,?)";
            pstmt = conn.prepareStatement(SqlString);
            pstmt.setInt(1, p.getDia());
            pstmt.setInt(2, p.getMes());
            pstmt.setInt(3, p.getAnho());
            pstmt.setString(4, p.getDiaSemana());
            pstmt.setInt(5, p.getHora());
            result = pstmt.executeUpdate();
            pstmt.close();
            if (result == 0) {
                throw new Exception();
            }
            int lastid = 0;
            
            SqlString="SELECT MAX(idPatron) from patron";
            pstmt=conn.prepareStatement(SqlString);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                lastid = rs.getInt("MAX(idPatron)");
            }
            int tam = (p.getConfSemaf().size()) / 2;

            for (int i = 0; i < tam; i++) {
                int j = i * 2;

                SqlString = "INSERT INTO semXPatron(IdPatron, TiempoV,TiempoR, posX, posY) "
                        + "VALUES(?,?,?,?,?)";
                pstmt = conn.prepareStatement(SqlString);
                //rs=pstmt.executeQuery();
                pstmt.setInt(1, lastid);
                pstmt.setInt(2, p.getConfSemaf().get(j));
                pstmt.setInt(3, p.getConfSemaf().get(j + 1));
                pstmt.setInt(4, p.getSem().get(j));
                pstmt.setInt(5, p.getSem().get(j+1));
                result = pstmt.executeUpdate();
            }

            
            pstmt.close();

            if (result == 0) {
                throw new Exception();
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    String generaDiaSemana(int dia, int mes, int anho) {

        Calendar fecha = Calendar.getInstance();
        fecha.set(anho, mes, dia);
        int d = fecha.get(Calendar.DAY_OF_WEEK);

        String r = "";
        switch (d) {
            case 0:
                r = "domingo";
            case 1:
                r = "lunes";
            case 2:
                r = "martes";
            case 3:
                r = "miercoles";
            case 4:
                r = "jueves";
            case 5:
                r = "viernes";
            case 6:
                r = "sabado";
        }

        return r;
    }
    
    
    void GuardarVelocProm(int dd, int mm, int aa, int horaIni, int horaFin, float velocidad){
        int result = 0;

        ConnectionDB objConn = new ConnectionDB();
        Connection conn = null;

        try {
            conn = objConn.open();
        } catch (SQLException ex) {
            //  Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null,ex);
        }

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String SqlString = null;
            SqlString = "INSERT INTO Simulacion(Dia, Mes, Anho, HoraInicial, HoraFinal, VelocProm) "
                    + "VALUES(?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(SqlString);
            pstmt.setInt(1, dd);
            pstmt.setInt(2, mm);
            pstmt.setInt(3, aa);
            pstmt.setInt(4, horaIni);
            pstmt.setInt(5, horaFin);
            pstmt.setFloat(6, velocidad);            
            result = pstmt.executeUpdate();
            pstmt.close();
            if (result == 0) {
                throw new Exception();
            }           


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
