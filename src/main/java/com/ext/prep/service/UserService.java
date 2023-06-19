package com.ext.prep.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Profile({"default", "dev", "prod"})
@Primary
@Service
public class UserService {

}
