package com.demo.exceptions;

public class TravelNotFoundByIdException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TravelNotFoundByIdException(Long travelId) {
        super("Travel not found with ID: " + travelId);
    }
}