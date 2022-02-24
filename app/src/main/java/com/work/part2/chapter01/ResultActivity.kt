package com.work.part2.chapter01

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)
        //값을 받을 떄는 어떤 형식으로 받는지 결정해야하므로
        //getStringExtra , getIntExtra, getLongExtra 등 형식에 맞게 작성해야 한다.

        //첫 번쨰 인자는 받아올 값, 두 번째 인자는 받아온 값이 없다면 대체할

        Log.d("Result", "height : $height, weight : $weight ")

        //키는 cm 로 입력 받지만 bmi 는 m형식으로 입력을 받아야 하므로
        val bmi = weight / (height / 100.0).pow(2.0)
        //command 를 누른 상태로 pow 를 보면 (double , double) 형식을 요구한다.
        //지금 우리는 int형으로 입력을 받고 나누고 있으므로 [ height/ 100,2 ]
        //.0을 이용하여 double 형으로 만든다.
        //처음에는 Math.pow(height/100,2) 로 입력을 하였지만
        //pow 에서 요구하는 형식으로 맞추기 위해 Math.pow(height/100.0,2.0)으로 선언한 후
        // pow에 노란밑줄이 존재하는 option + enter 를 눌러보면 프로그램에서 제안을 한다.
        //그 제안을 받아들인 결과 위와 같은 형식을로 변경된다.
        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상 체중"
            else -> "저체중"
        }

        val bmiResultValue = findViewById<TextView>(R.id.bmiResultValue)
        val TextResultValue = findViewById<TextView>(R.id.TextResultValue)

        bmiResultValue.text = bmi.toString()
        TextResultValue.text = resultText
    }
}
