package com.example.a2zadaca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.a2zadaca.ui.main.PageViewModel
import com.example.a2zadaca.ui.main.Person

class InputFragment : Fragment(R.layout.fragment_input) {
    private lateinit var addButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var surnameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var oibEditText: EditText
    private lateinit var viewModel: PageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)
        addButton = view.findViewById(R.id.add_button)
        nameEditText = view.findViewById(R.id.editTextName)
        surnameEditText = view.findViewById(R.id.editTextSurname)
        ageEditText = view.findViewById(R.id.editTextAge)
        oibEditText = view.findViewById(R.id.editTextOIB)
        viewModel = ViewModelProvider(requireActivity())[PageViewModel::class.java]
        addButton.setOnClickListener {
            viewModel.addPerson(Person(
                nameEditText.text.toString(),
                surnameEditText.text.toString(),
                ageEditText.text.toString(),
                oibEditText.text.toString(),
            ))
            nameEditText.text.clear()
            surnameEditText.text.clear()
            ageEditText.text.clear()
            oibEditText.text.clear()
        }
        return view
    }
}
