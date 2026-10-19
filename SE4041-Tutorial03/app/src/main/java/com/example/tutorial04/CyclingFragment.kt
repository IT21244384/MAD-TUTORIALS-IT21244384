package com.example.tutorial04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class CyclingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // The ViewModel is shared with the activity, so it outlives this fragment
        val viewModel = ViewModelProvider(requireActivity()).get(MainActivityData::class.java)

        val rootView = inflater.inflate(R.layout.fragment_cycling, container, false)
        val changeButton: Button = rootView.findViewById(R.id.btnChangeColor)
        val constraintLayout: ViewGroup = rootView.findViewById(R.id.cyclingLayout)

        // Restore the colour remembered earlier (0 = never changed)
        if (viewModel.cyclingBackground != 0) {
            constraintLayout.setBackgroundResource(viewModel.cyclingBackground)
        }

        changeButton.setOnClickListener {
            // First click -> color1, then alternate color2 / color1
            viewModel.cyclingBackground =
                if (viewModel.cyclingBackground == R.color.color1) R.color.color2 else R.color.color1
            constraintLayout.setBackgroundResource(viewModel.cyclingBackground)
        }
        return rootView
    }
}
