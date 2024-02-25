import java.util.Timer;
import java.util.TimerTask;

/**
 * Chrono is a timer class that creates a time counter from a given initial time.
 * It allows starting, stopping, and displaying the current time.
 *
 * @version 1.0
 * @author Zoumana Emmanuel Traoré
 */
public class Chrono {

    private int seconds;
    private int hours;
    private int minutes;
    private int timing;
    private int currSeconds;
    private int currMinutes;
    private int currHours;
    private Timer timer = new Timer();

    /**
     * Default constructor. Initializes a Chrono object with zero time.
     */
    public Chrono() {
        // Do nothing in the constructor for initialization
    }

    /**
     * Initializes a Chrono object with the given hours, minutes, and seconds.
     *
     * @param hours   The initial hours value.
     * @param minutes The initial minutes value.
     * @param seconds The initial seconds value.
     */
    public void initialize(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

        this.currHours = hours;
        this.currMinutes = minutes;
        this.currSeconds = seconds;

        this.timing = (this.currHours * 3600) + (this.currMinutes * 60) + this.currSeconds;
    }

    /**
     * Starts the timer.
     */
    public void start() {
        try {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    show();
                    if (timing > 0) {
                        timing--;
                        toHours();
                        toMinutes();
                        toSeconds();
                    } else {
                        stop();
                        System.out.println("End of Chrono");
                    }
                }
            }, 1000, 1000);
        } catch (IllegalStateException e) {
            System.out.println("Error starting timer: " + e.getMessage());
        }
    }

    /**
     * Stops the timer.
     */
    public void stop() {
        try {
            timer.cancel();
            timer.purge();
        } catch (IllegalStateException e) {
            System.out.println("Error stopping timer: " + e.getMessage());
        }
    }

    /**
     * Displays the current time in the format: hours h : minutes mn : seconds s.
     */
    protected void show() {
        System.out.println(this.toString());
    }

    /**
     * Returns the current time in hours.
     *
     * @return The current hours value.
     */
    public int toHours() {
        int restTiming = this.timing;
        int restHours;
        restHours = (int) ((restTiming - restTiming % 3600) / 3600);

        this.currHours = restHours;

        return restHours;
    }

    /**
     * Returns the current time in minutes.
     *
     * @return The current minutes value.
     */
    public int toMinutes() {
        int restTiming = this.timing;
        int restHours = this.toHours();
        int rest = (restTiming - (restHours * 3600));
        int restMinutes = (int) ((rest - rest % 60) / 60);

        this.currMinutes = restMinutes;

        return restMinutes;
    }

    /**
     * Returns the current time in seconds.
     *
     * @return The current seconds value.
     */
    public int toSeconds() {
        int restTiming = this.timing;
        int restHours = this.toHours();
        int restMinutes = this.toMinutes();
        int rest = (int) (restTiming - (restHours * 3600) - (restMinutes * 60));
        int restSeconds = rest;

        this.currSeconds = restSeconds;

        return restMinutes;
    }

    /**
     * Returns a string representation of the current time.
     *
     * @return The string representation of the current time.
     */
    @Override
    public String toString() {
        String str = this.currHours + " h : " + this.currMinutes + " mn : " + this.currSeconds + " s";
        return str;
    }

    /**
     * Main method for testing the Chrono class.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Chrono chrono = new Chrono();
        chrono.initialize(1, 30, 0);
        chrono.start();
    }
}
