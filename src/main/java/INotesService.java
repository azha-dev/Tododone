import java.util.ArrayList;

public interface INotesService {
    void addOneNote(Note note);

    ArrayList<Note> getAllNote();
}
