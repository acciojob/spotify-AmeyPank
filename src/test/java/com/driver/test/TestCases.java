package com.driver.test;

import com.driver.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Application.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCases {
    @Test
    public void test_create_song_nonexistent_album() throws Exception {
        // Arrange
        SpotifyController spotifyController = new SpotifyController();
        String title = "Bad Blood";
        String albumName = "1989";
        int length = 240;

        // Act and Assert
        assertThrows(Exception.class, () -> {
            spotifyController.createSong(title, albumName, length);
        });
    }
    @Test
    public void test_create_user() {
        // Arrange
        SpotifyController spotifyController = new SpotifyController();
        String name = "John";
        String mobile = "1234567890";

        // Act
        String result = spotifyController.createUser(name, mobile);

        // Assert
        assertEquals("Success", result);
    }
    @Test
    public void test_create_artist() {
        // Arrange
        SpotifyController spotifyController = new SpotifyController();
        String name = "Taylor Swift";

        // Act
        String result = spotifyController.createArtist(name);

        // Assert
        assertEquals("Success", result);
    }
    @Test
    public void test_create_album() {
        // Arrange
        SpotifyController spotifyController = new SpotifyController();
        String title = "1989";
        String artistName = "Taylor Swift";

        // Act
        String result = spotifyController.createAlbum(title, artistName);

        // Assert
        assertEquals("Success", result);
    }
    @Test
    public void test_create_song() throws Exception {
        // Arrange
        SpotifyController spotifyController = new SpotifyController();
        String title = "Blank Space";
        String albumName = "1989";
        int length = 240;

        // Act
        String result = spotifyController.createSong(title, albumName, length);

        // Assert
        assertEquals("Success", result);
    }
    @Test
    public void test_create_playlist_on_length() throws Exception {
        // Arrange
        SpotifyController spotifyController = new SpotifyController();
        String mobile = "1234567890";
        String title = "My Playlist";
        int length = 240;

        // Act
        String result = spotifyController.createPlaylistOnLength(mobile, title, length);

        // Assert
        assertEquals("Success", result);
    }
    @Test
    public void test_create_playlist_on_length_nonexistent_user() throws Exception {
        // Arrange
        SpotifyController spotifyController = new SpotifyController();
        String mobile = "9876543210";
        String title = "My Playlist";
        int length = 240;

        // Act and Assert
        assertThrows(Exception.class, () -> {
            spotifyController.createPlaylistOnLength(mobile, title, length);
        });
    }
    @Test
    public void test_create_playlist_on_name_nonexistent_user() throws Exception {
        // Arrange
        SpotifyController spotifyController = new SpotifyController();
        String mobile = "9876543210";
        String title = "My Playlist";
        List<String> songTitles = Arrays.asList("Blank Space", "Shake It Off");

        // Act and Assert
        assertThrows(Exception.class, () -> {
            spotifyController.createPlaylistOnName(mobile, title, songTitles);
        });
    }
    @Test
    public void test_find_playlist_nonexistent_user() throws Exception {
        // Arrange
        SpotifyController spotifyController = new SpotifyController();
        String mobile = "9876543210";
        String playlistTitle = "My Playlist";

        // Act and Assert
        assertThrows(Exception.class, () -> {
            spotifyController.findPlaylist(mobile, playlistTitle);
        });
    }

    @Test
    public void test_find_nonexistent_playlist() throws Exception {
        // Arrange
        SpotifyController spotifyController = new SpotifyController();
        String mobile = "1234567890";
        String playlistTitle = "Nonexistent Playlist";

        // Act and Assert
        assertThrows(Exception.class, () -> {
            spotifyController.findPlaylist(mobile, playlistTitle);
        });
    }
    @Test
    public void test_playlist_created_successfully() {
        // Arrange
        SpotifyController spotifyController = new SpotifyController();
        String mobile = "1234567890";
        String title = "My Playlist";
        int length = 3;

        // Act
        String result = spotifyController.createPlaylistOnLength(mobile, title, length);

        // Assert
        assertEquals("Success", result);
        // Additional assertions to check if playlist is created successfully
    }
}
