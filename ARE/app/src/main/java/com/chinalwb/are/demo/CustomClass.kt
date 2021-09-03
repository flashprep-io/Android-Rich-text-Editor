package com.chinalwb.are.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chinalwb.are.AREditText
import com.chinalwb.are.demo.toolitems.ARE_ToolItem_MyBold
import com.chinalwb.are.styles.toolbar.ARE_Toolbar
import com.chinalwb.are.styles.toolbar.ARE_ToolbarDefault
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Bold
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Italic
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Underline

class CustomClass: AppCompatActivity() {
    private lateinit var richEditText: AREditText
    private lateinit var toolbar: ARE_ToolbarDefault

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_class)

        initViews()
        initToolBar()
        setToolBarToEditText()
    }

    private fun initViews(){
        richEditText = findViewById(R.id.richEditText)
        toolbar = findViewById(R.id.toolbar)
    }

    private fun initToolBar(){
        val boldOption = ARE_ToolItem_Bold()
        val italicOption = ARE_ToolItem_Italic()
        val underlineOption = ARE_ToolItem_Underline()

        toolbar.addToolbarItem(boldOption)
        toolbar.addToolbarItem(italicOption)
        toolbar.addToolbarItem(underlineOption)
    }

    private fun setToolBarToEditText(){
        richEditText.setToolbar(toolbar)
    }
}