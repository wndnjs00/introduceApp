package com.example.signapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // SignInActivity에서 넘겨준 데이터 받아오기
        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")

        val myId = findViewById<TextView>(R.id.result_id2)
        val myName = findViewById<TextView>(R.id.result_name2)
        val endBtn = findViewById<Button>(R.id.end_btn)
        val img = findViewById<ImageView>(R.id.imageView2)


        // 받아온 데이터를 텍스트뷰에 표시 (텍스트뷰에 받아온 데이터 넣어줌)
        myId.setText(id)
        myName.setText(name)



        // 종료버튼 클릭시
        endBtn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }


        // 1부터 5까지 랜덤값 받아와서
        val random = Random
        val num = random.nextInt(1,5)

        // 해당하는 이미지 출력
        when(num){
            1 -> img.setImageResource(R.drawable.duck2)
            2-> img.setImageResource(R.drawable.duck3)
            3-> img.setImageResource(R.drawable.duck4)
            4-> img.setImageResource(R.drawable.duck5)
            5-> img.setImageResource(R.drawable.duck6)
        }

    }
}