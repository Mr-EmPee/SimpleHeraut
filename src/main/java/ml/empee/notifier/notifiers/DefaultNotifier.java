package ml.empee.notifier.notifiers;

import java.util.logging.Logger;

import ml.empee.notifier.exceptions.SimpleNotifierException;

public final class DefaultNotifier implements Notifier {

  private final Logger logger;

  public DefaultNotifier(Logger logger) {
    this.logger = logger;
  }

  @Override
  public void notify(String changelog) {
    if(!changelog.isEmpty()) {
      changelog = "This plugin isn't up to date. Here is the changelog: \n" + changelog;
      logger.info(changelog);
    }
  }

  @Override
  public void handleException(Exception exception) {
    throw new SimpleNotifierException("Error while checking for notifications", exception);
  }

}
