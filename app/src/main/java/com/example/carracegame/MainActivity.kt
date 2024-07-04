package com.example.carracegame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity(),GameTask {
    private lateinit var rootLayout : LinearLayout
    private lateinit var startBtn : Button
    private lateinit var mGameView: GameView
    private lateinit var HighScore:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn = findViewById(R.id.startBtn)
        rootLayout= findViewById(R.id.rootLayout)
        HighScore = findViewById(R.id.HighScore)
        mGameView = GameView(this,this)

        startBtn.setOnClickListener {
            mGameView.setBackgroundResource(R.drawable.road)
            rootLayout.addView(mGameView)
            startBtn.visibility = View.GONE
            HighScore.visibility = View.GONE
        }
    }

    @SuppressLint("SetTextI18n")
    override fun closeGame(mScore: Int) {
        HighScore.text = "HighScore :$mScore"
        rootLayout.removeView(mGameView)
        startBtn.visibility = View.VISIBLE
        HighScore.visibility = View.VISIBLE
    }
}