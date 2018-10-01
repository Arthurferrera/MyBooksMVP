package br.com.senaijandira.mybooksmvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.senaijandira.mybooksmvp.model.Book;
import br.com.senaijandira.mybooksmvp.R;

/**
 * Created by sn1041520 on 27/09/2018.
 */

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context ctx){
        super(ctx, 0, new ArrayList<Book>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if(v == null){
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.book_item_layout, parent, false);
        }

        TextView txtTitulo = v.findViewById(R.id.txtBookTitulo);
        TextView txtDescricao = v.findViewById(R.id.txtBookDescricao);

        Book livro = getItem(position);

        txtTitulo.setText(livro.getTitulo());
        txtDescricao.setText(livro.getDescricao());

        return v;
    }
}
