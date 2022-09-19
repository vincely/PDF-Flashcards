package com.vapps.pdfflashcards.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vapps.pdfflashcards.data.DeckDao

class DecksViewModelFactory(private val dao: DeckDao): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DecksViewmodel::class.java)) {
            return DecksViewmodel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}