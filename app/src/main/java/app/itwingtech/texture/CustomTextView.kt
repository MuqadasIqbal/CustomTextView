package app.itwingtech.texture

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat

class CustomTextView @JvmOverloads constructor(context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        attrs?.let {
            setCustomText(context,attrs)
        }
       //text = "Muqadas"
    }


    private fun setCustomText(context: Context, attrs: AttributeSet) {

        val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView)

            val customText = typedArray.getString(R.styleable.CustomTextView_customText) ?: "Default Text"
            text = customText

            val customtext=typedArray.getString(R.styleable.CustomTextView_customText)?:"Default Text"
            text=customtext

          val customFontResId = typedArray.getResourceId(R.styleable.CustomTextView_customTextFont, -1)
          if (customFontResId != -1) {
            typeface = ResourcesCompat.getFont(context, customFontResId) }

            val customTextSize = typedArray.getDimension(R.styleable.CustomTextView_customTextSize, 16f)
            textSize = customTextSize

            val customTextColor = typedArray.getColor(R.styleable.CustomTextView_customTextColor, resources.getColor(android.R.color.black))
            setTextColor(customTextColor)


            val alignment = typedArray.getInt(R.styleable.CustomTextView_customtextAligment, 0)
            when (alignment) {
                0 -> textAlignment = TEXT_ALIGNMENT_CENTER
                1 -> textAlignment = TEXT_ALIGNMENT_VIEW_START
                2 -> textAlignment = TEXT_ALIGNMENT_VIEW_END
            }


            val textStyle = typedArray.getInt(R.styleable.CustomTextView_customtextStyle, 0)
            when (textStyle) {
                0 -> setTypeface(typeface, android.graphics.Typeface.NORMAL)
                1 -> setTypeface(typeface, android.graphics.Typeface.BOLD)
                2 -> setTypeface(typeface, android.graphics.Typeface.ITALIC)
            }

            typedArray.recycle()
            }

    }
