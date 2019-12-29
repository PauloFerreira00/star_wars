package com.joao.santana.starwars.features.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.joao.santana.starwars.BR

abstract class BaseAdapter<T>(
    private val layoutID: Int
) : RecyclerView.Adapter<BaseAdapter<T>.BaseViewHolder>() {

    private val items: MutableList<T> = mutableListOf()

    fun submitList(list: List<T>) {
        if (items.isNotEmpty()) {
            items.clear()
        }

        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutID,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        return holder.bing(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class BaseViewHolder(
        private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun <T> bing(data: T?) {
            binding.setVariable(BR.data, data)
            binding.executePendingBindings()
        }
    }
}
