package com.scherer.customizablejournal.persistence;

import androidx.annotation.VisibleForTesting;

/**
 * Singleton instance to hold a repository.
 * Only to be used by {@link Repo#getInstance()}!
 */
@VisibleForTesting(otherwise = VisibleForTesting.PACKAGE_PRIVATE)
public class RepoSingelton {

    private static Repo repo;

    static Repo getRepo() {
        if (repo == null) {
            repo = new InMemoryRepo();
        }
        return repo;
    }

    @VisibleForTesting()
    public static void supersedeSingleton(Repo repo) {
        RepoSingelton.repo = repo;
    }
}
