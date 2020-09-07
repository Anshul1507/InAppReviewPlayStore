package tech.anshul1507.inappreviewplaystore

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if (Build.VERSION.SDK_INT >= 21){
            ReviewHelper.askForReview(this)
        }
    }
}