package ltd.evilcorp.core.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) = db.execSQL(
        "ALTER TABLE contacts ADD COLUMN has_unread_messages INTEGER NOT NULL DEFAULT 0"
    )
}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(db: SupportSQLiteDatabase) = db.execSQL(
        "ALTER TABLE messages ADD COLUMN type INTEGER NOT NULL DEFAULT 0"
    )
}

val MIGRATION_3_4 = object : Migration(3, 4) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("DROP TABLE IF EXISTS 'file_transfers'")
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS 'file_transfers'" +
                "('id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "'public_key' TEXT NOT NULL," +
                "'file_number' INTEGER NOT NULL," +
                "'file_kind' INTEGER NOT NULL," +
                "'file_size' INTEGER NOT NULL," +
                "'file_name' TEXT NOT NULL," +
                "'destination' TEXT NOT NULL," +
                "'outgoing' INTEGER NOT NULL," +
                "'progress' INTEGER NOT NULL)"
        )
    }
}
