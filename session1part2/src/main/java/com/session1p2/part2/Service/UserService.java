package com.session1p2.part2.Service;

import com.session1p2.part2.Shared.UserRequestModel;
import com.session1p2.part2.Shared.UserResponseModel;

import java.util.Optional;

public interface UserService {
    public UserResponseModel addNewUser(UserRequestModel userRequestModel);
}
