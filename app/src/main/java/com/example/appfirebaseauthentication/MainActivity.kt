package com.example.appfirebaseauthentication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appfirebaseauthentication.ui.theme.AppFirebaseAuthenticationTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = Firebase.auth

        Log.i(TAG, "onCreate usuário atual: ${auth.currentUser}")

        auth.createUserWithEmailAndPassword(
            "james.francis.byrnes@example-pet-store.com",
            "123456"
        ).addOnCompleteListener{ task ->
            if(task.isSuccessful){
                Log.i(TAG, "onCreate: Sucesso")
            }else{
                Log.i(TAG, "onCreate: Falha -> ${task.exception}")
            }
        }
    }
}

