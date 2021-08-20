package com.vks.isdown.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.vks.isdown.dao.VideoDao;
import com.vks.isdown.model.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    private final VideoDao videoDao;

    @Autowired
    public VideoService(@Qualifier("postgres") VideoDao videoDao){
        this.videoDao = videoDao;
    }

    public int addVideo(Video video) {
        return videoDao.insertVideo(video);
    }
    
    public List<Video> getAllVideos() {
        return videoDao.getVideos();
    }

    public Optional<Video> getVideoById(UUID id) {
        return videoDao.getVideoById(id);
    }

    public int deleteVideoById(UUID id) {
        return videoDao.deleteVideoById(id);
    }

    public int updateVideoById(UUID id, Video video) {
        return videoDao.updateVideoById(id, video);
    }
}
