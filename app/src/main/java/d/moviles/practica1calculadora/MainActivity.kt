package d.moviles.practica1calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0.setOnClickListener{ numeroPresionado("0")}
        btn1.setOnClickListener{ numeroPresionado("1")}
        btn2.setOnClickListener{ numeroPresionado("2")}
        btn3.setOnClickListener{ numeroPresionado("3")}
        btn4.setOnClickListener{ numeroPresionado("4")}
        btn5.setOnClickListener{ numeroPresionado("5")}
        btn6.setOnClickListener{ numeroPresionado("6")}
        btn7.setOnClickListener{ numeroPresionado("7")}
        btn8.setOnClickListener{ numeroPresionado("8")}
        btn9.setOnClickListener{ numeroPresionado("9")}

        btnSuma.setOnClickListener{ operacionPresionado(Suma)}
        btnMenos.setOnClickListener{ operacionPresionado(Resta)}
        btnMultiplicacion.setOnClickListener{ operacionPresionado(Multiplicacion)}
        btnDivision.setOnClickListener{ operacionPresionado(Division)}
        btnPotencia.setOnClickListener{ operacionPresionado(Potencia)}

        btnCE.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            txtPanel.text = ""
            operacion = SinOperacion
        }

        btnIgual.setOnClickListener {
            var resultado = when(operacion){
                Suma ->num1+num2
                Resta -> num1-num2
                Multiplicacion -> num1*num2
                Division -> num1/num2
                Potencia -> Math.pow(num1,num2)
                else -> 0
            }

            txtPanel.text = resultado.toString()
        }
    }

    private fun numeroPresionado(numero: String){
        txtPanel.text = "${txtPanel.text}$numero"

        if(operacion == SinOperacion){
            num1=txtPanel.text.toString().toDouble()
        }else{
            num2=txtPanel.text.toString().toDouble()
        }
    }

    private fun operacionPresionado(operacion: Int){
        this.operacion = operacion

        txtPanel.text = ""
    }

    companion object{
        const val  Suma=1
        const val  Resta=2
        const val  Multiplicacion=3
        const val  Division=4
        const val  Potencia=5
        const val  SinOperacion=0
    }
}