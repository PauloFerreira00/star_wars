package com.joao.santana.starwars.features.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(
    private val data: List<T>,
    private val layoutID: Int
) : RecyclerView.Adapter<BaseAdapter<T>.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutID,
                parent,
                FALSE
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        return holder.bing(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class BaseViewHolder(
        private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun <T> bing(data: T) {
            binding.setVariable(BR._all, data)
            binding.executePendingBindings()
        }
    }

    private companion object {
        private const val FALSE: Boolean = false
    }
}
