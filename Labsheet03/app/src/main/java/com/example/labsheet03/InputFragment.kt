package com.example.labsheet03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        val etNum1 = view.findViewById<EditText>(R.id.etNum1)
        val etNum2 = view.findViewById<EditText>(R.id.etNum2)

        fun getInputs(): Pair<Double, Double>? {
            val a = etNum1.text.toString().trim().toDoubleOrNull()
            val b = etNum2.text.toString().trim().toDoubleOrNull()
            if (a == null || b == null) {
                Toast.makeText(requireContext(), "Enter valid numbers", Toast.LENGTH_SHORT).show()
                return null
            }
            return a to b
        }

        fun goToResult(result: Double) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ResultFragment.newInstance(result))
                .addToBackStack(null)
                .commit()
        }

        view.findViewById<Button>(R.id.btnAdd).setOnClickListener {
            getInputs()?.let { (a, b) -> goToResult(a + b) }
        }
        view.findViewById<Button>(R.id.btnSub).setOnClickListener {
            getInputs()?.let { (a, b) -> goToResult(a - b) }
        }
        view.findViewById<Button>(R.id.btnMul).setOnClickListener {
            getInputs()?.let { (a, b) -> goToResult(a * b) }
        }
        view.findViewById<Button>(R.id.btnDiv).setOnClickListener {
            getInputs()?.let { (a, b) ->
                if (b == 0.0) {
                    Toast.makeText(requireContext(), "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                } else {
                    goToResult(a / b)
                }
            }
        }

        return view
    }
}