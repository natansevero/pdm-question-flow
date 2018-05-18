package com.example.natan.flow;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import flow.Dispatcher;
import flow.Flow;
import flow.Traversal;
import flow.TraversalCallback;

public class BasicDispatcher implements Dispatcher {

    private final Activity act;

    BasicDispatcher(Activity act) {
        this.act = act;
    }

    @Override
    public void dispatch(@NonNull Traversal traversal, @NonNull TraversalCallback callback) {
        Object destinationKey = traversal.destination.top();

        ViewGroup mainActivityFrame = (ViewGroup) act.findViewById(R.id.main_activy_frame);


        if (mainActivityFrame.getChildCount() > 0) {
            final View currentView = mainActivityFrame.getChildAt(0);

            if (traversal.origin != null) {
                traversal.getState(traversal.origin.top()).save(currentView);
            }

            final Object currentKey = Flow.getKey(currentView);
            if (destinationKey.equals(currentKey)) {
                callback.onTraversalCompleted();
                return;
            }

            mainActivityFrame.removeAllViews();
        }

        @LayoutRes final int layout;
        if(destinationKey instanceof SimpleScreen) {
            layout = R.layout.simple_screen;
        } else {
            throw new AssertionError("Error: " + destinationKey);
        }

        View incomingView = LayoutInflater.from(traversal.createContext(destinationKey, act)) //
                .inflate(layout, mainActivityFrame, false);

        mainActivityFrame.addView(incomingView);
        traversal.getState(traversal.destination.top()).restore(incomingView);

        callback.onTraversalCompleted();
    }
}
