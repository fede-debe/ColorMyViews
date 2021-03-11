package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // we call here the main function that handle the logic to change color while clicking on a view
        setListener()
    }

    private fun setListener(){
        // because we set the same ClickListener on each view, we use a list of view and then set listener for each view.
        val clickableViews: List<View> = listOf(box_one_text, box_two_text, box_three_text,
                                                box_four_text, box_five_text, constraint_layout,
                                                red_button, yellow_button, green_button)
        // set the Listener for each view
        for (item in clickableViews){
            item.setOnClickListener { makeColored(it)}
        }
    }

    private fun makeColored(view: View){
     // every view has a resource ID, we pick a color depending on which the source ID is. common pattern to use one click handler when the type of action is the same
    when(view.id){
        // Boxes using Color class colors for background
        R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
        R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

        // Boxes using Android color resources for background
        R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
        R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
        R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

        // Boxes using custom colors for background
        R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
        R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
        R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)

        // if the user tap the background of the views it gets light gray which reveals the outlines of the other boxes to click as a hint.( to make this work we need to call the layout in question inside the listOf views)
        else -> view.setBackgroundColor(Color.LTGRAY)
    }


    }

}