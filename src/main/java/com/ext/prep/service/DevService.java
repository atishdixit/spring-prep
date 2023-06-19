package com.ext.prep.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"default", "dev"})
@Service
public class DevService {
}
