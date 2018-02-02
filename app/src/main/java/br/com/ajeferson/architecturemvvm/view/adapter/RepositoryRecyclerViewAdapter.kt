package br.com.ajeferson.architecturemvvm.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.ajeferson.architecturemvvm.databinding.RvItemUserBinding
import br.com.ajeferson.architecturemvvm.service.model.User

/**
 * Created by ajeferson on 27/01/2018.
 */
class RepositoryRecyclerViewAdapter(
        private var items: List<User>,
        private val itemTouchHandler: (Int) -> Unit): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RvItemUserBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], itemTouchHandler)

    fun replaceData(list: List<User>) {
        items = list
        notifyDataSetChanged()
    }

}

class ViewHolder(private var binding: RvItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User, itemTouchLambda: ((Int) -> Unit)?) {
        binding.user = user
        binding.root.setOnClickListener { itemTouchLambda?.invoke(layoutPosition) }
        binding.executePendingBindings()
    }

}