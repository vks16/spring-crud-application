package com.vks.isdown.api;

import java.util.Arrays;
import java.util.List;

import com.vks.isdown.model.Video;
import com.vks.isdown.service.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/video")
@RestController
public class VideoController {
    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService vs) {
        this.videoService = vs;
    }

    @PostMapping("add")
    public void addVideo(@RequestBody Video video) {
        videoService.addVideo(video);
    }

    @GetMapping
    public List<Video> getVideos() {
        return videoService.getAllVideos();
    }
}
