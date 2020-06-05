package net.msmd.api.server.impl;

import net.msmd.api.bean.TestBean;
import net.msmd.api.dao.TestDao;
import net.msmd.api.server.TestServer;
import net.msmd.api.util.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestServerImpl implements TestServer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestDao testDao;

    @Override
    public SerResult<List<TestBean>> getTest() {
        try {
            List<TestBean> result = testDao.getTest();
            if (result.isEmpty()) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("e" + e.getMessage());
            return SerResult.createError();
        }
    }
}
