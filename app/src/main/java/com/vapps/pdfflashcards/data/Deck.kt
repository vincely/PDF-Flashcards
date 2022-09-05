package com.vapps.pdfflashcards.data

data class Deck(
    val deckId: Long,
    val deckName: String,
    val cardList: List<Card>) {

    val deckSize get() = cardList.size
}
