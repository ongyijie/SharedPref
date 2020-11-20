package my.edu.tarc.sharedpref

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private var userName: String = ""
    private lateinit var editTextName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create an instance of SharedPreference File
        sharedPreferences = getSharedPreferences("my.edu.tarc.sharedpref", Context.MODE_PRIVATE) //Let data to be used by another activity, or else use getPreferences()
        userName = sharedPreferences.getString(getString(R.string.user_name), getString(R.string.default_name))?:return   //get string or return null

        editTextName = findViewById(R.id.editTextName)
        editTextName.setText(userName)

        val buttonSave = findViewById<Button>(R.id.buttonSave)
        buttonSave.setOnClickListener {
            userName = editTextName.text.toString()
            with(sharedPreferences.edit()) {
                putString(getString(R.string.user_name), userName)
                apply()
            }
        }
    }
}