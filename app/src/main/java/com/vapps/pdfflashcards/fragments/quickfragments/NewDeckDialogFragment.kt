package com.vapps.pdfflashcards.fragments.quickfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.vapps.pdfflashcards.databinding.FragmentNewDeckDialogBinding


class NewDeckDialogFragment : DialogFragment() {

    private var _binding: FragmentNewDeckDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //forbid cancel by clicking outside of dialog
        isCancelable = false

        _binding = FragmentNewDeckDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        val textInput = binding.deckInput
        val cancelButton = binding.dialogCancelButton
        val createButton = binding.dialogCreateButton

        cancelButton.setOnClickListener {
            dismiss()
        }

        createButton.setOnClickListener {
            val editText = textInput.editText?.text.toString()
            if (editText != "" && editText != "null") {
                setFragmentResult("createDeck", bundleOf("deckName" to editText))
                dismiss()
            }
        }

        return view
    }
}
