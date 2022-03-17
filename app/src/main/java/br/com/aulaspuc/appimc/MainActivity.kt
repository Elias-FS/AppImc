package br.com.aulaspuc.appimc

import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var etPeso: AppCompatEditText
    private lateinit var etAltura: AppCompatEditText
    private lateinit var tvRes: AppCompatTextView
    private lateinit var btnCal: AppCompatButton
    private lateinit var tvSit: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        tvRes = findViewById(R.id.tvRes)
        tvSit = findViewById(R.id.tvSit)
        btnCal = findViewById(R.id.btnCal)
        btnCal.setOnClickListener {
            calcularIMC()
        }

    }

    private fun calcularIMC(){
        val dec = DecimalFormat("#,###.0") //2 casas decimais no final separado milhar "." e decimais ","
        if(etAltura.text.isNullOrEmpty() || etPeso.text.isNullOrEmpty()){
            Snackbar.make(tvRes,"Existem informações faltando! Digite seu peso e altura.", Snackbar.LENGTH_LONG).show()
        }else {
            val etPeso = etPeso.text.toString()
            val etAltura = etAltura.text.toString()
            val peso = etPeso.toDouble()
            val altura = etAltura.toDouble()
            val imc = peso / (altura * altura)


            val mensagem = "Seu índice de massa corporal é ${dec.format(imc)}Kg"
            tvRes.text = mensagem
            tvRes.visibility = View.VISIBLE

            if(imc<17){
                Snackbar.make(tvSit,"Muito abaixo do peso", Snackbar.LENGTH_LONG).show()
                tvSit.text = "Muito abaixo do peso"
                tvSit.visibility = View.VISIBLE
            }else if(imc > 17 && imc < 18.5){
                Snackbar.make(tvSit,"Abaixo do peso", Snackbar.LENGTH_LONG).show()
                tvSit.text = "Abaixo do peso"
                tvSit.visibility = View.VISIBLE
            }else if(imc > 18.5 && imc < 24.9){
                Snackbar.make(tvSit,"Peso normal", Snackbar.LENGTH_LONG).show()
                tvSit.text = "Peso normal"
                tvSit.visibility = View.VISIBLE
            }else if(imc > 25 && imc < 29.9){
                Snackbar.make(tvSit,"Acima do peso", Snackbar.LENGTH_LONG).show()
                tvSit.text = "Acima do peso"
                tvSit.visibility = View.VISIBLE
            }else if(imc > 30 && imc < 34.9){
                Snackbar.make(tvSit,"Obesidade 1", Snackbar.LENGTH_LONG).show()
                tvSit.text = "Obesidade 1"
                tvSit.visibility = View.VISIBLE
            }else if(imc > 35 && imc < 39.9){
                Snackbar.make(tvSit,"Obesidade 2 (severa)", Snackbar.LENGTH_LONG).show()
                tvSit.text = "Obesidade 2 (severa)"
                tvSit.visibility = View.VISIBLE
            }else if(imc > 40){
                Snackbar.make(tvSit,"Obesidade 3 (mórbida)", Snackbar.LENGTH_LONG).show()
                tvSit.text = "Obesidade 3 (mórbida)"
                tvSit.visibility = View.VISIBLE
            }

        }



    }
}