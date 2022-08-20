package com.app.sampledatepicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.sampledatepicker.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAction()
    }

    private fun initAction() {
        binding.btnPilihTanggal.setOnClickListener {
            val dateDialog = DatePickerDialog(
                this, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            )
            dateDialog.datePicker.minDate = System.currentTimeMillis()
            dateDialog.show()
        }
    }

    private val cal = Calendar.getInstance()
    private val dateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val uiFormat = "dd MMMM yyyy"
            val sdf = SimpleDateFormat(uiFormat, Locale.getDefault())

            val selectedDate = sdf.format(cal.time)
            val worddingSelectedDate = "Kamu memilih tanggal : $selectedDate"
            binding.tvTanggal.text = worddingSelectedDate
        }

}