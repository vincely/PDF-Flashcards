package com.vapps.pdfflashcards.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vapps.pdfflashcards.data.Deck

class DecksViewmodel : ViewModel() {

    var _decks = MutableLiveData<List<Deck>>()
    val decks: LiveData<List<Deck>> get() = _decks
    val deckIds: MutableList<Long> = mutableListOf()

    // Temporarily working with object in ViewModel
    // Will be replaced with database connection later on
    fun createDeck(name: String){
        val tempList = mutableListOf<Deck>()
        decks.value?.let {
            tempList.addAll(it)
        }
        if(deckIds.isEmpty()) deckIds.add(0L) else deckIds.add(deckIds.size.toLong())
        val id = deckIds.last()
        val newDeck = Deck(id, name)
        tempList.add(newDeck)
        _decks.value = tempList
    }

}