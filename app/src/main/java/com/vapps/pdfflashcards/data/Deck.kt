package com.vapps.pdfflashcards.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deck_table")
data class Deck(
    @PrimaryKey(autoGenerate = true)
    var deckId: Long = 0L,
    @ColumnInfo(name = "deck_name")
    var deckName: String = ""
)
