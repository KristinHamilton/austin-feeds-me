package com.example.utfeedsme.addeditevent;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.utfeedsme.addeditevent.AddEditEventContract.Presenter;
import com.example.utfeedsme.data.Event;
import com.example.utfeedsme.data.EventsDataSource;


/**
 * Created by darrankelinske on 4/13/16.
 */
public class AddEditEventPresenter implements Presenter {

    private String mEventId;
    private EventsDataSource mEventsRepository;
    private AddEditEventContract.View mAddEditEventView;

    public AddEditEventPresenter(@Nullable String taskId, @NonNull EventsDataSource eventsRepository,
                                @NonNull AddEditEventContract.View addEventView) {
        mEventId = taskId;
        mEventsRepository = eventsRepository;
        mAddEditEventView = addEventView;
    }

    @Override
    public void createEvent(String uid, String title, String description) {
        Event newEvent = new Event(uid, title, description);
        if (1 == 2) {
            // Oopsy - Need basic details
        } else {
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
