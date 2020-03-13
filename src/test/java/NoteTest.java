import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {


    @Test
    public void should_return_30min_if_note_created_since_30_minutes(){
        ApplicationTime.SetNow(LocalDateTime.of(2020,3,10,17,30));
        Note note = new Note(LocalDateTime.of(2020,3,10,17,0), "test1");
        String expected = "30min";
        assertEquals(expected, note.getTimeSinceNoteCreation());
    }

    @Test
    public void should_return_7d_if_note_created_since_7_days(){
        ApplicationTime.SetNow(LocalDateTime.of(2020,3,17,17,0));
        Note note = new Note(LocalDateTime.of(2020,3,10,10,0), "test2");
        String expected = "7d";
        assertEquals(expected, note.getTimeSinceNoteCreation());
    }

    @Test
    public void should_return_2month_if_note_created_since_2_month(){
        ApplicationTime.SetNow(LocalDateTime.of(2020,3,17,17,0));
        Note note = new Note(LocalDateTime.of(2020,1,10,10,0), "test3");
        String expected = "2month";
        assertEquals(expected, note.getTimeSinceNoteCreation());
    }

    @Test
    public void should_return_0min_if_note_created_since_less_than_one_minute(){
        ApplicationTime.SetNow(LocalDateTime.of(2020,1,10,10,0,0));
        Note note = new Note(LocalDateTime.of(2020,1,10,10,0,17), "test3");
        String expected = "0min";
        assertEquals(expected, note.getTimeSinceNoteCreation());
    }
}