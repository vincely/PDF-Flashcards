package com.vapps.pdfflashcards.fragments.quickfragments

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction
import com.vapps.pdfflashcards.MainActivity
import com.vapps.pdfflashcards.R
import com.vapps.pdfflashcards.databinding.FragmentNewDeckDialogBinding
import com.vapps.pdfflashcards.fragments.mainfragments.EditDeckFragment
import java.lang.IllegalStateException


class NewDeckDialogFragment : DialogFragment() {

    private var _binding: FragmentNewDeckDialogBinding? = null
    val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {

            // 1. Instantiate an AlertDialog.Builder with its constructor
            val builder = AlertDialog.Builder(it)

            // getting layoutinflater
            val inflater = requireActivity().layoutInflater

            _binding = FragmentNewDeckDialogBinding.inflate(inflater, null, false)
            builder.setView(binding.root)
                .setPositiveButton(R.string.add_deck, DialogInterface.OnClickListener {
                        dialog, id ->
                    //(activity as MainActivity).showEditDeck()
                    showEditDeck()
                })
                .setNegativeButton(R.string.cancel_add_deck, DialogInterface.OnClickListener {
                    dialog, id ->
                    Toast.makeText(context, "cancelled", Toast.LENGTH_SHORT).show()
                })

            // 2. Chain together various setter methods to set the dialog characteristics
            builder.setTitle(R.string.new_deck_dialog_title)

            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")

    }

    fun showEditDeck() {
        val editDeckFragment = EditDeckFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction
            .add(android.R.id.content, editDeckFragment)
            .addToBackStack(null)
            .commit()
    }



}