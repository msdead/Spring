package DZ6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import DZ6.domain.Note;
import DZ6.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService implements iNoteService {

    private NoteRepository repository;

    @Override
    public Note createNote(Note note) {
        return repository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Optional<Note> getNoteFromId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Note updateNote(Long id, Note updatedNote) {
        Optional<Note> optionalNote = getNoteFromId(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setContent(updatedNote.getContent());
            repository.save(note);
            return note;
        } else {
            return null;
        }
    }

    @Override
    public void deleteNote(Long id) {
        repository.deleteById(id);
    }
}
