package com.vapps.pdfflashcards.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Card(
    @PrimaryKey(autoGenerate = true)
    val cardId: Long,
    val deckUniqueId: Long,
    val front: String,
    val back: String
)
