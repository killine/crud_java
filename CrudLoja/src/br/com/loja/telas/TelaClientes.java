package br.com.loja.telas;

import java.sql.*;
import br.com.loja.dal.ModuloConexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class TelaClientes extends javax.swing.JInternalFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;    
   
    public TelaClientes() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void adicionar(){
          
        String sql = "INSERT INTO clientes (nomecli, endcli, fonecli, emailcli) VALUES (?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString (1, txtNome.getText());
            pst.setString (2, txtEndereco.getText());
            pst.setString (3, txtFone.getText());
            pst.setString (4, txtEmail .getText());
            
            if(txtNome.getText().isEmpty() || txtEndereco.getText().isEmpty() ||
                     txtFone.getText().isEmpty() || txtEmail.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null, "Prencha todos os campos obrigatórios!");
            }
            
            else{
                int adicionado = pst.executeUpdate();
                if(adicionado > 0){
                    
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
                    txtNome.setText (null);
                    txtEndereco.setText (null);
                    txtFone.setText (null);
                    txtEmail.setText (null);
                         
                }         
            }
        }
        catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    private void pesquisar_clientes(){
        
        String sql = "SELECT idcli as id, nomecli as nome, endcli as endereço, fonecli as fone, emailcli as email"
                + "WHERE nomecli LIKE?";
            
        try {
            pst = conexao.prepareStatement(sql);
            
            
            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));  
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
     }
    
    
    public void setar_campos(){
        
        int setar = tblClientes.getSelectedRow();
        txtId.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
        txtEndereco.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
        txtFone.setText(tblClientes.getModel().getValueAt(setar, 3).toString());
        txtEmail.setText(tblClientes.getModel().getValueAt(setar, 4).toString());

    }
    
    private void alterar(){
          
        String sql = "UPDATE clientes set nomecli=?, endcli=?, fonecli=?, emailcli=? WHERE idcli=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString (1, txtNome.getText());
            pst.setString (2, txtEndereco.getText());
            pst.setString (3, txtFone.getText());
            pst.setString (4, txtEmail .getText());
            pst.setString (5, txtId.getText());
            
            if(txtNome.getText().isEmpty() || txtEndereco.getText().isEmpty() ||
                     txtFone.getText().isEmpty() || txtEmail.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null, "Prencha todos os campos obrigatórios!");
            }
            
            else{
                int adicionado = pst.executeUpdate();
                if(adicionado > 0){
                    
                    JOptionPane.showMessageDialog(null, "Dados do cliente alterado com sucesso!");
                    txtNome.setText (null);
                    txtEndereco.setText (null);
                    txtFone.setText (null);
                    txtEmail.setText (null);
                         
                }         
            }
        }
        catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void remover(){
        
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse cliente?", 
                                   "Atenção", JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            
            String sql = "DELETE FROM clientes WHERE idcli=?";
            
            try{
                pst = conexao.prepareStatement(sql);
                pst.setString (1, txtId.getText());
                int apagado = pst.executeUpdate();
                if(apagado>0){
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                    txtId.setText(null);
                    txtNome.setText (null);
                    txtEndereco.setText (null);
                    txtFone.setText (null);
                    txtEmail.setText (null);
                } 
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
            } 
        }
    }
    
    private void limpar(){
        
        txtBuscaCliente.setText(null);
        txtId.setText(null);
        txtNome.setText (null);
        txtEndereco.setText (null);
        txtFone.setText (null);
        txtEmail.setText (null);
        ((DefaultTableModel) tblClientes.getModel()).setRowCount(0);
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscaCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtFone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");

        txtBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaClienteActionPerformed(evt);
            }
        });
        txtBuscaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaClienteKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/search.png"))); // NOI18N

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jLabel2.setText("Nome");

        jLabel3.setText("Endereço");

        jLabel4.setText("Tel");

        jLabel5.setText("Email");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFoneActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/create.png"))); // NOI18N
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/update.png"))); // NOI18N
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/delete.png"))); // NOI18N
        btnApagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(txtBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdicionar)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnAlterar)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnApagar))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtFone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                        .addComponent(txtEmail)
                                        .addComponent(txtEndereco))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                                    .addComponent(txtId))))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscaCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnApagar)
                    .addComponent(btnAlterar)
                    .addComponent(btnAdicionar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaClienteActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFoneActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        adicionar();

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtBuscaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaClienteKeyReleased
       
        pesquisar_clientes();
        
    }//GEN-LAST:event_txtBuscaClienteKeyReleased

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
       
        setar_campos();
                
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        
        alterar();
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        
        remover();
        
    }//GEN-LAST:event_btnApagarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBuscaCliente;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
