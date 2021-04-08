package main;
import org.joda.time.*;

public class Timer {
    private Instant start;
    private Period delta;

    public Timer(long start){
        this(new Instant(start));
    }

    public Timer(Instant start){
        this.start = start;
    }

    public Timer(){
        this(Instant.now());
    }

    public void stop(Instant end){
        delta = new Period(start,end);
        if(delta.get(DurationFieldType.millis()) < 0)
            throw new RuntimeException("Bad end");
    }

    public void stop(long end){
        this.stop(new Instant(end));
    }

    public void stop(){
        this.stop(Instant.now());
    }

    public void reset(){
        this.start = Instant.now();
    }

    public void reset(long newStart){
        this.start = new Instant(newStart);
    }

    public long getElapsedTime(){
        return delta.toStandardDuration().getMillis();
    }

    public int getDays(){
        return delta.get(DurationFieldType.days());
    } //TODO: Checkear

    public int getHours(){
        return delta.get(DurationFieldType.hours());
    }

    public int getMinutes(){
        return delta.get(DurationFieldType.minutes());
    }

    public double getSeconds(){
        return delta.get(DurationFieldType.seconds()) + delta.get(DurationFieldType.millis())/1000d;
    }

    @Override
    public String toString() {
        return String.format("(%s ms) %d dias %d horas %d minutos %d,%03d segundos",
                delta.toStandardDuration().getMillis(), delta.getDays(), delta.getHours(), delta.getMinutes(), delta.getSeconds(), delta.getMillis());
    }
}
