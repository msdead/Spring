package DZ6.service;

import DZ6.domain.Note;

import java.util.List;
import java.util.Optional;

public interface iNoteService {

    Note createNote(Note note);

    List<Note> getAllNotes();

    Optional<Note> getNoteFromId(Long id);

    Note updateNote(Long id, Note note);

    void deleteNote(Long id);

}
