package com.vapps.pdfflashcards.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Deck::class, Card::class], version = 1, exportSchema = false)
abstract class DeckDatabase : RoomDatabase() {
    abstract val deckDao: DeckDao

    companion object {
        @Volatile
        private var INSTANCE: DeckDatabase? = null

        fun getInstance(context: Context): DeckDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DeckDatabase::class.java,
                        "deck_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}