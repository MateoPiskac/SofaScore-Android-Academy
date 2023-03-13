package com.example.a2zadaca

import android.os.Bundle
import android.text.InputType.TYPE_CLASS_NUMBER
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a2zadaca.data.Car
import com.example.a2zadaca.data.EngineType
import com.example.a2zadaca.databinding.FragmentInputBinding
import com.example.a2zadaca.ui.main.PageViewModel

class InputFragment : Fragment(R.layout.fragment_input) {
    private lateinit var binding: FragmentInputBinding
    private lateinit var viewModel: PageViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInputBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity())[PageViewModel::class.java]
        binding.engineSpinner.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            EngineType.values()
        )
        when (binding.engineSpinner.selectedItem) {
            EngineType.SELECT -> binding.radioGroup.visibility = GONE
            EngineType.GASOLINE -> binding.radioGroup.visibility = VISIBLE
            EngineType.DIESEL -> binding.radioGroup.visibility = VISIBLE
            EngineType.HYBRID -> binding.radioGroup.visibility = VISIBLE
            EngineType.ELECTRIC -> binding.radioGroup.visibility = GONE
        }
        binding.engineSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (binding.engineSpinner.selectedItem) {
                    EngineType.SELECT -> binding.radioGroup.visibility = GONE
                    EngineType.GASOLINE -> binding.radioGroup.visibility = VISIBLE
                    EngineType.DIESEL -> binding.radioGroup.visibility = VISIBLE
                    EngineType.HYBRID -> binding.radioGroup.visibility = VISIBLE
                    EngineType.ELECTRIC -> binding.radioGroup.visibility = GONE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                binding.radioGroup.visibility = GONE
            }
        }

        binding.addButton.setOnClickListener {
            var errorCheck: Boolean = false
            errorCheck = checkInput(binding.editTextManufacturer)
            errorCheck = checkInput(binding.editTextModel)
            errorCheck = checkInput(binding.editTextAge)
            errorCheck = checkInput(binding.editTextEnginePower)
            errorCheck = checkInput(binding.radioGroup)
            errorCheck = checkInput(binding.engineSpinner)

            if (checkInput(binding.editTextManufacturer) && checkInput(binding.editTextModel) && checkInput(
                    binding.editTextAge
                ) && checkInput(binding.editTextEnginePower) && checkInput(binding.radioGroup) && checkInput(
                    binding.engineSpinner
                )
            ) {
                viewModel.addCar(
                    Car(
                        binding.editTextManufacturer.text.toString(),
                        binding.editTextModel.text.toString(),
                        binding.editTextAge.text.toString(),
                        binding.editTextEnginePower.text.toString(),
                        when (binding.radioGroup.checkedRadioButtonId) {
                            1 -> 4
                            2 -> 6
                            3 -> 8
                            else -> {
                                0
                            }
                        },
                        binding.engineSpinner.selectedItem as EngineType
                    )
                )
                binding.editTextManufacturer.text.clear()
                binding.editTextModel.text.clear()
                binding.editTextAge.text.clear()
                binding.editTextEnginePower.text.clear()
                binding.radioGroup.clearCheck()
                binding.engineSpinner.setSelection(0)
            }
        }
        return binding.root
    }

    fun checkInput(view: View): Boolean {
        if (view is EditText) {
            if (view.text.isEmpty()) {
                view.error = "Please enter this field"
                return false
            } else if (view.inputType == TYPE_CLASS_NUMBER && view.id == R.id.editTextAge) {
                if (view.text.toString().toInt() > 137) {
                    view.error = "Please enter a valid year"
                    return false
                }
            }
        } else if (view is Spinner) {
            if (view.selectedItem == EngineType.SELECT) {
                val errorTextView: TextView = view.selectedView as TextView
                errorTextView.error = "Please select engine type"
                return false
            }
        } else if (view is RadioGroup && view.visibility == VISIBLE)
            if (view.checkedRadioButtonId == -1) {
                Toast.makeText(
                    requireContext(),
                    "Please select number of cylinders",
                    Toast.LENGTH_SHORT
                ).show()
            }
        return true
    }
}

