package com.henimex.jspringrecap.business.abstracts;

import com.henimex.jspringrecap.core.dataAccess.UserDao;
import com.henimex.jspringrecap.core.entities.User;
import com.henimex.jspringrecap.core.utilities.results.DataResult;
import com.henimex.jspringrecap.core.utilities.results.Result;
import com.henimex.jspringrecap.entities.concretes.Product;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
