import java.util.ArrayList;

public class NotesService implements INotesService {
    private ArrayList<Note> notes;

    public NotesService() {
        notes = new ArrayList<>();
    }

    @Override
    public void addOneNote(Note note){
        this.notes.add(note);
    }

    @Override
    public ArrayList<Note> getAllNote(){
        return notes;
    }
}
