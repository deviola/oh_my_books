package com.app.ohmybooks.service;

import com.app.ohmybooks.domain.Title;
import com.app.ohmybooks.repository.TitleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleService {

    @Autowired
    private TitleRepo titleRepo;

    public List<Title> getAllTitles() {
        return titleRepo.findAll();
    }

    public Optional<Title> getTitleByid(Long titleId) {
        return titleRepo.findById(titleId);
    }

    public Title saveTitle(final Title title) {
        return titleRepo.save(title);
    }

}
