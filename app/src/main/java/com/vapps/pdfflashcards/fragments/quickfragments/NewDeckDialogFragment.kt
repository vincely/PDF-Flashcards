package com.vapps.pdfflashcards.fragments.quickfragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction
import com.vapps.pdfflashcards.R
import com.vapps.pdfflashcards.databinding.FragmentNewDeckDialogBinding
import com.vapps.pdfflashcards.fragments.mainfragments.EditDeckFragment
import java.lang.IllegalStateException
import kotlin.ClassCastException


class NewDeckDialogFragment : DialogFragment() {

    private var _binding: FragmentNewDeckDialogBinding? = null
    val binding get() = _binding!!
    lateinit var listener: NewDeckDialogListener
    var title = ""


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        isCancelable = false

        return activity?.let {

            // 1. Instantiate an AlertDialog.Builder with its constructor
            val builder = AlertDialog.Builder(it)

            // getting layoutinflater
            val inflater = requireActivity().layoutInflater

            _binding = FragmentNewDeckDialogBinding.inflate(inflater, null, false)
            builder.setView(binding.root)
                .setPositiveButton(R.string.add_deck, null)
                .setNegativeButton(R.string.cancel_add_deck, null)

            // 2. Chain together various setter methods to set the dialog characteristics
            builder.setTitle(R.string.new_deck_dialog_title)

            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")

    }

    // changing the dialog after instantiation, because custom functionality for the buttons
    // were needed
    override fun onResume() {
        super.onResume()


        //getting the current dialog in the fragment
        val mDialog = dialog as AlertDialog?

        //overriding the clicklistener of the positive button, so it would not dismiss automatically
        //after pressing
        mDialog?.let { it ->
            it.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                var wantToClose = false

                title = binding.deckInput.editText?.text.toString()
                if (title == "") {
                    Toast.makeText(context, "Name required", Toast.LENGTH_SHORT).show()
                } else {
                    wantToClose = true
                    listener.onDialogPositiveClick(this)
                }
                if (wantToClose) {
                    dismiss()
                }
            }
        }
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

    interface NewDeckDialogListener {
        fun onDialogPositiveClick( dialog: NewDeckDialogFragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as NewDeckDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(("$context must implement NewDeckDialogListener"))
        }

    }

}
