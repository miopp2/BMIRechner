package ch.bfh.cas.mad.mirjam.bmirechner

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BmiInterpretationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val textViewText = itemView.findViewById<TextView>(R.id.textview_text)

    fun setText(text: String)
    {
        textViewText.text = text
    }
}