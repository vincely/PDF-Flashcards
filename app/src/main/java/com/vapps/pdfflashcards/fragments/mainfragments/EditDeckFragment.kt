package com.vapps.pdfflashcards.fragments.mainfragments

import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.vapps.pdfflashcards.R
import com.vapps.pdfflashcards.databinding.FragmentEditDeckBinding


class EditDeckFragment : DialogFragment() {

    private var _binding: FragmentEditDeckBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditDeckBinding.inflate(inflater, container, false)
        val view = binding.root

        val toolbar = binding.editDeckToolbar
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
        toolbar.setTitle("Title") //Title needs to be retrieved from Deck Object

        return view
    }

    // Adding Menu
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.edit_deck_toolbar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when(menuItem.itemId) {
                    R.id.change_title_item -> {
                        // TODO: create dialog to change deck title
                        true
                    }
                    R.id.edit_deck_action_close -> {
                        dismiss()
                        true
                    }
                    else -> false
                }

            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}