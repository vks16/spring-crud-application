package com.vks.isdown.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.vks.isdown.model.Video;

public interface VideoDao {
        
    int insertVideo(UUID id, Video video);

    default int insertVideo(Video video) {
        UUID id = UUID.randomUUID();
        return insertVideo(id, video);
    }

    List<Video> getVideos();

    Optional<Video> getVideoById(UUID id);

    int deleteVideoById(UUID id);

    int updateVideoById(UUID id, Video video);
}
