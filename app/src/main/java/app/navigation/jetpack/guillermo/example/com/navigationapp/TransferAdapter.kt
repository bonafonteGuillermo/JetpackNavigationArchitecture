package app.navigation.jetpack.guillermo.example.com.navigationapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.transfer_item.view.*
import kotlin.properties.Delegates

typealias Listener = (Transfer) -> Unit

class TransferAdapter(data: List<Transfer> = emptyList(), private val listener: Listener) :
        RecyclerView.Adapter<TransferAdapter.TransferViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferViewHolder =
            TransferViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.transfer_item, parent, false), listener)

    override fun onBindViewHolder(holder: TransferViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class TransferViewHolder(view: View, private val listener: Listener) :
            RecyclerView.ViewHolder(view) {

        fun bind(item: Transfer) = with(itemView) {
            tv_concept_item.text = item.concept
            tv_amount_item.text = item.amount.toString()
            setOnClickListener { listener(item) }
        }
    }
}