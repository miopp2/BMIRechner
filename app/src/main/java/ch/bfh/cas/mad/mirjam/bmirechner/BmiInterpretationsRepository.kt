package ch.bfh.cas.mad.mirjam.bmirechner

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BmiInterpretationsRepository(private val context: Context) {

    suspend fun all(): List<String>
//        = context.resources.getStringArray(R.array.interpretation_bmi).toList()
//        = BmiInterpretationsClient.getAllBmiInterpretationsBlocking()
        = withContext(Dispatchers.IO){BmiInterpretationsClient.getAllBmiInterpretations()}

}