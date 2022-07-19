// Generated by view binder compiler. Do not edit!
package com.example.lunchwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lunchwallet.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLandingPageBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final LinearLayoutCompat landingPageContainer;

  @NonNull
  public final RecyclerView landingPageMealsRecyclerView;

  @NonNull
  public final LinearLayoutCompat relativeLayout;

  private FragmentLandingPageBinding(@NonNull FrameLayout rootView,
      @NonNull LinearLayoutCompat landingPageContainer,
      @NonNull RecyclerView landingPageMealsRecyclerView,
      @NonNull LinearLayoutCompat relativeLayout) {
    this.rootView = rootView;
    this.landingPageContainer = landingPageContainer;
    this.landingPageMealsRecyclerView = landingPageMealsRecyclerView;
    this.relativeLayout = relativeLayout;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLandingPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLandingPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_landing_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLandingPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.landing_page_container;
      LinearLayoutCompat landingPageContainer = ViewBindings.findChildViewById(rootView, id);
      if (landingPageContainer == null) {
        break missingId;
      }

      id = R.id.landingPageMealsRecyclerView;
      RecyclerView landingPageMealsRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (landingPageMealsRecyclerView == null) {
        break missingId;
      }

      id = R.id.relative_layout;
      LinearLayoutCompat relativeLayout = ViewBindings.findChildViewById(rootView, id);
      if (relativeLayout == null) {
        break missingId;
      }

      return new FragmentLandingPageBinding((FrameLayout) rootView, landingPageContainer,
          landingPageMealsRecyclerView, relativeLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
