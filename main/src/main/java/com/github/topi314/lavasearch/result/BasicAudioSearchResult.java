package com.github.topi314.lavasearch.result;

import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import java.util.List;

public class BasicAudioSearchResult implements AudioSearchResult {

	protected final List<AudioTrack> tracks;
	protected final List<AudioPlaylist> albums;
	protected final List<AudioPlaylist> artists;
	protected final List<AudioPlaylist> playlists;
	protected final List<AudioText> texts;

	public BasicAudioSearchResult(List<AudioTrack> tracks, List<AudioPlaylist> albums, List<AudioPlaylist> artists, List<AudioPlaylist> playlists, List<AudioText> texts) {
		this.tracks = tracks;
		this.albums = albums;
		this.artists = artists;
		this.playlists = playlists;
		this.texts = texts;
	}

	@Override
	public List<AudioTrack> getTracks() {
		return tracks;
	}

	@Override
	public List<AudioPlaylist> getAlbums() {
		return albums;
	}

	@Override
	public List<AudioPlaylist> getArtists() {
		return artists;
	}

	@Override
	public List<AudioPlaylist> getPlaylists() {
		return playlists;
	}

	@Override
	public List<AudioText> getTexts() {
		return texts;
	}

}
