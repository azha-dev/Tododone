import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Note {
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    private LocalDateTime creationDateTime;
    private String description;

    public Note(LocalDateTime creationDateTime, String description) {
        this.creationDateTime = creationDateTime;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTimeSinceNoteCreation(){
        if(ChronoUnit.MONTHS.between(this.creationDateTime, ApplicationTime.now) > 0) {
            return (int) ChronoUnit.MONTHS.between(this.creationDateTime, ApplicationTime.now) + "month";
        } else if(ChronoUnit.DAYS.between(this.creationDateTime, ApplicationTime.now) > 0){
            return (int) ChronoUnit.DAYS.between(this.creationDateTime, ApplicationTime.now) + "d";
        } else if(ChronoUnit.MINUTES.between(this.creationDateTime, ApplicationTime.now) > 0){
            return (int) ChronoUnit.MINUTES.between(this.creationDateTime, ApplicationTime.now) + "min";
        } else {
            return 0 + "min";
        }
    }
}
