package com.example.taskmanagerapp

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanagerapp.databinding.ActivityMainBinding
import com.example.taskmanagerapp.utils.setupDialog

class MainActivity : AppCompatActivity() {

    private val mainBinding:ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val addTaskDialog : Dialog by lazy{
        Dialog(this,R.style.DialogCustomTheme).apply {
            setupDialog(R.layout.add_task_dialog)
        }
    }
    private val updateTaskDialog : Dialog by lazy{
        Dialog(this,R.style.DialogCustomTheme).apply {
            setupDialog(R.layout.update_task_dialog)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)


        val addCloseImg = addTaskDialog.findViewById<ImageView>(R.id.closeImg)
        val updateCloseImg = updateTaskDialog.findViewById<ImageView>(R.id.closeImg)

        addCloseImg.setOnClickListener{addTaskDialog.dismiss()}
        updateCloseImg.setOnClickListener{updateTaskDialog.dismiss()}

        mainBinding.addTaskFaBtn.setOnClickListener{
            addTaskDialog.show()
        }
    }
}