package com.example.labsheet03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        val answer = arguments?.getDouble(ARG_ANSWER) ?: 0.0
        view.findViewById<TextView>(R.id.tvAnswer).text = "Answer: $answer"

        view.findViewById<Button>(R.id.btnBack).setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return view
    }

    companion object {
        private const val ARG_ANSWER = "answer"
        fun newInstance(answer: Double) = ResultFragment().apply {
            arguments = Bundle().apply { putDouble(ARG_ANSWER, answer) }
        }
    }
}
