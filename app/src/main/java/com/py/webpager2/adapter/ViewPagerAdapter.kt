package com.py.webpager2.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.py.webpager2.R
import com.py.webpager2.`class`.Parcela

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ParcelaAdapterVH>() {
    private var parcelaArrayList = arrayListOf<Parcela>()
    private var context: Context? = null

    fun setData(parcelaArrayList: ArrayList<Parcela>) {
        this.parcelaArrayList = parcelaArrayList
        notifyDataSetChanged()
        // notifyItemChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParcelaAdapterVH {
        context = parent.context
        return ParcelaAdapterVH(
            LayoutInflater.from(context)
                .inflate(R.layout.item_page, parent, false)
        )
    }


    override fun onBindViewHolder(holder: ParcelaAdapterVH, position: Int) {
        Log.i("look", "entro")
        holder.bind(parcelaArrayList[position])
    }

    override fun getItemCount(): Int {
        return parcelaArrayList.size
    }

    inner class ParcelaAdapterVH(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val nombreParcela = itemView.findViewById<TextView>(R.id.parcelaName)

        // private val etapaFenologica = itemView.findViewById<TextView>(R.id.etapaFenologica)
        private val stateEtapaFenologica =
            itemView.findViewById<ImageView>(R.id.stateEtapaFenologica)

        private fun updateRow(model: Parcela) {
            val resource =
                if (model.id == 1) R.drawable.ic_clear else R.drawable.ic_close
            stateEtapaFenologica.setImageResource(resource)
        }

        fun bind(model: Parcela) {
            nombreParcela.text = model.descripcion
            updateRow(model)
        }
    }

}