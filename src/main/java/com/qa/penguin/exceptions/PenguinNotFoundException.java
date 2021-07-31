package com.qa.penguin.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Penguin does not exist with that Id :(")
public class PenguinNotFoundException extends RuntimeException {

}
