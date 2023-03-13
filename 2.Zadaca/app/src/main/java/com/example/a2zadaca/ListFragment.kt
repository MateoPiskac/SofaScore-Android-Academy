package com.example.a2zadaca

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.a2zadaca.data.Car
import com.example.a2zadaca.databinding.FragmentListBinding
import com.example.a2zadaca.ui.main.PageViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach



class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var binding: FragmentListBinding
    private lateinit var pageViewModel: PageViewModel
    private lateinit var carAdapter: CarAdapter
    private lateinit var arrayAdapter: ArrayAdapter<Car>
    override fun onStart() {
        super.onStart()
        pageViewModel.cars().onEach(carAdapter::submitList).launchIn(lifecycleScope)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(requireActivity())[PageViewModel::class.java]
        arrayAdapter = ArrayAdapter(requireContext(), R.layout.car_list_item, R.id.textViewCar)
        pageViewModel.cars().onEach { arrayAdapter.addAll(it) }.launchIn(lifecycleScope)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
//        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carAdapter = CarAdapter()
        binding.listView.adapter = arrayAdapter
//        binding.recyclerView.adapter=carAdapter
    }

}


