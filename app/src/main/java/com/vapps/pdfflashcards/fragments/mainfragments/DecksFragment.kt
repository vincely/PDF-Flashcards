package com.vapps.pdfflashcards.fragments.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vapps.pdfflashcards.adapter.CardsAdapter
import com.vapps.pdfflashcards.data.Deck
import com.vapps.pdfflashcards.databinding.FragmentDecksBinding
import com.vapps.pdfflashcards.fragments.quickfragments.NewDeckBottomSheetFragment
import com.vapps.pdfflashcards.viewmodel.DecksViewmodel

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

        binding.addDecksFab.setOnClickListener {
            val modalBottomSheet = NewDeckBottomSheetFragment()
            modalBottomSheet.show(parentFragmentManager, NewDeckBottomSheetFragment.TAG)
        }
        val viewModel = ViewModelProvider(this)[DecksViewmodel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.decksRecyclerView.adapter = CardsAdapter(viewModel.decks.value ?: listOf<Deck>())


        return view
    }



}