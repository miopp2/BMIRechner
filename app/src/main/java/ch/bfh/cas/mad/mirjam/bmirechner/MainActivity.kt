package ch.bfh.cas.mad.mirjam.bmirechner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import kotlin.text.toInt


fun computeBMI(weight: Int, height: Int): Float {
    val heightM = (height / 100.0f)
    return (weight / (heightM * heightM))
}

class MainActivity : AppCompatActivity() {
    private lateinit var editTextWeight: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewOutput: TextView

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelProvider = ViewModelProvider(this)
        viewModel = viewModelProvider.get(MainViewModel::class.java)

//        setSupportActionBar(findViewById(R.id.toolbar_main))

        title = getString(R.string.title_activity_profile)

        editTextWeight = findViewById(R.id.edit_text_weight)
        editTextHeight = findViewById(R.id.edit_text_height)
        buttonCalculate =findViewById(R.id.button_calculate)
        textViewOutput = findViewById(R.id.text_view_output)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(
           R.menu.main_menu, menu
       )
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.main_menu_profile){
            val intent = Intent(
                this, ProfileActivity::class.java
            )
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        buttonCalculate.setOnClickListener{
            try {
                val height = editTextHeight.text.toString().toInt()
                val weight = editTextWeight.text.toString().toInt()
                val bmi = viewModel.calculateBmi(weightInKg = weight, heightInCm = height)
                val key = "ch.bfh.cas.mad.mirjam.bmicalculator.bmi"
                val intent = Intent(
                    this, ResultActivity::class.java
                )
                intent.putExtra(key, bmi)
                startActivity(intent)

            }
            catch(e: Exception){
                val coordinatorLayoutMain = findViewById<CoordinatorLayout>(R.id.coordinator_layout_main)
                Snackbar.make(coordinatorLayoutMain, R.string.error_input, Snackbar.LENGTH_LONG).show()
            }
        }

        val returnButton = findViewById<Button>(R.id.return_button)
        returnButton.setOnClickListener {
            finish()
        }

    }
}