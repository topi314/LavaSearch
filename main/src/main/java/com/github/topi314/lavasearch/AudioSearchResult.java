package com.github.topi314.lavasearch;

import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import java.util.List;

public interface AudioSearchResult {

	List<AudioTrack> getTracks();

	List<AudioPlaylist> getPlaylists();

	List<AudioPlaylist> getAlbums();

	List<AudioPlaylist> getArtists();

	List<AudioText> getTexts();

	enum Type {
		TRACK("track"),
		PLAYLIST("playlist"),
		ALBUM("album"),
		ARTIST("artist"),
		TEXT("text");

		private final String name;

		Type(String name) {
			this.name = name;
		}

		public static Type fromName(String name) {
			for (var type : Type.values()) {
				if (type.name.equals(name)) {
					return type;
				}
			}
			return null;
		}
	}

}