package com.example.viewpager2payme.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2geo.databinding.ItemViewPagerBinding
import com.example.viewpager2payme.Adapter.User

class ViewPager2Adapter(val list:ArrayList<User>):RecyclerView.Adapter<ViewPager2Adapter.VH>() {
    inner class VH(val itemViewPagerBinding: ItemViewPagerBinding):RecyclerView.ViewHolder(itemViewPagerBinding.root){
        fun onBind(user: User){
            itemViewPagerBinding.imageView.setImageResource(user.img)
            itemViewPagerBinding.itemTxtname.text = user.name
            itemViewPagerBinding.itemTxtinfo.text = user.info

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }
}