package com.vks.isdown.api;


import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.vks.isdown.model.Video;
import com.vks.isdown.service.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public void addVideo(@Valid @NotNull @RequestBody Video video) {
        videoService.addVideo(video);
    }

    @GetMapping
    public List<Video> getVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping(path = "/{id}")
    public Video getVideoById(@NotBlank @PathVariable("id") UUID id) {
        return videoService.getVideoById(id).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public int deleteVideoById(@NotBlank @PathVariable("id") UUID id) {
        return videoService.deleteVideoById(id);
    }

    @PutMapping("update")
    public int updateVideoById(@Valid @NotNull @RequestBody Video video) {
        return videoService.updateVideoById(video.getId(), video);
    }
}
