package com.vapps.pdfflashcards

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.vapps.pdfflashcards.databinding.FragmentNewDeckDialogBinding
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
                    Toast.makeText(context, "create deck", Toast.LENGTH_SHORT).show()
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

}