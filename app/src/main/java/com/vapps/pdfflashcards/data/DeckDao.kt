package com.vapps.pdfflashcards.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DeckDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeck(deck: Deck)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: Card)

    @Transaction
    @Query("SELECT * FROM deck_table")
    fun getDeckWithCards(): LiveData<List<DeckWithCards>>

}