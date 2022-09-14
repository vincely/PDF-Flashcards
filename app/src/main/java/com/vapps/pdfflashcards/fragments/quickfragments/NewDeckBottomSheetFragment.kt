package com.vapps.pdfflashcards.fragments.quickfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vapps.pdfflashcards.R
import com.vapps.pdfflashcards.adapter.BottomSheetAdapter
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

        val botSheetItems = resources.getStringArray(R.array.bot_sheet_items).toList()
        binding.botSheetRecyclerView.adapter = BottomSheetAdapter(botSheetItems) {
            when (it) {
                resources.getString(R.string.bottom_sheet_item_new) -> {
                    val dialog = NewDeckDialogFragment()
                    dialog.show(parentFragmentManager, "NewDeckDialogFragment")
                    dismiss()
                }
                else -> Toast.makeText(context, "Function not implemented yet", Toast.LENGTH_SHORT).show()
            }

        }


        /*binding.createDeckItem.setOnClickListener {
            val dialog = NewDeckDialogFragment()
            dialog.show(parentFragmentManager, "NewDeckDialogFragment")
            dismiss()
        }*/

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