package lab7prograii_carlosnoe;
//Hacer las validaciones con regex

import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author cd507
 */
public class New1 extends javax.swing.JFrame {

    public ArrayList<Producto> Products = new ArrayList();

    public New1() {
        initComponents();
        this.pack();
        LlenarTabla0();
        LlenarArbol();
    }

    public void LlenarArbol() {
        DefaultMutableTreeNode Archivos = new DefaultMutableTreeNode("Archivos");
        File Mont = new File("./");
        listar_no_orden(Mont, Archivos);
        JTree_ListarArchivos.setModel(new DefaultTreeModel(Archivos));
        FileNameExtensionFilter a = new FileNameExtensionFilter("Archivo", ".txt");
    }

    public void listar_no_orden(File p_raiz, DefaultMutableTreeNode nodo) {
        try {
            for (File temp : p_raiz.listFiles()) {
                if (temp.isFile()) {
                    if (temp.getName().endsWith(".txt")) {

                        DefaultMutableTreeNode n = new DefaultMutableTreeNode(
                                temp.getName());
                        nodo.add(n);
                    }
                } else {
                    if (temp.getName().endsWith(".txt")) {
                        DefaultMutableTreeNode n = new DefaultMutableTreeNode(
                                temp.getName());
                        nodo.add(n);
                        listar_no_orden(temp, n);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void LlenarTabla0() {
        javax.swing.table.DefaultTableModel MODELITO = new javax.swing.table.DefaultTableModel();
        MODELITO.addColumn("ID");
        MODELITO.addColumn("NOMBRE");
        MODELITO.addColumn("CATEGORY");
        MODELITO.addColumn("PRICE");
        MODELITO.addColumn("AISLE");
        MODELITO.addColumn("BIN");
        String Zero = " ";
        MODELITO.addRow(
                new Object[]{
                    Zero, Zero, Zero, Zero, Zero, Zero
                });
        JT_ListaDeProductos.setModel(MODELITO);
    }

    public void LlenarTablar() {
        javax.swing.table.DefaultTableModel MODELITO = new javax.swing.table.DefaultTableModel();
        MODELITO.addColumn("ID");
        MODELITO.addColumn("NOMBRE");
        MODELITO.addColumn("CATEGORY");
        MODELITO.addColumn("PRICE");
        MODELITO.addColumn("AISLE");
        MODELITO.addColumn("BIN");
        for (int i = 0; i < Products.size(); i++) {
            MODELITO.addRow(
                    new Object[]{
                        Products.get(i).getID(), Products.get(i).getNombre(), Products.get(i).getCategory(),
                        Products.get(i).getPrice(), Products.get(i).getAisle(), Products.get(i).getBin()
                    });
        }
        JT_ListaDeProductos.setModel(MODELITO);
    }

    public void escribirArchivo(File p_raiz) throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(p_raiz, false);
            bw = new BufferedWriter(fw);
            for (Producto t : Products) {
                bw.write(t.getID() + ",");
                bw.write(t.getNombre() + ",");
                bw.write(t.getPrice() + ",");
                bw.write(t.getAisle() + ",");
                bw.write(t.getBin() + ",");
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo(File archivo) {
        Scanner sc = null;
        Products = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(",");
                while (sc.hasNext()) {
                    Products.add(new Producto(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
                }
            } catch (Exception ex) {
            }
            sc.close();
        }
    }

    public void puntoLoad(String Pathing) {
        Scanner sc = null;
        Products = new ArrayList();
        File omo = new File(Pathing);
        if (omo.exists()) {
            try {
                sc = new Scanner(omo);
                sc.useDelimiter(",");
                while (sc.hasNext()) {
                    Products.add(new Producto(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
                }
            } catch (Exception ex) {
            }
            sc.close();
        }
    }

    public void puntoCreate(String Pathing) throws IOException {
        File novo = new File(Pathing);
        if (novo.exists()) {
            TableModel Table = JT_ListaDeProductos.getModel();
            Products = new ArrayList();
            for (int i = 0; i < Table.getRowCount(); i++) {
                Products.add(new Producto(Table.getValueAt(i, 0).toString(),
                        Table.getValueAt(i, 1).toString(),
                        Table.getValueAt(i, 2).toString(),
                        Table.getValueAt(i, 3).toString(),
                        Table.getValueAt(i, 4).toString(),
                        Table.getValueAt(i, 5).toString()));
            }
            File archivonuevo = novo;
            try {
                escribirArchivo(archivonuevo);
            } catch (IOException ex) {
                Logger.getLogger(New1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void puntoClear() {
        LlenarTabla0();
    }

    public void puntoRefresh() {
        LlenarArbol();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SubMenu1Tabla = new javax.swing.JPopupMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        SubMenu2Arbol = new javax.swing.JPopupMenu();
        JPopMenu_Loadfile = new javax.swing.JMenuItem();
        JPopMenu_Refresh = new javax.swing.JMenuItem();
        JTF_Escritor = new javax.swing.JTextField();
        JBT_Enter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTree_ListarArchivos = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        JT_ListaDeProductos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenuItem8.setText("Clear Table");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        SubMenu1Tabla.add(jMenuItem8);

        JPopMenu_Loadfile.setText("Load File");
        JPopMenu_Loadfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPopMenu_LoadfileActionPerformed(evt);
            }
        });
        SubMenu2Arbol.add(JPopMenu_Loadfile);

        JPopMenu_Refresh.setText("Refresh Trees");
        JPopMenu_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPopMenu_RefreshActionPerformed(evt);
            }
        });
        SubMenu2Arbol.add(JPopMenu_Refresh);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBT_Enter.setText("Enter");
        JBT_Enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_EnterActionPerformed(evt);
            }
        });

        JTree_ListarArchivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTree_ListarArchivosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTree_ListarArchivos);

        JT_ListaDeProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "CATEGORY", "Title 4"
            }
        ));
        JT_ListaDeProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JT_ListaDeProductosKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(JT_ListaDeProductos);

        jMenu1.setText("File");

        jMenuItem4.setText("New FIle");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Impor File");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Window");

        jMenu4.setText("Clear");

        jMenuItem1.setText("Clear Command Line");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("Clear Table");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenu2.add(jMenu4);

        jMenuItem3.setText("Refresh Table");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem6.setText("Product Structure");
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Commands");
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JTF_Escritor, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBT_Enter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JBT_Enter, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(JTF_Escritor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBT_EnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_EnterActionPerformed
        String FILEE = JTF_Escritor.getText();
        String[] spliteo = FILEE.split(" ");
        if (spliteo[0].equalsIgnoreCase("./load")) {
            System.out.println(spliteo[1]);
            puntoLoad(spliteo[1]);
        } else if (spliteo[0].equalsIgnoreCase("./create")) {
            System.out.println(spliteo[1]);
            try {
                puntoCreate(spliteo[1]);
            } catch (IOException ex) {
                Logger.getLogger(New1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (spliteo[0].equalsIgnoreCase("./clear")) {
            puntoClear();
        } else if ((spliteo[0].equalsIgnoreCase("./refresh"))) {
            puntoRefresh();
        }


    }//GEN-LAST:event_JBT_EnterActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JTF_Escritor.setText("");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void JT_ListaDeProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JT_ListaDeProductosKeyPressed
        if (evt.getKeyCode() == 10) {
            javax.swing.table.DefaultTableModel MODELITO = (javax.swing.table.DefaultTableModel) JT_ListaDeProductos.getModel();
            String Zero = " ";
            MODELITO.addRow(
                    new Object[]{
                        Zero, Zero, Zero, Zero, Zero, Zero
                    });
            JT_ListaDeProductos.setModel(MODELITO);
        }
    }//GEN-LAST:event_JT_ListaDeProductosKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        LlenarTabla0();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void JTree_ListarArchivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTree_ListarArchivosMouseClicked
        if (evt.isMetaDown()) {
            System.out.println(evt.getX() + " " + evt.getY());
            SubMenu2Arbol.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JTree_ListarArchivosMouseClicked

    private void JPopMenu_LoadfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPopMenu_LoadfileActionPerformed
        DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) JTree_ListarArchivos.getSelectionPath().getLastPathComponent();
        String zero = nodoSeleccionado.getUserObject().toString();
        File patthing = new File(zero);
        cargarArchivo(patthing);
        LlenarTablar();
    }//GEN-LAST:event_JPopMenu_LoadfileActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        TableModel Table = JT_ListaDeProductos.getModel();
        Products = new ArrayList();
        for (int i = 0; i < Table.getRowCount(); i++) {
            Products.add(new Producto(Table.getValueAt(i, 0).toString(),
                    Table.getValueAt(i, 1).toString(),
                    Table.getValueAt(i, 2).toString(),
                    Table.getValueAt(i, 3).toString(),
                    Table.getValueAt(i, 4).toString(),
                    Table.getValueAt(i, 5).toString()));
        }
        File archivonuevo = new File(JOptionPane.showInputDialog(this, "Ingrese un nombre") + ".txt");
        try {
            escribirArchivo(archivonuevo);
        } catch (IOException ex) {
            Logger.getLogger(New1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Scanner sc = null;
        Products = new ArrayList();
        String Pathing = JOptionPane.showInputDialog(this, "Ingrese el nombre");
        File omo = new File(Pathing);
        if (omo.exists()) {
            try {
                sc = new Scanner(omo);
                sc.useDelimiter(",");
                while (sc.hasNext()) {
                    Products.add(new Producto(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
                }
            } catch (Exception ex) {
            }
            sc.close();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void JPopMenu_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPopMenu_RefreshActionPerformed
        LlenarArbol();
    }//GEN-LAST:event_JPopMenu_RefreshActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        LlenarTablar();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(New1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBT_Enter;
    private javax.swing.JMenuItem JPopMenu_Loadfile;
    private javax.swing.JMenuItem JPopMenu_Refresh;
    private javax.swing.JTextField JTF_Escritor;
    private javax.swing.JTable JT_ListaDeProductos;
    private javax.swing.JTree JTree_ListarArchivos;
    private javax.swing.JPopupMenu SubMenu1Tabla;
    private javax.swing.JPopupMenu SubMenu2Arbol;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
