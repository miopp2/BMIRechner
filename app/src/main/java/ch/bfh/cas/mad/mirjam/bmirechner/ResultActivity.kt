package ch.bfh.cas.mad.mirjam.bmirechner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ResultActivity : AppCompatActivity() {
    private lateinit var viewModel: ResultViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val viewModelProvider = ViewModelProvider(
            this,
            ResultViewModelFactory(
                BmiInterpretationsRepository(applicationContext))
        )

        viewModel = viewModelProvider.get(ResultViewModel::class.java)

        val textViewResult = findViewById<TextView>(R.id.text_view_result)

        val key = "ch.bfh.cas.mad.mirjam.bmicalculator.bmi"
        val bmi = intent.extras?.getDouble(key)

        textViewResult.text = getString(R.string.bmi_format, bmi)
        val recyclerViewInterpretation = findViewById<RecyclerView>(R.id.recyclerview_bmi_interpretation)
//        val interpretations = resources.getStringArray(R.array.interpretation_bmi)
        recyclerViewInterpretation.layoutManager = LinearLayoutManager(this)

        Thread {
            val interpretations = viewModel.getBmiInterpretations()
            recyclerViewInterpretation.post {
                val adapter = BmiInterpretationAdapter(data = interpretations)
                recyclerViewInterpretation.adapter = adapter
            }
        }.start()
//        val interpretations = viewModel.getBmiInterpretations()
//        val adapter = BmiInterpretationAdapter(data = interpretations)

//        recyclerViewInterpretation.layoutManager = GridLayoutManager(this, 3)
//        recyclerViewInterpretation.adapter = adapter

        val returnButton = findViewById<Button>(R.id.return_button)

        returnButton.setOnClickListener {
            val intent = Intent(
                this, MainActivity::class.java
            )
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//            startActivity(intent)
            finish()
        }
    }
}