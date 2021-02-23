package edu.aku.abdulsajid.uenMnch.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import edu.aku.abdulsajid.uenMnch.core.MainApp;
import edu.aku.abdulsajid.uenMnch.data.DAO.FormsDAO;
import edu.aku.abdulsajid.uenMnch.data.DAO.GetFncDAO;
import edu.aku.abdulsajid.uenMnch.data.entities.District;
import edu.aku.abdulsajid.uenMnch.data.entities.FacilityProvider;
import edu.aku.abdulsajid.uenMnch.data.entities.Forms;
import edu.aku.abdulsajid.uenMnch.data.entities.Tehsil;
import edu.aku.abdulsajid.uenMnch.data.entities.UCs;
import edu.aku.abdulsajid.uenMnch.data.entities.Users;

@Database(entities = {Users.class, Forms.class, District.class,
        FacilityProvider.class, Tehsil.class, UCs.class}, version = AppDatabase.Sub_DBConnection.DATABASE_VERSION, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {

    /*@VisibleForTesting
    public static final String DATABASE_NAME = "wfppishincr.db";
    // Alter table for Database Update
    static final Migration MIGRATION_v2_v3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE forms "
                    + " ADD COLUMN last_update TEXT");
        }
    };*/

    private static AppDatabase sInstance;

    public static AppDatabase getDatabase(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context, AppDatabase.class, Sub_DBConnection.DATABASE_NAME)
//                            .addMigrations(MIGRATION_v1_v2, MIGRATION_v2_v3)
                            .setJournalMode(JournalMode.TRUNCATE)
                            .build();
                }
            }
        }
        return sInstance;
    }

    public abstract FormsDAO formsDao();

    public abstract GetFncDAO getFncDao();

    public interface Sub_DBConnection {
        String DATABASE_NAME = MainApp.AppName;
        int DATABASE_VERSION = 1;
        String TABLE_FORMS = "forms";
        String TABLE_USERS = "users";
        String TABLE_DISTRICT = "district";
        String TABLE_FACILITY_PROVIDER = "facility_provider";
        String TABLE_TEHSIL = "tehsil";
        String TABLE_UCs = "ucs";
    }
}
