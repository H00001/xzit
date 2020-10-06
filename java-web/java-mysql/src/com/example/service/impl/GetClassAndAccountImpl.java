package com.example.service.impl;

import com.example.dao.impl.AccountAccountDaoMysql;
import com.example.dao.AccountDao;
import com.example.dao.ClassDao;
import com.example.dao.impl.ClassDaoMysql;
import com.example.data.Account;
import com.example.data._Class;
import com.example.service.GetClassAndAccountService;

import java.io.Writer;
import java.util.List;

public class GetClassAndAccountImpl implements GetClassAndAccountService {
    @Override
    public void get(Writer w) throws Exception {
        AccountDao ad = new AccountAccountDaoMysql();
        ClassDao cd = new ClassDaoMysql();
        List<Account> la = ad.queryAll();
        List<_Class> ls = cd.queryAll();
        for (Account account : la) {
            w.write("account name="+account.getName()+" ");
        }
        for (_Class l : ls) {
            w.write("class name="+l.getName()+" ");
        }

    }
}
