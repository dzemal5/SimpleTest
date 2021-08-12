package org.com.testing.with.simpletest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.com.testing.with.simpletest.databinding.CardViewItemBinding

class RVCustomAdapter(var articleList: List<Article>) :
    RecyclerView.Adapter<RVCustomAdapter.RVCViewHolder>() {

    inner class RVCViewHolder(private val itemViewBiding: CardViewItemBinding) :
        RecyclerView.ViewHolder(itemViewBiding.root) {
            fun bind(position: Int) {
                itemView.apply {
                    itemViewBiding.mTextViewContent.text = articleList[position].content
                    itemViewBiding.mTextViewTitle.text = articleList[position].title
                    Picasso.get().load(articleList[position].imageURL).into(itemViewBiding.mImageViewCardViewItem);
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVCViewHolder {
        return RVCViewHolder(CardViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RVCViewHolder, position: Int) {
//        val article = articleList[position]
        holder.bind(position)

    }

    override fun getItemCount(): Int {
        return articleList.size
    }



}