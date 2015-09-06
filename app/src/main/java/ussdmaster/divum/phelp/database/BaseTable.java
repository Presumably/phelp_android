package ussdmaster.divum.phelp.database;

public abstract class BaseTable {

    public static final String CREATE_TABLE = "CREATE TABLE ";

    protected static final String TEXT_TYPE = " TEXT ";
    protected static final String INTEGER_TYPE = " INTEGER ";
    protected static final String AUTOINCREMENT = " AUTOINCREMENT ";
    protected static final String REAL = " REAL ";
    protected static final String COMMA_SEP = ",";

    protected static final String PRIMARY_KEY = " PRIMARY KEY ";
    protected static final String FOREIGN_KEY = " FOREIGN KEY ( ";
    protected static final String REFERENCES = " ) REFERENCES ";


}