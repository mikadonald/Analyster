
package com.elle.analyster.logic;

import com.elle.analyster.presentation.AnalysterWindow;
import javax.swing.JTable;

/**
 * Tab
 * This class is used to create a tab object.
 * This object contains all the components of the tab on Analyster.
 * Each tab may have its own attributes and that is what this class
 * is for.
 * @author Carlos Igreja
 * @since  June 25, 2015
 */
public class Tab implements ITableConstants{

    // attributes
    private String tableName;                    // name of the JTable
    private JTable table;                        // the JTable on the tab
    private TableFilter filter;                  // filter used for the table
    private float[] colWidthPercent;             // column width for each column
    private int totalRecords;                    // total records in table model
    private int recordsShown;                    // number of records shown on table
    private String[] tableColNames;              // column header names
    private String[] searchFields;               // search combobox options
    private ColumnPopupMenu ColumnPopupMenu;     // column filter pop up menu
    
    // these menu items are enabled differently for each tab
    private boolean activateRecordMenuItemEnabled; // enables activate record menu item
    private boolean archiveRecordMenuItemEnabled;  // enables archive record menu item
    private boolean addRecordsBtnVisible;          // sets the add records button visible

    
    /**
     * CONSTRUCTOR
     * Tab
     * This is used if no table is ready such as before initComponents of a frame.
     */
    public Tab() {
        tableName = "";
        table = new JTable();
        totalRecords = 0;
        recordsShown = 0;
        activateRecordMenuItemEnabled = false;
        archiveRecordMenuItemEnabled = false;
        addRecordsBtnVisible = false;
    }
    
    /**
     * CONSTRUCTOR
     * This would be the ideal constructor, but there are issues with 
     * the initcomponents in Analyster so the tab must be initialized first
     * then the table can be added
     * @param table 
     */
    public Tab(JTable table) {
        tableName = "";
        this.table = table;
        totalRecords = 0;
        recordsShown = 0;
        filter = new TableFilter(table);
        ColumnPopupMenu = new ColumnPopupMenu(filter);
        
        // store the column names for the table
        for (int i = 0; i < table.getColumnCount(); i++) 
            tableColNames[i] = table.getColumnName(i);
    }
    
    /**************************************************************************
     ********************** Setters & Getters *********************************
     **************************************************************************/

    
    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public TableFilter getFilter() {
        return filter;
    }

    public void setFilter(TableFilter filter) {
        this.filter = filter;
    }

    public float[] getColWidthPercent() {
        return colWidthPercent;
    }

    public void setColWidthPercent(float[] colWidthPercent) {
        this.colWidthPercent = colWidthPercent;
    }
    
    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getRecordsShown() {
        return getTable().getRowCount();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isActivateRecordMenuItemEnabled() {
        return activateRecordMenuItemEnabled;
    }

    public void setActivateRecordMenuItemEnabled(boolean activateRecordMenuItemEnabled) {
        this.activateRecordMenuItemEnabled = activateRecordMenuItemEnabled;
    }

    public boolean isArchiveRecordMenuItemEnabled() {
        return archiveRecordMenuItemEnabled;
    }

    public void setArchiveRecordMenuItemEnabled(boolean archiveRecordMenuItemEnabled) {
        this.archiveRecordMenuItemEnabled = archiveRecordMenuItemEnabled;
    }

    public String[] getTableColNames() {
        return tableColNames;
    }

    public void setTableColNames(String[] tableColNames) {
        this.tableColNames = tableColNames;
    }
    
    public void setTableColNames(JTable table) {
        tableColNames = new String[table.getColumnCount()];
        for (int i = 0; i < table.getColumnCount(); i++) 
            tableColNames[i] = table.getColumnName(i);
    }

    public String[] getSearchFields() {
        return searchFields;
    }

    public void setSearchFields(String[] searchFields) {
        this.searchFields = searchFields;
    }

    public boolean isAddRecordsBtnVisible() {
        return addRecordsBtnVisible;
    }

    public void setAddRecordsBtnVisible(boolean addRecordsBtnVisible) {
        this.addRecordsBtnVisible = addRecordsBtnVisible;
    }

    public ColumnPopupMenu getColumnPopupMenu() {
        return ColumnPopupMenu;
    }

    public void setColumnPopupMenu(ColumnPopupMenu ColumnPopupMenu) {
        this.ColumnPopupMenu = ColumnPopupMenu;
    }
    
    

    /**************************************************************************
     *************************** Methods **************************************
     **************************************************************************/
    
    /**
     * This method subtracts an amount from the totalRecords value
     * This is used when records are deleted to update the totalRecords value
     * @param amountOfRecordsDeleted 
     */
    public void subtractFromTotalRowCount(int amountOfRecordsDeleted) {
        totalRecords = totalRecords - amountOfRecordsDeleted;
    }
    
    /**
     * This method subtracts an amount from the totalRecords value
     * This is used when records are deleted to update the totalRecords value
     * @param amountOfRecordsDeleted 
     */
    public void addToTotalRowCount(int amountOfRecordsAdded) {
        totalRecords = totalRecords + amountOfRecordsAdded;
    }
    
    /**
     * This method returns a string that displays the records.
     * @return String This returns a string that has the records for both total and shown
     */
    public String getRecordsLabel(){
        
        String output;
        
        switch (getTableName()) {
            case ASSIGNMENTS_TABLE_NAME:
                output = "<html><pre>"
                       + "          Number of records shown: " + getRecordsShown() 
                  + "<br/> Number of records in Assignments: " + getTotalRecords()
                     + "</pre></html>";
                break;
            case REPORTS_TABLE_NAME:
                output = "<html><pre>"
                       + "      Number of records shown: " + getRecordsShown() 
                  + "<br/> Number of records in Reports: " + getTotalRecords() 
                     + "</pre></html>";
                break;
            case ARCHIVE_TABLE_NAME:
                output = "<html><pre>"
                       + "      Number of records shown: " + getRecordsShown() 
                  + "<br/> Number of records in Archive: " + getTotalRecords() 
                     + "</pre></html>";
                break;
            default:
                // this means an invalid table name constant was passed
                // this exception will be handled and thrown here
                // the program will still run and show the stack trace for debugging
                output = "<html><pre>"
                       + "*******ATTENTION*******"
                  + "<br/>Not a valid table name constant entered"
                     + "</pre></html>";
                try {
                    String errorMessage = "ERROR: unknown table";
                    throw new NoSuchFieldException(errorMessage);
                } catch (NoSuchFieldException ex) {
                    ex.printStackTrace();
                    // post to log.txt
                    AnalysterWindow.getInstance().getLogwind().sendMessages(ex.getMessage());
                }
        
                break;
        }
        
        return output;
    }
    
}// end Tab