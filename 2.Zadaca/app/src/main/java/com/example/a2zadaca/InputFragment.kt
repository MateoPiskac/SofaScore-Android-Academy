package com.example.a2zadaca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.a2zadaca.databinding.FragmentInputBinding
import com.example.a2zadaca.ui.main.PageViewModel
import com.example.a2zadaca.ui.main.Person

class InputFragment : Fragment(R.layout.fragment_input) {
    private lateinit var binding: FragmentInputBinding
    private lateinit var viewModel: PageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentInputBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity())[PageViewModel::class.java]
        binding.addButton.setOnClickListener {
            viewModel.addPerson(Person(
                binding.editTextName.text.toString(),
                binding.editTextSurname.text.toString(),
                binding.editTextAge.text.toString(),
                binding.editTextOIB.text.toString(),
            ))
            binding.editTextName.text.clear()
            binding.editTextSurname.text.clear()
            binding.editTextAge.text.clear()
            binding.editTextOIB.text.clear()
        }
        return binding.root
    }
}
