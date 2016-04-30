package com.example.utfeedsme.addeditevent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.utfeedsme.R;
import com.example.utfeedsme.addeditevent.AddEditEventContract.Presenter;
import com.example.utfeedsme.data.Event;
import com.example.utfeedsme.data.EventsDataSource;

import static com.parse.gdata.Preconditions.checkNotNull;

/**
 * Created by darrankelinske on 4/13/16.
 */
public class AddEditEventPresenter extends AppCompatActivity implements Presenter {

    private String mEventId;
    private EventsDataSource mEventsRepository;
    private AddEditEventContract.View mAddEditEventView;

    public AddEditEventPresenter() {
    }

    public AddEditEventPresenter(@Nullable String taskId, @NonNull EventsDataSource eventsRepository,
                                @NonNull AddEditEventContract.View addEventView) {
        mEventId = taskId;
        mEventsRepository = checkNotNull(eventsRepository);
        mAddEditEventView = checkNotNull(addEventView);
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_event);


    }

    @Override
    public void createEvent(String uid, String title, String description) {
        Event newEvent = new Event(uid, title, description);
//        if (newEvent.isEmpty()) {
            // Oopsy - Need basic details
//        } else {
//            mEventsRepository.saveEvent(newEvent);
            mAddEditEventView.showEventsList();
//        }
    }
}
