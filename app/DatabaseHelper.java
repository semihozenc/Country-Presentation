public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "my_notes.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NOTE_CREATE =
            "CREATE TABLE " + TablesInfo.NoteEntry.TABLE_NAME + " (" +
                    TablesInfo.NoteEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TablesInfo.NoteEntry.COLUMN_NOTE + " TEXT, " +
                    TablesInfo.NoteEntry.COLUMN_CREATE_DATE + " TEXT DEFAULT CURRENT_TIMESTAMP" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_NOTE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TablesInfo.NoteEntry.TABLE_NAME);

        onCreate(db);
    }
}