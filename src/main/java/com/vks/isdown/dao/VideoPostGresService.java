package com.vks.isdown.dao;

import com.vks.isdown.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class VideoPostGresService implements VideoDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VideoPostGresService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int insertVideo(UUID id, Video video) {
        final String sql = "INSERT INTO video (id, title, url) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {id, video.getTitle(), video.getUrl()});
        return 0;
    }

    @Override
    public List<Video> getVideos() {
        final String sql = "SELECT id, title, url FROM video";
        return jdbcTemplate.query(sql, (result, index) -> new Video(
                UUID.fromString(result.getString("id")),
                result.getString("title"),
                result.getString("url")
        ));
    }

//    @Override
//    public Optional<Video> getVideoById(UUID id) {
//        final String sql = "SELECT id, title, url FROM video where id='" + id + "'";
//        return jdbcTemplate.query(sql, (result, index) -> new Video(
//                UUID.fromString(result.getString("id")),
//                result.getString("title"),
//                result.getString("url")
//        )).stream().findFirst();
//    }

    @Override
    public Optional<Video> getVideoById(UUID id) {
        final String sql = "SELECT id, title, url FROM video where id = ?";

        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[]{id},
                (result, i) -> new Video(
                        UUID.fromString(result.getString("id")),
                        result.getString("title"),
                        result.getString("url")
                )
        ));
    }

    @Override
    public int deleteVideoById(UUID id) {
        final String sql = """
                DELETE FROM video
                WHERE id=?
                """;
        jdbcTemplate.update(sql, new Object[] {id});
        return 0;
    }

    @Override
    public int updateVideoById(UUID id, Video video) {
        final String sql = """
                UPDATE video
                SET title = ?, url = ?
                WHERE id=?
                """;
        jdbcTemplate.update(sql, new Object[] {video.getTitle(), video.getUrl(), id});
        return 0;
    }
}
