package com.vapps.pdfflashcards.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vapps.pdfflashcards.data.Deck
import com.vapps.pdfflashcards.data.DeckDao
import com.vapps.pdfflashcards.data.DeckWithCards
import kotlinx.coroutines.launch

class DecksViewmodel(val dao: DeckDao) : ViewModel() {

    var newDeckName = ""
    var decks = dao.getDeckWithCards()

    fun addDeck() {
        viewModelScope.launch {
            val deck = Deck()
            deck.deckName = newDeckName
            dao.insertDeck(deck)

        }
    }
}