package com.lutfiseptian.gunungapps.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lutfiseptian.Model.ModelGunung
import com.lutfiseptian.gunungapps.DetailGunungActivity
import com.lutfiseptian.gunungapps.DetailGunungActivity.Companion.DETAIL_GUNUNG
import com.lutfiseptian.gunungapps.R
import kotlinx.android.synthetic.main.activity_detail_gunung.view.*
import kotlinx.android.synthetic.main.activity_detail_gunung.view.imageGunung
import kotlinx.android.synthetic.main.activity_detail_gunung.view.tvLokasiGunung
import kotlinx.android.synthetic.main.activity_detail_gunung.view.tvNamaGunung
import kotlinx.android.synthetic.main.list_item_gunung.view.*

class ListGunungAdapter(private val context: Context?, private val modelGunung:
List<ModelGunung>) : RecyclerView.Adapter<ListGunungAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_gunung, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelGunung[position]

        if (context != null) {
            Glide.with(context)
                .load(data.strImageGunung)
                .into(holder.imageGunung)
        }

        holder.tvNamaGunung.text = data.strNamaGunung
        holder.tvLokasiGunung.text = data.strLokasiGunung

        holder.cvListGunung.setOnClickListener {
            val intent = Intent(context, DetailGunungActivity::class.java)
            intent.putExtra(DetailGunungActivity.DETAIL_GUNUNG, modelGunung[position])
            Log.d("detailGunung", "onBindViewHolder: ${DETAIL_GUNUNG}");
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return modelGunung.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvListGunung: CardView
        var imageGunung: ImageView
        var tvNamaGunung: TextView
        var tvLokasiGunung: TextView

        init {
            cvListGunung = itemView.cvListGunung
            imageGunung = itemView.imageGunung
            tvNamaGunung = itemView.tvNamaGunung
            tvLokasiGunung = itemView.tvLokasiGunung
        }
    }

}