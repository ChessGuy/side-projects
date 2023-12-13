package com.sideProject.randomPlaylist.model;

public class SimpleSong {

        private String songTitle;
        private String genre;
        private String artist;
        private int songDurationMs;
        private String [] minSec;  // [minutes, seconds]

        public SimpleSong (String songTitle, String artist, String genre, int songDurationMs) {
                this.songTitle = songTitle;
                this.artist = artist;
                this.genre = genre;
                this.songDurationMs = songDurationMs;
                this.minSec = getMinSec();
        }

        public String getSongTitle() {
                return songTitle;
        }

        public void setSongTitle(String songTitle) {
                this.songTitle = songTitle;
        }

        public String getGenre() {
                return genre;
        }

        public void setGenre(String genre) {
                this.genre = genre;
        }

        public String getArtist() {
                return artist;
        }

        public void setArtist(String artist) {
                this.artist = artist;
        }

        public int getSongDurationMs() {
                return songDurationMs;
        }

        public void setSongDurationMs(int songDurationMs) {
                this.songDurationMs = songDurationMs;
        }

        public String [] getMinSec () {
                int mins = (songDurationMs / 1000) / 60;
                int seconds = 0;
                String secondsString = "00";
                if ((songDurationMs / 1000) % 60 != 0) {
                        seconds = (songDurationMs / 1000) % 60;
                        if (seconds < 10) {
                                secondsString = Integer.toString(seconds);
                                secondsString = "0" + secondsString;
                        } else {
                                secondsString = Integer.toString(seconds);
                        }
                }
                this.minSec = new String[] {Integer.toString(mins), secondsString};
                return minSec;
        }
        @Override
        public String toString() {
                return songTitle + " by " + artist + " | Duration: " + minSec[0] + ":" + minSec[1]  + " | Genre: " +genre;
        }
}
