package com.ondemandcarwash.models;



import org.springframework.data.mongodb.core.mapping.Document;


import org.springframework.data.annotation.Id;

@Document(collection="Ratings")
public class Ratings {
	
	
	
	@Id
	int washerId;
	int rating;
	String Review;
	
	
	public Ratings() {
		
	}


	public Ratings(int washerId, int rating, String review) {
		super();
		this.washerId = washerId;
		this.rating = rating;
		Review = review;
	}


	public int getWasherId() {
		return washerId;
	}


	public void setWasherId(int washerId) {
		this.washerId = washerId;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getReview() {
		return Review;
	}


	public void setReview(String review) {
		Review = review;
	}


	@Override
	public String toString() {
		return "Ratings [washerId=" + washerId + ", rating=" + rating + ", Review=" + Review + "]";
	}
	
	
}