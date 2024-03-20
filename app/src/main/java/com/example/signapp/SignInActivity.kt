package com.example.signapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {


    private lateinit var getContent : ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        val loginbtn = findViewById<Button>(R.id.login_btn)
        val signbtn = findViewById<Button>(R.id.sign_btn)
        val id_et = findViewById<EditText>(R.id.id_et)
        val password_et = findViewById<EditText>(R.id.password_et)



        // 데이터를 받을 엑티비티에서 생성
        val getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            // Handle the returned result (결과 콜백)
            if(result.resultCode == Activity.RESULT_OK){

                // SignUpActivity로부터 받은 데이터
                val id = result.data?.getStringExtra("id")     //id값 받아옴
                val password = result.data?.getStringExtra("password") //password값 받아옴

                // editText에 표시
                id_et.setText(id)
                password_et.setText(password)
            }
        }



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
                startActivity(intent)
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
            }


        }



        // 회원가입 버튼 클릭시
        signbtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)

            // launcher실행해서 새로운 activity시작 (데이터를 받아올 엑티비티)
            getContent.launch(intent)   // startActivity(intent) + 데이터전달

        }



    }
}