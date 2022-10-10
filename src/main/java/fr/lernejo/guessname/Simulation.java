public class Simulation {

  private final Logger logger = LoggerFactory.getLogger("simulation");
  private final Player player;  
  private long numberToGuess; 

  public Simulation(Player player) {
    this Player = player;
  }

  public void initialize(long numberToGuess) {
    this numberToGuess = numberToGuess;
  }

  
   private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess) {
            logger.log("won");
            return true;
        }
        if (guess > numberToGuess) {
            logger.log("Le nombre est plus petit\n");
            player.respond(false);
        }else{
            logger.log("Le nombre est plus grand \n");
            player.respond(true);
        }

        return false;
    
  }

  public void loopUntilPlayerSucceed() {
       int iter = 0;
        LocalDateTime time = LocalDateTime.now();
        logger.log("Devinez le nombre");
        while (!nextRound() && iter < maxIterations) {
            iter++;
        }
        Duration diff = Duration.between(time, LocalDateTime.now());
        logger.log(String.format("%02d:%02d.%03d", diff.toMinutesPart(), diff.toSecondsPart(), diff.toMillisPart()));
        if (iter >= maxIterations)
            logger.log("perdu !!");
        else
            logger.log("gagné !");

  }
}
