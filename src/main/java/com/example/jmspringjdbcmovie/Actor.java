package com.example.jmspringjdbcmovie;

public class Actor {
	private Integer id;
	private String name;
	private String image;
	private String bio;

	public Actor(Integer id, String name, String image, String bio) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", image=" + image + ", bio=" + bio + "]";
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

}
