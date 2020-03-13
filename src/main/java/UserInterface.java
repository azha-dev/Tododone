import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserInterface {
    private Output output;
    private Input input;
    private INotesService NotesService;

    public UserInterface(Output output, Input input) {
        this.output = output;
        this.input = input;
        this.NotesService = new NotesService();
    }

    public void Run(){
        int response = 0;
        while (response!=3){
            ApplicationTime.SetNow(LocalDateTime.now());
            this.output.Send(
                    "Welcome on TodoDone, how can we help you ?\n"+
                    "1. List my notes\n" +
                    "2. Add a note\n" +
                    "3. Quit\n");
            response = this.input.GetInt();
                switch (response) {
                    case 1:
                        listAllNotes();
                        break;
                    case 2:
                        addANote();
                        break;
                    case 3:
                        break;
                    default:
                        this.output.Send(response + "is not a valid response");
                }
        }
    }

    private void addANote() {
        this.output.Send("Please enter the description of the note");
        String description = input.GetString();
        this.NotesService.addOneNote(new Note(ApplicationTime.now, description));
    }

    private void listAllNotes() {
        ArrayList<Note> allNotes = NotesService.getAllNote();
        if (allNotes.size() == 0){
            output.Send("You have no notes");
            return;
        }

        for (Note note : allNotes) {
            output.Send(note.getTimeSinceNoteCreation()+ " " + note.getDescription());
            output.Send(note.getCreationDateTime() + " here " + ApplicationTime.now);
        }
    }
}
