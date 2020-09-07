package tech.anshul1507.inappreviewplaystore

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Only Applicable above API >= 21 */
        if (Build.VERSION.SDK_INT >= 21){
            ReviewHelper.initialize(this)
        }

        /* Intent to Second Screen */
        button_next_screen.setOnClickListener {
            startActivity(Intent(this@MainActivity,SecondActivity::class.java))
        }
    }
}