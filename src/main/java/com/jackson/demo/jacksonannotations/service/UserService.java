package com.jackson.demo.jacksonannotations.service;

import com.jackson.demo.jacksonannotations.entity.UserEntity;
import com.jackson.demo.jacksonannotations.entity.repository.UserRepository;
import com.jackson.demo.jacksonannotations.model.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails createUser(UserDetails userDetails) {
        return mapToUserDetails(userRepository.save(mapToUserEntity(userDetails)));
    }

    private UserEntity mapToUserEntity(UserDetails userDetails) {
        return new UserEntity(
                userDetails.getFirstName(),
                userDetails.getLastName(),
                userDetails.getAge(),
                userDetails.getSsn(),
                userDetails.getPhonenumber(),
                userDetails.getCategory()
        );
    }

    private UserDetails mapToUserDetails(UserEntity userEntity) {
        return new UserDetails.UserDetailsBuilder()
                .userId(userEntity.getUserId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .age(userEntity.getAge())
                .ssn(userEntity.getSsn())
                .phonenumber(userEntity.getPhonenumber())
                .category(userEntity.getCategory())
                .build();
    }

    public UserDetails getUser(long userId) {
        return mapToUserDetails(userRepository.findByUserId(userId));
    }
}
