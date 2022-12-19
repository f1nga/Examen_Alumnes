package com.finga.examen_alumnes.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.finga.examen_alumnes.R
import com.finga.examen_alumnes.ui.model.Alumne

class ListAlumnAdapter (
    private val dataset: MutableList<Alumne>
) : RecyclerView.Adapter<ListAlumnAdapter.ItemViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(alumne: Alumne)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class ItemViewHolder(private val view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val txtNom: TextView = view.findViewById(R.id.idNombre)
        var imgView: ImageView = view.findViewById(R.id.idImagen)
        var txtEdat: TextView = view.findViewById(R.id.idEdat)
        var txtDescripcio: TextView = view.findViewById(R.id.idDescripcio)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(
                    Alumne(
                        txtNom.text.toString().split(",")[0],
                        txtEdat.text.toString().toInt(),
                        17430,
                        txtDescripcio.text.toString()
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        return ItemViewHolder(adapterLayout, mListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position] ?: return

        holder.txtNom.text = "${item.nom},"
        holder.imgView.setBackgroundResource(R.drawable.user)
        holder.txtEdat.text = item.edat.toString()
        holder.txtDescripcio.text = item.descripcio
    }


    override fun getItemCount(): Int {
        return dataset.size
    }


}