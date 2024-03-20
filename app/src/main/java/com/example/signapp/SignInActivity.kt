package com.example.signapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        val loginbtn = findViewById<Button>(R.id.login_btn)
        val signbtn = findViewById<Button>(R.id.sign_btn)
        val id_et = findViewById<EditText>(R.id.id_et)
        val password_et = findViewById<EditText>(R.id.password_et)


        val name = intent.getStringExtra("name")   // name값 받아옴
        val id2 = intent.getStringExtra("id2")
        val password2 = intent.getStringExtra("password2")

        id_et.setText(id2)
        password_et.setText(password2)



        // 로그인 버튼 클릭시
        loginbtn.setOnClickListener {

            // 사용자가 입력한 아이디, 비밀번호값 가져오기
            val id = id_et.text.toString()
            val password = password_et.text.toString()


            // 아이디 or 비밀번호가 비어있으면
            if (id.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                // 아니면 HomeActivity로 이동
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id",id) // 내가 입력한 id 넘겨줌
                intent.putExtra("name",name) // 내가 입력한 name 넘겨줌
                startActivity(intent)
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
            }


        }


        // 회원가입 버튼 클릭시
        signbtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }



    }
}