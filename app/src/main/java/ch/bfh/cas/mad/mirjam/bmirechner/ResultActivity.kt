package ch.bfh.cas.mad.mirjam.bmirechner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

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
        recyclerViewInterpretation.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch{
            val interpretations = viewModel.getBmiInterpretations()
            val adapter = BmiInterpretationAdapter(data = interpretations)
            recyclerViewInterpretation.adapter = adapter
        }

        val returnButton = findViewById<Button>(R.id.return_button)

        returnButton.setOnClickListener {
            val intent = Intent(
                this, MainActivity::class.java
            )
            finish()
        }
    }
}