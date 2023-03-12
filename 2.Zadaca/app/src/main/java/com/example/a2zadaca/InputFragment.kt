package com.example.a2zadaca

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a2zadaca.data.Car
import com.example.a2zadaca.data.EngineType
import com.example.a2zadaca.databinding.FragmentInputBinding
import com.example.a2zadaca.ui.main.PageViewModel

class InputFragment : Fragment(R.layout.fragment_input) {
    private lateinit var binding: FragmentInputBinding
    private lateinit var viewModel: PageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentInputBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity())[PageViewModel::class.java]
        binding.engineSpinner.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, EngineType.values())
        binding.addButton.setOnClickListener {
            viewModel.addCar(
                Car(
                binding.editTextManufacturer.text.toString(),
                binding.editTextModel.text.toString(),
                binding.editTextAge.text.toString(),
                binding.editTextEnginePower.text.toString(),
                    binding.engineSpinner.selectedItem as EngineType
            )
            )
            binding.editTextManufacturer.text.clear()
            binding.editTextModel.text.clear()
            binding.editTextAge.text.clear()
            binding.editTextEnginePower.text.clear()
            binding.engineSpinner.setSelection(0)
        }
        return binding.root
    }
}
