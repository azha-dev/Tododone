import java.time.LocalDateTime;

class ApplicationTime {
    public static void SetNow(LocalDateTime timeInjected){
        now = timeInjected;
    }

    public static LocalDateTime now;
}
