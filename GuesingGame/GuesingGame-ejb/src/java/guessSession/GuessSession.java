/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package guessSession;

import java.util.ArrayList;
import javax.ejb.Stateful;

/**
 *
 * @author Administrator
 */
@Stateful
public class GuessSession implements GuessSessionLocal {
    
    int answer = 0;
    ArrayList<Integer> guesses = new ArrayList<Integer>();
    int numGuesses = 0;

    public GuessSession()
    {
        this.reset();
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public void setNumGuesses(int numGuesses) {
        this.numGuesses = numGuesses;
    }

    public int makeGuess(int guess) {
        if(guess > this.getAnswer())
        {
            this.addGuess(guess);
            this.setNumGuesses(++numGuesses);
            return 1;
        }
        else if(guess == this.getAnswer())
        {
            return 0;
        }
        else
        {
            this.addGuess(guess);
            this.setNumGuesses(++numGuesses);
            return -1;
        }
    }

    public ArrayList<Integer> getGuesses() {
        return this.guesses;
    }

    public void addGuess(int guess){
        this.guesses.add(guess);
    }

    public void reset() {
        this.guesses.clear();
        this.numGuesses = 0;
        this.setAnswer((int) (Math.random() * 100));
    }

}
