package com.ajay.taskapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ajay.taskapp.R
import com.ajay.taskapp.databinding.ItemRepositoryBinding
import com.ajay.taskapp.domain.Repository
import com.ajay.taskapp.extensions.capitalize

class MainAdapter() : ListAdapter<Repository, MainAdapter.RepositoryViewHolder>(diffCallBack) {

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_repository, parent, false)
        return RepositoryViewHolder(
            ItemRepositoryBinding.bind(view)
        )
    }

    class RepositoryViewHolder(private val binding: ItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Repository) {
            with(item) {
                binding.apply {
                    textName.text = name.capitalize()
                    textDescription.text = description
                }
            }
        }
}

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<Repository>() {

            override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Repository,
                newItem: Repository
            ): Boolean =
                oldItem == newItem
        }
    }

}
