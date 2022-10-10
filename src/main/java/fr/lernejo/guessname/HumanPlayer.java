package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;
public class HumanPlayer implements Player {

	private final Logger logger = LoggerFactory.getLogger("Player");

        public long askNextGuess() {
        System.out.println("Entrer un nombre");
        Scanner scan = new Scanner(System.in);
        return scan.nextLong();
    }
}


