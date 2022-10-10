package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    
	private final Logger _log = LoggerFactory.getLogger(ComputerPlayer.class.getName());

     	private long nb_guess;
    	private long max = Long.MAX_VALUE;
    	private long min = 0;

    @Override
    public long askNextGuess(){
        nb_guess = (max + min) / 2;
        return nb_guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater)
        {
            min = nb_guess;
        }
        else
        {
            max = nb_guess;
        }
    }
}
