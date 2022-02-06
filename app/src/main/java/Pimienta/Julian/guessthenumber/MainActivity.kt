package Pimienta.Julian.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var maxNumber = 100
    var minNumber = 0
    var num : Int = 0
    var won = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView = findViewById(R.id.guessings)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.guessed)

        generate.setOnClickListener{
            num = Random.nextInt(minNumber, maxNumber)
            guessings.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }

        up.setOnClickListener {
            minNumber = num
            if (checkingLimits()){
                num = Random.nextInt(minNumber, maxNumber)
                guessings.setText(num.toString())
            }else{
                guessings.setText("It's not possible :( You beat me")
            }

        }

        down.setOnClickListener {
            maxNumber = num
            if (checkingLimits()){
                num = Random.nextInt(minNumber, maxNumber)
                guessings.setText(num.toString())
            }else{
                guessings.setText("It's not possible :( You beat me")
            }
        }

        guessed.setOnClickListener {
            if (!won){
                guessings.setText("I guessed your number: "+num)
                guessed.setText("Play Again?")
                won = true
            }else{
                generate.visibility = View.VISIBLE
                guessings.setText("Tap on generate to start")
                guessed.setText("Guessed")
                guessed.visibility = View.GONE
                resetValues()
            }

        }

    }

    fun resetValues(){
        maxNumber = 100
        minNumber = 0
        num  = 0
        won = false
    }

    fun checkingLimits(): Boolean{
        return minNumber != maxNumber
    }


}