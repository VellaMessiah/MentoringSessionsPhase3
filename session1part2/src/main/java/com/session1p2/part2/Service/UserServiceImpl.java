package com.session1p2.part2.Service;

import com.session1p2.part2.Entity.User;
import com.session1p2.part2.Repositories.UserRepository;
import com.session1p2.part2.Shared.UserRequestModel;
import com.session1p2.part2.Shared.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserResponseModel addNewUser(UserRequestModel userRequestModel) {
        userRequestModel.setUserId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user = userRepository.save(modelMapper.map(userRequestModel,User.class));
        return modelMapper.map(user,UserResponseModel.class);
    }
}
