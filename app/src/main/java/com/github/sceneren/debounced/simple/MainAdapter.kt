package com.github.sceneren.debounced.simple

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.github.sceneren.debounced.simple.R

class MainAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_text, item)
    }

}