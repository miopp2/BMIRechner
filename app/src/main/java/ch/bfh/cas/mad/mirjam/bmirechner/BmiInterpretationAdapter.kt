package ch.bfh.cas.mad.mirjam.bmirechner

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater

class BmiInterpretationAdapter(private val data: List<String>) : RecyclerView.Adapter<BmiInterpretationViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BmiInterpretationViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.bmi_interpretation_item, parent, false)
        return BmiInterpretationViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: BmiInterpretationViewHolder, position: Int) {
        holder.setText(data[position])
    }
}