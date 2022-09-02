package com.vapps.pdfflashcards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vapps.pdfflashcards.databinding.FragmentDecksBinding

//This fragment is the main view of this app
//All the created decks will be displayed here
class DecksFragment : Fragment() {
    private var _binding: FragmentDecksBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDecksBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.addDeckFab.setOnClickListener {
            val modalBottomSheet = NewDeckBottomSheetFragment()
            modalBottomSheet.show(parentFragmentManager, NewDeckBottomSheetFragment.TAG)
        }

        return view
    }

}