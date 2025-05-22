package pranala.ragam.karya

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.splash_scr)


        onNext()
    }

    private fun onNext() {
        Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
            override fun run() {
                val int = Intent(applicationContext, MainActivity::class.java)
                startActivity(int)
                finish()
            }
        },800)
    }
}