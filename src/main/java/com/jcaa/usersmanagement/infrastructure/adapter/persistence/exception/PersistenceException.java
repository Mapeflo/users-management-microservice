package com.jcaa.usersmanagement.infrastructure.adapter.persistence.exception;

public final class PersistenceException extends RuntimeException {

  private static final String MESSAGE_SAVE = "Failed to save user with ID: '%s'.";
  private static final String MESSAGE_UPDATE = "Failed to update user with ID: '%s'.";
  private static final String MESSAGE_FIND = "Failed to find user with ID: '%s'.";
  private static final String MESSAGE_EMAIL = "Failed to find user with email: '%s'.";
  private static final String MESSAGE_ALL = "Failed to retrieve all users.";
  private static final String MESSAGE_DELETE = "Failed to delete user with ID: '%s'.";
  private static final String MESSAGE_CONNECTION = "Could not establish database connection.";

  private PersistenceException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public static PersistenceException becauseSaveFailed(final String userId, final Throwable cause) {
    return new PersistenceException(String.format(MESSAGE_SAVE, userId), cause);
  }

  public static PersistenceException becauseUpdateFailed(
      final String userId, final Throwable cause) {
    return new PersistenceException(String.format(MESSAGE_UPDATE, userId), cause);
  }

  public static PersistenceException becauseFindByIdFailed(
      final String userId, final Throwable cause) {
    return new PersistenceException(String.format(MESSAGE_FIND, userId), cause);
  }

  public static PersistenceException becauseFindByEmailFailed(
      final String email, final Throwable cause) {
    return new PersistenceException(String.format(MESSAGE_EMAIL, email), cause);
  }

  public static PersistenceException becauseFindAllFailed(final Throwable cause) {
    return new PersistenceException(MESSAGE_ALL, cause);
  }

  public static PersistenceException becauseDeleteFailed(
      final String userId, final Throwable cause) {
    return new PersistenceException(String.format(MESSAGE_DELETE, userId), cause);
  }

  public static PersistenceException becauseConnectionFailed(final Throwable cause) {
    return new PersistenceException(MESSAGE_CONNECTION, cause);
  }

  // ===== Métodos para Carrera Académica =====

  public static PersistenceException becauseSaveFailedCarrera(final String id, final Throwable cause) {
    return new PersistenceException("Failed to save carrera académica with ID: '" + id + "'.", cause);
  }

  public static PersistenceException becauseUpdateFailedCarrera(final String id, final Throwable cause) {
    return new PersistenceException("Failed to update carrera académica with ID: '" + id + "'.", cause);
  }

  public static PersistenceException becauseFindByIdFailedCarrera(final String id, final Throwable cause) {
    return new PersistenceException("Failed to find carrera académica with ID: '" + id + "'.", cause);
  }

  public static PersistenceException becauseFindAllFailedCarrera(final Throwable cause) {
    return new PersistenceException("Failed to retrieve all carreras académicas.", cause);
  }

  public static PersistenceException becauseDeleteFailedCarrera(final String id, final Throwable cause) {
    return new PersistenceException("Failed to delete carrera académica with ID: '" + id + "'.", cause);
  }
}
