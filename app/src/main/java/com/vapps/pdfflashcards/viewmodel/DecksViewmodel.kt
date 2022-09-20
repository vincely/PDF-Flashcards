package com.vapps.pdfflashcards.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vapps.pdfflashcards.data.Deck
import com.vapps.pdfflashcards.data.DeckDao
import kotlinx.coroutines.launch

class DecksViewmodel(private val dao: DeckDao) : ViewModel() {

    val newDeckName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    var decks = dao.getDeckWithCards()

    fun addDeck() {
        viewModelScope.launch {
            val deck = Deck()
            deck.deckName = newDeckName.value.toString()
            dao.insertDeck(deck)
        }
    }
}