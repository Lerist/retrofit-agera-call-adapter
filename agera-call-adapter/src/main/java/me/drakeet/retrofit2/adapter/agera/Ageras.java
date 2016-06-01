package me.drakeet.retrofit2.adapter.agera;

import android.support.annotation.NonNull;
import com.google.android.agera.RepositoryCompilerStates;
import java.util.concurrent.Executors;

import static com.google.android.agera.Repositories.repositoryWithInitialValue;

/**
 * Created by drakeet on 16/6/1.
 */
public class Ageras {

  public static <T> RepositoryCompilerStates.RFlow<T, T, ?> goToBackgroundWithInitialValue(
      @NonNull final T initialValue) {
    return repositoryWithInitialValue(initialValue)
        .observe()
        .onUpdatesPerLoop()
        .goTo(Executors.newSingleThreadExecutor());
  }
}