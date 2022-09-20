package com.vapps.pdfflashcards.fragments.mainfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.vapps.pdfflashcards.adapter.CardsAdapter
import com.vapps.pdfflashcards.data.DeckDatabase
import com.vapps.pdfflashcards.databinding.FragmentDecksBinding
import com.vapps.pdfflashcards.fragments.quickfragments.NewDeckDialogFragment
import com.vapps.pdfflashcards.viewmodel.DecksViewModelFactory
import com.vapps.pdfflashcards.viewmodel.DecksViewmodel

//This fragment is the main view of this app
//All the created decks will be displayed here
class DecksFragment : Fragment() {
    private var _binding: FragmentDecksBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DecksViewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDecksBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = DeckDatabase.getInstance(application).deckDao
        val viewModelFactory = DecksViewModelFactory(dao)
        viewModel = ViewModelProvider(this, viewModelFactory)[DecksViewmodel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        val adapter = CardsAdapter()
        binding.decksRecyclerView.adapter = adapter


        viewModel.newDeckName.observe(viewLifecycleOwner) {
            viewModel.addDeck()
        }

        childFragmentManager.setFragmentResultListener("createDeck", this) {
                _, bundle ->
            val name = bundle.getString("deckName")
            viewModel.newDeckName.value = name
        }

        binding.addDecksFab.setOnClickListener {
            val dialog = NewDeckDialogFragment()
            dialog.show(childFragmentManager, "NewDeckDialogFragment")
        }

        viewModel.decks.observe(viewLifecycleOwner) {
            it?.let {
                adapter.data = it
            }
        }

        return view
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