package com.sideProject.randomPlaylist;

import com.sideProject.randomPlaylist.model.SimpleSong;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RandomPlaylistApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SpringApplication.run(RandomPlaylistApplication.class, args);

		SimpleSong sample = new SimpleSong("Song 1", "Artist 1", "Genre 1", 115000);

		System.out.println(sample);
	}



}
