package com.scherer.customizablejournal.persistence;

import com.scherer.customizablejournal.mocks.persistence.RepoMock;

import org.junit.Assert;
import org.junit.Test;

public class RepoSingeltonTest {

    @Test
    public void getRepoAlwaysReturnsSameInstance() {
        Assert.assertSame("RepoSingleton.getRepo must always return same value, due to singleton Pattern", RepoSingelton.getRepo(), RepoSingelton.getRepo());
    }

    @Test
    public void supersedeSingletonMustSupersedeInstance() {
        final RepoMock repoMock = new RepoMock();
        RepoSingelton.supersedeSingleton(repoMock);

        Assert.assertSame("RepoSingelton.getRepo must return superseded instance", repoMock, RepoSingelton.getRepo());
    }
}