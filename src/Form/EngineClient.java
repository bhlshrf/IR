package Form;

import finalir.DataStructure.DocumentResult;
import finalir.Engine;
import finalir.JazzySpellChecker;
import java.io.File;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class EngineClient extends javax.swing.JFrame {

    // thia static so, any EngineClient can connect to same Engine like server client
    static Engine g = new Engine(); 

    
    public EngineClient() {
        initComponents();
        
        jLabel2.setText("");
        jLabel3.setText("");
        
        jEditorPane1.setContentType("text/html");
        jEditorPane1.setEditable(false);
        jEditorPane1.setOpaque(false);
        jEditorPane1.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent hle) {
                if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                    if (hle.getDescription().equalsIgnoreCase("didyoumean")) 
                    {
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setName("tbxSearch"); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.setName("btnSearch"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("load files");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("jlabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "20", "30", "40", "50", "100" }));

        jCheckBox1.setText("advance");

        jScrollPane1.setViewportView(jEditorPane1);

        jButton3.setText("spawn");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("");
        jList1.setOpaque(false);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(217, 217, 217))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try 
        {
            g.IndexFiles(getFiles()).ComputeTF_IDF();
        }
        catch(Exception e){ }
    }//GEN-LAST:event_jButton2ActionPerformed

    JazzySpellChecker speller = new JazzySpellChecker();
    String lastCorrectLine;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        StringBuilder str = new StringBuilder();
        List<DocumentResult> res = g.SearchQuery( jTextField1.getText(), jCheckBox1.isSelected() );
        
        long time = g.getLastTime();
        int total = res.size();
        int t = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        int pages = total / t;
        
        for (DocumentResult d : res) {
            str.append("<br>" + d.getDocument().getName());
            if(t-- == 0)
                break;
        }
        
        jEditorPane1.setText("<html>" + str.toString() + "</html>");
        
        jLabel3.setText(total + " results in  " + time + " msec");
        
        if(speller.HasError(jTextField1.getText())){
            lastCorrectLine = speller.getCorrectedLine(jTextField1.getText());
            jLabel2.setText("<html>Did you mean: <i style='color:blue;'>" + lastCorrectLine + "</i></html>");
        }
        else
            jLabel2.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        jTextField1.setText(lastCorrectLine);
        jButton1ActionPerformed(null);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new EngineClient().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        DefaultListModel<String> d =  new DefaultListModel<>();
        g.getSuggestions(jTextField1.getText()).forEach( x-> d.addElement(x));
        jList1.setModel(d);
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if(jList1.getSelectedValue() != null)
        jTextField1.setText(jList1.getSelectedValue().toString());
    }//GEN-LAST:event_jList1MouseClicked

    
    public static File[] getFiles() {    
        final JFileChooser chooser = new JFileChooser(new File("src\\finalir\\testCases"));
        chooser.setMultiSelectionEnabled(true);
        chooser.setAcceptAllFileFilterUsed(false);

        File[] files = null;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            files = chooser.getSelectedFiles();
        }
        return files;
    }
    
    public static void main(String args[]) {
        
        try  { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ex) { }

        java.awt.EventQueue.invokeLater(
                new Runnable() { public void run() { new EngineClient().setVisible(true); } }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
