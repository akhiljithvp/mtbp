package com.mtbp.db.theaters.services;

import com.mtbp.db.BaseDbService;
import com.mtbp.db.theaters.Screen;

import java.util.List;
import java.util.Set;

public interface ScreenDbService extends BaseDbService<Screen, String> {
    void saveAll(List<Screen> screens);

    List<Screen> findAll(Set<String> screenIds);
}
