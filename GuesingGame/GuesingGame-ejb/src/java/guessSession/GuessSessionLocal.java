/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package guessSession;

import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface GuessSessionLocal {

    int makeGuess(int guess);

    public int getAnswer();

    ArrayList<Integer> getGuesses();

    public void addGuess(int guess);

    void reset();

    public int getNumGuesses();
    
}
