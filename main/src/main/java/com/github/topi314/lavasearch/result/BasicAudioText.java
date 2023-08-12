package com.github.topi314.lavasearch.result;

public class BasicAudioText implements AudioText {
	protected final String text;

	public BasicAudioText(String text) {
		this.text = text;
	}

	@Override
	public String getText() {
		return text;
	}

}
