package com.scherer.customizablejournal.persistence;

class RepoSingelton {

    private static Repo repo;

    static Repo getRepo(){
        if(repo==null){
            repo = new InMemoryRepo();
        }
        return repo;
    }
}
