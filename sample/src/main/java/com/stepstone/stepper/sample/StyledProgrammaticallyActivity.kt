package com.stepstone.stepper.sample

import android.content.res.ColorStateList
import android.os.Bundle
import android.support.annotation.ColorInt
import android.view.View
import butterknife.BindColor

/**
 * @author Piotr Zawadzki
 */
class StyledProgrammaticallyActivity : AbstractStepperActivity() {

    @BindColor(R.color.ms_custom_button_text_color)
    lateinit var customButtonColor: ColorStateList

    @BindColor(R.color.custom_active_step_color)
    @JvmField
    var customActiveStepColor: Int = 0

    @BindColor(R.color.custom_inactive_step_color)
    @JvmField
    var customInactiveStepColor: Int = 0

    @BindColor(R.color.custom_bottom_navigation_background_color)
    @JvmField
    var customBottomNativationBackgroundColor: Int = 0

    @ColorInt
    @JvmField
    @BindColor(R.color.ms_black)
    var blackColorInt: Int = 0

    override val layoutResId: Int
        get() = R.layout.activity_set_button_color_programmatically

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(stepperLayout) {
            setNextButtonColor(customButtonColor)
            setBackButtonColor(customButtonColor)
            setCompleteButtonColor(customButtonColor)
            setActiveStepColor(customActiveStepColor)
            setInactiveStepColor(customInactiveStepColor)
            setBottomNavigationBackgroundColor(customBottomNativationBackgroundColor)
        }
    }

    override fun onStepSelected(newStepPosition: Int) {
        super.onStepSelected(newStepPosition)
        when (newStepPosition) {
            1 -> stepperLayout.setNextButtonColor(blackColorInt)
            2 -> stepperLayout.setBackButtonColor(blackColorInt)
        }
    }

    override fun onCompleted(completeButton: View) {
        super.onCompleted(completeButton)
        stepperLayout.setCompleteButtonColor(blackColorInt)
    }
}
