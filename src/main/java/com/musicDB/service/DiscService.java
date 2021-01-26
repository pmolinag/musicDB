package com.musicDB.service;

import com.musicDB.entity.Disc;
import com.musicDB.repositories.discsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiscService {

    @Autowired
    private discsRepository DiscsRepository;

    @Transactional
    public List<Disc> getDiscs() {
        return DiscsRepository.getDiscs();
    }
}
