
package com.elle.analyster.database;

/**
 * CLASS
 * ModifiedData
 * This is to create modified data objects.
 */
public class ModifiedData {

    private String tableName;      // the table name
    private String columnName;     // this should be column name
    private Object value;          // new value
    private int id;                // id of the record
    

    /**
     * CONSTRUCTOR
     * ModifiedData
     * @param tableName
     * @param id
     * @param columnName
     * @param value 
     */
    public ModifiedData(String tableName, String columnName, Object value, int id) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.value = value;
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public Object getValue() {
        return value;
    }
    
    public int getId() {
        return id;
    }
}