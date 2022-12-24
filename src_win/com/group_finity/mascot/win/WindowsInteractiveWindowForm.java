package com.group_finity.mascot.win;

import com.group_finity.mascot.Main;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Kilkakon
 */
public class WindowsInteractiveWindowForm extends javax.swing.JDialog
{
    private final String configFile = "./conf/settings.properties";	// Config file name
    ArrayList<String> listData = new ArrayList<String>( );
    
    public WindowsInteractiveWindowForm( java.awt.Frame parent, boolean modal )
    {
        super( parent, modal );
        initComponents( );
        setLocationRelativeTo( null );
        
        listData.addAll( Arrays.asList( Main.getInstance( ).getProperties( ).getProperty( "InteractiveWindows", "" ).split( "/" ) ) );
        jList1.setListData( listData.toArray( ) );
    }
    
    public boolean display( )
    {
        setTitle( Main.getInstance( ).getLanguageBundle( ).getString( "InteractiveWindows" ) );
        jButton1.setText( Main.getInstance( ).getLanguageBundle( ).getString( "Add" ) );
        jButton2.setText( Main.getInstance( ).getLanguageBundle( ).getString( "Done" ) );
        jButton3.setText( Main.getInstance( ).getLanguageBundle( ).getString( "Remove" ) );
        setVisible( true );
        return true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Interactive Windows");

        jList1.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setLabel("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton3.setLabel("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton2.setText("Done");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // add button
        String inputValue = JOptionPane.showInputDialog( rootPane, Main.getInstance( ).getLanguageBundle( ).getString( "InteractiveWindowHintMessage" ), Main.getInstance( ).getLanguageBundle( ).getString( "AddInteractiveWindow" ), JOptionPane.QUESTION_MESSAGE ).trim( );
        if( !inputValue.isEmpty( ) && !inputValue.contains( "/" ) )
        {
            listData.add( inputValue );
            jList1.setListData( listData.toArray( ) );
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        // delete button
        if( jList1.getSelectedIndex() != -1 )
        {
            listData.remove( jList1.getSelectedIndex( ) );
            jList1.setListData( listData.toArray( ) );
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        // done button
        try
        {
            FileOutputStream output = new FileOutputStream( configFile );
            try
            {
                Main.getInstance( ).getProperties( ).setProperty( "InteractiveWindows", listData.toString( ).replace( "[", "" ).replace( "]", "" ).replace( ", ", "/" ) );
                Main.getInstance( ).getProperties( ).store( output, "Shimeji-ee Configuration Options" );
            }
            finally
            {
                output.close( );
            }
        }
        catch( Exception e )
        {
            // Doesn't matter at all
        }
        dispose( );
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main( String args[] )
    {
        java.awt.EventQueue.invokeLater( new Runnable()
        {
            public void run()
            {
                new WindowsInteractiveWindowForm(new javax.swing.JFrame(), true ).display( );
                System.exit( 0 );
            }
        } );
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
