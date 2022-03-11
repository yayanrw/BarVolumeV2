package com.example.barvolumev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.barvolumev2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
//    private lateinit var edtLength: EditText
//    private lateinit var edtWidth: EditText
//    private lateinit var edtHeight: EditText
//    private lateinit var btnCalculate: Button
//    private lateinit var tvResult: TextView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        edtLength = findViewById(R.id.edt_length)
//        edtWidth = findViewById(R.id.edt_width)
//        edtHeight = findViewById(R.id.edt_height)
//        btnCalculate = findViewById(R.id.btn_calculate)
//        tvResult = findViewById(R.id.tv_result)
//
//        btnCalculate.setOnClickListener(this)
        binding.btnCalculate.setOnClickListener(this)


        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
//            tvResult.setText(result)
            binding.tvResult.setText(result)
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate) {
            val inputLength = binding.edtLength.text.toString().trim()
            val inputWidth = binding.edtWidth.text.toString().trim()
            val inputHeight = binding.edtHeight.text.toString().trim()

            var isEmptyFields = false

            if (inputLength.isEmpty()) {
                isEmptyFields = true
                binding.edtLength.error = "Field ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                binding.edtWidth.error = "Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                binding.edtHeight.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                binding.tvResult.setText(volume.toString())
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
    }

    companion object {
        private const val STATE_RESULT = "state_result"
    }
}