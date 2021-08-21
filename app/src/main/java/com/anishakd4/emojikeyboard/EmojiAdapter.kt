package com.anishakd4.emojikeyboard

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.emoji.text.EmojiCompat
import androidx.recyclerview.widget.RecyclerView
import com.anishakd4.emojikeyboard.databinding.EmojiLayoutBinding

class EmojiAdapter(val list: List<String>) : RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder>() {

    class EmojiViewHolder(val binding: EmojiLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(unicode: String) {
            binding.emojiTextView.text = EmojiCompat.get().process(Html.fromHtml(unicode))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder {
        val binding: EmojiLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.emoji_layout,
            parent,
            false
        )
        return EmojiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}