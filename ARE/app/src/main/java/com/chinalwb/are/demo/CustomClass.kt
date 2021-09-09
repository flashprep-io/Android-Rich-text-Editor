package com.chinalwb.are.demo

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.*
import android.text.style.AlignmentSpan
import android.text.style.ImageSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.chinalwb.are.AREditText
import com.chinalwb.are.Constants
import com.chinalwb.are.demo.toolitems.ARE_ToolItem_MyBold
import com.chinalwb.are.styles.ARE_Bold
import com.chinalwb.are.styles.ARE_Strikethrough
import com.chinalwb.are.styles.toolbar.ARE_Toolbar
import com.chinalwb.are.styles.toolbar.ARE_ToolbarDefault
import com.chinalwb.are.styles.toolitems.*
import kotlinx.android.synthetic.main.activity_index.*

class CustomClass: AppCompatActivity() {
    private lateinit var richEditText: AREditText
    private lateinit var toolbar: ARE_ToolbarDefault
    private lateinit var richEditText2: AREditText
    private lateinit var toolbar2: ARE_ToolbarDefault

    private lateinit var customBold: ARE_Bold
    private lateinit var customBoldButton: ImageView
    private lateinit var customImageButton: ImageView
    private lateinit var getHtmlButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_class)

        initViews()
        initToolBar1()
        initToolBar2()
        setToolBarToEditText()
        setFocusChangeListener()
        initCustomToolBar()
        bindCustomToolBar()
    }

    private fun initViews(){
        richEditText = findViewById(R.id.richEditText)
        toolbar = findViewById(R.id.toolbar)
        richEditText2 = findViewById(R.id.richEditText2)
        toolbar2 = findViewById(R.id.toolbar2)
    }

    private fun initToolBar1(){
        val boldOption = ARE_ToolItem_Bold(R.drawable.bold_active, R.drawable.bold_in_active)
        val italicOption = ARE_ToolItem_Italic(R.drawable.italic_active, R.drawable.italic_in_active)
        val underlineOption = ARE_ToolItem_Underline(R.drawable.underline_active, R.drawable.underline_inactive)
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
        val boldOption = ARE_ToolItem_MyBold(R.drawable.bold, R.drawable.bold)
        val italicOption = ARE_ToolItem_Italic(R.drawable.italic, R.drawable.italic)
        val underlineOption = ARE_ToolItem_Underline(R.drawable.underline_active, R.drawable.underline_inactive)
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

    private fun initCustomToolBar(){
        customBoldButton = findViewById(R.id.customBoldButton)
        customImageButton = findViewById(R.id.customImageButton)
        getHtmlButton = findViewById(R.id.getHtmlButton)
        customBold = ARE_Bold(customBoldButton)
        customBold.setEditText(richEditText)
    }

    private fun bindCustomToolBar(){
        customImageButton.setOnClickListener {
            insertImageToEditText()
        }

        getHtmlButton.setOnClickListener {
            getHtmlData()
        }
    }

    private fun insertImageToEditText() {
        val editable = richEditText.editableText
        val startSelection = richEditText.selectionStart
        val endSelection = richEditText.selectionEnd

        val imageDrawable: Drawable = ContextCompat.getDrawable(this, R.drawable.cartoon_man_in_love)!!
        imageDrawable.setBounds(0, 0, imageDrawable.intrinsicWidth, imageDrawable.intrinsicHeight)
        val imageSpan =
            ImageSpan(imageDrawable, "https://flashprep-media-aps1.s3.ap-south-1.amazonaws.com/release/000-create-default/01.jpg")

        val centerSpan = AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER)
        val builder = SpannableStringBuilder()
        builder.append(Constants.CHAR_NEW_LINE)
        builder.append(Constants.ZERO_WIDTH_SPACE_STR)
        builder.append(Constants.CHAR_NEW_LINE)
        builder.append(Constants.ZERO_WIDTH_SPACE_STR)
        builder.setSpan(imageSpan, 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        builder.setSpan(centerSpan, 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val leftSpan: AlignmentSpan = AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL)
        builder.setSpan(leftSpan, 3, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

        editable.replace(startSelection, endSelection, builder)
    }

    private fun getHtmlData(){
        println("-----${richEditText.html}")
    }
}