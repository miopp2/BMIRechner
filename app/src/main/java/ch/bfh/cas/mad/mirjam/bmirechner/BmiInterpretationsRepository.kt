package ch.bfh.cas.mad.mirjam.bmirechner

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BmiInterpretationsRepository(private val context: Context) {

    fun all(): List<String>{
//        return context.resources.getStringArray(R.array.interpretation_bmi).toList()
        return BmiInterpretationsClient.getAllBmiInterpretationsBlocking()
    }
}