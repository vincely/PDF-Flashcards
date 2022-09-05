package com.vapps.pdfflashcards.data

// Just testdata to play around before deciding the architecture of database
object TestData {
    val data = listOf<Deck>(
        Deck(1, "Deck1", listOf(
            Card(1, "Deck1Front1", "Deck1Back1"),
            Card(2, "Deck1Front2", "Deck1Back2"),
            Card(3, "Deck1Front3", "Deck1Back3"),
            Card(4, "Deck1Front4", "Deck1Back4")
        )),
        Deck(2, "Deck2", listOf(
            Card(1, "Deck2Front1", "Deck2Back1"),
            Card(2, "Deck2Front2", "Deck2Back2"),
            Card(3, "Deck2Front3", "Deck2Back3"),
            Card(4, "Deck2Front4", "Deck2Back4")
        )),
        Deck(3, "Deck3", listOf(
            Card(1, "Deck3Front1", "Deck3Back1"),
            Card(2, "Deck3Front2", "Deck3Back2"),
            Card(3, "Deck3Front3", "Deck3Back3"),
            Card(4, "Deck3Front4", "Deck3Back4")
        )),
        Deck(4, "Deck4", listOf(
            Card(1, "Deck4Front1", "Deck4Back1"),
            Card(2, "Deck4Front2", "Deck4Back2"),
            Card(3, "Deck4Front3", "Deck4Back3"),
            Card(4, "Deck4Front4", "Deck4Back4")
        ))
    )
}