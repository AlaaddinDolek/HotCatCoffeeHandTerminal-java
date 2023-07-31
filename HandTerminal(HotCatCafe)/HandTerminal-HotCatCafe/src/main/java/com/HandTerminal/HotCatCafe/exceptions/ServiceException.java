package com.HandTerminal.HotCatCafe.exceptions;

import java.io.IOException;

public class ServiceException extends IOException {
    
 private ErrorResponse errorResponse;

 public ServiceException(ErrorResponse errorResponse) {
    super(errorResponse.getMessage());
    this.errorResponse = errorResponse;

 }

public ErrorResponse getErrorResponse() {
    return errorResponse;
}
}
