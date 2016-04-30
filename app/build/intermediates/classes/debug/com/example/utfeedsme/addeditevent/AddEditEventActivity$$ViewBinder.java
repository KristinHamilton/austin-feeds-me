// Generated code from Butter Knife. Do not modify!
package com.example.utfeedsme.addeditevent;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AddEditEventActivity$$ViewBinder<T extends com.example.utfeedsme.addeditevent.AddEditEventActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427416, "field 'title'");
    target.title = finder.castView(view, 2131427416, "field 'title'");
    view = finder.findRequiredView(source, 2131427417, "field 'description'");
    target.description = finder.castView(view, 2131427417, "field 'description'");
    view = finder.findRequiredView(source, 2131427418, "field 'saveButton'");
    target.saveButton = finder.castView(view, 2131427418, "field 'saveButton'");
  }

  @Override public void unbind(T target) {
    target.title = null;
    target.description = null;
    target.saveButton = null;
  }
}
