package com.mtbp.db.theaters.services;

import com.mtbp.db.repositories.ScreenRepository;
import com.mtbp.db.theaters.Screen;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScreenDbServiceImpl implements ScreenDbService {

    private final ScreenRepository screenRepository;

    @Override
    public Screen save(Screen screen) {
        return screenRepository.save(screen);
    }

    @Override
    public Optional<Screen> findById(String id) {
        return screenRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        try {
            screenRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Exception occurred while trying to delete document with id: {}", id, e);
            return false;
        }
    }

    @Override
    public void saveAll(List<Screen> screens) {
        screenRepository.saveAll(screens);
    }

    @Override
    public List<Screen> findAll(Set<String> screenIds) {
        return screenRepository.findAllById(screenIds);
    }
}
