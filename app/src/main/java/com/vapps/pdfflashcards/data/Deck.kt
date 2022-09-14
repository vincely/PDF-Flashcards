package com.vapps.pdfflashcards.data

data class Deck(val deckId: Long, var deckName: String){
    var cardList = mutableListOf<Card>()
    val deckSize get() = cardList.size
}
