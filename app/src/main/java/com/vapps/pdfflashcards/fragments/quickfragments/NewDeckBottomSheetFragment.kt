package com.vapps.pdfflashcards.fragments.quickfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vapps.pdfflashcards.databinding.FragmentNewDeckBottomSheetBinding


class NewDeckBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding:FragmentNewDeckBottomSheetBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewDeckBottomSheetBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.createDeckItem.setOnClickListener {
            val dialog = NewDeckDialogFragment()
            dialog.show(parentFragmentManager, "NewDeckDialogFragment")
            dismiss()
        }

        return view
    }

    companion object {
        const val TAG = "NewDeckBottomSheet"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}