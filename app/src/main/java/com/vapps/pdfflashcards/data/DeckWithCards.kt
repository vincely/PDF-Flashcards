package com.vapps.pdfflashcards.data

import androidx.room.Embedded
import androidx.room.Relation

data class DeckWithCards(
    @Embedded val deck: Deck,
    @Relation(
        parentColumn = "deckId",
        entityColumn = "deckUniqueId"
    )
    val cards: List<Card>
) {
}