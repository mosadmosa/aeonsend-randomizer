package com.games.boardgames.aeonsend.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.games.boardgames.aeonsend.R;
import com.games.boardgames.aeonsend.utils.Constants;
import com.games.boardgames.aeonsend.listeners.OnDataPass;
import com.games.boardgames.aeonsend.listeners.OnPlayersChange;

/**
 * Created by honza on 29.9.17.
 */

public class PlayersBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private TextView textView;
    private ImageView subtractImageView;
    private ImageView addImageView;
    private int numPlayers;
    private OnDataPass dataPasser;
    private OnPlayersChange playerChanger;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
        playerChanger = (OnPlayersChange) context;
        numPlayers = dataPasser.getFragmentValuesBundle().getInt(Constants.EXTRASNUMPLAYERS);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            if (numPlayers == 0) {
                numPlayers = 4;
            }
        } else {
            numPlayers = savedInstanceState.getInt("numPlayers");
        }

        // Pass number of PLayers to parent Activity
        passData(numPlayers);

        View view = inflater.inflate(R.layout.players_fragment, container, false);

        textView = view.findViewById(R.id.players_fragment_num_players_value_textview);
        textView.setText(String.valueOf(numPlayers));

        subtractImageView = view.findViewById(R.id.players_fragment_subtract_imageview);
        subtractImageView.setImageResource(R.drawable.ic_remove_black_48dp);
        subtractImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numPlayers != 1) {
                    numPlayers--;
                }
                textView.setText(String.valueOf(numPlayers));
                passData(numPlayers);
                playerChanger.onPlayersChange(numPlayers);

            }
        });

        addImageView = view.findViewById(R.id.players_fragment_add_imageview);
        addImageView.setImageResource(R.drawable.ic_add_black_48dp);
        addImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numPlayers != 4) {
                    numPlayers++;
                }
                textView.setText(String.valueOf(numPlayers));
                passData(numPlayers);
                playerChanger.onPlayersChange(numPlayers);

            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numPlayers", numPlayers);
    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    public void passData(int numPlayers) {
        dataPasser.onDataPass(Constants.EXTRASNUMPLAYERS, numPlayers);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}
