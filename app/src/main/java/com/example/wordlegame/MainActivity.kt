package com.example.wordlegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

//import com.example.wordlegame.MainActivity.FourLetterWordList.fourLetterWords


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sumOfFunctions()

}
   private fun sumOfFunctions(){

        val button = findViewById<Button>(R.id.btn)
        val reset = findViewById<Button>(R.id.btn2)
        val textView = findViewById<TextView>(R.id.textView)
        val guessOne = findViewById<TextView>(R.id.guess1)
        val responseOne = findViewById<TextView>(R.id.respond1)
        val responseTwo = findViewById<TextView>(R.id.respond2)
        val responseThree = findViewById<TextView>(R.id.respond3)
        val guessTwo = findViewById<TextView>(R.id.guess2)
        val guessThree = findViewById<TextView>(R.id.guess3)
        val input = findViewById<EditText>(R.id.addText)


        val duration=Toast.LENGTH_LONG
        val toast=Toast.makeText(applicationContext,"Sorry, You have exceeded the 3 number of chances",duration)
        var i:Int=1
       var j:Int=1
       var word:String=""
//for (i:Int in 1..3) {


    button.setOnClickListener {
        if (i == 1) {
            guessOne.text = input.text.toString()
            word= guessOne.text as String
            input.getText().clear()
            responseOne.text= checkGuess(word)

        }


        if (i == 2) {
            guessTwo.text = input.text.toString()
            word= guessTwo.text as String
           responseTwo.text = checkGuess(word)
            input.getText().clear()
            Log.d("TAG", "this is two")

        }


        if (i == 3) {
            guessThree.text = input.text.toString()
            word= guessThree.text as String
         responseThree.text = checkGuess(word)
            input.getText().clear()
            textView.visibility = View.VISIBLE
            reset.visibility = View.VISIBLE
            textView.text=wordToGuess
            disable(button, textView)
            toast.show()
            Log.d("TAG", "this is three")

        }

        i++
    }


    reset.visibility = View.VISIBLE;
    reset.setOnClickListener {
        reset.visibility = View.INVISIBLE

        enable(button, textView)
        i = 1
        guessOne.text = ""
        guessTwo.text = ""
        guessThree.text = ""
        responseOne.text = ""
        responseTwo.text = ""
        responseThree.text = ""


        textView.visibility = View.INVISIBLE
    }
    Log.d("Tag", "greater than 3")

    }
    private fun enable(button: Button?, textView: TextView?) {
        if (button != null) {
            button.isEnabled = true
        };
        if (textView != null) {
            if (button != null) {
                button.setTextColor(ContextCompat.getColor(textView.context, R.color.white))
            }
        }
        if (button != null) {
            if (textView != null) {
                button.setBackgroundColor(
                    ContextCompat.getColor(
                        textView.context,
                        R.color.purple_700
                    )
                )
            }
        }
    }
}

    private fun disable(button: Button?, textView: TextView?) {
        if (button != null) {
            button.isEnabled = false
        };
        if (textView != null) {
            if (button != null) {
                button.setTextColor(ContextCompat.getColor(textView.context, R.color.white))
            }
        }
        if (button != null) {
            if (textView != null) {
                button.setBackgroundColor(
                    ContextCompat.getColor(
                        textView.context,
                        androidx.appcompat.R.color.material_grey_600
                    )
                )
            }
        }
    }

//}

object FourLetterWordList {
        // List of most common 4 letter words from: https://7esl.com/4-letter-words/
        val fourLetterWords =
            "Area,Army,Baby,Back,Ball,Band,Bank,Base,Bill,Body,Book,Call,Card,Care,Case,Cash,City,Club,Cost,Date,Deal,Door,Duty,East,Edge,Face,Fact,Farm,Fear,File,Film,Fire,Firm,Fish,Food,Foot,Form,Fund,Game,Girl,Goal,Gold,Hair,Half,Hall,Hand,Head,Help,Hill,Home,Hope,Hour,Idea,Jack,John,Kind,King,Lack,Lady,Land,Life,Line,List,Look,Lord,Loss,Love,Mark,Mary,Mind,Miss,Move,Name,Need,News,Note,Page,Pain,Pair,Park,Part,Past,Path,Paul,Plan,Play,Post,Race,Rain,Rate,Rest,Rise,Risk,Road,Rock,Role,Room,Rule,Sale,Seat,Shop,Show,Side,Sign,Site,Size,Skin,Sort,Star,Step,Task,Team,Term,Test,Text,Time,Tour,Town,Tree,Turn,Type,Unit,User,View,Wall,Week,West,Wife,Will,Wind,Wine,Wood,Word,Work,Year,Bear,Beat,Blow,Burn,Call,Care,Cast,Come,Cook,Cope,Cost,Dare,Deal,Deny,Draw,Drop,Earn,Face,Fail,Fall,Fear,Feel,Fill,Find,Form,Gain,Give,Grow,Hang,Hate,Have,Head,Hear,Help,Hide,Hold,Hope,Hurt,Join,Jump,Keep,Kill,Know,Land,Last,Lead,Lend,Lift,Like,Link,Live,Look,Lose,Love,Make,Mark,Meet,Mind,Miss,Move,Must,Name,Need,Note,Open,Pass,Pick,Plan,Play,Pray,Pull,Push,Read,Rely,Rest,Ride,Ring,Rise,Risk,Roll,Rule,Save,Seek,Seem,Sell,Send,Shed,Show,Shut,Sign,Sing,Slip,Sort,Stay,Step,Stop,Suit,Take,Talk,Tell,Tend,Test,Turn,Vary,View,Vote,Wait,Wake,Walk,Want,Warn,Wash,Wear,Will,Wish,Work,Able,Back,Bare,Bass,Blue,Bold,Busy,Calm,Cold,Cool,Damp,Dark,Dead,Deaf,Dear,Deep,Dual,Dull,Dumb,Easy,Evil,Fair,Fast,Fine,Firm,Flat,Fond,Foul,Free,Full,Glad,Good,Grey,Grim,Half,Hard,Head,High,Holy,Huge,Just,Keen,Kind,Last,Late,Lazy,Like,Live,Lone,Long,Loud,Main,Male,Mass,Mean,Mere,Mild,Nazi,Near,Neat,Next,Nice,Okay,Only,Open,Oral,Pale,Past,Pink,Poor,Pure,Rare,Real,Rear,Rich,Rude,Safe,Same,Sick,Slim,Slow,Soft,Sole,Sore,Sure,Tall,Then,Thin,Tidy,Tiny,Tory,Ugly,Vain,Vast,Very,Vice,Warm,Wary,Weak,Wide,Wild,Wise,Zero,Ably,Afar,Anew,Away,Back,Dead,Deep,Down,Duly,Easy,Else,Even,Ever,Fair,Fast,Flat,Full,Good,Half,Hard,Here,High,Home,Idly,Just,Late,Like,Live,Long,Loud,Much,Near,Nice,Okay,Once,Only,Over,Part,Past,Real,Slow,Solo,Soon,Sure,That,Then,This,Thus,Very,When,Wide"
       // Returns a list of four letter words as a list
        fun getAllFourLetterWords(): List<String> {
            return fourLetterWords.split(",")
        }
    // Returns a random four letter word from the list in all caps
        fun getRandomFourLetterWord(): String {
            val allWords = getAllFourLetterWords()
            val randomNumber = (0..allWords.size).shuffled().last()
            return allWords[randomNumber].uppercase()
        }
    }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
   var wordToGuess:String= FourLetterWordList.getRandomFourLetterWord();

    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

