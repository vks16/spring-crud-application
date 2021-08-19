package com.vks.isdown.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import com.vks.isdown.model.Video;

import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakeVideoAccessService implements VideoDao {
    private static List<Video> DB = new ArrayList<Video>();

    @Override
    public int insertVideo(UUID id, Video video) {
        DB.add(new Video(id, video.getTitle(), video.getUrl()));
        return 1;
    }

    @Override
    public List<Video> getVideos() {
        return DB;
    }

    @Override
    public Optional<Video> getVideoById(UUID id) {
        return DB.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteVideoById(UUID id) {
        var responseCode = 0;
        getVideoById(id).ifPresent(e -> DB.remove(e));
        return responseCode;
    }

    @Override
    public int updateVideoById(UUID id, Video video) {
        var responseCode = 0;
        getVideoById(id).ifPresent(e -> DB.set(DB.indexOf(e), video));
        return responseCode;
    }

    
}
