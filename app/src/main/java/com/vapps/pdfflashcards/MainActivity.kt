package com.vapps.pdfflashcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.vapps.pdfflashcards.databinding.ActivityMainBinding
import com.vapps.pdfflashcards.fragments.mainfragments.DecksFragment
import com.vapps.pdfflashcards.fragments.mainfragments.EditDeckFragment
import com.vapps.pdfflashcards.fragments.quickfragments.NewDeckDialogFragment


class MainActivity : AppCompatActivity(), NewDeckDialogFragment.NewDeckDialogListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
    }

    fun showEditDeck() {
        val editDeckFragment = EditDeckFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction
            .add(android.R.id.content, editDeckFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onDialogPositiveClick(dialog: NewDeckDialogFragment) {
        val d = dialog.dialog?.findViewById<TextInputLayout>(R.id.deck_input)
        //Snackbar.make(binding.root, dialog.title, Snackbar.LENGTH_SHORT).show()
        //showEditDeck()
        val fragManager = supportFragmentManager
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val deckFragment = navHostFragment?.childFragmentManager?.fragments?.get(0) as DecksFragment
        deckFragment.testAddDeck(dialog.title)
    }
}