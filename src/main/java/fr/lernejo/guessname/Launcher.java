package fr.lernejo.guessname;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;



public class Launcher {
    private static final Logger logger = LoggerFactory.getLogger("Launcher");

     public static void main(String args[])
    {
        long iterations = 1000;
        long random = new SecureRandom().nextLong(100);
        Player player = null;
        if (args.length > 0)
        {
            if (args[0].equals("-interactive"))
            {
                player = new HumanPlayer();
                iterations = Long.MAX_VALUE;
            }
            else if (args[0].equals("-auto"))
            {
                try
                {
                    random = Long.parseLong(args[1]);
                    player = new ComputerPlayer();
                }
                catch (Exception e)
                {
                    logger.log(e.getMessage());
                }
            }
        }
        if (player != null)
        {
            Simulation simulation = new Simulation(player);
            simulation.initialize(random);
            simulation.loopUntilPlayerSucceed(iterations);
        }
        else
        {
            logger.log("il faut saisir -auto et un nombre ou saisir -interactive");
        }
    }
}

