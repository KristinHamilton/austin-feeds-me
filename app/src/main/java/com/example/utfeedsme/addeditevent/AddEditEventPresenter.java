package com.example.utfeedsme.addeditevent;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.utfeedsme.addeditevent.AddEditEventContract.Presenter;
import com.example.utfeedsme.data.Event;
import com.example.utfeedsme.data.EventsDataSource;
import com.firebase.client.Firebase;


/**
 * Created by darrankelinske on 4/13/16.
 */
public class AddEditEventPresenter implements Presenter {

    private String mEventId;
    private Firebase mFirebase;
    private EventsDataSource mEventsRepository;
    private AddEditEventContract.View mAddEditEventView;

    public AddEditEventPresenter(@Nullable String taskId, Firebase firebase,
                                 @NonNull EventsDataSource eventsRepository,
                                 @NonNull AddEditEventContract.View addEventView) {
        mEventId = taskId;
        mFirebase = firebase;
        mEventsRepository = eventsRepository;
        mAddEditEventView = addEventView;
    }

    @Override
    public void createEvent(String title, String description) {

        if (null == mFirebase.getAuth()) {
            mAddEditEventView.showNotification("Please login to post an event");
        } else {
            Event newEvent = new Event(mFirebase.getAuth().getUid(), title, description);
            mEventsRepository.saveEvent(newEvent, new EventsDataSource.SaveEventCallback() {
                @Override
                public void onEventSaved(boolean success) {
                    mAddEditEventView.showEventsList();
                }

                @Override
                public void onError(String error) {
                    Log.i("Woo", "toast or snackbar?");
                }
            });
    }
    }
}
