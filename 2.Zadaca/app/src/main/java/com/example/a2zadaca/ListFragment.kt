package com.example.a2zadaca

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2zadaca.ui.main.PageViewModel

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var pageViewModel: PageViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var personAdapter: PersonAdapter
    override fun onStart() {
        super.onStart()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this)[PageViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        pageViewModel.dataItemListLiveData.observe(viewLifecycleOwner) {
            recyclerView.adapter?.notifyItemInserted(it.size-1)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personAdapter = PersonAdapter(pageViewModel.getPeople())
        recyclerView.adapter=personAdapter
        personAdapter.notifyDataSetChanged()

    }

}


