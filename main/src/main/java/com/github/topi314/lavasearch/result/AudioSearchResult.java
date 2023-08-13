package com.github.topi314.lavasearch.result;

import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import java.util.List;

/**
 * AudioSearchResult is the result of a search for audio tracks, playlists, albums, artists or texts.
 */
public interface AudioSearchResult {

	public static final AudioSearchResult EMPTY = new BasicAudioSearchResult(List.of(), List.of(), List.of(), List.of(), List.of());

	/**
	 * @return a list of tracks found
	 */
	List<AudioTrack> getTracks();

	/**
	 * @return a list of playlists found
	 */
	List<AudioPlaylist> getPlaylists();

	/**
	 * @return a list of albums found
	 */
	List<AudioPlaylist> getAlbums();

	/**
	 * @return a list of artists found
	 */
	List<AudioPlaylist> getArtists();

	/**
	 * @return a list of texts found
	 */
	List<AudioText> getTexts();

	/**
	 * Type is the type of the search result.
	 */
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

		/**
		 * @return the name of the type
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * @param name the name of the type
		 * @return the type corresponding to the name
		 */
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