package br.com.ajeferson.architecturemvvm.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.ajeferson.architecturemvvm.databinding.RvItemRepositoryBinding
import br.com.ajeferson.architecturemvvm.service.model.Repository

/**
 * Created by ajeferson on 27/01/2018.
 */
class RepositoryRecyclerViewAdapter(
        private var items: List<Repository>,
        private val itemTouchHandler: (Int) -> Unit): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RvItemRepositoryBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], itemTouchHandler)

    fun replaceData(list: List<Repository>) {
        items = list
        notifyDataSetChanged()
    }

}

class ViewHolder(private var binding: RvItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: Repository, itemTouchLambda: ((Int) -> Unit)?) {
        binding.repository = repository
        binding.root.setOnClickListener { itemTouchLambda?.invoke(layoutPosition) }
        binding.executePendingBindings()
    }

}