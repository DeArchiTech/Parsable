package com.parsable.appetizer.parasable.View;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parsable.appetizer.parasable.Event.SendDataEvent;
import com.parsable.appetizer.parasable.ParsableEnum;
import com.parsable.appetizer.parasable.Presenter.ISendDataPresenter;
import com.parsable.appetizer.parasable.Presenter.SendDataPresenterImpl;
import com.parsable.appetizer.parasable.R;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;
import com.parsable.appetizer.parasable.Subscriber.SendTextSubscriber;

import org.jetbrains.annotations.NotNull;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

public class SendDataActivity extends AppCompatActivity implements ISendDataScreen, View.OnClickListener {

    ISendDataPresenter presenter;

    @Bind(R.id.sendDataEditText)
    TextView sendDataTextView;

    @Bind(R.id.sendDatabutton)
    Button sendDataButton;

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch(id){

            case R.id.sendDatabutton:{
                this.sendDataButtonPressed();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        ButterKnife.bind(this);
        this.sendDataButton.setOnClickListener(this);
    }

    @Override
    public void displayActionMessage(@NotNull ParsableEnum.actionName action, boolean result) {

        if (result) {

            displaySuccessMessage(action.name());

        } else {

            displayError(action.name());
        }

    }

    public ISendDataPresenter getPresenter() {
        if(presenter == null){
            presenter = new SendDataPresenterImpl(new RepositoryImpl());
        }
        return presenter;
    }


    @Override
    public void setPresnter(@NotNull ISendDataPresenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void sendDataButtonPressed() {

        CharSequence input = getInput();
        if(input != null){

            //Call Presenter with Event
            String inputString = input.toString();
            SendDataEvent sendDataEvent = new SendDataEvent(input.toString());
            getPresenter().sendDataEvent(sendDataEvent , this);

        }

    }

    private CharSequence getInput(){

        if(this.sendDataTextView!=null){
            return this.sendDataTextView.getText();
        }
        return null;

    }


    private void displayError(String action) {

        AlertDialog.Builder builder = new AlertDialog.Builder(SendDataActivity.this);
        builder.setMessage(action + " " + getString(R.string.displayErrorTitlePostfix))
                .setPositiveButton(action + " " +getString(R.string.displayErrorMessagePostfix), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog  = builder.create();
        dialog.show();


    }

    private void displaySuccessMessage(@NotNull String action) {

        AlertDialog.Builder builder = new AlertDialog.Builder(SendDataActivity.this);
        builder.setMessage(action)
                .setPositiveButton(getString(R.string.displaySuccessButton), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog  = builder.create();
        dialog.show();

    }

}
