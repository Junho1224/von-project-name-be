package com.von.api;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeService {
    private final HomeRepository homeRepository;
    
    public final String test(){
        return "";
    }
}
