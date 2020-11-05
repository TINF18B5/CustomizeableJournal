package com.scherer.customizablejournal.persistence;

/**
 * Singleton instance to hold a repository.
 * Only to be used by {@link Repo#getInstance()}!
 */
class RepoSingelton {

    private static Repo repo;

    static Repo getRepo() {
        if (repo == null) {
            repo = new InMemoryRepo();
        }
        return repo;
    }
}
