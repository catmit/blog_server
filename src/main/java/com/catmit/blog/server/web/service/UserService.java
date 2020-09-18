package com.catmit.blog.server.web.service;

import com.catmit.blog.server.web.dao.UserDAO;
import com.catmit.blog.server.web.entity.po.UserPO;
import com.catmit.blog.server.web.entity.vo.UserVO;
import com.catmit.blog.server.web.exception.AppearException;
import com.catmit.blog.server.web.exception.BusinessException;
import com.catmit.blog.server.web.exception.ErrorCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public UserVO login(UserPO loginInfo){
        UserVO user = new UserVO();
        UserPO userPO = userDAO.findUserPOByColumn("mail", loginInfo.getMail());
        if(userPO == null) AppearException.appearBusinessException(ErrorCode.USER_NOT_EXIST);
        validPassword(userPO.getPassword(), loginInfo.getPassword());
        BeanUtils.copyProperties(userPO, user);
        return user;
    }

    public UserVO register(UserPO registerInfo){
        UserVO userVO = userDAO.findUserVOByColumn("mail", registerInfo.getMail());
        if(userVO != null) {
            AppearException.appearBusinessException(ErrorCode.MAIL_ALREADY_EXIST);
        }
        return userDAO.insertUser(registerInfo);
    }

    public UserVO getUserVOById(int id){
        UserVO user = userDAO.findUserById(id);
        if(user == null) AppearException.appearBusinessException(ErrorCode.USER_NOT_EXIST);
        return user;
    }




    private void validPassword(String sourcePassword, String targetPassword){
        if(targetPassword == null){
            AppearException.appearBusinessException(ErrorCode.EMPTY_PASSWORD);
        }
        if(!Objects.equals(sourcePassword, targetPassword)){
            AppearException.appearBusinessException(ErrorCode.INVALID_PASSWORD);
        }
    }

}
