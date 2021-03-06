package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    public static final ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        if (notes.isEmpty()) {
            notes.add(new Note("Парикмахерская", "сделать причёску", "Понедельник", 2));
            notes.add(new Note("Баскетбол", "с пацанами", "Вторник", 3));
            notes.add(new Note("Варик", "катать ладдер", "Среда", 1));
            notes.add(new Note("Писать код", "писать код", "Четверг", 2));
        }
        NotesAdapter adapter = new NotesAdapter(notes);
        // теперь нам необходимо указать как мы будем распологать RecyclerView
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotes.setAdapter(adapter);


    }

    public void onClickAddNote(View view) {
        Intent intent = new Intent(this, NoteAddActivity.class);
        startActivity(intent);
    }
}