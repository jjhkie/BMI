package com.work.part2.chapter01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText: EditText =findViewById(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)

        val resultButton = findViewById<Button>(R.id.resultButton)

        resultButton .setOnClickListener {


            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                //text가 비어있다면 true를 반환하고 비어잇지않다면 false를 반환
                Toast.makeText(this,"빈 값이 있습닌다.",Toast.LENGTH_LONG).show()

                //이후에는 다음 코드가 실행하지않도록 return 을 걸어준다.
                return@setOnClickListener//setOnCLickListener를 나가준다.
            }
            //이 아래로는 절대 빈 값이 올 수 없다.
            val height :Int = heightEditText.text.toString().toInt()
            //String 형으로 치환한 후 Int형으로 변환
            val weight :Int = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            //현재는 MainActivity(this)지만 그 다음에는 ResultActivity를 실행시키고 싶어
            intent.putExtra("height",height)
            intent.putExtra("weight",weight)
            startActivity(intent)
        }
    }
}