package com.example.a2zadaca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.a2zadaca.ui.main.PageViewModel

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var pageViewModel: PageViewModel
    private lateinit var textViewContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this)[PageViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val linearLayout = view.findViewById<LinearLayout>(R.id.contactsLayout)
        pageViewModel.dataItemListLiveData.observe(viewLifecycleOwner) { people ->
            linearLayout.removeAllViews()

            for (person in people) {
                val textView = TextView(requireContext())
                textView.text = person.toString()
                linearLayout.addView(textView)
            }
        }

        return view
    }


}