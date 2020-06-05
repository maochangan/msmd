package net.msmd.api.server;

import net.msmd.api.bean.TestBean;
import net.msmd.api.util.SerResult;

import java.util.List;

public interface TestServer {

    public SerResult<List<TestBean>> getTest();
}
