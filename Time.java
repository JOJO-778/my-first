public class Time {

    public static void main(String[] args) {
        TimeModel timeModel = new TimeModel();
        TimeView timeView = new TimeView();
        TimeController timeController = new TimeController(timeView, timeModel);
        timeController.run();
    }

}