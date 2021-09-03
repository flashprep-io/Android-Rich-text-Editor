package com.chinalwb.are.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chinalwb.are.AREditText
import com.chinalwb.are.demo.toolitems.ARE_ToolItem_MyBold
import com.chinalwb.are.styles.ARE_Strikethrough
import com.chinalwb.are.styles.toolbar.ARE_Toolbar
import com.chinalwb.are.styles.toolbar.ARE_ToolbarDefault
import com.chinalwb.are.styles.toolitems.*

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
        val strikethrough = ARE_ToolItem_Strikethrough()
        val superScriptOption = ARE_ToolItem_Superscript()
        val subScriptOption = ARE_ToolItem_Subscript()

        toolbar.addToolbarItem(boldOption)
        toolbar.addToolbarItem(italicOption)
        toolbar.addToolbarItem(underlineOption)
        toolbar.addToolbarItem(strikethrough)
        toolbar.addToolbarItem(superScriptOption)
        toolbar.addToolbarItem(subScriptOption)
    }

    private fun setToolBarToEditText(){
        richEditText.setToolbar(toolbar)
    }
}