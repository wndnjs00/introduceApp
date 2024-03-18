package com.example.signapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val name = findViewById<EditText>(R.id.name_et)
        val id = findViewById<EditText>(R.id.id_et2)
        val password = findViewById<EditText>(R.id.password_et2)
        val signBtn = findViewById<Button>(R.id.sign_btn2)


        // 회원가입 버튼 클릭시
        signBtn.setOnClickListener {
            
            // 사용자가 입력한 이름,아이디,비밀번호값 가져오기
            val name = name.text.toString()
            val id = id.text.toString()
            val password = password.text.toString()


            // 이름,아이디,비밀번호값중 하나라도 비어있으면
            if(name.isEmpty() || id.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            }else{
                // 아니면 SignInActivity로 이동
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("name",name)    //name값 넘겨주기
                startActivity(intent)
                finish()    // 엑티비티 파괴
            }

        }


    }
}