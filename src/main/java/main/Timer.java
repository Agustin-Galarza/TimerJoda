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
        return delta.toStandardDays().getDays();
    } //TODO: Checkear

    public int getHours(){
        return delta.getHours();
    }

    public int getMinutes(){
        return delta.getMinutes();
    }

    public double getSeconds(){
        return delta.getSeconds() + delta.getMillis()/1000d;
    }

    @Override
    public String toString() {
        return String.format("(%s ms) %d dias %d horas %d minutos %d,%03d segundos",
                delta.toStandardDuration().getMillis(), delta.getDays(), delta.getHours(), delta.getMinutes(), delta.getSeconds(), delta.getMillis());
    }
}
