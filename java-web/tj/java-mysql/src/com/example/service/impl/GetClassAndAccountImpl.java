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
    public void get(int n,int o,Writer w) throws Exception {
        // n是数量,o是起始位置
        AccountDao ad = new AccountAccountDaoMysql();
        ClassDao cd = new ClassDaoMysql();
        List<Account> la = ad.queryAll();
        // 剪切一个子集合，从0开始，到n，正好有n个
        la = la.subList(o,n==-1?la.size()-1:n +o);
        List<_Class> ls = cd.queryAll();
        w.write("|id|name|math|english|class|<br>");
        for (Account account : la) {
            w.write("|"+account.getId()+
                    "\t|"+account.getName()+
                    "\t|"+account.getMath()+
                    "\t|"+account.getEnglish()+
                    "\t|"+account.getClazz()+"|"+
                    "<br>");
        }

    }
}
