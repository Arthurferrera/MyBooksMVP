package br.com.senaijandira.mybooksmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import br.com.senaijandira.mybooksmvp.adapter.BookAdapter;
import br.com.senaijandira.mybooksmvp.model.Book;

public class MainActivity extends AppCompatActivity
    implements AdapterView.OnItemClickListener {

    ListView lstViewBooks;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstViewBooks = findViewById(R.id.lstViewBooks);

        //configurando o adapter
        bookAdapter = new BookAdapter(this);
        lstViewBooks.setAdapter(bookAdapter);

        //configurando o click da lista
        lstViewBooks.setOnItemClickListener(this);

        //criando alguns objetos fake
        bookAdapter.add(new Book(0,"Kotlin Android", "teste lalala"));
        bookAdapter.add(new Book(0,"Pequeno principe", "teste lalala"));
    }


    //Quando clicou em um item da lista
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Book livroClicado = bookAdapter.getItem(position);

        Toast.makeText(this,
                livroClicado.getTitulo(),
                Toast.LENGTH_LONG
                ).show();

    }
}
