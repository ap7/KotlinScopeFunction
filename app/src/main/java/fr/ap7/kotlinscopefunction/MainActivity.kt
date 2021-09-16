package fr.ap7.kotlinscopefunction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var number: Int? = null

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Let is used for null check in kotlin
         **/

        // not a god solution
        if (number != null) {
            val number2 = number!! + 1
        } else number = 3

        // the good solution is

        // This block is only execute if number is not null
        // and then we access to this "it" which is juste number
        number?.let {
            val number2 = it + 1
        }

        val x = number?.let {
            val number2 = it + 1
            number2
        } ?: 3 // -> THIS THE ELSE CASE, elvis operator

        /**
         * ALSO is similar to  Let
         * But the difference is that also does not return the last line but LET does it
         * Also return the object it was called
         **/
        fun getSquareId() = (i + i).also {
            i++
        }

        /**
         * APPLY is used for to modify object, to make lot of changes on a specific object
         * Can be called on every object
         **/
        val intent = Intent().apply {
            putExtra("", "")
            putExtra("", 0)
            action = ""
        }

        /**
         * RUN is similar or equivalent to  APPLY
         * But the difference is that also return  an object but RUN doesn't it
         * RUN won't return the object it was called
         **/
        val intent2 = Intent().run {
            putExtra("", "")
            putExtra("", 0)
            action = ""
            this
        }

        /**
         * WITH is the same or to RUN
         **/
        val intent3 = with(Intent()) {
            putExtra("", "")
            putExtra("", 0)
            action = ""
            this
        }
    }
}
