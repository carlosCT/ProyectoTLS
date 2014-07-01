/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.vista.seguridad;

import inf.pucp.edu.pe.controlador.UsuarioDAO;
import inf.pucp.edu.pe.modelo.Usuario;
import inf.pucp.edu.pe.vista.principal.PanelImagenVentana;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JuanCarlos
 */
public class ModificarUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form DesbloquearUsuario
     */
    public ModificarUsuario() {
        //674, 552
        setBounds(400, 100, 674, 552);
        PanelImagenVentana p = new PanelImagenVentana();
        p.setBorder(new EmptyBorder(5, 5, 5, 5));
        p.setLayout(new BorderLayout(0, 0));
        setContentPane(p);
        
        initComponents();
        setLocation(100, 100);
         tblUsuario.setModel(myModel);
        //jPanel1.setBackground(Color.lightGray);
        //jTable1.setBackground(colorPanel);
        this.setTitle("Modificar Usuario");
        jPanel1.setOpaque(false);
        this.setClosable(true);
        this.setMaximizable(false);
        this.setIconifiable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
     UserTableModel myModel=new UserTableModel();
    UsuarioDAO userDao= new UsuarioDAO();
    ArrayList<Usuario> userList= userDao.allUser();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
        public final void refreshTable(){
            userList=userDao.allUser();
            myModel.fireTableChanged(null);
        }
        
     class UserTableModel extends AbstractTableModel{
        public static final int COLS =5;
        
        @Override
        public int getRowCount(){
            return userList.size();
        }
        
        @Override
        public int getColumnCount(){
            return COLS;
            
        }
        
       
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex){
              String value = "";
              int value2=-1;
            switch(columnIndex){
                //codigo del empleado
                case 0: value = userList.get(rowIndex).getDni();break;
                //Nombre completo
                case 1: value = userList.get(rowIndex).getNombres()+ " " +
                                            userList.get(rowIndex).getApellidos(); break;
                    
                //telefono del empleado
                case 2: value2 = userList.get(rowIndex).getPerfil(); break;  
                //correo del empleado
                case 3: value = userList.get(rowIndex).getEmail();break;
                //dni
                case 4: value2 = userList.get(rowIndex).getEstadoBloqueo();break;
            }
          
            if(value2!=-1)return value2;
                    else
                return value;
            
        }
        
        @Override
         public String getColumnName(int col){
            switch(col){
                case 0: return "DNI"; 
                case 1: return "Nombre completo";
                case 2: return "Perfil";
                case 3: return "Email";
                case 4: return "Estado";
                default: return "";   
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombres y Apellidos", "Perfil", "Email", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblUsuario);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de Búsqueda: "));

        jLabel3.setText("Usuario:");

        jLabel4.setText("Perfil: ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/buscar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addComponent(jLabel4)
                        .addGap(42, 42, 42)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblUsuario;
    // End of variables declaration//GEN-END:variables
}
