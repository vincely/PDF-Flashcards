package com.vapps.pdfflashcards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vapps.pdfflashcards.databinding.FragmentEditDeckBinding


class EditDeckFragment : Fragment() {

    private var _binding: FragmentEditDeckBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_deck, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}