package com.shaunabram.handsontable.persist;

import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldDAOImpl implements HelloWorldDAO {

    @Override
    public String getGreeting(String msg) {
        return msg; //dummy impl that just returns argument
    }

}
