package com.example.a2zadaca

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2zadaca.ui.main.PageViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var pageViewModel: PageViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var personAdapter: PersonAdapter
    override fun onStart() {
        super.onStart()
        pageViewModel.people().onEach(personAdapter::submitList).launchIn(lifecycleScope)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(requireActivity())[PageViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personAdapter = PersonAdapter()
        recyclerView.adapter=personAdapter
    }

}


