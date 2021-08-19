package com.vks.isdown.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    
    
}
