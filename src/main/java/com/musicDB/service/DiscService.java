package com.musicDB.service;

import com.musicDB.entity.Disc;
import com.musicDB.repositories.DiscsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiscService {

    @Autowired
    private DiscsRepository discsRepository;

    @Transactional
    public List<Disc> getDiscs() {
        return discsRepository.getDiscs();
    }

    @Transactional
    public Disc getDiscById(Long discId) {
        return discsRepository.getDiscById(discId);
    }
}
