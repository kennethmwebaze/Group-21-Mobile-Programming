import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private var operand1 = ""
    private var operator = ""
    private var operand2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult = findViewById(R.id.tvResult)
    }

    fun onNumberButtonClick(view: View) {
        val button = view as TextView
        if (operator.isEmpty()) {
            operand1 += button.text
            tvResult.text = operand1
        } else {
            operand2 += button.text
            tvResult.text = operand2
        }
    }

    fun onOperatorButtonClick(view: View) {
        val button = view as TextView
        operator = button.text.toString()
    }

    fun onEqualsButtonClick(view: View) {
        val result: Double = when (operator) {
            "+" -> operand1.toDouble() + operand2.toDouble()
            "-" -> operand1.toDouble() - operand2.toDouble()
            "*" -> operand1.toDouble() * operand2.toDouble()
            "/" -> operand1.toDouble() / operand2.toDouble()
            else -> 0.0
        }
        tvResult.text = result.toString()
        operand1 = result.toString()
        operand2 = ""
        operator = ""
    }

    fun onClearButtonClick(view: View) {
        operand1 = ""
        operand2 = ""
        operator = ""
        tvResult.text = "0"
    }

    fun onBackspaceButtonClick(view: View) {
        if (operator.isEmpty()) {
            if (operand1.isNotEmpty()) {
                operand1 = operand1.substring(0, operand1.length - 1)
                tvResult.text = operand1
            }
        } else {
            if (operand2.isNotEmpty()) {
                operand2 = operand2.substring(0, operand2.length - 1)
                tvResult.text = operand2
            }
        }
    }

    fun onDotButtonClick(view: View) {
        if (operator.isEmpty()) {
            if (!operand1.contains('.')) {
                operand1 += "."
                tvResult.text = operand1
            }
        } else {
            if (!operand2.contains('.')) {
                operand2 += "."
                tvResult.text = operand2
            }
        }
    }
}
