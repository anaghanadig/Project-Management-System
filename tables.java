/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import app.searchbar;
import java.text.MessageFormat;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ANAGHA
 */
public class tables extends javax.swing.JFrame {

    /**
     * Creates new form tables
     */
    public tables() {
        initComponents();


try {
         /*   Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "123456");
            Statement stmt = con.createStatement();

            // Join the 'studentroject', 'batch', and 'mentor' tables using a SQL query
            String sql = "SELECT studentroject.project_id, studentroject.domain, studentroject.type, studentroject.semester, "
                    + "studentroject.link, studentroject.project_name, studentroject.review, studentroject.batch_id, "
                    + "batch.year, batch.numstu, batch.status, "
                    + "mentor.mentor_id, mentor.mentor_name "
                    + "FROM studentroject "
                    + "LEFT JOIN batch ON studentroject.batch_id = batch.batch_id "
                    + "LEFT JOIN mentor ON studentroject.project_id = mentor.project_id";

            ResultSet rs = stmt.executeQuery(sql);

            DefaultTableModel tblModel = new DefaultTableModel();

            // Add columns to the model
            String[] columns = {"Project ID", "Domain", "Type", "Semester", "Link", "Project Name", "Review", "Batch ID", "Year", "Num Students", "Status", "Mentor ID", "Mentor Name"};
            tblModel.setColumnIdentifiers(columns);

            // Clear existing rows
            tblModel.setRowCount(0);

            while (rs.next()) {
                // Retrieve columns from the result set
                int projectID = rs.getInt("project_id");
                String domain = rs.getString("domain");
                String type = rs.getString("type");
                int semester = rs.getInt("semester");
                String link = rs.getString("link");
                String projectName = rs.getString("project_name");
                int review = rs.getInt("review");
                int batchID = rs.getInt("batch_id");
                int year = rs.getInt("year");
                int numStudents = rs.getInt("numstu");
                String status = rs.getString("status");
                int mentorID = rs.getInt("mentor_id");
                String mentorName = rs.getString("mentor_name");

                // Assuming jTable3 is your JTable instance
                Object[] rowData = {projectID, domain, type, semester, link, projectName, review, batchID, year, numStudents, status, mentorID, mentorName};
                tblModel.addRow(rowData);
            }

            // Set the model to your JTable
            table4.setModel(tblModel);

            con.close();*/
         Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "123456");
Statement stmt = con.createStatement();

// Join the 'studentroject', 'batch', 'mentor', and 'groupsclg' tables using a SQL query
String sql = "SELECT studentroject.project_id, studentroject.domain, studentroject.type, studentroject.semester, "
        + "studentroject.link, studentroject.project_name, studentroject.review, studentroject.batch_id, "
        + "batch.year, batch.numstu, batch.status, "
        + "mentor.mentor_id, mentor.mentor_name, "
        + "groupsclg.g_id, groupsclg.snum, groupsclg.g_names, groupsclg.leader, groupsclg.contact "
        + "FROM studentroject "
        + "LEFT JOIN batch ON studentroject.batch_id = batch.batch_id "
        + "LEFT JOIN mentor ON studentroject.project_id = mentor.project_id "
        + "LEFT JOIN groupsclg ON studentroject.project_id = groupsclg.project_id";

ResultSet rs = stmt.executeQuery(sql);

DefaultTableModel tblModel = new DefaultTableModel();

// Add columns to the model
String[] columns = {"Project ID", "Domain", "Type", "Semester", "Link", "Project Name", "Review", "Batch ID",
                    "Year", "Num Students", "Status", "Mentor ID", "Mentor Name",
                    "Group ID", "Group Students", "Group Names", "Group Leader", "Group Contact"};
tblModel.setColumnIdentifiers(columns);

// Clear existing rows
tblModel.setRowCount(0);

while (rs.next()) {
    // Retrieve columns from the result set
    int projectID = rs.getInt("project_id");
    String domain = rs.getString("domain");
    String type = rs.getString("type");
    int semester = rs.getInt("semester");
    String link = rs.getString("link");
    String projectName = rs.getString("project_name");
    int review = rs.getInt("review");
    int batchID = rs.getInt("batch_id");
    int year = rs.getInt("year");
    int numStudents = rs.getInt("numstu");
    String status = rs.getString("status");
    int mentorID = rs.getInt("mentor_id");
    String mentorName = rs.getString("mentor_name");

    int groupID = rs.getInt("g_id");
    int groupStudents = rs.getInt("snum");
    String groupNames = rs.getString("g_names");
  //  String groupNames = "<html>" + rs.getString("g_names").replace(",", "<br>") + "</html>";
    String groupLeader = rs.getString("leader");
    long groupContact = rs.getLong("contact");

    // Assuming jTable3 is your JTable instance
    Object[] rowData = {projectID, domain, type, semester, link, projectName, review, batchID,
                        year, numStudents, status, mentorID, mentorName,
                        groupID, groupStudents, groupNames, groupLeader, groupContact};
    tblModel.addRow(rowData);
    TableColumnModel ColumnModel =table4.getColumnModel();
                ColumnModel.getColumn(0).setPreferredWidth(2);
                ColumnModel.getColumn(1).setPreferredWidth(1);
                ColumnModel.getColumn(3).setPreferredWidth(100);
                ColumnModel.getColumn(5).setPreferredWidth(20);
                ColumnModel.getColumn(4).setPreferredWidth(80);
                ColumnModel.getColumn(2).setPreferredWidth(280);
    
}

// Set the model to your JTable
table4.setModel(tblModel);

// Close the connection
con.close();

        } catch (Exception e) {
            e.printStackTrace(); // Print the exception for debugging
        }
    






    }
    
    private ResultSet executeQuery(String sql) throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "123456");
    Statement stmt = con.createStatement();
    return stmt.executeQuery(sql);
}
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BB1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        TEXT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        BB1.setBackground(new java.awt.Color(255, 204, 255));
        BB1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        BB1.setText("SEARCH");
        BB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BB1MouseClicked(evt);
            }
        });
        BB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BB1ActionPerformed(evt);
            }
        });

        table4.setBackground(new java.awt.Color(255, 204, 255));
        table4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        table4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        table4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PROJECT_ID", "DOMAIN", "TYPE", "SEMESTER", "LINK", "PROJECT_NAME", "REVIEW", "BATCH_ID", "YEAR", "NUM STUDENTNTS", "STATUS", "MENTOR_ID", "MENTOR ANME", "GROUP_ID", "STUDENTS", "NAMES", "LEADER", "CONTACT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table4.setAlignmentX(2.0F);
        table4.setAlignmentY(1.0F);
        table4.setIntercellSpacing(new java.awt.Dimension(4, 1));
        table4.setRowHeight(30);
        table4.setShowHorizontalLines(true);
        table4.setShowVerticalLines(true);
        jScrollPane4.setViewportView(table4);
        if (table4.getColumnModel().getColumnCount() > 0) {
            table4.getColumnModel().getColumn(0).setResizable(false);
            table4.getColumnModel().getColumn(0).setPreferredWidth(20);
            table4.getColumnModel().getColumn(0).setHeaderValue("PROJECT_ID");
            table4.getColumnModel().getColumn(1).setResizable(false);
            table4.getColumnModel().getColumn(1).setHeaderValue("DOMAIN");
            table4.getColumnModel().getColumn(2).setResizable(false);
            table4.getColumnModel().getColumn(2).setHeaderValue("TYPE");
            table4.getColumnModel().getColumn(3).setResizable(false);
            table4.getColumnModel().getColumn(3).setHeaderValue("SEMESTER");
            table4.getColumnModel().getColumn(4).setResizable(false);
            table4.getColumnModel().getColumn(4).setHeaderValue("LINK");
            table4.getColumnModel().getColumn(5).setResizable(false);
            table4.getColumnModel().getColumn(5).setHeaderValue("PROJECT_NAME");
            table4.getColumnModel().getColumn(6).setResizable(false);
            table4.getColumnModel().getColumn(6).setHeaderValue("REVIEW");
            table4.getColumnModel().getColumn(7).setResizable(false);
            table4.getColumnModel().getColumn(7).setPreferredWidth(20);
            table4.getColumnModel().getColumn(7).setHeaderValue("BATCH_ID");
            table4.getColumnModel().getColumn(8).setResizable(false);
            table4.getColumnModel().getColumn(8).setHeaderValue("YEAR");
            table4.getColumnModel().getColumn(9).setResizable(false);
            table4.getColumnModel().getColumn(9).setHeaderValue("NUM STUDENTNTS");
            table4.getColumnModel().getColumn(10).setResizable(false);
            table4.getColumnModel().getColumn(10).setHeaderValue("STATUS");
            table4.getColumnModel().getColumn(11).setResizable(false);
            table4.getColumnModel().getColumn(11).setHeaderValue("MENTOR_ID");
            table4.getColumnModel().getColumn(12).setResizable(false);
            table4.getColumnModel().getColumn(12).setHeaderValue("MENTOR ANME");
            table4.getColumnModel().getColumn(13).setResizable(false);
            table4.getColumnModel().getColumn(13).setHeaderValue("GROUP_ID");
            table4.getColumnModel().getColumn(14).setResizable(false);
            table4.getColumnModel().getColumn(14).setHeaderValue("STUDENTS");
            table4.getColumnModel().getColumn(15).setResizable(false);
            table4.getColumnModel().getColumn(15).setHeaderValue("NAMES");
            table4.getColumnModel().getColumn(16).setResizable(false);
            table4.getColumnModel().getColumn(16).setHeaderValue("LEADER");
            table4.getColumnModel().getColumn(17).setResizable(false);
            table4.getColumnModel().getColumn(17).setHeaderValue("CONTACT");
        }

        TEXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEXTActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ANAGHA\\Downloads\\MINIPROJECT1\\NEW HOME.png")); // NOI18N
        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(BB1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jButton1)
                        .addGap(52, 52, 52)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 271, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BB1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(78, 78, 78)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void TEXTActionPerformed(java.awt.event.ActionEvent evt) {                                     
      // TODO add your handling code here:
                              // TODO add your handling code here:
    }                                    

    private void BB1MouseClicked(java.awt.event.MouseEvent evt) {                                 
DefaultTableModel model=(DefaultTableModel) table4.getModel();
 TableRowSorter<DefaultTableModel> obj1=new TableRowSorter<>(model);
 table4.setRowSorter(obj1);
 obj1.setRowFilter(RowFilter.regexFilter("(?i)"+TEXT.getText())); 
 // TODO add your handling code here:
    }                                

    private void BB1ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
    }                                   

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
this.dispose();
searchbar search=new searchbar();
search.setVisible(true);        // TODO add your handling code here:
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
 MessageFormat header = new  MessageFormat("DEPARTMENT PROJECT MANAGEMENT SYSTEM ");
        MessageFormat footer = new  MessageFormat("ISE DEPARTMENT");
        
        try{
         table4.print(JTable.PrintMode.FIT_WIDTH,header,footer);
            // jTable1.print(JTable.PrintMode.NORMAL,header,footer);
        }catch(Exception e){
            
        }            // TODO add your handling code here:
    }                                        

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
            java.util.logging.Logger.getLogger(tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BB1;
    public static javax.swing.JTextField TEXT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable table4;
    // End of variables declaration                   
}
