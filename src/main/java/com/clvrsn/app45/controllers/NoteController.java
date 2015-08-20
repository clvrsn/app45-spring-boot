package com.clvrsn.app45.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clvrsn.app45.entities.Note;

@RestController
@RequestMapping("/rest")
public class NoteController {

	private static List<Note> notesDb = new ArrayList<Note>();
	
	@RequestMapping(value = "/notes", method = RequestMethod.GET)
	public ResponseEntity<List<Note>> notesList() {

		return new ResponseEntity<List<Note>>(NoteController.notesDb, HttpStatus.OK);
	}

	@RequestMapping(value = "/notes", method = RequestMethod.POST )
	public ResponseEntity<Note> notesCreate(@RequestBody Note note) {

		NoteController.notesDb.add(note);

		return new ResponseEntity<Note>(note, HttpStatus.OK);

	}

	@RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
			public ResponseEntity<Note> notesGet(@PathVariable Long id) {

		for (Note note : NoteController.notesDb) {

			if (note.getId() == id)
				return new ResponseEntity<Note>(note, HttpStatus.OK);

		}

		return new ResponseEntity<Note>(new Note(), HttpStatus.OK);
	}

	@RequestMapping(value = "/notes", method = RequestMethod.DELETE)
	public ResponseEntity<Note> notesDelete(@RequestBody Note note) {

		for (Note n : NoteController.notesDb) {

			if (note.getId() == note.getId()) {
				NoteController.notesDb.remove(note);
				break;
			}

		}
		
		return new ResponseEntity<Note>(new Note(), HttpStatus.OK);

	}

}
