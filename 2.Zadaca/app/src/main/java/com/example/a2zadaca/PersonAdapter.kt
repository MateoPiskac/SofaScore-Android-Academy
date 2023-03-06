package com.example.a2zadaca

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a2zadaca.ui.main.Person

class PersonAdapter(private val people: List<Person>) :
    ListAdapter<Person, PersonAdapter.ViewHolder>(DiffCallback()) {

    private class DiffCallback : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean =
            oldItem.toString()===newItem.toString()

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean =
            oldItem==newItem
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewPerson: TextView = itemView.findViewById(R.id.textViewPerson)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = people[position]
        holder.textViewPerson.text = person.toString()
    }

    override fun getItemCount() = people.size
}
