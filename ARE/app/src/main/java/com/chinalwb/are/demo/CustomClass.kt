package com.chinalwb.are.demo

import android.os.Bundle
import android.view.View
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
    private lateinit var richEditText2: AREditText
    private lateinit var toolbar2: ARE_ToolbarDefault

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_class)

        initViews()
        initToolBar1()
        initToolBar2()
        setToolBarToEditText()
        setFocusChangeListener()
    }

    private fun initViews(){
        richEditText = findViewById(R.id.richEditText)
        toolbar = findViewById(R.id.toolbar)
        richEditText2 = findViewById(R.id.richEditText2)
        toolbar2 = findViewById(R.id.toolbar2)
    }

    private fun initToolBar1(){
        val boldOption = ARE_ToolItem_Bold()
        val italicOption = ARE_ToolItem_Italic()
        val underlineOption = ARE_ToolItem_Underline()
        val strikethrough = ARE_ToolItem_Strikethrough()
        val superScriptOption = ARE_ToolItem_Superscript()
        val subScriptOption = ARE_ToolItem_Subscript()
        val imageOption = ARE_ToolItem_Image()

        toolbar.addToolbarItem(boldOption)
        toolbar.addToolbarItem(italicOption)
        toolbar.addToolbarItem(underlineOption)
        toolbar.addToolbarItem(strikethrough)
        toolbar.addToolbarItem(superScriptOption)
        toolbar.addToolbarItem(subScriptOption)
        toolbar.addToolbarItem(imageOption)
    }

    private fun initToolBar2(){
        val boldOption = ARE_ToolItem_Bold()
        val italicOption = ARE_ToolItem_Italic()
        val underlineOption = ARE_ToolItem_Underline()
        val strikethrough = ARE_ToolItem_Strikethrough()
        val superScriptOption = ARE_ToolItem_Superscript()
        val subScriptOption = ARE_ToolItem_Subscript()
        val imageOption = ARE_ToolItem_Image()

        toolbar2.addToolbarItem(boldOption)
        toolbar2.addToolbarItem(italicOption)
        toolbar2.addToolbarItem(underlineOption)
        toolbar2.addToolbarItem(strikethrough)
        toolbar2.addToolbarItem(superScriptOption)
        toolbar2.addToolbarItem(subScriptOption)
        toolbar2.addToolbarItem(imageOption)
    }

    private fun setToolBarToEditText(){
        richEditText.setToolbar(toolbar)
        richEditText2.setToolbar(toolbar2)
        toolbar2.visibility = View.INVISIBLE
    }

    private fun setFocusChangeListener(){
        richEditText.setOnFocusChangeListener(object : View.OnFocusChangeListener{
            override fun onFocusChange(p0: View?, hasFocus: Boolean) {
                if(hasFocus){
                    toolbar.visibility = View.VISIBLE
                    toolbar2.visibility = View.INVISIBLE
                }
            }
        })

        richEditText2.setOnFocusChangeListener(object : View.OnFocusChangeListener{
            override fun onFocusChange(p0: View?, hasFocus: Boolean) {
                if(hasFocus){
                    toolbar2.visibility = View.VISIBLE
                    toolbar.visibility = View.INVISIBLE
                }
            }
        })
    }
}