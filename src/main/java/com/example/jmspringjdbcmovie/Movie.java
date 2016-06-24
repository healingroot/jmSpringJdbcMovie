package com.example.jmspringjdbcmovie;


public class Movie {
	private Integer id;
	private String title;
	private String image;
	private Integer year;
	private String plot;

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", image=" + image + ", year=" + year + ", plot=" + plot + "]";
	}

	public Movie(Integer id, String title, String image, Integer year, String plot) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.year = year;
		this.plot = plot;
	}
	
	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}
}