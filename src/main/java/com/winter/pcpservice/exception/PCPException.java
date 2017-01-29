package com.winter.pcpservice.exception;

/**
 * Common Exception for all Exceptions used in PCP Services
 */
public class PCPException extends RuntimeException {

  /**
   * Constructs a new PCP exception with the specified detail message.
   *
   * @param message           the detail message
   */
  public PCPException(String message) {
    super(message);
  }

  /**
   * Constructs a new PCP exception with the specified detail message and cause.
   *
   * @param message           the detail message
   * @param exception         the exception
   */
  public PCPException(String message, Exception exception) {
    super(message, exception);
  }

  /**
   * Constructs a new PCP exception with the specified detail message, cause, suppression
   * enabled or disabled, and writable stack trace enabled or disabled.
   *
   * @param message            the detail message.
   * @param cause              the cause.  (A {@code null} value is permitted, and indicates that
   *                           the cause is nonexistent or unknown.)
   * @param enableSuppression  whether or not suppression is enabled or disabled
   * @param writableStackTrace whether or not the stack trace should be writable
   */
  public PCPException(String message, Throwable cause, boolean enableSuppression, boolean
          writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
