package com.vks.isdown.dao;

import com.vks.isdown.model.Video;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class VideoPostGresService implements VideoDao {

    @Override
    public int insertVideo(UUID id, Video video) {
        return 0;
    }

    @Override
    public List<Video> getVideos() {
        return List.of(
                new Video(UUID.randomUUID(), "Vishal Random list", "https://fdkjfkd.com")
        );
    }

    @Override
    public Optional<Video> getVideoById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteVideoById(UUID id) {
        return 0;
    }

    @Override
    public int updateVideoById(UUID id, Video video) {
        return 0;
    }
}
